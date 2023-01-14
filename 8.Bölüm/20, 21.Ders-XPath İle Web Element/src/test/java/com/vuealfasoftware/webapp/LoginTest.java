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

        //WebElement emailAdresi = chromeDriver.findElement(By.id("userId"));
        //WebElement sifre = chromeDriver.findElement(By.name("password"));

        //emailAdresi.sendKeys("mehmet ocal");
        //sifre.sendKeys("123456");

        //WebElement emailAdresi = chromeDriver.findElement(By.className("input"));
        //emailAdresi.sendKeys("mehmet ocal");

        /*
        List<WebElement> inputList = chromeDriver.findElements(By.className("input"));
        inputList.get(0).sendKeys("mehmet ocal");
        inputList.get(1).sendKeys("123456");
*/
        //WebElement sifremiUnuttum = chromeDriver.findElement(By.linkText("Şifremi Unuttum"));
        //WebElement kayitOl = chromeDriver.findElement(By.partialLinkText("Kayıt"));
        //WebElement girisYapButon = chromeDriver.findElement(By.tagName("button"));

        //WebElement emailAdresi = chromeDriver.findElement(By.cssSelector("input[class='input background-user']"));
        //WebElement emailAdresi = chromeDriver.findElement(By.cssSelector("input.input"));
        //WebElement emailAdresi = chromeDriver.findElement(By.cssSelector(".input"));
        //WebElement emailAdresi = chromeDriver.findElement(By.cssSelector("input[id='userId']"));
        //WebElement emailAdresi = chromeDriver.findElement(By.cssSelector("input#userId"));
        //WebElement emailAdresi = chromeDriver.findElement(By.cssSelector("#userId"));
        //emailAdresi.sendKeys("mehmet ocal");

        WebElement seleniumGiris = chromeDriver.findElement(By.xpath("//p[starts-with(@class, 'bsform')]"));

        System.out.println(seleniumGiris.getText());

        WebElement emailAdresi = chromeDriver.findElement(By.xpath("//input[@id='userId']"));

        emailAdresi.sendKeys("mehmet ocal");

        WebElement sifreAlanı = chromeDriver.findElement(By.xpath("//input[@type='password']"));

        sifreAlanı.sendKeys("123456");


        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //girisYapButon.click();

        //kayitOl.click();
        //sifremiUnuttum.click();

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
