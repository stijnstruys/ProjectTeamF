/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function(){

    //datepicker
    $(".datepicker").datepicker();
    var test;

    //notification
    $( "#dialog-message" ).dialog({
         autoOpen: false,
         modal: true,
         show: {
           effect: "blind",
           duration: 1000
         },
        buttons: {
            Send: function() {
                $("#viewTripForm" ).submit();
                    },
            Skip: function() {
                $("#viewTripForm" ).submit();
                    }
        }
       });

    $("#updateTrip").click(function(){
        $("#dialog-message" ).dialog( "open" );
      //alert("test");
    });

    $("#sendMail").click(function(){
            $("#viewTripForm" ).submit();
          //alert("test");
        });
    $("#dialog").hide()(function(){
              //  $("#viewTripForm" ).submit();
              alert("test");
            });
    $("#dialog").dialog("hide")(function(){
          //  $("#viewTripForm" ).submit();
          alert("test");
        });
    $( "#dialog").close(function(){
        $("#viewTripForm" ).submit();
      //alert("test");
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
