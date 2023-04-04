package stepDefination;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.googleSearch;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class steps {
    public WebDriver driver;
    public googleSearch gs;
    public Properties prop;

    @Before
    public void toinitProperties(){
        try {
            FileInputStream fis = new FileInputStream("C:\\Users\\akshaypa\\IdeaProjects\\APAC\\Properties\\details.properties");
            prop = new Properties();
            prop.load(fis);
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    @Given("User launches the chrome browser")
    public void user_launches_the_chrome_browser() {
        System.out.println("b4 chrome driver");
        System.setProperty("webdriver.chrome.driver","C:\\Users\\akshaypa\\IdeaProjects\\APAC\\Drivers\\chromedriver.exe");
        driver= new ChromeDriver();

        gs=new googleSearch(driver);
    }
    @When("User opens {string} url")
    public void user_opens_url(String string) {
        driver.get(prop.getProperty(string));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @When("Enters {string} into the Search Bar")
    public void enters_into_the_search_bar(String string) {
        gs.setTextInSearchBar(string, driver);
    }
    @When("clicks onto the Search Button")
    public void clicks_onto_the_search_button() {
        gs.sendKeys("Enter");
    }
    @When("A Screenshot is taken of the response screen")
    public void a_screenshot_is_taken_of_the_response_screen() {
        System.out.println("SS will be taken");
    }

    @After()
   public void closeBrowser(){
        gs.quit();
   }

}
