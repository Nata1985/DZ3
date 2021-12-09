package com.geek.lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyWarehouse1Test {

    public static final int MAX_WAIT_RETRY = 10;

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.moysklad.ru/login/");
        driver.findElement(By.xpath("//input[@name='j_username']")).sendKeys("admin@natafufka23");
        driver.findElement(By.xpath("//input[@name='j_password']")).sendKeys("601f95388e");
        driver.findElement(By.xpath("//*[@type='submit']")).click();
        //Thread.sleep(10000);
        WebElement el = waitElement(driver, "//*[contains(@src, 'procurement')]");
        el.click();
        //driver.findElement(By.xpath("//*[contains(@src, 'procurement')]")).click();
        driver.findElement(By.xpath("//span[text()='Счета поставщиков']")).click();
        driver.findElement(By.xpath("//span[text()='Счет']")).click();
        //driver.findElement(By.xpath("//div[contains(.,'Контрагент') and @class='gwt-Label']/../../td[2]/div/div/div[1]/div[1]/input")).click();
        driver.findElement(By.xpath("//div[contains(.,'Контрагент') and @class='gwt-Label']/../../td[2]/div/div/div[1]/div[1]/input")).click();
        WebElement we = driver.findElement(By.xpath("//div[contains(.,'Контрагент') and @class='gwt-Label']/../../td[2]/div/div/div[1]/div[1]/input"));
        //driver.findElement(By.xpath("//div[contains(.,'Контрагент') and @class='gwt-Label']/../../td[2]/div/div/div[1]/div[1]/input")).sendKeys("розничный покупатель");
        we.sendKeys("розничный покупатель");
        we.sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("//span[text()='Сохранить']")).click();
    }

    private static WebElement waitElement(WebDriver driver, String xPath) throws InterruptedException {
        WebElement we = null;
        for (int i = 0; i < MAX_WAIT_RETRY; i++) {
            try {
                we = driver.findElement(By.xpath(xPath));
                return we;
            } catch (NoSuchElementException e) {
                Thread.sleep(1000);
            }
        }
        return null;
    }
    //driver.quit();








}
