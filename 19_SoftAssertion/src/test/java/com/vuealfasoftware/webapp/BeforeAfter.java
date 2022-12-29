package com.vuealfasoftware.webapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class BeforeAfter {

    private WebDriver defaultTarayici;

    @BeforeMethod
    @Parameters({"tarayici"})
    public void baslangic(@Optional("chrome") String tarayici){
        if(tarayici.equals("firefox")){
            System.setProperty("webdriver.geckodriver.driver","src/main/resources/geckodriver.exe");
            defaultTarayici = new FirefoxDriver();
        }else {
            //chrome driver oluşturulacak
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
    public void login(String kullaniciEmailAdresi, String kullaniciSifre){

        SoftAssert softAssert = new SoftAssert();

        defaultTarayici.get("https://vue-alfabank-demo.web.app/login");

        WebElement inputEmailAdresi = defaultTarayici.findElement(By.id("userId"));
        WebElement inputSifre = defaultTarayici.findElement(By.xpath("//input[@name='password']"));
        WebElement buttonGirisYap = defaultTarayici.findElement(By.cssSelector("button[id='loginButton']"));

        inputEmailAdresi.sendKeys(kullaniciEmailAdresi);
        inputSifre.sendKeys(kullaniciSifre);

        sleep(2000);
        buttonGirisYap.click();

        softAssert.assertFalse(!defaultTarayici.findElement(By.cssSelector("p[class='bsform-alert']")).isDisplayed());

        System.out.println(defaultTarayici.findElement(By.cssSelector("p[class='bsform-alert']")).isDisplayed());

        WebElement pUyariMesaji = defaultTarayici.findElement(By.cssSelector("p[class='bsform-alert']"));
        String uyariMesaji = pUyariMesaji.getText();
        String beklenenDeger = "Kullanıcı bulunamadı, lütfen şifre ve e-mail alanlarını kontrol ";

        softAssert.assertEquals(uyariMesaji, beklenenDeger);

        System.out.println(uyariMesaji);

        softAssert.assertAll();

    }

    public void sleep(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
