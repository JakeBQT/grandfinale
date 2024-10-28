package com.finaltest.puttingitalltogether;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SauceDemoTestParametersFinal {

	private void pause(int limit) {

		try {
			Thread.sleep(limit * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	WebDriver driver;

	String expectedSuccesfulAssertion1 = "Swag Labs";


	@BeforeMethod
	public void setUp() {
		System.out.println("Launching Google Chrome browser");
		String url = "https://www.saucedemo.com/";
		driver = new ChromeDriver();
		driver.get(url);
	}

	@AfterMethod

	public void closure() {
		System.out.println("Test closure is being initiated");
		
		pause (1);
				
		driver.quit();
	}

	@Test
	@Parameters({"username", "password"})
	public void sauceDemoLogin(String username, String password) {
		
		
		//assertion on the login web page
		WebElement swagLabsAssertionMessage = driver.findElement(By.xpath("//div[contains(text(),'Swag Labs')]"));
		
		Assert.assertTrue(swagLabsAssertionMessage.getText().contains(expectedSuccesfulAssertion1));
		
		
		//all web elements for login
		
		WebElement usernameField = driver.findElement(By.id("user-name"));
		WebElement passwordField = driver.findElement(By.id("password"));
		WebElement loginButton = driver.findElement(By.id("login-button"));
		
		//test steps
		
		usernameField.sendKeys(username);
		passwordField.sendKeys(password);
		loginButton.click();
	
	}
	
	

}
