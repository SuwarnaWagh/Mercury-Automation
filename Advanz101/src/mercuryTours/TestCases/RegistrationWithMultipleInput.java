package mercuryTours.TestCases;

import org.testng.annotations.Test;

import mercuryTours.POM.ObjectRepository;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;

public class RegistrationWithMultipleInput {
	
	private static final String URL = "http://newtours.demoaut.com/";
	ObjectRepository register;
	private WebDriver driver;
	String filepath = "C://Users//Admin//eclipse-workspace//Advanz101//src//mercuryTours.TestData//Mercury_TestData.xlsx", user;
	FileInputStream fis ;
	XSSFSheet sheet;
	XSSFWorkbook workbook;
	 XSSFRow row;
	
  @Test
  public void RegistrationWithMultipleInput() throws IOException {
	  try {
		  try {
			fis = new FileInputStream(filepath);
		} catch (FileNotFoundException e) {			
			e.printStackTrace();
		}
		  workbook = new XSSFWorkbook(fis);
		  sheet = workbook.getSheet("Sheet1");
		  for(int i = 1; i <=sheet.getLastRowNum(); i++) {
			  register.clickOnRegister(driver);
				register.enterFirstName(driver, sheet.getRow(i).getCell(0).toString());
				register.enterLastName(driver, sheet.getRow(i).getCell(1).toString());
				register.enterPhone(driver, sheet.getRow(i).getCell(2).toString());
				register.enterEmailId(driver, sheet.getRow(i).getCell(3).toString());
				register.enterAddress1(driver, sheet.getRow(i).getCell(4).toString());
				register.enterCity(driver, sheet.getRow(i).getCell(5).toString());
				register.enterState(driver, sheet.getRow(i).getCell(6).toString());
				register.enterPostalCode(driver, sheet.getRow(i).getCell(7).toString());
				register.selectCountryName(driver, sheet.getRow(i).getCell(8).toString());
				user = sheet.getRow(i).getCell(9).toString();
				register.enterUserName(driver, sheet.getRow(i).getCell(9).toString());
				register.enterPassword(driver, sheet.getRow(i).getCell(10).toString());
				register.enterConfirmPassword(driver, sheet.getRow(i).getCell(11).toString());
				register.submitRegistration(driver);
				
				assertEquals(driver.findElement(By.xpath("//td/p/a/font/b")).getText(), "Note: Your user name is "+ user +".");
				
				System.out.println("Assertion passed for "+user);
				register.clickOnSignOff(driver);
		  }
	  	
	 }catch(NoSuchElementException e) {
			System.out.println("Error in finding webelements - Please check locators");
	}catch(StaleElementReferenceException e) {
			System.out.println("Error in Loading webpage - Please check Internet Connection");
	}
  }
  @BeforeClass
  @Parameters("browser")
  public void beforeClass(String browsername) {
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
