package pageObject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Homepage {
	WebDriver driver;
	private WebDriverWait wait;
	
	public Homepage(WebDriver driver) {
		this.driver = driver;

		PageFactory.initElements(driver, this);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		this.wait = new WebDriverWait(driver, 30);
}
	public void navigate_toStackexchange() {
		driver.get("https://stackexchange.com/");
	}
	@FindBy(how = How.XPATH, using = "//li[@class='-ctas']/a[1]")
	public WebElement clicktoLogin;
	
	@FindBy(how = How.XPATH , using = "//*[@id='openid_btns']/a[1]")
	public WebElement selectLoginWithStack;
	
	@FindBy(how = How.XPATH , using = "//input[@name='email']")
	private WebElement keyUsername;

	@FindBy(how = How.XPATH , using = "//input[@name='password']")
	private WebElement keyPassword;

	@FindBy(how = How.XPATH , using = "//input[@type='submit'][@class='affiliate-button']")
	public WebElement clickSignin;

	@FindBy(how = How.XPATH , using = "//div[@class='error']/p[1]")
	public WebElement error_found;


	public void enterUsername(String username) {
	keyUsername.sendKeys(username);
	}
	public void enterPassword(String password) {
		keyPassword.sendKeys(password);
	}

	public void switchFrame(){
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("affiliate-signin-iframe"));

		//driver.switchTo().frame("affiliate-signin-iframe");
	}

	
	}
