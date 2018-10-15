package stepdefinition;

import java.net.MalformedURLException;

import cucumber.api.PendingException;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import pageObject.Homepage;
import pageObject.Searchpage;


public class Test_Step {
	
	public static WebDriver driver;
	public static Actions act;

	private Scenario scenario;
	static Homepage homepage;
	static Searchpage searchPage;
	
	@Given ("^User open browser$")
	public void user_open_browser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	@Then ("^Navigate to Stackexchange$")
	public void navigate_to_Stackexchange() {
		driver.get("https://stackexchange.com/");
	}
	@And ("^Click on Login$")
	public void Click_on_Login() throws InterruptedException {
		homepage = new Homepage(driver);
		homepage.clicktoLogin.click();
	}
	@And ("^Select to log in with stackexchange$")
	public void Selecttologinwithstackexchange() throws InterruptedException {
		homepage = new Homepage(driver);
		homepage.selectLoginWithStack.click();
	}
	@And ("^input username and password$")
	public void inputUsername_and_Password() throws InterruptedException {
		homepage = new Homepage(driver);
		homepage.switchFrame();
		homepage.enterUsername("worapong.kitt@gmail.com");
		homepage.enterPassword("/*Jo141810");
		homepage.clickSignin.click();
	}
	@Then ("^Show Result of login$")
	public void Userinput_wrong_username_password() {
		homepage = new Homepage(driver);
		if(driver.findElements(By.xpath("//div[@class='error']/p[1]")).size()>0) {
			System.out.println("No account with this email & password found");
			
		}
		else {
		System.out.println("Log in successfully");
		scenario.write("Log in successfully");
	}
}
	
	@Before
	public void beforeScenario(Scenario scenario) {
		this.scenario = scenario;
	}

	@After(order = 1)
	public void afterScenario(Scenario scenario) throws WebDriverException, MalformedURLException {
		if (scenario.isFailed()) {
			scenario.embed(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES), "image/png");		
		}
	}

	@After(order = 0)
	public void AfterSteps() {
		driver.close();
	}

	@And("^Fill in \"([^\"]*)\"$")
	public void fillIn(String arg0) throws Throwable {
        searchPage = new Searchpage(driver);
	    searchPage.setSearch(arg0);
	}

	@And("^Check all subject at first page$")
	public void checkAllSubjectAtFirstPage() throws Throwable {

		searchPage.verifySubject("AUTOMATE TEST");
	}
}