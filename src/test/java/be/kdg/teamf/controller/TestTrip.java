package be.kdg.teamf.controller;

import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.internal.FindsByName;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * User: Stijn
 * Date: 14-2-13
 * Time: 14:19
 * To change this template use File | Settings | File Templates.
 */
public class TestTrip {

    private ChromeDriver driver;

    @Test
    public void addTrip() {
     /*   driver = makeChromeDriver();
        logIn();
        WebElement trip = driver.findElementById("tripOverzicht");
        trip.click();
        WebElement addtripbtn = driver.findElementById("addtripbtn");
        addtripbtn.click();

        WebElement add_trip_next = driver.findElementById("add_trip_next");
        add_trip_next.click();

        WebElement tripname = driver.findElementById("tripname");
        WebElement tripDescription = driver.findElementById("tripDescription");

        tripname.sendKeys("Test selenium");
        tripDescription.sendKeys("Dropping door scouts");
        add_trip_next.click();

        WebElement tripEndD = driver.findElementById("TripEndD");
        tripEndD.click();
        List<WebElement> endDate = driver.findElementsByTagName("a");
        endDate.get(36).click();

        WebElement tripStartD = driver.findElementById("TripStartD");
        tripStartD.click();
        List<WebElement> startDate = driver.findElementsByTagName("a");
        startDate.get(35).click();

        add_trip_next.click();

        WebElement startLocation = driver.findElementById("startLocation");
        WebElement notification = driver.findElementById("notification");

        startLocation.sendKeys("Wechelderzande");
        notification.sendKeys("Dropping");
        add_trip_next.click();

        WebElement equipmentInput = driver.findElementById("equipment-input");
        Select tripEquipment = new Select (driver.findElementById("trip_equipment"));
        WebElement addEquipment = driver.findElementById("add_equipment");
        WebElement removeEquipment = driver.findElementById("remove_equipment");

        equipmentInput.sendKeys("test");
        addEquipment.click();
        tripEquipment.selectByIndex(0);
        removeEquipment.click();
        equipmentInput.sendKeys("Rugzak");
        addEquipment.click();
        add_trip_next.click();

        WebElement tripAdd = driver.findElementById("trip_add");
        tripAdd.click();
        driver.close();*/
    }

    @Test
    public void updateTrip(){
       /* driver = makeChromeDriver();
        logIn();
        headerDropDownClick();
        WebElement myTripsLink = driver.findElementById("myTripsLink");
        myTripsLink.click();

        WebElement tripLink = (WebElement) driver.findElementsByClassName("trip_name");
        tripLink.click();
        driver.quit();*/

    }

    @Test
    public void deleteTrip() {

    }

    public void logIn() {
        headerDropDownClick();
        WebElement userNameText = driver.findElementByName("j_username");
        userNameText.sendKeys("test");
        WebElement passwordText = driver.findElementByName("j_password");
        passwordText.sendKeys("test");
        WebElement logInButton = driver.findElementByName("submit");
        logInButton.click();
    }

    private void headerDropDownClick() {
        WebElement dropDown = driver.findElementByClassName("dropdown-toggle");
        dropDown.click();
    }

    public void logOut(){
        headerDropDownClick();
        WebElement logoutLink = driver.findElementById("logoutLink");
        logoutLink.click();
    }


    private ChromeDriver makeChromeDriver() {
        System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1920,1080));
        driver.get("http://localhost:8080/ProjectTeamF-1.0/general/index.html");
        return driver;
    }

}