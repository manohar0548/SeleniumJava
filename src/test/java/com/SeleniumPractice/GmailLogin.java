package com.SeleniumPractice;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GmailLogin {
    public static void main(String[] args) {
        // Set up Chrome Options to disable automation flag
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.addArguments("--disable-blink-features=AutomationControlled");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://accounts.google.com/v3/signin/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2Fu%2F0%2F&dsh=S422574674%3A1756115204387515&emr=1&flowEntry=ServiceLogin&flowName=GlifWebSignIn&followup=https%3A%2F%2Fmail.google.com%2Fmail%2Fu%2F0%2F&ifkv=AdBytiMgbl_g_E2CcZYVYMdOAmdGah3aN4ZXC9YOHq6uwKTXljlJ31aKX9yEWOf8NZzWcNunMqK5Fw&osid=1&service=mail");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement userName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("identifierId")));
        userName.sendKeys("abc@gmail.com");	//Replace with your username
        List<WebElement> nextButton = driver.findElements(By.tagName("span"));
        for (WebElement button : nextButton) {
            if (button.getText().contains("Next")) {
                button.click();
                break;
            }
        }
        WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("Passwd")));
        password.sendKeys("abcdefgh"); // Replace with your password
        List<WebElement> nextButtonPassword = driver.findElements(By.tagName("span"));
        for (WebElement button : nextButtonPassword) {
            if (button.getText().contains("Next")) {
                button.click();
                break;
            }
        }

        // Verify login success
        try {
            wait.until(ExpectedConditions.urlContains("/mail/u/0"));
            String currentUrl = driver.getCurrentUrl();
            if (currentUrl.contains("/mail/u/0")) {
                System.out.println("Login Successful: Redirected to Gmail inbox.");
            } else {
                System.out.println("Login Failed: Did not reach inbox page.");
            }
        } catch (Exception e) {
            System.out.println("Login Failed: Exception occurred - " + e.getMessage());
        }
        driver.quit();
    }
}