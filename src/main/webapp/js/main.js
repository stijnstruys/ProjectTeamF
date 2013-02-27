/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

//globale variabele
var beginTripN = "";
var beginTripDescr = "";
var beginTripStartD = "";
var beginTripEndD = "";
var beginTripOrg = "";
var beginTripLoc = "";

$(document).ready(function () {

    //User profile
    userprofile();

    //trips
    trippages();

    //add trip
    addTrip();


    //begin gegevens nemen
    beginTripN = $("#TripN").val();
    beginTripDescr = $("#TripDescr").val();
    beginTripStartD = $("#TripStartD").val();
    beginTripEndD = $("#TripEndD").val();
    beginTripOrg = $("#TripOrg").val();
    beginTripLoc = $("#TripLoc").val();

    //datepicker
    Date.format = 'yy/mm/dd';
    //$(".datepicker").datepicker();
    $("#dateOfBirth").datepicker({
        dateFormat: 'yy/mm/dd',
        defaultDate: '-21Y',
        minDate: '-150Y',
        maxDate: '-16Y',
        changeMonth: true,
        changeYear: true
    });
    $("#TripStartD").datepicker({
        dateFormat: 'yy/mm/dd',
        minDate: '0D',
        changeMonth: true,
        changeYear: true,
        onClose: function (selectedDate) {
            if ($("#TripStartD").val() != "") {
                $("#TripEndD").datepicker("option", "minDate", selectedDate);
            }
        }
    });

    //$("").

    $("#TripEndD").datepicker({
        dateFormat: 'yy/mm/dd',
        minDate: '0D',
        changeMonth: true,
        changeYear: true,
        onClose: function (selectedDate) {
            if ($("#TripEndD").val() != "") {
                $("#TripStartD").datepicker("option", "maxDate", selectedDate);
            }
        }
    });
    /* $(".datepicker").datepicker(
     {
     dateFormat: 'yy-mm-dd',
     minDate: 0,
     maxDate: '+20Y',
     changeMonth: true,
     changeYear: true
     }
     );  */

    //notification
    $("#dialog-message-languages").dialog({
        autoOpen: false,
        width: 'auto',
        modal: true,
        show: {
            effect: "blind",
            duration: 1000
        }
    });

    $("#dialog-message").dialog({
        autoOpen: false,
        width: 'auto',
        modal: true,
        show: {
            effect: "blind",
            duration: 1000
        },
        buttons: {
            Send: function () {
                sendMail();
            },
            Skip: function () {
                $("#viewTripForm").submit();
            }
        }
    });

    $("#updateTrip").click(function () {
        checkChanges();
        $("#dialog-message").dialog("open");
    });

    var availableTags = [
        "ActionScript",
        "AppleScript",
        "Asp",
        "BASIC",
        "C",
        "C++",
        "Clojure",
        "COBOL",
        "ColdFusion",
        "Erlang",
        "Fortran",
        "Groovy",
        "Haskell",
        "Java",
        "JavaScript",
        "Lisp",
        "Perl",
        "PHP",
        "Python",
        "Ruby",
        "Scala",
        "Scheme"
    ];
    /*$("#autocomplete").autocomplete({
     source: 'search/tripNames.html'
     //source: availableTags
     });  */

    /*languages*/
    $("#languageFlag").click(function () {
        checkChanges();
        $("#dialog-message-languages").dialog("open");
    });

    var test = $("hiddenNameList").val();
    // alert(test);
});

function addTrip() {
    $("#add_equipment").click(function() {
        var equipmentToAdd = $("#equipment-input").val();
        if(equipmentToAdd.len)
        var o = new Option(equipmentToAdd, equipmentToAdd);
        $("#trip_equipment").append(o);
        $("#equipment-input").val("");
    });

    $("#remove_equipment").click(function() {
        $("#trip_equipment option:selected").remove();
    });


}

function trippages() {
    var currentpage = $(".trip_pagina_0_content");

    $(".trip_details").hide();
    currentpage.show();

    $(".trip_pagina").click(function () {
        currentpage.hide();
        currentpage = $("." + this.id + "_content");
        currentpage.show();
    });

    /*
     $("#trips_prev").click( function() {

     });

     $("#trips_next").click( function() {

     });

     */
}


function userprofile() {
    $(".profile_input").hide();
    $(".profile_btns").hide();
    $(".hidethis").removeClass("hidethis");

    $("#user_modify_profile").click(function () {
        $(".profile_lbl").hide();
        $(".profile_input").show();
        $(".profile_btns").show();
        $("#user_modify_profile").hide();
        $("#profile_show_pos").removeAttr("disabled");
        $("#profile_show_not").removeAttr("disabled");
    });

    $("#profile_cancel").click(function () {
        $(".profile_lbl").show();
        $(".profile_input").hide();
        $(".profile_btns").hide();
        $("#user_modify_profile").show();
        $("#profile_show_pos").attr('disabled', 'true');
        $("#profile_show_not").attr('disabled', 'true');
        ;
    });

}


function checkChanges() {
    //eind gegevens nemen
    var eindTripN = $("#TripN").val();
    var eindTripDescr = $("#TripDescr").val();
    var eindTripStartD = $("#TripStartD").val();
    var eindTripEndD = $("#TripEndD").val();
    var eindTripOrg = $("#TripOrg").val();
    var eindTripLoc = $("#TripLoc").val();

    //zet oude gegevens
    $("#tripNold").text(beginTripN);
    $("#tripDold").text(beginTripDescr);
    $("#tripStartDold").text(beginTripStartD);
    $("#tripEndDold").text(beginTripEndD);
    $("#tripOrgold").text(beginTripOrg);
    $("#tripLocold").text(beginTripLoc);

    //zet nieuwe gegevens
    $("#tripNnew").text(eindTripN);
    $("#tripDnew").text(eindTripDescr);
    $("#tripStartDnew").text(eindTripStartD);
    $("#tripEndDnew").text(eindTripEndD);
    $("#tripOrgnew").text(eindTripOrg);
    $("#tripLocnew").text(eindTripLoc);

    //zet labels
    $("#tripNmessage").text($("#labelTripN").text());
    $("#tripDmessage").text($("#labelTripDescr").text());
    $("#tripStartDmessage").text($("#labelTripStartD").text());
    $("#tripEndDmessage").text($("#labelTripEndD").text());
    $("#tripOrgmessage").text($("#labelTripOrg").text());
    $("#tripLocmessage").text($("#labelTripLoc").text());

    if (beginTripN != eindTripN) {
        $("#messageRowN").css("opacity", "1");
        $("#tripNmessage").css("font-weight", "bold");
        $("#tripNold").css("font-weight", "bold");
        $("#tripNchange").css("font-weight", "bold");
        $("#tripNnew").css("font-weight", "bold");
    }
    if (beginTripDescr != eindTripDescr) {
        $("#messageRowD").css("opacity", "1");
        $("#tripDmessage").css("font-weight", "bold");
        $("#tripDold").css("font-weight", "bold");
        $("#tripDchange").css("font-weight", "bold");
        $("#tripDnew").css("font-weight", "bold");
    }
    if (beginTripStartD != eindTripStartD) {
        $("#messageRowStartD").css("opacity", "1");
        $("#tripStartDmessage").css("font-weight", "bold");
        $("#tripStartDold").css("font-weight", "bold");
        $("#tripStartDchange").css("font-weight", "bold");
        $("#tripStartDnew").css("font-weight", "bold");
    }
    if (beginTripEndD != eindTripEndD) {
        $("#messageRowEndD").css("opacity", "1");
        $("#tripEndDmessage").css("font-weight", "bold");
        $("#tripEndDold").css("font-weight", "bold");
        $("#tripEndDchange").css("font-weight", "bold");
        $("#tripEndDnew").css("font-weight", "bold");
    }
    if (beginTripOrg != eindTripOrg) {
        $("#messageRowOrg").css("opacity", "1");
        $("#tripOrgmessage").css("font-weight", "bold");
        $("#tripOrgold").css("font-weight", "bold");
        $("#tripOrgchange").css("font-weight", "bold");
        $("#tripOrgnew").css("font-weight", "bold");
    }
    if (beginTripLoc != eindTripLoc) {
        $("#messageRowLoc").css("opacity", "1");
        $("#tripLocmessage").css("font-weight", "bold");
        $("#tripLocold").css("font-weight", "bold");
        $("#tripLocchange").css("font-weight", "bold");
        $("#tripLocnew").css("font-weight", "bold");
    }

}

function sendMail() {

    var formInhoud = $("#changes").html();
    var organiserMessage = $("#Message").val();
    //alert(organiserMessage);
    var tripID = $("#hiddenTripID").val();
    $("#dialog-message").css("cursor", "wait");
    $.post("/ProjectTeamF-1.0/user/mail.html",
        { formulier: formInhoud, orgMessage: organiserMessage, orgMessage2: tripID },
        function (data) {
            $("#viewTripForm").submit();
        }
    );

    /*$.ajax({
     type: "POST",
     url: "/ProjectTeamF-1.0/trip/mail.html",
     data: "formulier="+ formInhoud+ "&orgMessage="+ organiserMessage+ "&tripID="+ tripID,
     success: function(response){
     // we have the response
     alert('gelukt' + response);
     },
     error: function(e){
     alert('mislukt');
     }
     }); */


}
