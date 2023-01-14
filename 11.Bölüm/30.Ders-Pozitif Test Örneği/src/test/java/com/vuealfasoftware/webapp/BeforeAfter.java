package com.vuealfasoftware.webapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BeforeAfter {

    private WebDriver defaultTarayici;

    @BeforeMethod
    @Parameters({"tarayici"})
    public void baslangic(String tarayici){
        if(tarayici.equals("firefox")){
            System.setProperty("webdriver.geckodriver.driver", "src/main/resources/geckodriver.exe");
            defaultTarayici = new FirefoxDriver();
        }else {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
            defaultTarayici = new ChromeDriver();
        }
        defaultTarayici.manage().window().maximize();
    }

    @AfterMethod
    public void bitis(){
        defaultTarayici.quit();
    }

    @Test
    @Parameters({"kullaniciEmailAdresi", "kullaniciSifre"})
    public void loginTest(String kullaniciEmailAdresi, String kullaniciSifre){
        defaultTarayici.get("https://vue-alfabank-demo.web.app/login");

        //WebElementler oluşturulacak
        WebElement inputEmailAdresi = defaultTarayici.findElement(By.id("userId"));
        WebElement inputSifre = defaultTarayici.findElement(By.xpath("//input[@name='password']"));
        WebElement buttonGirisYap = defaultTarayici.findElement(By.cssSelector("button[id='loginButton']"));

        //Derğerlerini göndericez
        inputEmailAdresi.sendKeys(kullaniciEmailAdresi);
        inputSifre.sendKeys(kullaniciSifre);

        //sleep
        sleep(2000);
        buttonGirisYap.click();
    }

    public void sleep(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
