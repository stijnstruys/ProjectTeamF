$(document).ready(function () {
    function postFunction(type, username, typeUsername, firstname, lastname, id){
        $.post(location.protocol + '//' + location.host + '/ProjectTeamF-1.0/user/addSocial.html', {
            type:type,
            userName:username,
            typeUserName:typeUsername,
            firstName:firstname,
            lastName:lastname,
            id:id
        }, function (data) {

            window.location = "http://localhost:8080/ProjectTeamF-1.0/" + data;
        });
    }

  /*  window.fbAsyncInit = function () {
        FB.init({appId:'534896926530393', status:true, cookie:true, xfbml:true});
    };*/

    FB.Event.subscribe('auth.login', function (response) {
        login();
    });

    FB.Event.subscribe('auth.logout', function (response) {
        logout();
    });

    function login() {
        var fbFirstName;
        var fbLastName;
        var fbId;
        var fbUserName;
        var fbScreenName;
        alert("test");

        FB.api('/me', function (response) {
            if (response.username == null) {
                fbScreenName = response.first_name + response.last_name;
                fbUserName = response.first_name + response.last_name;
            } else {
                fbScreenName = response.username;
                fbUserName = response.username;
            }
            fbFirstName = response.first_name;
            fbLastName = response.last_name;
            fbId = response.id;
            document.getElementsByName("j_username").value = fbUserName;
            postFunction('Facebook',fbUserName, fbScreenName, fbFirstName, fbLastName, fbId);
        });


    }

    function logout() {

    }
})

/*(function(d, s, id) {
    var js, fjs = d.getElementsByTagName(s)[0];
    if (d.getElementById(id)) return;
    js = d.createElement(s); js.id = id;
    js.src = "//connect.facebook.net/nl_NL/all.js#xfbml=1&appId=534896926530393";
    fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));*/
