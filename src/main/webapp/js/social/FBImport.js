/**
 * Created with IntelliJ IDEA.
 * User: Stijn
 * Date: 20-2-13
 * Time: 9:20
 * To change this template use File | Settings | File Templates.
 */
// Additional JS functions here
$(document).ready(function () {
    $("#user_importfb").click(function() {
        importD();
    });
});

function importD() {
    FB.init({
        appId      : '534896926530393', // App ID
        channelUrl : '//http://localhost:8080/channel.html', // Channel File
        status     : true, // check login status
        cookie     : true, // enable cookies to allow the server to access the session
        xfbml      : true  // parse XFBML
    });

    FB.getLoginStatus(function(response) {
        if (response.status === 'connected') {
            // connected
            importData();
        } else if (response.status === 'not_authorized') {
            // not_authorized

        } else {
            // not_logged_in
            importData();
        }
    });

};

function importData() {
    FB.login(function(response) {
        if (response.authResponse) {
            // connected
            userSettings();
        } else {
            // cancelled
        }
    }, {scope: 'email,user_birthday,user_hometown,publish_actions'});
}

function userSettings() {
    FB.getLoginStatus(function(response) {
        FB.api('/me', function(user) {
            var firstName = document.getElementById("firstname");
            var lastName = document.getElementById("lastname");
            var userName = document.getElementById("userName");
            var email = document.getElementById("email");
            var city = document.getElementById("city");
            var dateOfBirth = document.getElementById("dateOfBirth");
            // alert(""+user.firstName & "+" & user.first_name );
            if(user.first_name != null) {
                firstName.value = user.first_name;
            }

            if(user.last_name !=null) {
                lastName.value = user.last_name;
            }

            if (user.username !=null)  {
                userName.value = user.username;
            }  else {
                userName.value = user.name;
            }

            if (user.email !=null) {
                email.value = user.email;
            }

          if(user.birthday !=null){
                dateOfBirth.value= user.birthday;
            }
        });
    });
}

// Load the SDK Asynchronously
(function(d){
    var js, id = 'facebook-jssdk', ref = d.getElementsByTagName('script')[0];
    if (d.getElementById(id)) {return;}
    js = d.createElement('script'); js.id = id; js.async = true;
    js.src = "//connect.facebook.net/en_US/all.js";
    ref.parentNode.insertBefore(js, ref);
}(document));
