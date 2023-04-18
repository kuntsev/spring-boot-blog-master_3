package com.kuntsev;
import org.junit.*;

import static java.time.Duration.ofSeconds;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
public class BlogDemoTestPageObject {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();
    JavascriptExecutor js;
    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\kuntsev\\Documents\\univer\\2022\\TA\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        baseUrl = "https://www.google.com/";
        driver.get("http://localhost:8090/login");
        //driver.manage().timeouts().implicitlyWait(60);
        js = (JavascriptExecutor) driver;
    }

    @Test
    public void testUntitledTestCase() throws Exception {

        LoginPage loginpage = new LoginPage(driver);
        HomePage homePage =  loginpage.Login("user", "password");
        PostPage postPage = homePage.clickNewPostButton();
        BlogPage blogPage = postPage.AddPost("Title", "Post Body");


        /*driver.findElement(By.xpath("//input[@value='Login']")).click();
        driver.get("http://localhost:8090/home");
        driver.findElement(By.linkText("New Post")).click();
        driver.get("http://localhost:8090/newPost");
        driver.findElement(By.id("title")).click();
        driver.findElement(By.id("title")).clear();
        driver.findElement(By.id("title")).sendKeys("test post");
        driver.findElement(By.id("body")).clear();
        driver.findElement(By.id("body")).sendKeys("Test test Hello word");
        driver.findElement(By.xpath("//input[@value='Save']")).click();
        driver.get("http://localhost:8090/blog/user");
        driver.findElement(By.linkText("test post")).click();
        driver.get("http://localhost:8090/post/13");
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Comments:'])[1]/following::button[1]")).click();
        driver.get("http://localhost:8090/commentPost/13");
        driver.findElement(By.id("body")).click();
        driver.findElement(By.id("body")).clear();
        driver.findElement(By.id("body")).sendKeys("The best post I've read");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.get("http://localhost:8090/post/13");
        driver.findElement(By.linkText("Sign Out")).click();*/
    }

   /*@After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }*/

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}
