package com.kuntsev;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
public class HomePage {


    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }



    public PostPage clickNewPostButton (){
        driver.findElement(By.linkText("New Post")).click();
        driver.get("http://localhost:8090/newPost");
        return new PostPage(driver);
    }



}
