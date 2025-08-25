package com.SeleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

	public static void main(String[] args) throws Exception {
		WebDriver driver = new ChromeDriver();
		driver.get("https://github.com/");
		Thread.sleep(2000);
		
//		Clicking on Signin Link
		WebElement signInButton = driver.findElement(By.linkText("Sign in"));
		signInButton.click();
		Thread.sleep(2000);
		
//		Login Page
		WebElement loginInputField = driver.findElement(By.id("login_field"));
		loginInputField.sendKeys("usename");
		WebElement passwordField = driver.findElement(By.id("password"));
		passwordField.sendKeys("password");
		WebElement loginButton = driver.findElement(By.name("commit"));
		loginButton.click();
		Thread.sleep(2000);
		driver.quit();

	}

}
