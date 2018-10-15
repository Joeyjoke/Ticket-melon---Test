package pageObject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Searchpage {

    WebDriver driver;
    private WebDriverWait wait;

    @FindBy(how = How.XPATH, using = "//input[@name='q'][@type='text']")
    private WebElement txtSearch;

    @FindBy(how = How.XPATH, using = "//div[@class='result-link']/span/a")
    private List<WebElement> listOfSubject;

    public Searchpage(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(driver, this);

        this.wait = new WebDriverWait(driver, 30);
    }

    public void setSearch(String value){
        txtSearch.sendKeys(value);
        txtSearch.sendKeys(Keys.ENTER);
    }
    public boolean verifySubject(String subject){
        int list = listOfSubject.size();
        String subjectSearch;
        boolean foundSubject = false;

        for(int i = 0; i < list ; i++){
           subjectSearch =  listOfSubject.get(i).getText().toUpperCase();
           System.out.println(subjectSearch);
            if(subjectSearch.contains(subject)){
                foundSubject = true;
            }
            else{
                foundSubject = false;
                break;
            }
        }
      return foundSubject;
    }

}
