package GenericUtility;

import org.testng.annotations.DataProvider;

public class ExcelUtility {
@DataProvider(name="LoginTestData")	
public Object[][] dataprovider() {
	Object[][] obj=new Object[5][5];
	obj[0][0] ="admin1";
	obj[0][1] ="admin2";
	obj[0][2] ="admin3";
	obj[0][3] ="admin4";
	obj[0][4] ="admin5";
	
	return obj;
	
}
}
