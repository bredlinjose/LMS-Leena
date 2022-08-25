package org.sdet38.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelFile {

	public static void main(String[] args) throws EncryptedDocumentException, IOException
	{
     //step 1: read the file using file input stream
		
		FileInputStream fis = new FileInputStream(".\\Data\\testdata.xlsx");
	//step 2: create workbook
		
	Workbook book =	WorkbookFactory.create(fis);
	//step 3: load the sheet
	
	Sheet sh =book.getSheet("Sheet1");
	//step 4: navigate to the row
	
	Row row = sh.getRow(1);
	//step 5: navigate to the cell
	
	Cell cel = row.getCell(2);
	//step 6: read the value inside the cell
	
	System.out.println(cel.getStringCellValue());
	}

}