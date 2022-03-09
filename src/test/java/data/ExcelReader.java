package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	
	static FileInputStream fis=null;
	
	public FileInputStream getFileInputStream()
	{
		String filePath=System.getProperty("user.dir")+"\\src\\test\\java\\data\\userData.xlsx";
		File sourceFile=new File(filePath);
		
		try {
			fis=new FileInputStream(sourceFile);
		} catch (FileNotFoundException e) {
			System.out.println("test data file not found" + e.getMessage());
			System.exit(0);
		}
		
		return fis;
	}
	
	public Object[][] getExcelData() throws IOException
	{
		fis=getFileInputStream();
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheet=wb.getSheetAt(0);
		
		int totalNumbersOfRows= (sheet.getLastRowNum()+1);
		int totalNumbersOfCols=4;
		
		String [][] arrayExcelOfData=new String[totalNumbersOfRows][totalNumbersOfCols];
		
		for (int i = 0; i < totalNumbersOfRows; i++) 
		{
			for (int j = 0; j < totalNumbersOfCols; j++) 
			{
				XSSFRow row=sheet.getRow(i);
				arrayExcelOfData[i][j]=row.getCell(j).toString();
			}
		}
		wb.close();
		return arrayExcelOfData;
	}

}
