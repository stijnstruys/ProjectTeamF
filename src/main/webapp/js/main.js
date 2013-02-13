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

    //begin gegevens nemen
    beginTripN = $("#TripN").val();
    beginTripDescr = $("#TripDescr").val();
    beginTripStartD = $("#TripStartD").val();
    beginTripEndD = $("#TripEndD").val();
    beginTripOrg = $("#TripOrg").val();
    beginTripLoc = $("#TripLoc").val();

    //datepicker
    $(".datepicker").datepicker();
    var test;

    //notification
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
                $("#viewTripForm").submit();
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

    /* $.get("/ProjectTeamF-1.0/trip/tripNames", function(data) {
     test = data;
     }); */
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
    $("#autocomplete").autocomplete({
        source: availableTags
    });
});

function checkChanges() {
    //eind gegevens nemen
    var eindTripN = $("#TripN").val();
    var eindTripDescr = $("#TripDescr").val();
    var eindTripStartD = $("#TripStartD").val();
    var eindTripEndD = $("#TripEndD").val();
    var eindTripOrg = $("#TripOrg").val();
    var eindTripLoc = $("#TripLoc").val();

    //zet oude gegevens
    $("#tripNold").val(beginTripN);
    $("#tripDold").val(beginTripDescr);
    $("#tripStartDold").val(beginTripStartD);
    $("#tripEndDold").val(beginTripEndD);
    $("#tripOrgold").val(beginTripOrg);
    $("#tripLocold").val(beginTripLoc);

    //zet nieuwe gegevens
    $("#tripNnew").val(eindTripN);
    $("#tripDnew").val(eindTripDescr);
    $("#tripStartDnew").val(eindTripStartD);
    $("#tripEndDnew").val(eindTripEndD);
    $("#tripOrgnew").val(eindTripOrg);
    $("#tripLocnew").val(eindTripLoc);

    //zet labels
    $("#tripNmessage").text($("#labelTripN").text());
    $("#tripDmessage").text($("#labelTripDescr").text());
    $("#tripStartDmessage").text($("#labelTripStartD").text());
    $("#tripEndDmessage").text($("#labelTripEndD").text());
    $("#tripOrgmessage").text($("#labelTripOrg").text());
    $("#tripLocmessage").text($("#labelTripLoc").text());

    if (beginTripN != eindTripN) {
        $("#messageRowN").css("opacity", "1");
    }
    if (beginTripDescr != eindTripDescr) {
        $("#messageRowD").css("opacity", "1");
    }
    if (beginTripStartD != eindTripStartD) {
        $("#messageRowStartD").css("opacity", "1");
    }
    if (beginTripEndD != eindTripEndD) {
        $("#messageRowEndD").css("opacity", "1");
    }
    if (beginTripOrg != eindTripOrg) {
        $("#messageRowOrg").css("opacity", "1");
    }
    if (beginTripLoc != eindTripLoc) {
        $("#messageRowLoc").css("opacity", "1");
    }


    //changes += '</div>';
    //$("#changes").html(changes);
    //$("#changes").innerHTML(changes);
    //$("#changes").text(changes);
}

function sendMail() {


}
