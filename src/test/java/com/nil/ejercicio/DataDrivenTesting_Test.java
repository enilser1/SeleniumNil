package com.nil.ejercicio;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DataDrivenTesting_Test {
	
	private WebDriver driver;
	private WriteExcelFile writeFile;
	private ReadExcelFile readFile;
	private ReadExcelFile2 readFile2;
	private By searchBoxLocator = By.id("search_query_top");
	private By searchBtnLocator = By.name("submit_search");
	private By resultTextLocator = By.cssSelector("span.heading-counter");
	
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		//driver = new ChromeDriver();
		writeFile = new WriteExcelFile();
		readFile = new ReadExcelFile();
		readFile2 = new ReadExcelFile2();
		
		//driver.get("http://automationpractice.com/index.php");
	}

	
	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void test() throws IOException, InterruptedException {
		//String rutaExcel="C:\\Users\\USER\\Desktop\\Test.xlsx";
		String rutaExcel="./src/test/resources/excel/Test.xlsx";
		List<String> readList=readFile.readExcel(rutaExcel, "Hoja1");
		//List<String> readList2=readFile2.readExcel(rutaExcel, "Hoja1");
		
		
		//String searchText = readFile.getCellValue(rutaExcel, "Hoja1", 0, 0);
		
		//List<String> writeList = new ArrayList<String>();
		for (int i = 0; i < readList.size(); i++) {
			
			
			driver = new ChromeDriver();
			driver.get("http://automationpractice.com/index.php");
			String searchText = readList.get(i).toString();
			driver.findElement(searchBoxLocator).sendKeys(searchText);
			driver.findElement(searchBtnLocator).click();
			Thread.sleep(3000);
			String resultText = driver.findElement(resultTextLocator).getText();
			//writeList.add(resultText);
			writeFile.writeCellValue(rutaExcel, "Hoja1", i, 1, resultText);
			driver.quit();
			
			
			
		}
		
		//writeFile.writeExcel(rutaExcel, "Hoja1", writeList);
		
		

	}

}
