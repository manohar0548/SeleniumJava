package com.SeleniumPractice;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class Locators {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(1000);
		// By name
		WebElement username = driver.findElement(By.name("username"));
		username.sendKeys("Admin");
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("admin123");
		// By tagname
		List<WebElement> loginButton= driver.findElements(By.tagName("button"));
		for(WebElement button : loginButton) {
			if(button.getText().contains("Login")) {
				button.click();
				break;
			}
		}
		Thread.sleep(3000);
		driver.quit();
	}
}