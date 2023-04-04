package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class googleSearch
{
    public WebDriver driver;
    //public WebDriverWait wait = new WebDriverWait(driver,30);

    @FindBy(xpath = "//input[@title='Search']")
    WebElement searchBar;
   @FindBy(xpath="//input[@value='Google Search' and @role='button']")
   WebElement searchButton;

    public googleSearch(WebDriver gdriver){
        this.driver=gdriver;
    }

    public void setTextInSearchBar(String text, WebDriver driver){
        searchBar= driver.findElement(By.xpath("//input[@title='Search']"));
        searchBar.clear();
        searchBar.sendKeys(text);
    }

    public void performSearch(){
        searchButton.click();
    }

    public void sendKeys(String string){
        searchBar.sendKeys(Keys.ENTER);
    }

    public void quit(){
        driver.quit();
    }
}
