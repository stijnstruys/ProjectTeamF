package be.kdg.teamf.controller;

import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Stijn
 * Date: 1-3-13
 * Time: 13:35
 * To change this template use File | Settings | File Templates.
 */
public class RegisterTest {
   /* @Test
    public void register() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("http://localhost:8080/ProjectTeamF-1.0/general/index.html");
        WebElement registerLink = driver.findElementById("registerLink");
        registerLink.click();

        WebElement userName = driver.findElementById("userName");
        WebElement password = driver.findElementById("password");
        WebElement email = driver.findElementById("email");
        WebElement firstName = driver.findElementById("firstName");
        WebElement lastName = driver.findElementById("lastName");
        WebElement dateOfBirth = driver.findElementById("dateOfBirth");
        WebElement telephone = driver.findElementById("telephone");
        WebElement street = driver.findElementById("street");
        WebElement number = driver.findElementById("number");
        WebElement zipcode = driver.findElementById("zipcode");
        WebElement city = driver.findElementById("city");
        WebElement submitButton = driver.findElementById("register_submit");

        userName.sendKeys("test");
        password.sendKeys("test");
        email.sendKeys("stijn.struys@student.kdg.be");
        firstName.sendKeys("test");
        lastName.sendKeys("test");
        telephone.sendKeys("034598685");
        street.sendKeys("Test");
        number.sendKeys("12");
        zipcode.sendKeys("2275");
        city.sendKeys("Wechelderzande");
        dateOfBirth.click();
        List<WebElement> datePickerDateOfBirth = driver.findElementsByTagName("a");
        datePickerDateOfBirth.get(25).click();
        submitButton.click();

    }             */
}
