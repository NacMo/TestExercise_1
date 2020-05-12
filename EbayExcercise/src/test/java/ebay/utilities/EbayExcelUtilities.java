package ebay.utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class EbayExcelUtilities 
{
	public static Object[][] readData(String sheetname) throws IOException
	{
		FileInputStream fis=new FileInputStream("E:\\batch239\\EbayExcercise\\src\\test\\java\\app\\ebay\\data\\EbayData.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sh=wb.getSheet(sheetname);
		
		//total no. of row
		int totalRows= sh.getPhysicalNumberOfRows();
		
		//total no. of columns
		int totalColumns=sh.getRow(0).getPhysicalNumberOfCells();
		
		//we need to read the data from excel and populate it in 2D Object Array
		Object arr[] []=new Object[totalRows-1][totalColumns];
		for(int i=1;i<totalRows;i++)//rows
		{
			for(int j=0;j<totalColumns;j++)//columns
			{
				arr[i-1][j]=sh.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return arr;
		
		
	}

}
