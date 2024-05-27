package GenericUtility;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviderClass {
	@DataProvider(name = "logindata")

    public static Object[][] logindata() throws IOException  {

        String filePath = "D:\\c\\Desktop\\OrangeHrm.xlsx"; // Adjust this path

        String sheetName = "Login"; // Adjust this sheet name

        return ExcelUtility.readExcelData(filePath, sheetName);

        

 }

  @DataProvider(name = "searchdata")

    public static Object[][] searchdata() throws IOException {

        String filePath = "C:\\Users\\shivs\\Downloads\\Book1.xlsx"; // Adjust this path

        String sheetName = "SearchData"; // Adjust this sheet name

        return ExcelUtility.readExcelData(filePath, sheetName);

}
}
