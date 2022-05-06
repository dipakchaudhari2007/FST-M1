package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Activity_3 {
    public static void main(String[] args) throws InterruptedException {

        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();

        //Open the browser
        driver.get("https://www.training-support.net/selenium/simple-form");

        //Find the page title and print it
        String pageTitle = driver.getTitle();
        System.out.println(pageTitle);

        //Find the input fields
        WebElement firstName = driver.findElement(By.id("firstName"));
        WebElement lastName = driver.findElement(By.id("lastName"));
        //Enter text
        firstName.sendKeys("Dipak");
        lastName.sendKeys("Chaudhari");

        //Enter the email
        driver.findElement(By.id("email")).sendKeys("test@example.com");

        //Enter the contact number
        driver.findElement(By.id("number")).sendKeys("1234567890");

        //Click Submit
        driver.findElement(By.cssSelector("input.ui.green.button")).click();

        //Sleep to see the execution
        Thread.sleep(3000);

        //Handle the Alert
        driver.switchTo().alert().accept();

        //Sleep to see the execution
        Thread.sleep(5000);

        //Close the browser
        driver.close();
    }
}