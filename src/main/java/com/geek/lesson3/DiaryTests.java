package com.geek.lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DiaryTests {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = getWebDriver();
        try {
            Registration(driver);
            //Authorization(driver);
        } finally {
            if (driver != null) {
               // driver.quit();
            }
        }
    }

    private static void Registration(WebDriver driver) {
        driver.get("https://diary.ru/user/registration");
        WebElement loginField = driver.findElement(By.id("signupform-username"));
        loginField.sendKeys("nata2564790");
        driver.findElement(By.id("signupform-email")).sendKeys("Natafka2559@rambler.ru");
        driver.findElement(By.id("chk_box_user_confirm")).click();
        driver.findElement(By.id("signup_btn")).click();
    }

    public static void Authorization(WebDriver driver) throws InterruptedException {
        driver.get("https://diary.ru/user/login");
        WebElement loginField2 = driver.findElement(By.id("loginform-username"));
        loginField2.sendKeys("Nastya1985");
        driver.findElement(By.id("loginform-password")).sendKeys("gjyxbr");
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='reCAPTCHA']")));
        driver.findElement(By.xpath("//div[@class='recaptcha-checkbox-border']")).click();
        Thread.sleep(10000);
        driver.switchTo().parentFrame();
        driver.findElement(By.id("login_btn")).click();
    }

    private static WebDriver getWebDriver() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }
}