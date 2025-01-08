package inadigital.android_driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.github.cdimascio.dotenv.Dotenv;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class AndroidDriverInstance {
    static AppiumDriver driver;
    public static AndroidDriver androidDriver;


    public static void main(String[] args) {
        initialize();
    }

    public static void initialize() {

        UiAutomator2Options caps = new UiAutomator2Options();
        Dotenv dotenv = Dotenv.load();

        caps.setPlatformName(dotenv.get("PLATFORM_NAME"));
        caps.setPlatformVersion(dotenv.get("PLATFORM_VERSION"));
        caps.setDeviceName(dotenv.get("DEVICE_NAME"));
        caps.setUdid(dotenv.get("UDID"));
        caps.setApp(dotenv.get("APP_PATH"));
        caps.setAppWaitActivity("*");

        caps.setCapability("appium:autoGrantPermissions", true);
        caps.setCapability("appium:ignoreHiddenApiPolicyError", true);

        caps.setCapability("appium:noReset", false);  // Reset aplikasi setelah sesi berakhir
        caps.setCapability("appium:fullReset", true); // Jika true, akan meng-uninstall aplikasi setelah sesi


        try {
            androidDriver = new AndroidDriver(new URL("http://0.0.0.0:4723"), caps);
            androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
            System.out.println(androidDriver.getPageSource());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void quit() {
        androidDriver.quit();
    }
}
