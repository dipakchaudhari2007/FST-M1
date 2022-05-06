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

public class Activity8 {
    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        driver = new FirefoxDriver();
        driver.get("http://alchemy.hguy.co/crm");
    }

    @Test
    public void printTableContent() throws InterruptedException {
        
        driver.findElement(By.id("user_name")).sendKeys("admin");
        driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
        driver.findElement(By.name("Login")).click();
        Reporter.log("Entered login credentials");

        WebDriverWait wait = new WebDriverWait (driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("Home"));

        WebElement salesMenuOption = driver.findElement(By.id("grouptab_0"));
        Actions builder = new Actions(driver);
        builder.moveToElement(salesMenuOption).build().perform();
        driver.findElement(By.id("moduleTab_9_Accounts")).click();
        wait.until(ExpectedConditions.urlContains("Accounts"));
        Reporter.log("User navigated to Accounts page");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[@class='module-title-text']")));
        List<WebElement> nameCol = driver.findElements(By.xpath("//table/tbody/tr[@class='oddListRowS1']/td[3]"));

        for (int i=0; i<5; i++){
            WebElement nameTxt = nameCol.get(i);
            System.out.println(nameTxt.getText());
        }
    }

    @AfterMethod
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }
}