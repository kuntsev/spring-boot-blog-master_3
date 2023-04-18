package com.kuntsev;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
public class PostPage {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();
    JavascriptExecutor js;



    public PostPage(WebDriver driver) {
        this.driver = driver;
    }

    public void SetTitle(String title) {
        driver.findElement(By.id("title")).click();
        driver.findElement(By.id("title")).clear();
        driver.findElement(By.id("title")).sendKeys("test post");
    }
    public void SetPostBody(String body) {
        driver.findElement(By.id("body")).clear();
        driver.findElement(By.id("body")).sendKeys("Test test Hello word");
    }
    public BlogPage AddPost(String title, String body) {

        driver.findElement(By.xpath("//input[@value='Save']")).click();;
        SetTitle(title);
        SetPostBody(body);
        return clickSaveButton();
    }
    public BlogPage clickSaveButton(){
        driver.findElement(By.xpath("//input[@value='Save']")).click();
        driver.get("http://localhost:8090/blog/user");
        return new BlogPage(driver);
    }
}
