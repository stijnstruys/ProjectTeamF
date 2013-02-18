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

    handleColorPickers();

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
    var test = "leeg";
  /* $.post("/ProjectTeamF-1.0/trip/tripNames.html",
            function (data) {
                test = data;
            }
        );
    alert(test); */
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

function handleColorPickers() {

     var f = $.farbtastic('#picker');
     var p = $('#picker').css('opacity', 0.25);
     var selected;

     $('.colorpicker')
         .each(function () {
             f.linkTo(this);
             $(this).css('opacity', 0.75); })
         .focus(function() {
             if (selected) {
                 $(selected).css('opacity', 0.75).removeClass('colorwell-selected');
             }
             f.linkTo(this);
             p.css('opacity', 1);
             $(selected = this).css('opacity', 1).addClass('colorwell-selected');
         }
     );

    $("#color1").change(function() {
       var color = $("#color1").val();
       $("#content").css("background", color);
    });

    $("#color2").change(function() {
        var color = $("#color2").val();
        $("#content").css("color", color);
    });

    $("#color3").change(function() {
        var color = $("#color3").val();
        $("#content h2").css("color", color);
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
   $.post("/ProjectTeamF-1.0/trip/mail.html",
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
