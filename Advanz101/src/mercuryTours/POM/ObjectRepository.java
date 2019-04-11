package mercuryTours.POM;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ObjectRepository {
	
	public static final String driverName = "webdriver.chrome.driver";
	public static final String driverPath = "I://driver//chromedriver.exe";
	WebDriver driver = null; 

	public WebDriver callChromedriver() {
		 System.setProperty(driverName,driverPath);
		  driver = new ChromeDriver();
		  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		  driver.manage().window().maximize();
		  return driver;
	}
	
	public void clickOnRegister(WebDriver driver) {
		List<WebElement> links = driver.findElements(By.className("mouseOut"));
    	links.size();
    	for (int i =0 ; i < links.size() ; i++){
    		String compareString = links.get(i).getText();
    		if(compareString.equals("REGISTER")){
    			links.get(i).click();
    			break;
    		}
    	}
	}
	
	public void enterFirstName(WebDriver driver, String firstname) {
		driver.findElement(By.name("firstName")).sendKeys(firstname);
	}
	
	public void enterLastName(WebDriver driver, String laststname) {
	driver.findElement(By.name("lastName")).sendKeys(laststname);
	}
	public void enterPhone(WebDriver driver, String phone) {
		driver.findElement(By.name("phone")).sendKeys(phone);
	}
	public void enterUserName(WebDriver driver, String username) {
	driver.findElement(By.name("email")).sendKeys(username);
	}
	public void enterAddress1(WebDriver driver, String address1) {
	driver.findElement(By.name("address1")).sendKeys(address1);
	}
	public void enterCity(WebDriver driver, String city) {
	driver.findElement(By.name("city")).sendKeys(city);
	}
	
	public void enterState(WebDriver driver, String state) {
	driver.findElement(By.name("state")).sendKeys(state);
	}
	public void enterPostalCode(WebDriver driver, String postalcode) {
	driver.findElement(By.name("postalCode")).sendKeys(postalcode);
	}
	public void selectCountryName(WebDriver driver, String country) {
	WebElement CountryName = driver.findElement(By.name("country"));
	Select select = new Select(CountryName);
	select.selectByVisibleText(country);
	}
	
	public void enterEmailId(WebDriver driver, String email) {
	driver.findElement(By.name("userName")).sendKeys(email);
	}
	
	public void enterPassword(WebDriver driver, String pwd) {
	driver.findElement(By.name("password")).sendKeys(pwd);
	}
	public void enterConfirmPassword(WebDriver driver, String confirmpassword) {
	driver.findElement(By.name("confirmPassword")).sendKeys(confirmpassword);
	}
	
	public void submitRegistration(WebDriver driver) {
	driver.findElement(By.name("register")).click();
	}
	//td/p/a/font/b Note: Your user name is
	
	/*if(driver.findElement(By.xpath("//td/p/a/font/b")).getText().contains("Note: Your user name is")){
		System.out.println("User registration completed successfully");
	}*/
	//driver.findElement(By.xpath("//td/p/font/a[01]")).click();
	
	
	//driver.findElement(By.name("userName")).sendKeys("baaaa1");
	//driver.findElement(By.name("password")).sendKeys("baaaaaa1");
	public void submitLogin(WebDriver driver) {
	driver.findElement(By.name("login")).click();
	}
	public void enterLoginId(WebDriver driver, String loginId) {
		driver.findElement(By.name("userName")).sendKeys(loginId);;
		}
	
	public void enterLoginPassword(WebDriver driver, String password) {
		driver.findElement(By.name("password")).sendKeys(password);;
		}
	
	
	public void clickOnSignON(WebDriver driver) {
		List<WebElement> links = driver.findElements(By.className("mouseOut"));
    	links.size();
    	for (int i =0 ; i < links.size() ; i++){
    		String compareString = links.get(i).getText();
    		if(compareString.equals("SIGN-ON")){
    			links.get(i).click();
    			break;
    		}
    	}
	}
	public void clickOnSignOff(WebDriver driver) {
		List<WebElement> links = driver.findElements(By.className("mouseOut"));
    	links.size();
    	for (int i =0 ; i < links.size() ; i++){
    		String compareString = links.get(i).getText();
    		if(compareString.equals("SIGN-OFF")){
    			links.get(i).click();
    			break;
    		}
    	}
	}
	//System.out.println(driver.getTitle());
	//assertEquals(driver.getTitle(), "Find a Flight: Mercury Tours:");
}
