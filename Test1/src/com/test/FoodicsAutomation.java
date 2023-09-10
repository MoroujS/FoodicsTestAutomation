package com.test;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;;
import org.testng.annotations.Test;


public class FoodicsAutomation {

    //--------------------------------StartTesting-----------------------------------
    @Test(timeOut = 20000)
    public void basicTest1() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\TestCrew\\Downloads\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        System.out.println("Opening Url");
        driver.get("https://www.google.com/");
        driver.findElement(By.xpath("//body//a[text()='English']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//form//textarea[@id='APjFqb']")).sendKeys("Food");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//form//textarea[@id='APjFqb']")).clear();
        Thread.sleep(2000);
        WebElement SearchBox = driver.findElement(By.xpath("//form//textarea[@id='APjFqb']"));
        SearchBox.sendKeys("Foodics",Keys.ENTER);
        Thread.sleep(2000);
        String Result = driver.findElement(By.xpath("//body//div[@id='result-stats']")).getText();
        Assert.assertTrue(Result.contains("results"));
        Thread.sleep(2000);
        WebElement Related = driver.findElement(By.xpath("(//div[@role='heading'])[3]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Related);
        Thread.sleep(2000);
        driver.close();
    }
}
