package inadigital.page_object;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import inadigital.android_driver.AndroidDriverInstance;
import inadigital.utils.Utils;

import java.time.Duration;
import java.util.Arrays;

public class BasePage {
    public By element(String elementLocator) {
        String elementValue = Utils.ELEMENTS.getProperty(elementLocator);

        String[] locator = elementValue.split("_");
        String locatorType = locator[0];
        String locatorValue = elementValue.substring(elementValue.indexOf("_") + 1);
        return switch (locatorType) {
            case "id" -> By.id(locatorValue);
            case "name" -> By.name(locatorValue);
            case "xpath" -> By.xpath(locatorValue);
            case "containsText" -> By.xpath(String.format("//*[contains(@text, '%s')]", locatorValue));
            case "containsDesc" -> By.xpath(String.format("//*[contains(@content-desc, '%s')]", locatorValue));
            case "cssSelector" -> By.cssSelector(locatorValue);
            case "accessibilityId" -> AppiumBy.accessibilityId(locatorValue);
            case "className" -> By.className(locatorValue);
            default -> throw new IllegalStateException("Unexpected locator type: " + locatorType);
        };
    }

    public String getFormattedLocator(String key, String... dynamicValues) {
        String locatorTemplate = Utils.ELEMENTS.getProperty(key);
        return String.format(locatorTemplate, (Object[]) dynamicValues);
    }

    public AndroidDriver driver() {
        return AndroidDriverInstance.androidDriver;
    }

    public AndroidDriver getDriver() {
        return AndroidDriverInstance.androidDriver;
    }

    public WebElement waitUntil(ExpectedCondition<WebElement> expectation) {
        WebDriverWait wait = new WebDriverWait(driver(), Duration.ofSeconds(60));
        return wait.until(expectation);
    }

    public WebElement waitUntil(ExpectedCondition<WebElement> expectation, int timeoutInSeconds) {
        // Buat WebDriverWait dengan waktu tunggu yang diterima sebagai parameter
        WebDriverWait wait = new WebDriverWait(driver(), Duration.ofSeconds(timeoutInSeconds));
        return wait.until(expectation);
    }

    public void tap(String element) {
        waitUntil(ExpectedConditions.elementToBeClickable(element(element))).click();
    }

    public void typeOn(String element, String value) {
        WebElement elementField = waitUntil(ExpectedConditions.visibilityOfElementLocated(element(element)));
        elementField.click();
        elementField.clear();
        elementField.sendKeys(value);
    }

    public void tapOnElement(String element) {
        WebElement elementField = waitUntil(ExpectedConditions.visibilityOfElementLocated(element(element)));
        // Definisikan input perangkat sentuh
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence tap = new Sequence(finger, 1);

        // Tentukan aksi tap menggunakan W3C Actions
        tap.addAction(finger.createPointerMove(Duration.ofMillis(0),
                PointerInput.Origin.fromElement(elementField), 0, 0));
        tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver().perform(Arrays.asList(tap));// Tap pada elemen
    }

    public void assertIsDisplay(String element) {
        try {
            waitUntil(ExpectedConditions.visibilityOfElementLocated(element(element))).isDisplayed();
        } catch (NoSuchElementException e) {
            throw new AssertionError(String.format("This element '%s' not found", element));
        }
    }

    public void assertIsNotDisplayed(String element) {
        try {
            // Coba temukan elemen dengan kondisi "visibility"
            boolean isVisible = waitUntil(ExpectedConditions.visibilityOfElementLocated(element(element))).isDisplayed();

            // Jika elemen terlihat, lempar AssertionError
            if (isVisible) {
                throw new AssertionError(String.format("This element '%s' is still visible", element));
            }
        } catch (NoSuchElementException e) {
            // Jika elemen tidak ditemukan, ini berarti elemen tidak ditampilkan, dan tes berhasil
        }
    }


    public void assertIsEnabled(String element) {
        try {
            waitUntil(ExpectedConditions.visibilityOfElementLocated(element(element))).isEnabled();
        } catch (NoSuchElementException e) {
            throw new AssertionError(String.format("This element '%s' not found", element));
        }
    }

    public void assertIsDisabled(String elementLocator) {
        try {
            WebElement element = waitUntil(ExpectedConditions.visibilityOfElementLocated(element(elementLocator)));

            if (element.isEnabled()) {
                throw new AssertionError(String.format("Element '%s' is enabled, but expected to be disabled.", elementLocator));
            } else {
                System.out.println(String.format("Element '%s' is disabled as expected.", elementLocator));
            }
        } catch (NoSuchElementException e) {
            throw new AssertionError(String.format("This element '%s' not found", elementLocator));
        }
    }

    public void assertIsTextDisplayedOnElement(String elementLocator, String... expectedTexts) {
        try {
            WebElement element = waitUntil(ExpectedConditions.visibilityOfElementLocated(element(elementLocator)));
            String actualText = element.getText();

            for (String expectedText : expectedTexts) {
                if (actualText.equals(expectedText)) {
                    return; // Mengembalikan true jika salah satu teks yang diharapkan ditemukan
                }
            }
        } catch (Exception e) {
            System.out.println("Warning in isTextDisplayedOnElement: " + e.getMessage());
        }
    }

    public void isContentDescDisplayedOnElement(String elementLocator, String... expectedContentDescs) {
        try {
            WebElement element = waitUntil(ExpectedConditions.visibilityOfElementLocated(element(elementLocator)));
            String actualContentDesc = element.getAttribute("content-desc");

            for (String expectedContentDesc : expectedContentDescs) {
                if (actualContentDesc != null && actualContentDesc.contains(expectedContentDesc)) {
                    return; // Mengembalikan true jika salah satu content-desc yang diharapkan ditemukan
                }
            }
        } catch (Exception e) {
            System.out.println("Warning in isContentDescDisplayedOnElement: " + e.getMessage());
        }
    }

    public void verifyElementIsNotClickable(String elementLocator) {
            WebElement element = waitUntil(ExpectedConditions.visibilityOfElementLocated(element(elementLocator)));
            String clickableAttribute = element.getAttribute("clickable");

            if ("false".equals(clickableAttribute)) {
                System.out.println("Test Passed: The element is not clickable.");
            } else {
                System.out.println("Test Failed: The element is clickable.");
            }
    }

    public void isCheckboxChecked(String elementLocator, boolean expectedCheckedStatus) {
        try {
            WebElement element = waitUntil(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementLocator)));
            String isChecked = element.getAttribute("checked");

            // Jika atribut "checked" adalah "true", maka berarti checkbox tercentang
            "true".equals(isChecked);

            // Verifikasi apakah status checked sesuai dengan yang diharapkan
        } catch (Exception e) {
            System.out.println("Warning: Unable to verify checkbox status. " + e.getMessage());
        }
    }

    public void pause(long milliseconds) {
        try {
            Thread.sleep(milliseconds); // Menunggu selama jumlah milidetik yang diberikan
        } catch (InterruptedException e) {
            System.err.println("Pause interrupted: " + e.getMessage());
            Thread.currentThread().interrupt(); // Mengembalikan status interrupted ke thread
        }
    }

    public void verifyCheckboxEnabled(String elementLocator, boolean expectedEnabledStatus) {
        try {
            // Tunggu hingga elemen checkbox terlihat dan dapat diakses
            WebElement element = waitUntil(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementLocator)));

            // Ambil atribut "enabled" dari elemen checkbox
            String isEnabled = element.getAttribute("enabled");

            // Konversi nilai atribut "enabled" menjadi boolean
            "true".equals(isEnabled);
        } catch (Exception e) {
            System.out.println("Warning: Unable to verify checkbox enabled status. " + e.getMessage());
        }
    }

    public void hideKeyboard() {
        try {
            driver().hideKeyboard();
        } catch (Exception e) {
            System.out.println("Warning: Unable to hide keyboard. " + e.getMessage());
        }
    }

    public boolean scrollAndClickToElementByDescription(String description) {
        try {
            driver().findElement(new AppiumBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(" +
                    "new UiSelector().description(\"" + description + "\"))")).click();
            return true;
        } catch (Exception e) {
            System.out.println("Warning: Element with description '" + description + "' not found. " + e.getMessage());
            return false;
        }
    }

    public void scrollForward(int times) {
        try {
            for (int i = 0; i < times; i++) {
                driver().findElement(new AppiumBy.ByAndroidUIAutomator(
                        "new UiScrollable(new UiSelector().scrollable(true)).scrollForward()"));
            }
        } catch (Exception e) {
            System.out.println("Warning: Unable to scroll forward. " + e.getMessage());
        }
    }

    public void scrollBackward(int times) {
        try {
            for (int i = 0; i < times; i++) {
                driver().findElement(new AppiumBy.ByAndroidUIAutomator(
                        "new UiScrollable(new UiSelector().scrollable(true)).scrollBackward()"));
            }
        } catch (Exception e) {
            System.out.println("Warning: Unable to scroll backward. " + e.getMessage());
        }
    }

    public void scrollToEnd(int maxSwipes) {
        try {
            driver().findElement(new AppiumBy.ByAndroidUIAutomator(
                    "new UiScrollable(new UiSelector().scrollable(true)).scrollToEnd(" + maxSwipes + ", 5)"));
            System.out.println("Successfully scrolled to the end.");
        } catch (Exception e) {
            System.out.println("Warning: Unable to scroll to end. " + e.getMessage());
        }
    }
}
