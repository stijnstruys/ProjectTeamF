package be.kdg.teamf.controller;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Keys;


/**
 * Created with IntelliJ IDEA.
 * User: Stijn
 * Date: 13-2-13
 * Time: 15:08
 * To change this template use File | Settings | File Templates.
 */
public class SearchTest {

    private ChromeDriver driver;

    @Test
    public void searchFromIndex(){
        driver = makeChromeDriver();
        search();
        driver.close();
    }
    
    @Test
    public void searchFromAbout(){
        driver = makeChromeDriver();
        WebElement about = driver.findElementById("about");
        about.click();
        search();
        driver.close();
    }

    @Test
    public void searchFromTrip(){
        driver = makeChromeDriver();
        WebElement trip = driver.findElementById("tripOverzicht");
        trip.click();
        search();
        driver.close();
    }
    
    @Test
    public void searchFromRegister(){
        driver = makeChromeDriver();
        WebElement register = driver.findElementById("registerLink");
        register.click();
        search();
        driver.close();
    }

    
    @Test
    public void loggedInSearch(){
        driver = makeChromeDriver();
        logIn();
        search();
        logOut();
        driver.close();
    }

    @After
    public void quitDriver() {
        driver.quit();
    }
    
    
    public void search() {
        WebElement searchBar = driver.findElementByName("searchInput");
        searchBar.sendKeys("Trip1");
        searchBar.sendKeys(Keys.ENTER);
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

