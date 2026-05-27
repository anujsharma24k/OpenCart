package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name= "userlogin")
	public String [][] loginUserData() throws IOException
	{
		String filePath = System.getProperty(("user.dir")+"//TestData//UserData.xlsx");
		ExcelUtility eu = new ExcelUtility(filePath);
		int RowCount = eu.getRowCount("User");
		int ColCount = eu.getColumnCount("User");
		String TwoDArray[][] = new String[RowCount][ColCount];
		for(int i = 1; i<=RowCount;i++)
		{
			for (int j = 0; j<ColCount;j++)
			{
				TwoDArray[i-1][j] = eu.getCellData("User", i, j);
			}
		}
		
		return TwoDArray;
	}

}
