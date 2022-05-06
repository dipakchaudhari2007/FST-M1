package liveProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity3 {
    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        driver = new FirefoxDriver();
        driver.get("http://alchemy.hguy.co/crm");
    }

    @Test
    public void getCopyRightText() {

        String copyRightText = driver.findElement(By.xpath("//a[@id='admin_options']")).getText();
        System.out.println("The copyright text in the footer is --> "+copyRightText);
    }

    @AfterMethod
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }

}