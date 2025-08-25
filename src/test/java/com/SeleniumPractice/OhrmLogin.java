package com.SeleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OhrmLogin {
    public static void main(String[] args) {
        // Set up ChromeDriver using WebDriverManager
//        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        String targetUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";

        try {
            driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        	driver.get(targetUrl);
            driver.manage().window().maximize();
            
            String currentUrl = driver.getCurrentUrl();
            if (currentUrl.contains("opensource-demo.orangehrmlive.com")) {
                System.out.println("URL " + targetUrl + " is open and accessible.");
            } else {
                System.out.println("URL " + targetUrl + " is not open or redirected to: " + currentUrl);
            }

            // Initialize WebDriverWait
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
            driver.getTitle();
            System.out.println("Verified URL" );
            
            WebElement userName = driver.findElement(By.xpath("/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input"));
            userName.sendKeys("Admin");
            WebElement password = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input"));
            password.sendKeys("admin123");
            WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button"));
            loginButton.click();
            Thread.sleep(1000);
        } catch (Exception e) {
            System.err.println("Error during login: " + e.getMessage());
            
        } finally {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            driver.quit();
        }
    }
}