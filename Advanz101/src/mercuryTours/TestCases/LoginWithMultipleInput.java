package mercuryTours.TestCases;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import mercuryTours.POM.ObjectRepository;

public class LoginWithMultipleInput {

	private static final String URL = "http://newtours.demoaut.com/";
	ObjectRepository register;
	private WebDriver driver;
	String filepath = "C://Users//Admin//eclipse-workspace//Advanz101//src//mercuryTours.TestData//Mercury_TestData.xlsx";
	FileInputStream fis ;
	XSSFSheet sheet;
	XSSFWorkbook workbook;
	XSSFRow row;
	 
	@Test
	public void loginWithMultipleInput() throws IOException {
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet("Sheet1");
		for(int i = 1; i <=sheet.getLastRowNum(); i++) {
		register.clickOnSignON(driver);	
		register.enterLoginId(driver, sheet.getRow(i).getCell(9).toString());
		register.enterLoginPassword(driver, sheet.getRow(i).getCell(10).toString());
		register.submitLogin(driver);
		assertEquals(driver.getTitle(), "Find a Flight: Mercury Tours:");
		System.out.println("Logged in Successfully with  "+sheet.getRow(i).getCell(9).toString());
		register.clickOnSignOff(driver);
		}
	}
	@BeforeClass
	@Parameters("browser")
	  public void beforeClass(String browsername) {
		try {
			fis = new FileInputStream(filepath);
		} catch (FileNotFoundException e) {			
			e.printStackTrace();
		}
		  	register = new ObjectRepository();
		  	if(browsername.equalsIgnoreCase("chrome")) {
				driver = register.callChromedriver();	
			}else if(browsername.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", "I:\\driver\\geckodriver-v0.21.0-win64\\geckodriver.exe");
				driver = new FirefoxDriver();
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				 driver.manage().window().maximize();
			} 
			driver.get(URL);
	  }
	@AfterTest
	public void afterTest() {		
		driver.close();
	}
	
}
