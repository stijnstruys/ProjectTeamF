package be.kdg.teamf.controller;

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
        driver = MakeChromeDriver();
        search();
        driver.close();
    }
    
    @Test
    public void searchFromAbout(){
        driver = MakeChromeDriver();
        WebElement about = driver.findElementById("about");
        about.click();
        search();
        driver.close();
    }

    @Test
    public void searchFromTrip(){
        driver = MakeChromeDriver();
        WebElement trip = driver.findElementById("tripOverzicht");
        trip.click();
        search();
        driver.close();
    }
    
    @Test
    public void searchFromRegister(){
        driver = MakeChromeDriver();
        WebElement register = driver.findElementById("registerLink");
        register.click();
        search();
        driver.close();
    }

    
    @Test
    public void loggedInSearch(){
        driver = new ChromeDriver();
        
    }
    
    
    public void search() {
        WebElement searchBar = driver.findElementByName("searchInput");
        searchBar.sendKeys("Trip1");
        searchBar.sendKeys(Keys.ENTER);
    }


    private ChromeDriver MakeChromeDriver() {
        System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1920,1080));
        driver.get("http://localhost:8080/ProjectTeamF-1.0/general/index.html");
        return driver;
    }
}

