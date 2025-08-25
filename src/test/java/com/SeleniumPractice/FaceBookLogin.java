package com.SeleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FaceBookLogin {

	public static void main(String[] args) throws Exception {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		Thread.sleep(2000);
		
//		Clicking on Signin Link
		WebElement userName = driver.findElement(By.id("email"));
		userName.sendKeys("manoharlakkaraju@gmail.com");
		
		WebElement password = driver.findElement(By.id("pass"));
		password.sendKeys("13491A0548");
		
		WebElement signIn = driver.findElement(By.xpath("//*[@name=\'login\']"));
		signIn.click();
		Thread.sleep(2000);
		driver.quit();

	}

}
