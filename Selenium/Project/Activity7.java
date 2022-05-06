package liveProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Activity7 {
    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        driver = new FirefoxDriver();
        driver.get("http://alchemy.hguy.co/crm");
    }

    @Test
    public void readInfoFromPopup() throws InterruptedException {
        
        driver.findElement(By.id("user_name")).sendKeys("admin");
        driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
        driver.findElement(By.name("Login")).click();
        Reporter.log("Entered login credentials");

        WebDriverWait wait = new WebDriverWait (driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("Home"));

        WebElement salesMenuOption = driver.findElement(By.id("grouptab_0"));
        Actions builder = new Actions(driver);
        builder.moveToElement(salesMenuOption).build().perform();
        driver.findElement(By.id("moduleTab_9_Leads")).click();
        wait.until(ExpectedConditions.urlContains("Leads"));
        Reporter.log("User navigated to Leads page");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[@class='module-title-text']")));

        WebElement lastAddIcon=driver.findElement(By.xpath("(//span[@title='Additional Details'])[20]"));
        lastAddIcon.click();
        Reporter.log("<br> Clicked on last row Additional Details ");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='phone']")));
        String phNum=driver.findElement(By.xpath("//span[@class='phone']")).getText();
        Reporter.log("<br> Phone Number of Lead is: "+phNum);
        System.out.println("Phone Number of Lead is: "+phNum);
    }

    @AfterMethod
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }
}