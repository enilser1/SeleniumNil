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

public class WriteExcelFile2 {
	
	public WriteExcelFile2() {
		
	}

	
	public void writeExcel(String rutaExcel,String hojaExcel,List<String> lista) throws IOException {

		File file = new File(rutaExcel);

		FileInputStream inputStream = new FileInputStream(file);

		XSSFWorkbook newWorkbook = new XSSFWorkbook(inputStream);
		
		XSSFSheet newSheet = newWorkbook.getSheet(hojaExcel);
		
		int rowCount = newSheet.getLastRowNum()-newSheet.getFirstRowNum();
		
		XSSFRow row = newSheet.getRow(0);
		
		XSSFRow newRow = newSheet.createRow(rowCount+1);
		
		for (int i = 0; i < row.getLastCellNum(); i++) {

			XSSFCell newCell = newRow.createCell(i);
			newCell.setCellValue(lista.get(i));			
		}
		
	}
	
	public void writeCellValue(String rutaExcel,String hojaExcel,int numeroFila, int numeroColumna,String texto) throws IOException{

		File file = new File(rutaExcel);
		
		FileInputStream inputStream = new FileInputStream(file);
		
		XSSFWorkbook newWorkbook = new XSSFWorkbook(inputStream);
		
		XSSFSheet newSheet = newWorkbook.getSheet(hojaExcel);
		
		XSSFRow row = newSheet.getRow(numeroFila);
		
		XSSFCell primeraCelda = row.getCell(numeroColumna-1);
		
		System.out.println("primer valor es:"+primeraCelda.getStringCellValue());
	
		XSSFCell siguienteColumna=row.createCell(numeroColumna);
		siguienteColumna.setCellValue(texto);
		
		System.out.println("siguiente valor es:"+siguienteColumna.getStringCellValue());
		
	
	}
}
