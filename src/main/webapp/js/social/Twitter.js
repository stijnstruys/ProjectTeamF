/**
 * Created with IntelliJ IDEA.
 * User: Stijn
 * Date: 26-2-13
 * Time: 14:35
 * To change this template use File | Settings | File Templates.
 */
//tweeten
!function(d,s,id){
    var js,fjs=d.getElementsByTagName(s)[0];
    if(!d.getElementById(id))
    {
        js=d.createElement(s);js.id=id;js.src="//platform.twitter.com/widgets.js";
        fjs.parentNode.insertBefore(js,fjs);
    }
}(document,"script","twitter-wjs");
