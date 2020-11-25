package Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilities {
	
	FileInputStream ofile;
	XSSFWorkbook owkbook;
	XSSFSheet osheet;
	XSSFRow orow;
	XSSFCell ocell;
	
	public ExcelUtilities(String fileloc, String wrksheet) throws Exception
	{
	   	ofile = new FileInputStream(fileloc);
	   	owkbook = new XSSFWorkbook(ofile);
	   	osheet = owkbook.getSheet(wrksheet);
	   	
	}
	
	public String getCellData(int rownum, int colnum)
	{
		orow = osheet.getRow(rownum);
		ocell = orow.getCell(colnum);
		DataFormatter formatter = new DataFormatter();
		//String value = ocell.getStringCellValue();
		String value = formatter.formatCellValue(ocell);
		System.out.println("value in the cell is" + value);
		return value;

	}
	
	
	public Object[][] exceldp()
	{  
		String ExcelData[][];
		int rowno = osheet.getLastRowNum();
		orow = osheet.getRow(0);
		int colno = orow.getLastCellNum();
		ExcelData= new String[rowno][colno];
		for(int i=1;i<=rowno;i++)
		{
			for(int j=0;j<colno;j++)
			{
				ExcelData[i-1][j]= this.getCellData(i,j);
			}
		}
		return ExcelData;
		
	}
	
	
}
