package activities;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity_5_1 {

    public static void main(String[] args) {

        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();

        //Open the browser
        driver.get("https://www.training-support.net/selenium/dynamic-controls");

        //Find the checkbox
        WebElement checkboxInput = driver.findElement(By.xpath("//input[@type='checkbox']"));
        System.out.println("The checkbox Input is displayed: " + checkboxInput.isDisplayed());

        driver.findElement(By.id("toggleCheckbox")).click();

        System.out.println("The checkbox Input is displayed: " + checkboxInput.isDisplayed());

        //Close the browser
        driver.close();

    }

}
