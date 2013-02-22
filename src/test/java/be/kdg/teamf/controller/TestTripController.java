package be.kdg.teamf.controller;

import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * User: Stijn
 * Date: 14-2-13
 * Time: 14:19
 * To change this template use File | Settings | File Templates.
 */
public class TestTripController {
    private ChromeDriver driver;
    private WebElement tripName;
    private WebElement tripDescription;
    private WebElement tripStartDate;
    private WebElement tripEndDate;
    private WebElement tripOrganiser;
    private WebElement tripStartLocation;

    @Test
    public void trips() throws InterruptedException {
        /*testAddTrip();
        testUpdateTrip();
        testDeleteTrip();*/
    }

    public void testAddTrip() throws InterruptedException {
        driver = getChromeDriver();
        goToTrip();
        List<WebElement> linksTrip = driver.findElementsByTagName("a");
        linksTrip.get(7).click();
        findElements();
        WebElement tripType = driver.findElementByName("tripType");
        List<WebElement> tripAddButton = driver.findElementsByTagName("input");

        tripEndDate.click();
        List<WebElement> datePickerEnd = driver.findElementsByTagName("a");
        datePickerEnd.get(26).click();
        tripType.sendKeys("test");
        tripName.sendKeys("test");
        tripDescription.sendKeys("test");
        tripStartDate.click();
        List<WebElement> datePickerStart = driver.findElementsByTagName("a");
        datePickerStart.get(25).click();
        tripStartLocation.sendKeys("Antwerpen");
        tripOrganiser.sendKeys("Stijn Struys");
        tripAddButton.get(11).click();
        waitAndClose();
    }

    private void waitAndClose() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.close();
    }


    public void testUpdateTrip(){
        driver = getChromeDriver();
        goToTrip();
        goToTripDetail();
        findElements();
        tripName.sendKeys("updatetest");
        WebElement updateButton = driver.findElementById("updateTrip");
        updateButton.click();

        List<WebElement> buttons = driver.findElementsByTagName("button");
        buttons.get(4).click();
        waitAndClose();

    }

    public void testDeleteTrip() {
        driver = getChromeDriver();
        goToTrip();
        goToTripDetail();
        List<WebElement> links = driver.findElementsByTagName("a");
        links.get(7).click();
        waitAndClose();
    }

    private void goToTripDetail() {
        List<WebElement> links = driver.findElementsByTagName("a");
        links.get(8).click();
    }

    private void findElements() {
        tripName = driver.findElementByName("tripName");
        tripDescription = driver.findElementByName("tripDescription");
        tripStartDate = driver.findElementByName("startDate");
        tripEndDate = driver.findElementByName("endDate");
        tripOrganiser = driver.findElementByName("organiser");
        tripStartLocation = driver.findElementByName("startLocation");
    }
    private void goToTrip() {
        List<WebElement> linksIndex = driver.findElementsByTagName("a");
        linksIndex.get(4).click();
    }

    private ChromeDriver getChromeDriver() {
        System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1920,1080));
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://localhost:8080/ProjectTeamF-1.0/general/index.html");
        return driver;
    }
}




