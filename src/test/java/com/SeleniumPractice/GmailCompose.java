package com.SeleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class GmailCompose {
    public static void composeEmail(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[6]/div[3]/div/div[2]/div[1]/div[1]/div/div"))).click();
        System.out.println("Clicked Compose button.");
        WebElement toButton =driver.findElement(By.name(""));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[24]/div[2]/div/div/div[1]/div/div[1]/div[1]/div/div/div/div[2]/div/div/div[4]/table/tbody/tr/td[2]/form/div[1]"))).sendKeys("hlakkaraju9@example.com");
//        System.out.println("Entered recipient email.");
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(":8h"))).sendKeys("Test Email from Selenium");
//        System.out.println("Entered subject.");
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(":a9"))).sendKeys("This is a test email sent using Selenium for practice.");
//        System.out.println("Entered email body.");
//        wait.until(ExpectedConditions.elementToBeClickable(By.id(":86"))).click();
//        System.out.println("Clicked Send button.");
    }

    public static void main(String[] args) {
        WebDriver driver = GmailLogin.login();
        composeEmail(driver);
        driver.quit();
    }
}