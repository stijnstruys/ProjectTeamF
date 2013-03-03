package be.kdg.teamf.controller;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Keys;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * User: Stijn
 * Date: 13-2-13
 * Time: 15:08
 * To change this template use File | Settings | File Templates.
 */
public class SearchTest {
     @Test
    public void test() {

    }
   /* @Test
    public void logIn() throws InterruptedException{
        ChromeDriver driver = getChromeDriver();

        WebElement dropDown = driver.findElementByClassName("dropdown-toggle");
        dropDown.click();
        WebElement userNameText = driver.findElementByName("j_username");
        userNameText.sendKeys("test");
        WebElement passwordText = driver.findElementByName("j_password");
        passwordText.sendKeys("test");
        WebElement logInButton = driver.findElementByName("submit");
        logInButton.click();
        driver.close();
    }

    @Test
    public void search() {
        ChromeDriver driver = getChromeDriver();
        WebElement searchBar = driver.findElementByName("searchInput");
        searchBar.sendKeys("Trip1");
        searchBar.sendKeys(Keys.ENTER);
    }


    private ChromeDriver getChromeDriver() {
        System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1920,1080));
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://localhost:8080/ProjectTeamF-1.0/general/index.html");
        return driver;
    }*/
}

