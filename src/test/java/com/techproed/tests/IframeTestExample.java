package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class IframeTestExample {
    // https://the-internet.herokuapp.com/iframe
    // 1. Adım : Sayfadaki iframe'i bulacağız.
    // 2. Adım : O iframe'in içerisindeki "p" tag name'ine sahip webelementi bulacağız.
    // 3. Adım : İçerisine "Selamlar IFRAME" yazdıracağız.
    // 4. Adım : Iframe'den çıkış yapıp, sayfamıza döneceğiz (defaultContent)
    // 5. Adım : "Elemental Selenium" linkini bulup, tıklayacağız.
    WebDriver driver;
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public void iframe(){
        driver.get("https://the-internet.herokuapp.com/iframe");
        //driver.switchTo().frame(0);
        //driver.switchTo().frame("mce_0_ifr");

        // 1. Adım : Sayfadaki iframe'i bulacağız.
        WebElement frame=driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
        driver.switchTo().frame(frame);

        // 2. Adım : O iframe'in içerisindeki "p" tag name'ine sahip webelementi bulacağız.
        driver.findElement(By.tagName("p")).clear();

        // 3. Adım : İçerisine "Selamlar IFRAME" yazdıracağız.
        driver.findElement(By.xpath("//body[@id='tinymce']")).sendKeys("Selamlar IFRAME");

        // 4. Adım : Iframe'den çıkış yapıp, sayfamıza döneceğiz (defaultContent)
        driver.switchTo().defaultContent();

        // 5. Adım : "Elemental Selenium" linkini bulup, tıklayacağız.
        driver.findElement(By.linkText("Elemental Selenium")).click();

    }
}
