$(document).ready(function () {
    function postFunction(type, username, typeUsername, firstname, lastname, id,email,birthday){
        $.post(location.protocol + '//' + location.host + '/ProjectTeamF-1.0/user/addSocial.html', {
            type:type,
            userName:username,
            typeUserName:typeUsername,
            firstName:firstname,
            lastName:lastname,
            id:id,
            email:email,
            birthday:birthday
        }, function (data) {

            window.location = "http://localhost:8080/ProjectTeamF-1.0/" + data;
        });
    }

    FB.Event.subscribe('auth.login', function (response) {
        login();
    });

    FB.Event.subscribe('auth.logout', function (response) {
        logout();
    });

    function login() {
        logout();
        var fbFirstName;
        var fbLastName;
        var fbId;
        var fbUserName;
        var fbScreenName;
        var fbEmail;
        var fbBirthday;
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
            fbEmail = response.email;;
            fbBirthday = response.birthday;
            postFunction('Facebook',fbUserName, fbScreenName, fbFirstName, fbLastName, fbId,fbEmail,fbBirthday);
        });
    }

    function logout() {

    }
})