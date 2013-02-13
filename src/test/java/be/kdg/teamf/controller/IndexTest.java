package be.kdg.teamf.controller;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * User: Stijn
 * Date: 13-2-13
 * Time: 15:08
 * To change this template use File | Settings | File Templates.
 */
public class IndexTest {
    @Test
    public void logIn(){
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1820,1080));
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //driver.get("http://localhost.com");

        //WebElement query = driver.findElement(By.name(""));

    }
}
