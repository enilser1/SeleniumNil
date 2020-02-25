package com.nil.ejercicio;

import static org.junit.Assert.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Caso1 {
	
	private WebDriver driver;
	By registerLinkLocation=By.linkText("REGISTER");
	By registerPageLocation=By.xpath("//img[@src='/images/nav/logo.gif']");
	By usernameLocator=By.id("email");
	By passwordLocator=By.name("password");
	By confirmpasswordLocator=By.cssSelector("input[name='confirmPassword']");
	By registerbtnLocator=By.name("register");
	
	By userLocator=By.name("userName");
	By passLocator=By.name("password");
	By signInbtnLocator=By.name("login");
	
	By homePage=By.xpath("//img[@src='/images/masts/mast_flightfinder.gif']");
	
	@Before
	public void setUp() throws Exception {
		
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://newtours.demoaut.com/mercurywelcome.php");
	}

	@After
	public void tearDown() throws Exception {
		//driver.quit();
	}

	@Test
	public void registerUser() throws InterruptedException {
		driver.findElement(registerLinkLocation).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(2000);
		
		if(driver.findElement(registerPageLocation).isDisplayed()) {
			driver.findElement(usernameLocator).sendKeys("usernameLocator");
			driver.findElement(passwordLocator).sendKeys("pass1");
			driver.findElement(confirmpasswordLocator).sendKeys("pass1");
			driver.findElement(registerbtnLocator).click();
		}
		else {
			System.out.print("Error Caso 1");
		}
		List<WebElement> fonts=driver.findElements(By.tagName("font"));
		
		
		assertEquals("Note: Your user name is usernameLocator.",fonts.get(5).getText());
	
	}
	
	@Test
	public void signIn() throws InterruptedException {
		if(driver.findElement(userLocator).isDisplayed()) {
			driver.findElement(userLocator).sendKeys("usernameLocator");
			driver.findElement(passLocator).sendKeys("pass1");
			driver.findElement(signInbtnLocator).click();
			
			//Implicit Wait
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			//Explicit Wait
			//Thread.sleep(2000);
			WebDriverWait ewait=new WebDriverWait(driver,10);
			ewait.until(ExpectedConditions.titleContains("quality-stream"));
			
			Wait<WebDriver> fwait = new FluentWait<WebDriver>(driver)
			.withTimeout(10,TimeUnit.SECONDS)
			.pollingEvery(2,TimeUnit.SECONDS)
			.ignoring(NoSuchElementException.class);
			
			assertTrue(driver.findElement(homePage).isDisplayed());
		}
		else {
			System.out.print("Error Caso 2");
		}
	}

}
