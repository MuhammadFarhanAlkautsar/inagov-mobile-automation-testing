package inadigital.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import inadigital.android_driver.AndroidDriverInstance;

import static inadigital.utils.Utils.loadElementProperties;
import static inadigital.utils.Constants.ELEMENTS;

public class AndroidDriverHooks {
    @Before(value = "@Android")
    public void initializeAndroidDriver() {
        AndroidDriverInstance.initialize();
        loadElementProperties(ELEMENTS);
    }

    @After(value = "@Android")
    public void quitDriver(Scenario scenario) {
        boolean testStatus = scenario.isFailed(); // true or false
        try {
            if (testStatus) {
                final byte[] data = ((TakesScreenshot) AndroidDriverInstance.androidDriver).getScreenshotAs(OutputType.BYTES);
                scenario.attach(data, "image/png", "Failed Screenshot");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            AndroidDriverInstance.quit();
        }
    }
}
