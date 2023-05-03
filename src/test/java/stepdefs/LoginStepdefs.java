package stepdefs;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class LoginStepdefs {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();
    JavascriptExecutor js;
    @Given("I'm on {} page")
    public void iMOnPage(String arg0) {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\kuntsev\\Documents\\univer\\2022\\TA\\chromedriver_win32\\chromedriver.exe");
            driver = new ChromeDriver();
            baseUrl = "https://www.google.com/";
            //driver.manage().timeouts().implicitlyWait(60);
            js = (JavascriptExecutor) driver;
            driver.get(arg0);
    }

    @And("fill {string} with {}")
    public void fillWith(String arg0, String arg1) {
        driver.findElement(By.name(arg0)).clear();
        driver.findElement(By.name(arg0)).sendKeys(arg1);
    }

    @And("I fill {string} with {}")
    public void iFillWith(String arg0, String arg1) {
        driver.findElement(By.name(arg0)).clear();
        driver.findElement(By.name(arg0)).sendKeys(arg1);
    }

    @When("I click on {string} button")
    public void iClickOnButton(String arg0) {
        String s = "//input[@value='"+arg0+"']";
        driver.findElement(By.xpath(s)).click();

    }

    @Then("I should be redirected on {} page")
    public void iShouldBeRedirectedOnPage(String arg0) {
        assertEquals(driver.getCurrentUrl(),arg0);
    }
}
