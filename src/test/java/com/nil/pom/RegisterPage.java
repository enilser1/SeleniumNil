package com.nil.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.nil.base.Base;

public class RegisterPage extends Base{

	public RegisterPage(WebDriver driver) {
		super();
		// TODO Auto-generated constructor stub
	}

	By registerLinkLocation=By.linkText("REGISTER");
	By registerPageLocation=By.xpath("//img[@src='/images/nav/logo.gif']");
	By usernameLocator=By.id("email");
	By passwordLocator=By.name("password");
	By confirmpasswordLocator=By.cssSelector("input[name='confirmPassword']");
	By registerbtnLocator=By.name("register");
	
	By registeredMessage = By.tagName("font");
	
	public void registerUser() throws InterruptedException {
		click(registerLinkLocation);
		Thread.sleep(2000);
		if(isDisplayed(registerPageLocation)) {
			sendKeys("usernameLocator",usernameLocator);
			sendKeys("pass1",passwordLocator);
			sendKeys("pass1",confirmpasswordLocator);
			click(registerbtnLocator);
		}else {
			System.out.print("Error Caso 1");
		}
	}
	
	public String registeredMessage() {
		
		List<WebElement> fonts=findElements(registeredMessage);
		return getText(fonts.get(5));
	}
}
