package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

    // 🔹 Class level variables
    private Workbook wb;
    private FileInputStream fis;
    private FileOutputStream fos;
    private String filePath;

    // 🔹 Constructor (only file path)
    public ExcelUtility(String filePath) throws IOException {
        this.filePath = filePath;
        
    }

    // 1. Get Row Count
    public int getRowCount(String sheetName) throws IOException {
    	fis = new FileInputStream(filePath);
        wb = new XSSFWorkbook(fis);
        Sheet sheet = wb.getSheet(sheetName);
        return sheet.getLastRowNum(); // last index
    }

    // 2. Get Column Count
    public int getColumnCount(String sheetName) throws IOException {
    	fis = new FileInputStream(filePath);
        wb = new XSSFWorkbook(fis);
        Sheet sheet = wb.getSheet(sheetName);
        Row row = sheet.getRow(0); // header row
        return row.getLastCellNum(); // count
    }

    // 3. Get Cell Data (row + column index)
    public String getCellData(String sheetName, int rowNum, int colNum) throws IOException {
    	fis = new FileInputStream(filePath);
        wb = new XSSFWorkbook(fis);
        Sheet sheet = wb.getSheet(sheetName);
        Row row = sheet.getRow(rowNum);

        if (row == null) return "";

        Cell cell = row.getCell(colNum);
        if (cell == null) return "";

        DataFormatter formatter = new DataFormatter();
        return formatter.formatCellValue(cell);   // to covert data into string without changing the exact value.
    }

    // 4. Get Cell Data by Column Name (VERY IMPORTANT ⭐)
    public String getCellDataByColumnName(String sheetName, int rowNum, String colName) throws IOException {
    	fis = new FileInputStream(filePath);
        wb = new XSSFWorkbook(fis);
        Sheet sheet = wb.getSheet(sheetName);
        Row headerRow = sheet.getRow(0);

        int colIndex = -1;

        for (int i = 0; i < headerRow.getLastCellNum(); i++) {
            if (headerRow.getCell(i).getStringCellValue().equalsIgnoreCase(colName)) {
                colIndex = i;
                break;
            }
        }

        if (colIndex == -1) return "";

        return getCellData(sheetName, rowNum, colIndex);
    }

    // 5. Write Data into Excel
    public void setCellData(String sheetName, int rowNum, int colNum, String data) throws IOException {
    	fis = new FileInputStream(filePath);
        wb = new XSSFWorkbook(fis);

        Sheet sheet = wb.getSheet(sheetName);
        Row row = sheet.getRow(rowNum);

        if (row == null) {
            row = sheet.createRow(rowNum);
        }

        Cell cell = row.getCell(colNum);
        if (cell == null) {
            cell = row.createCell(colNum);
        }

        cell.setCellValue(data);

        fos = new FileOutputStream(filePath);
        wb.write(fos);
        fos.close();
    }

    // 6. Write Data by Column Name (Advanced ⭐)
    public void setCellDataByColumnName(String sheetName, int rowNum, String colName, String data) throws IOException {
    	fis = new FileInputStream(filePath);
        wb = new XSSFWorkbook(fis);

        Sheet sheet = wb.getSheet(sheetName);
        Row headerRow = sheet.getRow(0);

        int colIndex = -1;

        for (int i = 0; i < headerRow.getLastCellNum(); i++) {
            if (headerRow.getCell(i).getStringCellValue().equalsIgnoreCase(colName)) {
                colIndex = i;
                break;
            }
        }

        if (colIndex == -1) {
            throw new RuntimeException("Column not found: " + colName);
        }

        setCellData(sheetName, rowNum, colIndex, data);
    }

    // 7. Close Workbook (Best Practice)
    public void closeWorkbook() throws IOException {
        wb.close();
        if (fis != null) fis.close();
    }
}
