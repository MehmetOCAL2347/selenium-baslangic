package com.vuealfasoftware.webapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

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

        defaultTarayici.get("https://vue-alfabank-demo.web.app/login");

        WebElement inputEmailAdresi = defaultTarayici.findElement(By.id("userId"));
        WebElement inputSifre = defaultTarayici.findElement(By.xpath("//input[@name='password']"));
        WebElement buttonGirisYap = defaultTarayici.findElement(By.cssSelector("button[id='loginButton']"));

        inputEmailAdresi.sendKeys(kullaniciEmailAdresi);
        inputSifre.sendKeys(kullaniciSifre);

        sleep(2000);
        buttonGirisYap.click();

        Assert.assertFalse(defaultTarayici.findElement(By.cssSelector("p[class='bsform-alert']")).isDisplayed());

        System.out.println(defaultTarayici.findElement(By.cssSelector("p[class='bsform-alert']")).isDisplayed());

    }

    public void sleep(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
