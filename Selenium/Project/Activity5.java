package liveProject;

import io.opentelemetry.exporter.logging.SystemOutLogExporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Activity5 {
    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        driver = new FirefoxDriver();
        driver.get("http://alchemy.hguy.co/crm");
    }

    @Test
    public void loginVerifyNavColor() {
        
        driver.findElement(By.id("user_name")).sendKeys("admin");
        driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
        driver.findElement(By.name("Login")).click();
        Reporter.log("Entered login credentials");

        WebDriverWait wait = new WebDriverWait (driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlContains("Home"));
        String navColor = driver.findElement(By.id("toolbar")).getCssValue("color");
        System.out.println("RGBA Color of the navbar is "+navColor);
        String hex = Color.fromString(navColor).asHex();
        System.out.println("Hex code for navbar color:"+hex);
    }

    @AfterMethod
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }
}