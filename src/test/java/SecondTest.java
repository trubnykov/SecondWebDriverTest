import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class SecondTest {

    private WebDriver driver;

    @BeforeClass // Runs this method before the first test method in the current class is invoked
    public void setUp() {
        // Create a new instance of the Firefox driver
        driver = new FirefoxDriver();
    }

    @Test
    public void OpenGoogleSearchForAutomation() {

        driver.get("http://www.google.com");

        // Next, we'll execute the search
        // Search for "automation"
        WebElement searchBox;
        searchBox = driver.findElement(By.id("lst-ib"));
        searchBox.sendKeys("testautomationday.com");
        searchBox.submit();

        // Now, let's gather our search results
        List<WebElement> results = driver.findElements(By.cssSelector(".r"));

        // Finally, we'll loop over the list to verify each result link contains our term
        for (int i = 0; i < results.size(); i++) {
            Assert.assertTrue(results.get(i).getText().contains("testautomationday.com"), "Search result validation failed at instance [ + i + ].");
        }
    }
    @AfterClass // Runs this method after all the test methods in the current class have been run
    public void tearDown() {
        // Close all browser windows and safely end the session
        driver.quit();
    }
}


