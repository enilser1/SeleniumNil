package com.nil.pom;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.nil.base.Base;
import com.nil.ejercicio.WriteExcelFile;

public class PantallaCotizacion extends Base {

	public PantallaCotizacion() {
		super();
		// TODO Auto-generated constructor stub
	}
	private WriteExcelFile writeFile=new WriteExcelFile();
	List<String> writeList = new ArrayList<String>();
	
	By checkbox = By.id("nav-checkbox2");
	By dropdownLocator = By.xpath("//div[@class='listas-allRisk--box']");
	By primamensualLocator = By.xpath("//p[@class='cotizador-allRisk__monto-mensual--item']");
	By retroceder1Locator = By.xpath("//span[@class='backcotizacion d-none d-lg-block']");
	By retroceder2Locator = By.xpath("//span[@class='backcotizacion']");


	public void seleccionarMarca() throws InterruptedException {
		
		List<WebElement> listas = findElements(dropdownLocator);
		WebElement dropdownList = listas.get(0);
		List<WebElement> options = dropdownList.findElements(By.tagName("div"));
		int i = (int) (Math.random() * options.size());
		click(options.get(i));
		Thread.sleep(1000);

	}
	
	public void seleccionarAnio() throws InterruptedException {

		List<WebElement> listas = findElements(dropdownLocator);
		WebElement dropdownList = listas.get(1);
		List<WebElement> options = dropdownList.findElements(By.tagName("div"));
		int i = (int) (Math.random() * options.size());
		click(options.get(i));
		Thread.sleep(1000);
	}
	
	public void seleccionarModelo() throws InterruptedException {
		
		List<WebElement> listas = findElements(dropdownLocator);	
		WebElement dropdownList = listas.get(2);
		List<WebElement> options = dropdownList.findElements(By.tagName("div"));
		int i = (int) (Math.random() * options.size());
		click(options.get(i));
		Thread.sleep(1000);
	}
	
public String obtenerPrimaMensual() throws InterruptedException {
		
		List<WebElement> listas = findElements(primamensualLocator);
		WebElement primamensual = listas.get(1);
		List<WebElement> options = primamensual.findElements(By.tagName("span"));
		String primaMensual=getText(options.get(0));
		return primaMensual;
		//writeList.add(resultText);
		
		
	}
	
public void retrocederPagina() throws InterruptedException {
		
		WebElement span1 = findElement(retroceder1Locator);	
		WebElement retroceder1=span1.findElement(By.tagName("img"));
		List<WebElement> listas = findElements(retroceder2Locator);	
		WebElement span2 = listas.get(2);
		WebElement retroceder2=span2.findElement(By.tagName("img"));
		
		click(retroceder1);
		Thread.sleep(1000);
		click(retroceder2);
		Thread.sleep(3000);
	
	
	}
	
	

}
