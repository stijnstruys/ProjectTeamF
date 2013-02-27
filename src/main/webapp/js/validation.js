/**
 * Created with IntelliJ IDEA.
 * User: Jerre
 * Date: 26/02/13
 * Time: 23:00
 * To change this template use File | Settings | File Templates.
 */

var loader = "<img src='../img/validation/loader.gif' />";
var success ="<img src='../img/validation/accepted.png' />";
var failed ="<img src='../img/validation/error_button.png' />";

$(document).ready(function () {
    $("#validation_failed").css("visibility", "visible");
    $("#validation_failed").hide();

    //user registration validation
    registration();

    //add new trip
    trip();
});

function trip() {
    var errormsg;
    var go;
    removeErrors();

    $('#add_trip_form').submit( function() {
        go = true;
        errormsg = "";
         removeErrors();

        if($("#tripname").val().length == 0) {
            go = false;
            errormsg += "<li>Enter a name for your trip!</li>";
            $("#cg_tripname").addClass("error");
        }

        if( $("#TripStartD").val().length == 0 ) {
            go = false;
            errormsg += "<li>Please select a startdate!</li>";
            $("#cg_startdate").addClass("error");
        }

        if( $("#TripEndD").val().length == 0 ) {
            go = false;
            errormsg += "<li>Please select an enddate!</li>";
            $("#cg_enddate").addClass("error");
        }

        if(!go) {
            $("#validation_failed")
                .show()
                .html('<ul>' + errormsg + '</ul>');
            return false;
        }
    });

    $("#trip_reset").click( function() {
        removeErrors();
        $("#validation_failed").hide();
        $("#trip_equipment").html("");
    });

    function removeErrors() {
        $("#cg_tripname").removeClass("error");
        $("#cg_startdate").removeClass("error");
        $("#cg_enddate").removeClass("error");
    }
}

function registration() {
    var errormsg = "";
    var username = $("#userName");
    var pw = $("#password");
    var email = $("#email");

    var usernameok, pwok, emailok = false;

    //Username
    username.keyup( function() {
        checkUsername();
    });

    function checkUsername() {
        $("#addon_username").html(loader);
        if(username.val().length > 3) {
            $.ajax({
                url: '/ProjectTeamF-1.0/user/checkusername.html',
                data: ({name : username.val()}),
                async: false,
                success: function(data) {
                    if( data == "true" ) {
                        $("#addon_username").html(failed);
                        usernameok = false;
                        errormsg += "<li>Username already in use!</li>"
                    } else {
                        $("#addon_username").html(success);
                        usernameok = true;
                    }
                }
            });
        }  else {
            $("#addon_username").html(failed);
            usernameok = false;
            errormsg += "<li>Username needs to be at least 3 characters long!</li>"
        }

    }

    //password
    pw.keyup(function() {
        checkpw();
    });

    function checkpw(  ) {

        if(pw.val().length < 3){
            $("#addon_password").html(failed);
            pwok = false;
            errormsg += "<li>Password needs to be at least 3 characters long!</li>"
        } else {
            $("#addon_password").html(success);
            pwok = true;
        }
    }

    //email
    email.keyup(function() {
        checkEmail();
    });

    function checkEmail() {

        var filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
        if (!filter.test(email.val())) {
            $("#addon_email").html(failed);
            emailok = false;
            errormsg += "<li>This is not a valid email address!</li>"
        } else{
            $("#addon_email").html(success);
            emailok = true;
        }

    }

    $("#trip_add").click(function() {
        $('#trip_equipment').find('option').attr('selected','selected');
    });
    //submit
    $("#user").submit( function() {
        $("#validation_failed").hide();
        $("#trip_equipment").
        errormsg = "";
        checkUsername();
        checkpw();
        checkEmail();


        if(!usernameok || !pwok || !emailok)  {
            $("#validation_failed")
                .show()
                .html('<ul>' + errormsg + '</ul>');

            return false;
        }
    });

}