package com.nil.ejercicio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcelFile {
	
	public WriteExcelFile() {
		
	}

	
	public void writeExcel(String rutaExcel,String hojaExcel,List<String> lista) throws IOException {
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
		
		/* Obtenemos la primera fila, esto nos sirve para tomar 
		 * la estructura de esta como referencia */
		XSSFRow row = newSheet.getRow(0);
		
		XSSFRow newRow = newSheet.createRow(rowCount+1);
		
		for (int i = 0; i < row.getLastCellNum(); i++) {
			
			/* Con estas dos lineas, creamos y seteamos los valores de la lista */
			XSSFCell newCell = newRow.createCell(i);
			newCell.setCellValue(lista.get(i));			
		}
		
		inputStream.close();
		
		/*Esto nos permite escribir en el Excel */
		FileOutputStream outputStream = new FileOutputStream(file);
		newWorkbook.write(outputStream);
		outputStream.close();
	}
	
	public void writeCellValue(String rutaExcel,String hojaExcel,int numeroFila, int numeroColumna,String texto) throws IOException{
	
		/* Nuevo fichero generico */
		File file = new File(rutaExcel);
		
		/* Declaramos al file como un fichero de escritura */
		FileInputStream inputStream = new FileInputStream(file);
		
		/*Objeto donde se guarda el archivo excel, osea el fichero como tal */
		XSSFWorkbook newWorkbook = new XSSFWorkbook(inputStream);
		
		/* Objeto donde se guarda la hoja donde se esta trabajando */
		XSSFSheet newSheet = newWorkbook.getSheet(hojaExcel);
		
		XSSFRow row = newSheet.getRow(numeroFila);
		
		XSSFCell primeraCelda = row.getCell(numeroColumna-1);
		
		System.out.println("primer valor es:"+primeraCelda.getStringCellValue());
	
		XSSFCell siguienteColumna=row.createCell(numeroColumna);
		siguienteColumna.setCellValue(texto);
		
		System.out.println("siguiente valor es:"+siguienteColumna.getStringCellValue());
		
		inputStream.close();
		
		/*Esto nos permite escribir en el Excel */
		FileOutputStream outputStream = new FileOutputStream(file);
		newWorkbook.write(outputStream);
		outputStream.close();
	}
}
