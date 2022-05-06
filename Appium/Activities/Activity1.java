package activities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;

public class Activity1 {
    // Declare Android driver
    AndroidDriver<MobileElement> driver;

    @BeforeClass
    public void beforeClass() throws MalformedURLException {
        // Set the Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceId", "1cdfafa0");
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("appPackage", "com.oneplus.calculator");
        caps.setCapability("appActivity", ".Calculator");
        caps.setCapability("noReset", true);

        // Instantiate Appium driver
        URL appServer = new URL("http://localhost:4723/wd/hub");
        driver = new AndroidDriver<>(appServer, caps);
    }

    @Test
    public void add() {
        // Using resource-id
        driver.findElementById("digit_5").click();
        // Using Accessibility ID
        driver.findElementByAccessibilityId("multiply").click();
        // Using XPath
        driver.findElementByXPath("//android.widget.Button[@text='9']").click();

        // Perform Calculation
        driver.findElementById("eq").click();

        // Display Result
        String result = driver.findElement(MobileBy.id("result")).getText();
        System.out.println(result);

        // Assertion
        Assert.assertEquals(result, "45");
    }

    @AfterClass
    public void afterClass() {

        driver.quit();
    }
}
