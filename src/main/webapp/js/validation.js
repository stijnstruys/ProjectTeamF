/**
 * Created with IntelliJ IDEA.
 * User: Jerre
 * Date: 26/02/13
 * Time: 23:00
 * To change this template use File | Settings | File Templates.
 */

var loader = "<img src='../img/validation/loader.gif' />";
var success = "<img src='../img/validation/accepted.png' />";
var failed = "<img src='../img/validation/error_button.png' />";

$(document).ready(function () {
    $("#validation_failed").css("visibility", "visible");
    $("#validation_failed").hide();

    //user registration validation
    user();

    stoppingpoints();
});


function user() {
    var errormsg = "";
    var username = $("#userName");
    var pw = $("#password");
    var email = $("#email");
    var dob = $("#dateOfBirth");
    var usernameok, pwok, emailok, dobok = false;

    //Username
    username.keyup(function () {
        checkUsername();
    });

    function checkUsername() {
        $("#addon_username").html(loader);
        if (username.val().length > 3) {
            $.ajax({
                url: '/ProjectTeamF-1.0/user/checkusername.html',
                data: ({name: username.val()}),
                async: false,
                success: function (data) {
                    if (data == "true") {
                        $("#addon_username").html(failed);
                        usernameok = false;
                        errormsg += "<li>Username already in use!</li>"
                    } else {
                        $("#addon_username").html(success);
                        usernameok = true;
                    }
                }
            });
        } else {
            $("#addon_username").html(failed);
            usernameok = false;
            errormsg += "<li>Username needs to be at least 3 characters long!</li>"
        }

    }


    //password
    pw.keyup(function () {
        checkpw();
    });

    function checkpw() {

        if (pw.val().length < 3) {
            $("#addon_password").html(failed);
            pwok = false;
            errormsg += "<li>Password needs to be at least 3 characters long!</li>";
        } else {
            $("#addon_password").html(success);
            pwok = true;
        }
    }

    //email
    email.keyup(function () {
        checkEmail();
    });

    function checkEmail() {

        var filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
        if (!filter.test(email.val())) {
            $("#addon_email").html(failed);
            emailok = false;
            errormsg += "<li>This is not a valid email address!</li>";
        } else {
            $("#addon_email").html(success);
            emailok = true;
        }

    }

    //Date of birth
    function checkDOB() {
        if (dob.val().length == 0) {
            $("#addon_dob").html(failed);
            errormsg += "<li>Please enter a Date of Birth!</li>";
            dobok = false;
        } else {
            $("#addon_dob").html(success);
            dobok = true;
        }
    }

    dob.change(function () {
        checkDOB();
    });

    //submit
    $("#user").submit(function () {
        $("#validation_failed").hide();
        errormsg = "";
        checkUsername();
        checkpw();
        checkEmail();
        checkDOB();

        if (!usernameok || !pwok || !emailok || !dobok) {
            $("#validation_failed")
                .show()
                .html('<ul>' + errormsg + '</ul>');

            return false;
        }
    });

    //submit profile
    $('#profile_edit').submit(function () {
        $("#validation_failed").hide();
        errormsg = "";
        checkEmail();
        checkDOB();

        if (!emailok || !dobok) {
            $("#validation_failed")
                .show()
                .html('<ul>' + errormsg + '</ul>');

            return false;
        }
    });

}

function stoppingpoints() {
    var emailparticipantok = false;
    var errormsg = "";

    $("#participants-email").keyup(function () {
        checkEmail();
    });

    function checkEmail() {
        if($("#participants-email").val().length > 5) {
            var filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
            if (!filter.test($("#participants-email").val())) {
                $("#addon_email").html(failed);
                emailparticipantok = false;
                errormsg += "<li>This is not a valid email address!</li>";
            } else {
                $("#addon_email").html(success);
                emailparticipantok = true;
            }
        }  else {
            emailparticipantok = false;
            errormsg = "<li>This is not a valid email address!</li>"
            $("#addon_email").html(failed);
        }

    }

    $("#form-participants").submit( function () {

         errormsg = "";
        checkEmail();
        if (!emailparticipantok) {

           $("#validation_failed")
                .show()
                .html('<ul>' + errormsg + '</ul>');

            return false;

        }
    });

}