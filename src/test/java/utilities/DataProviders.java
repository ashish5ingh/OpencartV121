package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	//DataProvider 1
	
	@DataProvider(name="LoginData")
	public String [][] getData() throws IOException{
		
		String path = "testData/data.xlsx"; //taking xl file from testData
		
		ExcelUtils xlutil = new ExcelUtils(path); //creating an object for XLUtility
		
		int totalrows = xlutil.getRowCount("Sheet3");
		int totalcols = xlutil.getCellCount("Sheet3", 1);
		
		String logindata[][] = new String[totalrows][totalcols]; //created for two dimension array which can store data from xl
		
		for(int i=1; i<=totalrows; i++) {	//1    //read the data from xl storing in two dimensional array
			
			for(int j=0;j<totalcols;j++) {	//0		//i is rows  j is col
				
				logindata[i-1][j]=xlutil.getCellData("Sheet3", i, j);
			}
		}
		
	return logindata; //returning two dimension array
	}
	
	//DataProvider 2
	
	
	//DataProvider 3
	
	
	//DataProvider 4

}
