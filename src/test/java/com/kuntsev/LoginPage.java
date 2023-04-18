package com.kuntsev;
import org.junit.*;
import static java.time.Duration.ofSeconds;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;


public class LoginPage {
   private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();
    JavascriptExecutor js;


    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage Login(String username, String password) {

        driver.findElement(By.linkText("Login")).click();
        SetUserName(username);
        SetUserPass(password);
        return clickLoginButton();
    }

    public void SetUserName(String username){
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys("user");
    }
    public void SetUserPass(String password){
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("password");
    }
    public HomePage clickLoginButton(){
        driver.findElement(By.xpath("//input[@value='Login']")).click();
        driver.get("http://localhost:8090/home");
        return new HomePage(driver);
    }


}

