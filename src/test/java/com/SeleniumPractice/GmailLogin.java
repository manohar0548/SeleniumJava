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
	public static WebDriver login() {
		// Set up Chrome Options to disable automation flag
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.addArguments("--disable-blink-features=AutomationControlled");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://mail.google.com");
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
        password.sendKeys("abc@123456"); // Replace with your password
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
		return driver;
		
	}
    public static void main(String[] args) {
    	WebDriver driver = login();
        driver.quit();
    
    }
}