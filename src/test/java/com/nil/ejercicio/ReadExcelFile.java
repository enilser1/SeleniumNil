package com.nil.ejercicio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFile {
	public ReadExcelFile() {
		
	}
public List<String> readExcel(String rutaExcel,String hojaExcel) throws IOException {
	/* Nuevo fichero generico */
	File file = new File(rutaExcel);
	
	/* Declaramos al file como un fichero de escritura */
	FileInputStream inputStream = new FileInputStream(file);
	
	/*Objeto donde se guarda el archivo excel, osea el fichero como tal */
	XSSFWorkbook newWorkbook = new XSSFWorkbook(inputStream);
	
	/* Objeto donde se guarda la hoja donde se esta trabajando */
	XSSFSheet newSheet = newWorkbook.getSheet(hojaExcel);
	
	/* Filas de la hoja excel */
	int rowCount = newSheet.getLastRowNum()-newSheet.getFirstRowNum();
	
	List<String> Lista = new ArrayList<String>();
	for (int i = 0; i <= rowCount; i++) {
		/* Objeto que va ir leyendo fila por file */
		XSSFRow row=newSheet.getRow(i);
		
		/* Recorremos todas las columnas de la fila */
		for (int j = 0; j < row.getLastCellNum(); j++) {
			/*Imprimimos el valor de la columna */
			Lista.add(row.getCell(j).getStringCellValue());
			//System.out.println(row.getCell(j).getStringCellValue() + "||");
		}
	}
	
	return Lista;
}
	
public String getCellValue(String rutaExcel,String hojaExcel,int numeroFila, int numeroColumna) throws IOException {
	/* Nuevo fichero generico */
	File file = new File(rutaExcel);
	
	/* Declaramos al file como un fichero de escritura */
	FileInputStream inputStream = new FileInputStream(file);
	
	/*Objeto donde se guarda el archivo excel, osea el fichero como tal */
	XSSFWorkbook newWorkbook = new XSSFWorkbook(inputStream);
	
	/* Objeto donde se guarda la hoja donde se esta trabajando */
	XSSFSheet newSheet = newWorkbook.getSheet(hojaExcel);
	
	XSSFRow row=newSheet.getRow(numeroFila);
	XSSFCell cell=row.getCell(numeroColumna);
	
	return cell.getStringCellValue();
	
}
}

