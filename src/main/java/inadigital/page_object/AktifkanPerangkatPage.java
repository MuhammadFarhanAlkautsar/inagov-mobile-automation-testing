package inadigital.page_object;

import inadigital.utils.Utils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AktifkanPerangkatPage extends BasePage {
    public void isOnAktifkanPerangkatPage() {
        assertIsDisplay("TEXT_APPBAR_AKTIFKAN_PERANGKAT");
        assertIsDisplay("TEXT_AKTIFKAN_PERANGKAT");
    }

    public void isPopupErrorINApasIDNotFound() {
        assertIsDisplay("POPUP_ERROR_INAPAS_ID_NOT_FOUND");
    }

    public void isPopupErrorInvalidINApasID() {
        assertIsDisplay("POPUP_ERROR_INAPAS_ID_INVALID");
    }

    public void isValidationErrorINApasID() {
        assertIsDisplay("TEXT_VALIDATION_ERROR_INAPAS_ID");
    }

    public void tapLanjut() {
        tap("BUTTON_LANJUT");
    }

    public void inputINApasID(String id) {
        typeOn("FIELD_INAPAS_ID", id);  // Use the typeOn method to input the name
        hideKeyboard();
    }

    public void verifyInapasIdTruncated() {
        // Locate the input field again
        WebElement inputField = waitUntil(ExpectedConditions.visibilityOfElementLocated(element("FIELD_INAPAS_ID"))); // Replace with actual ID
        String displayedValue = inputField.getText();

        // Verify if the displayed value is truncated to 10 characters
        if (displayedValue.length() == 10) {
            System.out.println("Success: INApas ID is correctly truncated to 10 characters.");
        } else {
            System.out.println("Error: INApas ID is not truncated correctly. Displayed value: " + displayedValue);
            throw new RuntimeException("INApas ID truncation failed.");
        }
    }

    public String getEnvValue(String key) {
        if (key.startsWith("ENV_")) {
            // Menghapus prefix "ENV_" untuk mencocokkan nama variabel di .env
            return Utils.env(key.replace("ENV_", ""));
        }
        return key; // Mengembalikan nilai asli jika tidak berawalan "ENV_"
    }
}
