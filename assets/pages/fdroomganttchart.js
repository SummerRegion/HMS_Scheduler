/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
HMS = {};

HMS.fdroomganttchart = {
    slotMoment: "",
    init : function(){
        $("#hidIsClicked").val(0);
        HMS.fdroomganttchart.bindCodeMasterDrpLst($("#drlRoomTypeRGC"),"RMT","",false,false, "Room Type");
        $("#drlRoomTypeRGC").select2();
        HMS.fdroomganttchart.bindCodeMasterDrpLst($("#drlHkStatusRGC"),"HSS","",false,false, "HouseKeep Status");
        $("#drlHkStatusRGC").select2();
        
        $("#drlRoomTypeRGC").on("change", function(){
            HMS.fdroomganttchart.loadRoomInfo();
            HMS.fdroomganttchart.loadEventInfo();
            HMS.fdroomganttchart.loadGanttChart();
        });
        $("#drlHkStatusRGC").on("change", function(){
            HMS.fdroomganttchart.loadRoomInfo();
            HMS.fdroomganttchart.loadEventInfo();
            HMS.fdroomganttchart.loadGanttChart();
        });
        
    },
    loadGanttChart : function(){
        $("#calendar").empty();
        var calendarEl = document.getElementById('calendar');
        var hotelDate = $("#txtHotelDate").val();
        
        var calendar = new FullCalendar.Calendar(calendarEl, {

            plugins: [ 'interaction', 'dayGrid', 'timeGrid', 'resourceTimeline' ],
            schedulerLicenseKey: 'GPL-My-Project-Is-Open-Source',
            now: new Date(),
            editable: false,
            selectable: false,
            selectHelper: false,
            aspectRatio: 1.8,
            height: 400,
            scrollTime: '00:00',
            slotWidth: 55,
            defaultView: 'resourceTimelineMonth',
            slotLabelFormat: [
                { day: 'numeric', weekday: 'short' }
            ],
            eventOverlap: false,
            resourceOrder: 'roomTypeDesc',
            resourceAreaWidth: '30%',
            resourceGroupField: 'roomTypeDesc',
            resourceColumns: [
                {
                    labelText: 'Floor',
                    field: 'floor',
                    width: '50px'
                },
                {
                    labelText: 'Room',
                    field: 'room',
                    width: '50px'
                },
                {
                    labelText: 'Status',
                    field: 'statusDesc',
                    width: '200px',
                    render: function(resource, el) {
                        var extendedProps = resource.extendedProps;
                        switch (extendedProps.statusDesc){
                            case "VACANT CLEAN":
                                el.style.color = '#ffffff';
                                el.className = 'fc-cell-content bg-success';
                                break;
                            case "VACANT DIRTY":
                                el.style.color = '#ffffff';
                                el.className = 'fc-cell-content bg-danger';
                                break;
                            case "OCCUPIED CLEAN":
                                el.style.color = '#ffffff';
                                el.className = 'fc-cell-content bg-warning';
                                break;
                            case "OCCUPIED DIRTY":
                                el.style.color = '#ffffff';
                                el.className = 'fc-cell-content bg-primary';
                                break;
                            case "OUT OF ORDER":
                                el.style.color = '#000000';
                                el.className = 'fc-cell-content bg-default';
                                break;
                        }
                    }
                }
            ],
            resources: window.roomData,
            events: window.eventData,
            select:function(arg){}
        });

        calendar.render();
        
        HMS.fdroomganttchart.highlightOOORoom();
        $(".eventContent").click(function() {
            $(".eventContent").removeClass("hideControl").addClass("hideControl");
        });
    },
    loadRoomInfo: function(){
        
        var jsonSearchData = {
            roomNo: null,
            floorNo: null,
            housekeepingStatus : $("#drlHkStatusRGC").val(),
            roomType: {
                roomType: $("#drlRoomTypeRGC").val()
            }
        };
        
        jQuery.ajax({
            type: "GET",
            cache: false,
            headers: {
                        "Authorization": "Bearer " + window.sessionStorage.getItem("authToken")
            },
            async: false,
            url: "/hms-scheduler/webapi/roomganttchart",
            "data": {
               "q": JSON.stringify(jsonSearchData)
            },
            dataType: "json",
            success: function (response) {
                var optionFloorNo = "";
                var optionRoomNo = "";
                var selected = false;
                var arrRoomData = [];
                $.each(response, function (i, item) {
                    var roomDate = {
                        id : item.gnroomId,
                        gnroomId: item.gnroomId,
                        roomType:item.roomType.roomType,
                        roomTypeDesc:item.roomType.roomTypeDesc,
                        floor:item.floorNo,
                        room:item.roomNo,
                        status:item.housekeepingStatus,
                        statusDesc:item.housekeepingStatusDesc
                    };
                    arrRoomData[i]=roomDate;
                });
                window.roomData = arrRoomData;
            }
        });
    },
    loadEventInfo: function(){
        var hotelDate = new Date();
        var jsonSearchData = {
            room : {
                roomNo: null,
                floorNo: null,
                housekeepingStatus : $("#drlHkStatusRGC").val(),
                roomType: {
                    roomType: $("#drlRoomTypeRGC").val()
                }
            }
        };
        
        jQuery.ajax({
            type: "GET",
            cache: false,
            headers: {
                        "Authorization": "Bearer " + window.sessionStorage.getItem("authToken")
            },
            async: false,
            url: "/hms-scheduler/webapi/roomganttchart/event",
            "data": {
               "q": JSON.stringify(jsonSearchData)
            },
            dataType: "json",
            success: function (response) {
                var arrEventData = [];
                $.each(response, function (i, item) {
                    var backgroundColor="";
                    var nationality = "";
                    if (item.person !== null){
                        if (item.person.nationality !== null){
                            nationality=item.person.nationality;
                        }
                    }
                    switch (item.registrationStatus){
                        case "1":
                            backgroundColor="#f40cf4";
                            break;
                        case "4":
                            backgroundColor="#4bd396";
                            break;
                        case "5":
                            backgroundColor="#e0a316";
                            break;
                        case "6":
                            backgroundColor="#5069d8";
                            break;
                    }
                    var eventData = {
                        id : i+1,
                        resourceId:item.room.gnroomId,
                        start:HMS.fdroomganttchart.convertDate(new Date(item.arrivalDate)),
                        end:HMS.fdroomganttchart.convertDate(new Date(item.departureDate)),
                        backgroundColor:backgroundColor,
                        registrationId:item.id,
                        gnroomId:item.room.gnroomId,
                        reservationId:item.reservation.id,
                        nationality: nationality,
                        status:item.registrationStatus,
                        statusDesc:item.registrationStatusDesc,
                        title:(item.reservation.groupName!==null?item.reservation.groupName:item.reservation.guestPerson.name),
                        version:item.version
                    };
                    arrEventData[i]=eventData;
                });
                
                window.eventData = arrEventData;
            }
        });
    },
    highlightOOORoom: function(){
        $.each(window.roomData, function(i, item){
            if (item.status === "OOO"){
                $('[data-resource-id="'+item.id+'"]').css("background-color", "lightgray");
            }
        });
    },
    convertDate : function(jsDate){
        var date = HMS.fdroomganttchart.toDateString(jsDate);
        var dateSplit = date.split("/");
        
        var newDate = dateSplit[2] + "-" + dateSplit[1] + "-" + dateSplit[0];
        return newDate;
    },
    bindCodeMasterDrpLst : function ($drpElement, strCMDCode, strCodeLine, strBln, blnAsync, strBlnDesc, filter) {
        jQuery.ajax({
            type: "GET",
            cache: false,
            headers: {
                "Authorization": "Bearer " + window.sessionStorage.getItem("authToken")
            },
            async: blnAsync,
            url: "/hms-scheduler/webapi/code/" + (strCMDCode ? strCMDCode + "/" : "") + (strCodeLine ? strCodeLine : ""),
            data: {},
            dataType: "json",
            success: function (response) {
                var option = "";
                var selected = false;
                window.CodeMasterDrpLst = response;
                if (jQuery.isFunction(filter)) {
                    response = filter(response);
                }

                jQuery.each(response, function (i, item) {
                    if (strCMDCode !== null && strCMDCode !== "") {
                        option += '<option value="' + item.clCode + '"' + (item.defaultInd === 'Y' ? ' selected="selected"' : '') + '>'
                                + item.clDescription + '</option>';
                        if (item.defaultInd === true)
                            selected = true;
                    } else {
                        option += '<option value="' + item.code + '">' + item.description + '</option>';
                    }
                });
                $drpElement.append(option);

                if (!strBlnDesc)
                    strBlnDesc = "Please Select";
                if (!selected) {
                    $drpElement.prepend('<option value="" selected="selected">' + strBlnDesc + "</option>");
                } else {
                    $drpElement.prepend('<option value="">' + strBlnDesc + "</option>");
                }
            }
        });
    },
    toJsDate : function (val) {
        var newDt = null;
        try {
            if (val !== null) {
                if (typeof val === "number") {
                    newDt = new Date(parseInt(val));
                } else if (typeof val === "string") {
                    if (val.indexOf("/Date(") >= 0) {
                        newDt = new Date(parseInt(val.substring(6)));
                    } else {
                        var subVal = val.split(" ");
                        if (subVal.length === 2) {
                            var dt = subVal[0].split("/");
                            var tm = subVal[1].split(":");
                            newDt = new Date(parseInt(dt[2]), parseInt(dt[1]) - 1, parseInt(dt[0]),
                                    parseInt(tm[0]), parseInt(tm[1]));
                        } else {
                            var dt = subVal[0].split("/");
                            newDt = new Date(parseInt(dt[2]), parseInt(dt[1]) - 1, parseInt(dt[0]));
                        }

                    }
                }
            }
        } catch (e) {
            newDt = null;
        }
        return newDt;
    },
    toDateString : function (val, incTime) {
        var formalizeDate = "";

        if (val instanceof Date) {
            var day = val.getDate() < 10 ? "0" + val.getDate() : val.getDate();
            var mth = (val.getMonth() + 1) < 10 ? "0" + (val.getMonth() + 1) : (val.getMonth() + 1);
            if (incTime) {
                var hours = val.getHours() < 10 ? "0" + val.getHours() : val.getHours();
                var minutes = val.getMinutes() < 10 ? "0" + val.getMinutes() : val.getMinutes();
                var seconds = val.getSeconds() < 10 ? "0" + val.getSeconds() : val.getSeconds();
                formalizeDate = (day + "/" + mth + "/" + val.getFullYear() + " " + hours + ":" + minutes + ":" + seconds);
            } else {
                formalizeDate = (day + "/" + mth + "/" + val.getFullYear());
            }
        }

        return formalizeDate;
    }

};

jQuery(document).ready(function(){
    window.eventData = [];
    window.roomData = [];
    HMS.fdroomganttchart.loadGanttChart();
    HMS.fdroomganttchart.init();
    
});