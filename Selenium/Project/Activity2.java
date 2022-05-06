package liveProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity2 {
    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        driver = new FirefoxDriver();
        driver.get("http://alchemy.hguy.co/crm");
    }

    @Test
    public void getHeaderImgUrl() {

        String imgLogoUrl = driver.findElement(By.xpath("//div[@class='companylogo']/img")).getAttribute("src");
        System.out.println("The URL of the header image --> "+imgLogoUrl);
    }

    @AfterMethod
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }

}