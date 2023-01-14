package com.vuealfasoftware.webapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.util.List;

public class LoginTest {

    @Test
    public void LoginTest(){

        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");

        WebDriver chromeDriver = new ChromeDriver();

        chromeDriver.manage().window().maximize();

        //chromeDriver.get("https://vue-alfabank-demo.web.app/main");
        chromeDriver.get("https://vue-alfabank-demo.web.app/login");

        WebElement emailAdresi = chromeDriver.findElement(By.id("userId"));

        emailAdresi.sendKeys("mehmet ocal");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        chromeDriver.quit();

    }

    /*
    @Test
    public  void LoginTestFirefox(){

        System.setProperty("webdriver.geckodriver.driver", "src/main/resources/geckodriver.exe");

        WebDriver fireFoxDriver = new FirefoxDriver();

        fireFoxDriver.manage().window().maximize();

        fireFoxDriver.get("https://vue-alfabank-demo.web.app/main");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        fireFoxDriver.quit();

    }
    */


}
