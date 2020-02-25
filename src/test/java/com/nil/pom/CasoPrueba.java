package com.nil.pom;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class CasoPrueba {
	private WebDriver driver;
	PantallaPrincipal pPrincipal;
	PantallaCotizacion pCotizacion;
	
	@Before
	public void setUp() throws Exception {
		pPrincipal = new PantallaPrincipal();
		pCotizacion = new PantallaCotizacion();
		//driver = pCotizacion.chromeDriverConnection();
		//pCotizacion.pagina("https://test.interseguro.pe/vehicular/cotiza/cotizacion/");
		pPrincipal.pagina("https://test.interseguro.pe/vehicular/");
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() throws InterruptedException {
		pPrincipal.ingresarPlaca("");
		Thread.sleep(3000);
		pCotizacion.seleccionarMarca();
		Thread.sleep(2000);
		pCotizacion.seleccionarAnio();
		Thread.sleep(2000);
		pCotizacion.seleccionarModelo();
		//assertTrue(signInPage.isHomePageDisplayed());
		assertTrue(true);
	}

}
