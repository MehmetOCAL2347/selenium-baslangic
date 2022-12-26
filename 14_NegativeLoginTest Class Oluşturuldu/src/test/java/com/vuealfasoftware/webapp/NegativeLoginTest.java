package com.vuealfasoftware.webapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class NegativeLoginTest {

    @Test
    public void yanlisEmailYanlisSifre(){
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
        inputEmailAdresi.sendKeys("abc@gmail.com");
        inputSifre.sendKeys("abcdef");

        //sleep
        sleep(2000);
        buttonGirisYap.click();

        //driver quit
        chromeDriver.quit();

    }

    private void sleep(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
