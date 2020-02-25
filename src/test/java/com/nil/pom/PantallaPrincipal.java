package com.nil.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.nil.base.Base;

public class PantallaPrincipal extends Base{

	public PantallaPrincipal() {
		super();
		// TODO Auto-generated constructor stub
	}

	By placaLocator=By.id("vehicleModelPlate");

	
	By homePage=By.xpath("//img[@src='/images/masts/mast_flightfinder.gif']");

	public void ingresarPlaca(String placa) throws InterruptedException {
	
		//if(isDisplayed(placaLocator)) {
			System.out.print("entro");
			sendKeys(placa,placaLocator);
			Thread.sleep(4000);
	
	}

}
