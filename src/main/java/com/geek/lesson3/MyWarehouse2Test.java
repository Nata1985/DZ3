package com.geek.lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyWarehouse2Test {


    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.moysklad.ru/login/");
        driver.findElement(By.xpath("//input[@name='j_username']")).sendKeys("admin@natafufka23");
        driver.findElement(By.xpath("//input[@name='j_password']")).sendKeys("601f95388e");
        driver.findElement(By.xpath("//*[@type='submit']")).click();
        Thread.sleep(10000);
        driver.findElement(By.xpath("//*[contains(@src, 'money')]")).click();
        driver.findElement(By.xpath("//span[text()='Платежи']")).click();
        driver.findElement(By.xpath("//span[text()='Приход']")).click();
       // driver.findElement(By.xpath("//div[@class=\"b-fixed-panel b-fixed-panel-up\"]")).click();
        driver.findElement(By.xpath("//td[text()='Приходный ордер']")).click();
        //driver.findElement(By.xpath("//div[.='Контрагент' and @class='gwt-Label']/../following-sibling::td//div[@class='edit-button']/preceding-sibling::div[@class='border-box']//div[contains(@class,'selector')]" )).click();
       //driver.findElement(By.xpath("//div[.='Контрагент' and @class='gwt-Label']/../following-sibling::td//div[@class='edit-button']/preceding-sibling::div[@class='border-box']//div[contains(@class,'selector')]" )).sendKeys("розничный покупатель");
        driver.findElement(By.xpath("//div[.='Контрагент' and @class='gwt-Label']/../../td[4]/div/div/div/div/input" )).click();
        driver.findElement(By.xpath("//div[@title='natafufka23'] ")).click();
        driver.findElement(By.xpath("//span[text()='Сохранить']")).click();
    }
}
