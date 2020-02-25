package com.nil.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.nil.base.Base;

public class SignInPage extends Base{

	public SignInPage(WebDriver driver) {
		super();
		// TODO Auto-generated constructor stub
	}
	
	By userLocator=By.name("userName");
	By passLocator=By.name("password");
	By signInbtnLocator=By.name("login");
	
	By homePage=By.xpath("//img[@src='/images/masts/mast_flightfinder.gif']");

	public void signIn() throws InterruptedException {
	
		if(isDisplayed(userLocator)) {
			sendKeys("usernameLocator",userLocator);
			sendKeys("pass1",passLocator);
			click(signInbtnLocator);
		}else {
			System.out.print("Error Caso 2");
		}
	}
	
public boolean isHomePageDisplayed() {
		return isDisplayed(homePage);
	}
}
