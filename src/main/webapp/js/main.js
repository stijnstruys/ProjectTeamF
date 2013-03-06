/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

//globale variabele
var beginTripN = "";
var beginTripDescr = "";
var beginTripStartD = "";
var beginTripEndD = "";
var beginTripNot = "";
var beginTripLoc = "";

$(document).ready(function () {

    //User profile
    userprofile();

    //trips
    trippages();

    //add trip
    addTrip();


    //add trip select show descreption
    $("#descriptionType1").show();
    $("#tripTypeSelect").change(function () {
        if ($("#tripTypeSelect").val() == 1) {
            $("#descriptionType1").show();
            $("#descriptionType2").hide();
            $("#descriptionType3").hide();
        }
        else if ($("#tripTypeSelect").val() == 2) {
            $("#descriptionType1").hide();
            $("#descriptionType2").show();
            $("#descriptionType3").hide();
        }
        else if ($("#tripTypeSelect").val() == 3) {
            $("#descriptionType1").hide();
            $("#descriptionType2").hide();
            $("#descriptionType3").show();
        }
    });

    //admin cp trip
    $('#trip_equipment').find('option').removeAttr("selected");
    $("#updateTrip").click(function () {
        $('#trip_equipment').find('option').attr('selected', 'selected');
        checkChanges();
        $("#dialog-message").dialog("open");

    });

    $("#editequipmentbtn").click(function () {
        $('#trip_equipment').find('option').attr('selected', 'selected');
    });

    //add category (trips)
    $("#add_tripcat").click(function () {
        $("#tripCategorie").submit();
    });

    //browse foto
    $("#browse_foto").click(function () {
        $("input[id=foto]").click();
    });

    $("input[id=foto]").change(function () {
        var n = $(this).val().split('\\');
        $("#browse_foto_input").val(n[n.length - 1])
    });

    //begin gegevens nemen
    beginTripN = $("#TripN").val();
    beginTripDescr = $("#TripDescr").val();
    beginTripStartD = $("#TripStartD").val();
    beginTripEndD = $("#TripEndD").val();
    beginTripNot = $("#TripNotificatie").val();
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

    //mail
    $("#skip").click(function () {
        $("#viewTripForm").submit();
    });

    $("#sendMail").click(function () {
        sendMail();
    });

    $("#dialog-message").dialog({
        autoOpen: false,
        width: 'auto',
        modal: true,
        show: {
            effect: "blind",
            duration: 1000
        }
    });

    /*languages*/
    $("#languageFlag").click(function () {
        checkChanges();
        $("#dialog-message-languages").dialog("open");
    });

    var test = $("hiddenNameList").val();
    // alert(test);
});

function addTrip() {
    /* wizard */
    //Variables
    var current;
    var numberOfSteps = 7;
    var firstclick = false;
    var prevhidden = true;
    var nexthidden = false;
    var triptype;
    var errormsg = "";

    $("#temdate").datepicker({
        dateFormat: 'yy/mm/dd',
        minDate: '0D',
        changeMonth: true,
        changeYear: true
    });

    //remove css (otherwise you see it for a few seconds while javascript is loading)
    $(".add_trip_div").css("visibility", "visible");
    $(".add_trip_div").hide();
    $("#add_trip_prev").parent().addClass("disabled");
    $("#validation_failed").css("visibility", "visible");
    $("#validation_failed").hide();
    //show first window
    $("#add_trip_1").show();
    current = 1;

    //next & prev
    $("#add_trip_next").click(function () {
        var validationOk = true;
        if (current < numberOfSteps) {

            /*validation calls*/
            errormsg = "";
            switch (current) {
                case 2:
                    validationOk = checkName();
                    break;
                case 3:
                    validationOk = checkStartAndEnd();
                    break;
                case 4:
                    validationOk = checkDateUntill();
                    break;
            }
            /*end validation calls */
            if (validationOk) {
                $("#validation_failed").hide();
                if (prevhidden) {
                    prevhidden = false;
                    $("#add_trip_prev").parent().removeClass("disabled");
                    triptype = $("#tripTypeSelect").val();
                }

                $("#add_trip_" + current).hide();
                current++;

                if (current == 3) {
                    if (triptype == 3) {
                        current++;
                    }
                }
                if (current == 4) {
                    if (triptype != 2) {
                        current++;
                    }
                }


                $("#add_trip_" + current).show();
                if (current >= numberOfSteps) {
                    $("#add_trip_next").parent().addClass("disabled");
                    nexthidden = true;
                }
            } else {
                $("#validation_failed")
                    .show()
                    .html("<ul>" + errormsg + "</ul>");
            }
        }
    });

    $("#add_trip_prev").click(function () {
        if (current > 1) {

            if (nexthidden) {
                nexthidden = false;
                $("#add_trip_next").parent().removeClass("disabled");
            }

            $("#add_trip_" + current).hide();
            current--;

            if (current == 3) {
                if (triptype == 3) {
                    current--;
                }
            }
            if (current == 4) {
                if (triptype != 2) {
                    current--;
                }
            }
            $("#add_trip_" + current).show();
            if (current <= 1) {
                $("#add_trip_prev").parent().addClass("disabled");
                prevhidden = true;
            }
        }
    });

    /* Equipment */
    $("#add_equipment").click(function () {
        var equipmentToAdd = $("#equipment-input").val();
        if (equipmentToAdd.length > 0) {
            var o = new Option(equipmentToAdd, equipmentToAdd);
            $("#trip_equipment").append(o);
            $("#equipment-input").val("");
        }
    });

    $("#remove_equipment").click(function () {
        $("#trip_equipment option:selected").remove();
    });

    $("#trip_add").click(function () {
        $('#trip_equipment').find('option').attr('selected', 'selected');
    });

    /* validation */

    function checkName() {
        if ($("#tripname").val().length == 0) {
            errormsg += "<li>Enter a name for your trip!</li>";
            $("#cg_tripname").addClass("error");
            return false;
        }
        $("#cg_tripname").removeClass("error");
        return true;
    }

    function checkStartAndEnd() {
        var inorde = true;

        if ($("#TripStartD").val().length == 0) {
            errormsg += "<li>Please select a startdate!</li>";
            $("#cg_startdate").addClass("error");
            inorde = false;
        }

        if ($("#TripEndD").val().length == 0) {
            errormsg += "<li>Please select an enddate!</li>";
            $("#cg_enddate").addClass("error");
            inorde = false;
        }

        if (inorde) {
            $("#cg_enddate").removeClass("error");
            $("#cg_startdate").removeClass("error");
            return true;
        }
        return false;
    }

    function checkDateUntill() {
        if ($("#temdate").val().length == 0) {
            errormsg += "<li>Please select a date!</li>"
            $("#cg_repetition").addClass("error");
            return false;
        }
        $("#cg_repetition").removeClass("error");
        return true;
    }

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
    var eindTripNot = $("#TripNotificatie").val();
    var eindTripLoc = $("#TripLoc").val();

    //zet oude gegevens
    $("#tripNold").text(beginTripN);
    $("#tripDold").text(beginTripDescr);
    $("#tripStartDold").text(beginTripStartD);
    $("#tripEndDold").text(beginTripEndD);
    $("#tripNotold").text(beginTripNot);
    $("#tripLocold").text(beginTripLoc);

    //zet nieuwe gegevens
    $("#tripNnew").text(eindTripN);
    $("#tripDnew").text(eindTripDescr);
    $("#tripStartDnew").text(eindTripStartD);
    $("#tripEndDnew").text(eindTripEndD);
    $("#tripNotnew").text(eindTripNot);
    $("#tripLocnew").text(eindTripLoc);

    //zet labels
    $("#tripNmessage").text($("#labelTripN").text());
    $("#tripDmessage").text($("#labelTripDescr").text());
    $("#tripStartDmessage").text($("#labelTripStartD").text());
    $("#tripEndDmessage").text($("#labelTripEndD").text());
    $("#tripNotmessage").text($("#labelTripNotificatie").text());
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
    if (beginTripNot != eindTripNot) {
        $("#messageRowNot").css("opacity", "1");
        $("#tripNotmessage").css("font-weight", "bold");
        $("#tripNotold").css("font-weight", "bold");
        $("#tripNotchange").css("font-weight", "bold");
        $("#tripNotnew").css("font-weight", "bold");
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

    var mesOrg = $("#messageOrg").text();
    var formInhoud = $("#changes").html();
    var organiserMessage = $("#Message").val();
    var folChange = $("#followingChanges").text();
    var viewTheTrip = $("#viewTheTrip").html();
    var tripID = $("#hiddenTripID").val();

    $.ajax({
        type: "GET",
        url: '/ProjectTeamF-1.0/user/mail.html',
        data: ({mesOrg: mesOrg, followingChanges: folChange, formulier: formInhoud, orgMessage: organiserMessage, tripID: tripID, viewTheTrip: viewTheTrip}),
        async: false,
        success: function (data) {
            if (data == "true") {
                $("#viewTripForm").submit();
            } else {
                alert('Mail failed. Contact admin!');
            }
        }
    });

}
