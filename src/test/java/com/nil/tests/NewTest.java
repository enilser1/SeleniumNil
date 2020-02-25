package com.nil.tests;

import org.testng.annotations.Test;

import com.nil.base.Base;
import com.nil.ejercicio.ReadExcelFile;
import com.nil.ejercicio.ReadExcelFile2;
import com.nil.ejercicio.WriteExcelFile;
import com.nil.pom.PantallaCotizacion;
import com.nil.pom.PantallaPrincipal;

import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.FileHandler;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class NewTest extends Base{
	private WebDriver driver;
	PantallaPrincipal pPrincipal;
	PantallaCotizacion pCotizacion;
	ReadExcelFile2 readExcelFile2;
	WriteExcelFile writeExcelFile;
	List<String> writeList;
	
	/*
	 * By signInLocator = By.linkText("Sign in"); By emailLocator = By.id("email");
	 * By passwordLocator = By.id("passwd"); By signInButtonLocator =
	 * By.id("SubmitLogin");
	 * 
	 * By signOutButtonLocator= By.cssSelector("a.logout");
	 */
	
	@BeforeClass
	  public void beforeClass() {
		
		pPrincipal = new PantallaPrincipal();
		pCotizacion = new PantallaCotizacion();
		pPrincipal.pagina("https://test.interseguro.pe/vehicular/");
		readExcelFile2 = new ReadExcelFile2();
		writeExcelFile = new WriteExcelFile();
		writeList = new ArrayList<String>();
		
		//driver = pCotizacion.chromeDriverConnection();
		//pCotizacion.pagina("https://test.interseguro.pe/vehicular/cotiza/cotizacion/");
		
		
		/*
		 * System.setProperty("webdriver.chrome.driver",
		 * "./src/test/resources/chromedriver/chromedriver.exe"); driver = new
		 * ChromeDriver(); driver.manage().window().maximize();
		 * driver.get("http://automationpractice.com/index.php");
		 */
	  }
	
  @Test(dataProvider = "authenticationData")
  public void login(String placa,String exe) throws InterruptedException, Exception {
	  
	 
	  	pPrincipal.ingresarPlaca(placa);
	  	
		pCotizacion.seleccionarMarca();
		
		pCotizacion.seleccionarAnio();
		
		pCotizacion.seleccionarModelo();
		
		capturarPantalla(placa);
		
		writeList.add(pCotizacion.obtenerPrimaMensual());
		
		pCotizacion.retrocederPagina();
		
		//assertTrue(signInPage.isHomePageDisplayed());
		assertTrue(true);
		/*
		 * if(driver.findElement(signInLocator).isDisplayed()) {
		 * driver.findElement(signInLocator).click();
		 * 
		 * WebDriverWait wait = new WebDriverWait(driver,10);
		 * wait.until(ExpectedConditions.presenceOfElementLocated(emailLocator));
		 * 
		 * driver.findElement(emailLocator).sendKeys(email);
		 * driver.findElement(passwordLocator).sendKeys(password);
		 * driver.findElement(signInButtonLocator).click();
		 * 
		 * assertEquals(driver.findElement(signOutButtonLocator).getText(),"Sign out");
		 * 
		 * driver.findElement(signOutButtonLocator).click(); }else {
		 * System.out.println("Sign in link is not present"); }
		 */
  }

  @DataProvider(name="authenticationData")
  public Object[][] getData() throws Exception {
	  
	  Object[][] testObjArray = readExcelFile2.readExcel("./src/test/resources/excel/Test.xlsx","Hoja1");
	  
      return (testObjArray);
	  
		/*
		 * Object[][]data=new Object[3][2];
		 * 
		 * data[0][0]="qs123@gmail.com"; data[0][1]="GGG129";
		 * data[1][0]="testng_qs@gmail.com"; data[1][1]="GGG130";
		 * data[2][0]="sasa@gmail.com"; data[2][1]="GGG131";
		 */

   
   //Object[][] testObjArray = ExcelUtils.getTableArray("D://ToolsQA//OnlineStore//src//testData//TestData.xlsx","Sheet1");
   
   //return (testObjArray);
  // return data;
  }
  

  @AfterClass
  public void afterClass() throws Exception {
	  writeExcelFile.writeExcel("./src/test/resources/excel/Test.xlsx", "Hoja1", writeList);
	  //driver.close();
  }

}
