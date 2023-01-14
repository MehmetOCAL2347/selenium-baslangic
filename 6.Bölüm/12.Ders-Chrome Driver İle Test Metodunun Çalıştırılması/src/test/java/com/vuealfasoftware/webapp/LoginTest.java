package com.vuealfasoftware.webapp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LoginTest {

    @Test
    public void LoginTest(){

        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");

        WebDriver chromeDriver = new ChromeDriver();

        chromeDriver.manage().window().maximize();

        chromeDriver.get("https://vue-alfabank-demo.web.app/main");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        chromeDriver.quit();

    }

}
