/**
 * Created with IntelliJ IDEA.
 * User: Stijn
 * Date: 20-2-13
 * Time: 9:20
 * To change this template use File | Settings | File Templates.
 */
// Additional JS functions here
window.fbAsyncInit = function() {
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
        } else if (response.status === 'not_authorized') {
            // not_authorized
            importData();
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
            testAPI();
        } else {
            // cancelled
        }
    });
}

function testAPI() {
    FB.getLoginStatus(function(response) {
        FB.api('/me', function(user) {
            var firstName = document.getElementById("firstName");
            var lastName = document.getElementById("lastName");
            var userName = document.getElementById("userName");
            var telephone = document.getElementById("telephone");
            var email = document.getElementById("email");
            var city = document.getElementById("city");

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

            if (user.telephone != null){
                telephone.value = user.telephone;
            }

            if (user.email !=null) {
                email.value = user.email;
            }

            if (user.hometown !=null){
                city.value = user.hometown;
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