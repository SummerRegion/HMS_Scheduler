/* 
 * do not use this Javascript file directly --
 * Use within web worker
 */

/* global self */

var ws = {};

var isEmpty = function(obj) {
    try {
        return Object.keys(obj).length === 0 && obj.constructor === Object;
    } catch(e) {
        
    }
    
    for(var prop in obj) {
        if(obj.hasOwnProperty(prop))
            return false;
    }

    return JSON.stringify(obj) === JSON.stringify({});
};

var webSocketSend = function(message) {
    console.log(ws);
    if(ws!==null && !isEmpty(ws)) {
           console.log(ws.readyState); 
           if(ws.readyState === 1) {
               try {
                    ws.send(message);
               } catch(e) {
                   console.log(e);
               } 
           }
        }
};

var beginWebSocketConnection = function (url) {
    url = ((url.includes("ws://") || url.includes("wss://")) ? url : "ws://"+url);

    try {
        ws = new WebSocket(url);
    } catch(e) {
        self.postMessage({error:"WebSocket Connection is blocked at specified port"});
        ws = {};
        return;
    }
    
    ws.onmessage= function(event) {
        self.postMessage(event.data);
    };
    
    ws.onopen = function(event) {
        //webSocketSend("requestNotification");
    };
    
    //ws.onclose = function() { setTimeout(function(){ beginWebSocketConnection(url);},
    //            5000);};
};

onmessage = function (e) {
    var dt = e.data;
    
    switch(dt.cmd) {
        case 'init':
            beginWebSocketConnection(dt.url);
            break;
    }
};