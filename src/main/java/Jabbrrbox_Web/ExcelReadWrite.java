package Jabbrrbox_Web;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * Hello world!
 *
 */
public class ExcelReadWrite {
	public static void main(String[] args) throws IOException {

		// Create sheet,Row and Cell and add record
		/*
		 * XSSFWorkbook wb = new XSSFWorkbook(); XSSFSheet sheet =
		 * wb.createSheet("User"); //
		 * sheet.createRow(0).createCell(0).setCellValue("Name"); //
		 * sheet.createRow(0).createCell(1).setCellValue("Country"); //
		 * sheet.createRow(0).createCell(2).setCellValue("Course"); for (int row = 0;
		 * row <= 3; row++) {
		 * 
		 * sheet.createRow(row);
		 * 
		 * for (int cell = 0; cell < 3; cell++) {
		 * 
		 * System.out.println("Enter Cell value for row " + row + "for Cell " + cell);
		 * Scanner sc = new Scanner(System.in);
		 * sheet.getRow(row).createCell(cell).setCellValue(sc.next()); } }
		 * FileOutputStream file = new FileOutputStream(System.getProperty("user.dir") +
		 * "//TestData//UserData.xlsx"); wb.write(file); wb.close(); file.close();
		 */
		// Read already added sheet with row and cells and adding new cell record
		
		FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "//TestData//UserData.xlsx");

		XSSFWorkbook wb = new XSSFWorkbook(file);
		XSSFSheet sheet = wb.getSheet("User");
		int rownum = sheet.getLastRowNum();
		System.out.println(rownum);
		int cellnumber = sheet.getRow(0).getLastCellNum();
		System.out.println(cellnumber);
		String cellnum = sheet.getRow(0).getCell(3).toString();
		System.out.println(cellnum);
		//sheet.getRow(0).createCell(3).setCellValue("Institute");
		//sheet.getRow(1).createCell(3).setCellValue("Qspider");
		//sheet.getRow(2).createCell(3).setCellValue("Jspider");
		//sheet.getRow(3).createCell(3).setCellValue("Kiwitech");

		FileOutputStream fileOut = new FileOutputStream(System.getProperty("user.dir") + "//TestData//UserData.xlsx");
		wb.write(fileOut);
		System.out.println("File Updated");
		wb.close();
		file.close();
		fileOut.close();
		 

	}
}
