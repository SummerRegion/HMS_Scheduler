/* global self */
'use strict';
let timer_id = -1;
let wsTask = {};

const isEmpty = function(obj) {
    try {
        return Object.keys(obj).length === 0 && obj.constructor === Object;
    } catch(e) {}
    for(let prop in obj) {
        if(obj.hasOwnProperty(prop)) return false;
    }
    return JSON.stringify(obj) === JSON.stringify({});
};

const webSocketSend = function(message) {
    console.log(wsTask);
    if(wsTask!==null && !isEmpty(wsTask)) {
           console.log(wsTask.readyState); 
           if(wsTask.readyState === 1) {
               try {
                    wsTask.send(message);
               } catch(e) {
                   console.log(e);
               } 
           }
        }
};

const beginWebSocketConnection = function (url) {
    url = ((url.includes("ws://") || url.includes("wss://")) ? url : "ws://"+url);
    try {
        wsTask = new WebSocket(url);
    } catch(e) {
        postMessage({result:'error', value:"WebSocket Connection is blocked at specified port"});
        wsTask = {};
        return;
    }

    wsTask.onmessage= function(event) {
        const data = JSON.parse(event.data);
        if(data.newHotelDate !== undefined)
            postMessage({result:'hotel_date_updated', value: event.data});
    };
    
    wsTask.onopen = function(event) {
    };
    
    wsTask.onclose = function() { 
    };
    
    postMessage({result:'websocket_started', value:true});
};

const timerHandler = function() {
  clearTimeout(timer_id);
  console.log('clear timer');
  postMessage({result: 'time_out', value: true});
  console.log('send time_out message');
};

addEventListener('message', function(e) {
    if('command' in e.data) {
        switch(e.data.command) {
            case 'start_timer':
                timer_id = setTimeout(timerHandler, e.data.attr );
                postMessage({result: 'timer_start', value: true});
                break;
            case 'start_websocket':
                beginWebSocketConnection(e.data.attr);
                break;
        }
    }
}, false);


