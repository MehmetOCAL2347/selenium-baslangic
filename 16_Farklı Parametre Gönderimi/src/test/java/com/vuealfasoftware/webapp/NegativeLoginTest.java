package com.vuealfasoftware.webapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class NegativeLoginTest {

    @Test(priority = 2, groups = {"yanlisEmail", "yanlisSifre"})
    @Parameters({"kullaniciEmailAdresi", "kullaniciSifre"})
    public void yanlisEmailYanlisSifre(String kullaniciEmailAdresi, String kullaniciSifre){
        // Driver tanımlıcaz + tam ekran
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().maximize();

        //Login sayfasına yönlendircez
        chromeDriver.get("https://vue-alfabank-demo.web.app/login");

        //WebElementler oluşturulacak
        WebElement inputEmailAdresi = chromeDriver.findElement(By.id("userId"));
        WebElement inputSifre = chromeDriver.findElement(By.xpath("//input[@name='password']"));
        WebElement buttonGirisYap = chromeDriver.findElement(By.cssSelector("button[id='loginButton']"));

        //Derğerlerini göndericez
        inputEmailAdresi.sendKeys(kullaniciEmailAdresi);
        inputSifre.sendKeys(kullaniciSifre);

        //sleep
        sleep(2000);
        buttonGirisYap.click();

        //driver quit
        chromeDriver.quit();

    }

    @Test(priority = 1, groups = {"yanlisEmail", "dogruSifre"})
    @Parameters({"kullaniciEmailAdresi", "kullaniciSifre"})
    public void yanlisEmailDogruSifre(String kullaniciEmailAdresi, String kullaniciSifre){
        // Driver tanımlıcaz + tam ekran
        System.setProperty("webdriver.geckodriver.driver", "src/main/resources/geckodriver.exe");
        WebDriver firefoxDriver = new FirefoxDriver();
        firefoxDriver.manage().window().maximize();

        //Login sayfasına yönlendircez
        firefoxDriver.get("https://vue-alfabank-demo.web.app/login");

        //WebElementler oluşturulacak
        WebElement inputEmailAdresi = firefoxDriver.findElement(By.id("userId"));
        WebElement inputSifre = firefoxDriver.findElement(By.xpath("//input[@name='password']"));
        WebElement buttonGirisYap = firefoxDriver.findElement(By.cssSelector("button[id='loginButton']"));

        //Derğerlerini göndericez
        inputEmailAdresi.sendKeys(kullaniciEmailAdresi);
        inputSifre.sendKeys(kullaniciSifre);

        //sleep
        sleep(2000);
        buttonGirisYap.click();

        //driver quit
        firefoxDriver.quit();

    }

    private void sleep(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
