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
import java.util.List;

public class Activity9 {
    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        driver = new FirefoxDriver();
        driver.get("http://alchemy.hguy.co/crm");
    }

    @Test
    public void printUnameAndFullName() throws InterruptedException {
        
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
        List<WebElement> nameCol = driver.findElements(By.xpath("//table/tbody/tr/td[3]/b"));
        List<WebElement> userCol = driver.findElements(By.xpath("//table/tbody/tr/td[8]"));

        System.out.println("Name : User");
        for (int i=0; i<10; i++){
            WebElement nameTxt = nameCol.get(i);
            WebElement userTxt = userCol.get(i);
            System.out.println(nameTxt.getText()+" : "+userTxt.getText());
        }
    }

    @AfterMethod
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }
}