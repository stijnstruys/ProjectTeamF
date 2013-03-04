package be.kdg.teamf.controller;

import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.internal.FindsByName;

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
        makeChromeDriver();
        logIn();
        driver = makeChromeDriver();
        WebElement trip = driver.findElementById("tripOverzicht");
        trip.click();




    }

    @Test
    public void updateTrip(){

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