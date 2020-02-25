package com.nil.pom;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class SignIn_Test {
	private WebDriver driver;
	SignInPage signInPage;
	
	@Before
	public void setUp() throws Exception {
		signInPage = new SignInPage(driver);
		driver = signInPage.chromeDriverConnection();
		signInPage.pagina("http://newtours.demoaut.com/mercurywelcome.php");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() throws InterruptedException {
		signInPage.signIn();
		Thread.sleep(2000);
		assertTrue(signInPage.isHomePageDisplayed());
	}

}
