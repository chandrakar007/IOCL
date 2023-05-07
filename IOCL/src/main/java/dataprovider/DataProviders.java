package dataprovider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import utility.ExcelDataProvider;

public class DataProviders {
	
	public static String TESTDATA_SHEET_PATH="";
	static Workbook book;
	static Sheet sheet;
	

	@DataProvider(name = "LoginCredentials")
	public String[][] getLoginData() throws IOException {
		String path = "C:\\Chandrakar\\IOCLExcelFile\\DataFile.xlsx";

		ExcelDataProvider exceldatapr = new ExcelDataProvider(path);
		int totalrows = exceldatapr.getRowCount("LoginCredentials");
		int totalcols = exceldatapr.getCellCount("LoginCredentials", 1);

		String customerData[][] = new String[totalrows][totalcols];
		for (int i = 1; i <= totalrows; i++) {
			for (int j = 0; j < totalcols; j++) {

				customerData[i - 1][j] = exceldatapr.getCellData("LoginCredentials", i, j);
			}
		}

		return customerData;

	}

	@DataProvider(name = "addUser")
	public Object[][] addAddUserData() throws IOException {
		//String path = "F:\\IOCL_Automation_Data\\IOCLExcelFile\\AddCustomer.xlsx";
		String path = "C:\\Users\\chandrakar.dwivedi\\eclipse-workspace\\E2EIOCL\\ExcelFile\\IOCL_Data.xlsx";

		File file = new File(path);

		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Add User");
		wb.close();

		int rowcount = sheet.getLastRowNum();
		int colcount = sheet.getRow(0).getLastCellNum();

		Object[][] obj = new Object[rowcount][1];

		for (int i = 0; i < rowcount; i++) {
			Map<Object, Object> datamap = new HashMap<Object, Object>();
			for (int j = 0; j < colcount; j++) {
				datamap.put(sheet.getRow(0).getCell(j).toString(), sheet.getRow(i + 1).getCell(j).toString());

			}
			obj[i][0] = datamap;
		}

		return obj;

	}

	@DataProvider(name = "customerinfo")
	public Object[][] getCustomerData() throws IOException {
		String path = "C:\\Chandrakar\\IOCLExcelFile\\DataFile.xlsx";
		//String path = "C:\\Users\\chandrakar.dwivedi\\eclipse-workspace\\E2EIOCL\\ExcelFile\\IOCL_Data.xlsx";

		File file = new File(path);

		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("CustomerData");
		wb.close();

		int rowcount = sheet.getLastRowNum();
		int colcount = sheet.getRow(0).getLastCellNum();

		Object[][] obj = new Object[rowcount][1];

		for (int i = 0; i < rowcount; i++) {
			Map<Object, Object> datamap = new HashMap<Object, Object>();
			for (int j = 0; j < colcount; j++) {
				datamap.put(sheet.getRow(0).getCell(j).toString(), sheet.getRow(i + 1).getCell(j).toString());

			}
			obj[i][0] = datamap;
		}

		return obj;

	}

	@DataProvider(name = "merchantInfo")
	public Object[][] getMerchantData() throws IOException {
		//String path = "F:\\IOCL_Automation_Data\\IOCLExcelFile\\AddCustomer.xlsx";
		String path = "C:\\Chandrakar\\IOCLExcelFile\\DataFile.xlsx";

		File file = new File(path);

		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("MerchantData");
		wb.close();

		int rowcount = sheet.getLastRowNum();
		int colcount = sheet.getRow(0).getLastCellNum();

		Object[][] obj = new Object[rowcount][1];

		for (int i = 0; i < rowcount; i++) {
			Map<Object, Object> datamap = new HashMap<Object, Object>();
			for (int j = 0; j < colcount; j++) {
				datamap.put(sheet.getRow(0).getCell(j).toString(), sheet.getRow(i + 1).getCell(j).toString());

			}
			obj[i][0] = datamap;
		}

		return obj;

	}}


    //Naveen Automation
//    public static Object[][] getTestData(String sheetName){
//    	FileInputStream file=null;
//    	try {
//    		file=new FileInputStream(TESTDATA_SHEET_PATH);
//    	}catch (FileNotFoundException e) {
//    		e.printStackTrace();	
//    	}
//    	try {
//    		book=WorkbookFactory.create(file);
//    	}
//    	catch (InvalidFormatException e) {
//    		e.printStackTrace();
//    	}
//    	catch (IOException e) {
//    		e.printStackTrace();
//    	}
//    	sheet=book.getSheet(sheetName);
//    	Object[][] data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
//    	//System.out.println(sheet.getLastRowNum() + "----------" +
//    	//sheet.getRow(0).getLastCellNum());
//    	for(int i=0;i<sheet.getLastRowNum(); i++) {
//    		for(int k=0;k<sheet.getRow(0).getLastCellNum(); k++) {
//    			data[i][k]=sheet.getRow(i+1).getCell(k).toString();
//    			//System.out.println(data[i][j]);
//    		}}
//    	return data;
//    		}
//    	}
    












//     @DataProvider(name="LoginCredentials")
//		public Object[][] getCustomerData() throws IOException
//		{
//			 String path="F:\\\\IOCL_Automation_Data\\\\IOCLExcelFile\\\\AddCustomer.xlsx";
//
//          File file= new File(path);
//          
//          FileInputStream fis=new FileInputStream(file);
//          XSSFWorkbook wb= new XSSFWorkbook(fis);
//          XSSFSheet sheet=wb.getSheet("LoginCredentials");
//          wb.close();
//          
//          int rowcount=sheet.getLastRowNum();
//          int colcount=sheet.getRow(0).getLastCellNum();
//          
//          Object[][] obj=new Object[rowcount][1];
//          
//          for(int i=0;i<rowcount;i++) {
//         	 Map<Object,Object> datamap=new HashMap<Object,Object>();
//          for(int j=0;j<colcount;j++) {
//         	 datamap.put(sheet.getRow(0).getCell(j).toString(),sheet.getRow(i+1).getCell(j).toString());
//         	 
//          }
//         	 obj[i][0]=datamap;
//          }
//    
//	       return obj;
//
//      }
//  }
