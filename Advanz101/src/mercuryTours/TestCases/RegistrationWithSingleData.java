package mercuryTours.TestCases;

import org.testng.annotations.Test;

import mercuryTours.POM.ObjectRepository;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;

public class RegistrationWithSingleData {
	
	private static final String URL = "http://newtours.demoaut.com/";
	ObjectRepository register;
	private WebDriver driver;
	@Test
	//@Parameters("browser")
	public void NewUserRegistrationAndLoginWithSingleData() throws IOException {
		try {
		register.clickOnRegister(driver);
		register.enterFirstName(driver, "Opesydra");
		register.enterLastName(driver, "Uhet");
		register.enterPhone(driver, "1234567890");
		register.enterEmailId(driver, "Esasgwat@tco.com");
		register.enterAddress1(driver, "India 1245");
		register.enterCity(driver, "XYN");
		register.enterState(driver, "ABC");
		register.enterPostalCode(driver, "123456");
		register.selectCountryName(driver, "INDIA");
		register.enterUserName(driver, "optest");
		register.enterPassword(driver, "P@$$W00rd");
		register.enterConfirmPassword(driver, "P@$$W00rd");
		register.submitRegistration(driver);
		assertEquals(driver.findElement(By.xpath("//td/p/a/font/b")).getText(), "Note: Your user name is optest.");
		System.out.println("Registered Successfully");
		
		register.clickOnSignOff(driver);
		
		register.clickOnSignON(driver);
		
		register.enterLoginId(driver, "optest");
		register.enterLoginPassword(driver, "P@$$W00rd");
		register.submitLogin(driver);
		assertEquals(driver.getTitle(), "Find a Flight: Mercury Tours:");
		System.out.println("Logged in Successfully");
		
		}catch(NoSuchElementException e) {
			System.out.println("Error in finding webelements - Please check locators");
		}catch(StaleElementReferenceException e) {
			System.out.println("Error in Loading webpage - Please check Internet Connection");
		}
	}

	
	@BeforeTest
	@Parameters("browser")
	public void beforeTest(String browsername) {
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
