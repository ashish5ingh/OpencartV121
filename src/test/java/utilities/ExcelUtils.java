package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	
	public  FileInputStream fis;
	public  FileOutputStream fos;
	public  XSSFWorkbook  wb;
	public  XSSFSheet ws;
	public  XSSFRow row;
	public  XSSFCell cell;
	public  XSSFCellStyle style;
	String path;
	
	public ExcelUtils(String path) {
		
		this.path=path;
	}
	
	public int getRowCount(String sheetName) throws IOException {
		
		 fis = new FileInputStream(path);
		 wb = new XSSFWorkbook(fis);
		 ws =  wb.getSheet(sheetName);
		 int row_count = ws.getLastRowNum();
		 wb.close();
		 fis.close();
		 return row_count;
	}
	
	public int getCellCount(String sheetName, int rowNum) throws IOException {
		
		 fis = new FileInputStream(path);
		 wb = new XSSFWorkbook(fis);
		 ws =  wb.getSheet(sheetName);
		 row = ws.getRow(rowNum);
		 int cell_count = row.getLastCellNum();
		 wb.close();
		 fis.close();
		 return cell_count;
	}
	
	public String getCellData(String sheetName, int rowNum, int colNum) throws IOException {
		
		 fis = new FileInputStream(path);
		 wb = new XSSFWorkbook(fis);
		 ws =  wb.getSheet(sheetName);
		 row = ws.getRow(rowNum);
		 cell = row.getCell(colNum);
		 
		 String data;
		 try {
			//data = cell.toString();
			 DataFormatter formatter = new DataFormatter();
			 data = formatter.formatCellValue(cell);
		 }
			 
		 catch (Exception e){
			 data="";
		 }
		 
		 wb.close();
		 fis.close();
		 return data;
	}
	
	public void setCellData(String sheetName, int rowNum, int colNum, String data) throws IOException {
		
		 File xlfile = new File(path);
		 if(!xlfile.exists()) {			//If file not exists then create new file
			 
			 wb = new XSSFWorkbook();
			 fos = new FileOutputStream(path);
			 wb.write(fos);
		 }
		 
		 fis = new FileInputStream(path);
		 wb = new XSSFWorkbook(fis);
		 
		 if(wb.getSheetIndex(sheetName)==-1) //If sheet not exists then create new sheet
			 wb.createSheet(sheetName);
		 ws =wb.getSheet(sheetName);
		 
		 if(ws.getRow(rowNum)==null)  //If row not exists then create new Row
			 ws.createRow(rowNum);
		 row=ws.getRow(rowNum);
		 
		 cell=row.createCell(colNum);
		 cell.setCellValue(data);
		 fos=new FileOutputStream(path);
		 wb.write(fos);
		 wb.close();
		 fis.close();
		 fos.close();
				 
	}
	
	public void fillGreenColour(String sheetName, int rowNum, int cellNum) throws IOException {
		
		 fis = new FileInputStream(path);
		 wb = new XSSFWorkbook(fis);
		 ws =  wb.getSheet(sheetName);
		 row = ws.getRow(rowNum);
		 cell = row.createCell(cellNum);
		 
		 style = wb.createCellStyle();
		 
		 style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		 style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		 
		 cell.setCellStyle(style);
		 fos = new FileOutputStream(path);
		 wb.write(fos);
		 wb.close();
		 fis.close();
		 fos.close();
	}
	
	public void fillRedColour(String sheetName, int rowNum, int cellNum) throws IOException {
		
		 fis = new FileInputStream(path);
		 wb = new XSSFWorkbook(fis);
		 ws =  wb.getSheet(sheetName);
		 row = ws.getRow(rowNum);
		 cell = row.createCell(cellNum);
		 
		 style = wb.createCellStyle();
		 
		 style.setFillForegroundColor(IndexedColors.RED.getIndex());
		 style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		 
		 cell.setCellStyle(style);
		 fos = new FileOutputStream(path);
		 wb.write(fos);
		 wb.close();
		 fis.close();
		 fos.close();
	}
	
	

}
