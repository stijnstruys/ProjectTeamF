/**
 * Created with IntelliJ IDEA.
 * User: Stijn
 * Date: 26-2-13
 * Time: 13:42
 * To change this template use File | Settings | File Templates.
 */

//facebook like
(function(d, s, id) {
    var js, fjs = d.getElementsByTagName(s)[0];
    if (d.getElementById(id)) return;
    js = d.createElement(s); js.id = id;
    js.src = "//connect.facebook.net/nl_NL/all.js#xfbml=1&appId=534896926530393";
    fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'), {scope: 'publish_actions,publish_stream'});

