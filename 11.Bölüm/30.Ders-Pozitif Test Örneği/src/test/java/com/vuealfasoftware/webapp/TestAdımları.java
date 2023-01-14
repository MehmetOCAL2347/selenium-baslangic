package com.vuealfasoftware.webapp;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestAdımları {

    private WebDriver defaultTarayici;

    @BeforeMethod
    public void baslangic(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        defaultTarayici = new ChromeDriver();
        defaultTarayici.manage().window().maximize();
    }

    @AfterMethod
    public void bitis(){
        defaultTarayici.quit();
    }

    @Test
    public void emptyAreas(){
        defaultTarayici.get("https://vue-alfabank-demo.web.app/login");

        WebElement buttonGiris = defaultTarayici.findElement(By.id("loginButton"));
        buttonGiris.click();

        WebElement alertEmail = defaultTarayici.findElement(By.xpath("//p[contains(text(), 'Lütfen e-mail adresinizi giriniz')]"));
        WebElement alertPassword = defaultTarayici.findElement(By.xpath("//p[contains(text(), 'Lütfen kullanıcı şifrenizi giriniz')]"));

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(alertEmail.isDisplayed());
        softAssert.assertTrue(alertPassword.isDisplayed());
        softAssert.assertEquals(alertEmail.getText(), "Lütfen e-mail adresinizi giriniz");
        softAssert.assertEquals(alertPassword.getText(), "Lütfen kullanıcı şifrenizi giriniz");

        softAssert.assertAll();

    }


    @Test
    public void successLogin(){
        defaultTarayici.get("https://vue-alfabank-demo.web.app/login");

        WebElement inputEmail = defaultTarayici.findElement(By.id("userId"));
        WebElement inputPassword = defaultTarayici.findElement(By.id("password"));
        WebElement buttonGiris = defaultTarayici.findElement(By.id("loginButton"));

        inputEmail.sendKeys("udemySelenium@gmail.com");
        inputPassword.sendKeys("udemySelenium!");
        buttonGiris.click();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(defaultTarayici.getCurrentUrl(), "https://vue-alfabank-demo.web.app/main");
        softAssert.assertAll();
    }
}
