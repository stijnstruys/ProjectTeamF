/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function(){

    //datepicker
    $(".datepicker").datepicker();
    var test;

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
