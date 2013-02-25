/**
 * Created with IntelliJ IDEA.
 * User: Jorne
 * Date: 25/02/13
 * Time: 17:00
 * To change this template use File | Settings | File Templates.
 */

var counter = 1;
function addEquipment() {

    $("#newEquip").before('<tr><td id=equipmentnew'+counter+' ><input type="text" value="" name="equipment"/><button class="btn"  type="button" onclick="removeEquipment(\'equipmentnew'+counter+'\')">X</button></td></tr>');
    counter++;
}
function removeEquipment(s) {

    $("#"+s).remove();

}
