package inadigital.page_object;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class VerifikasiWajahPage extends BasePage {
    public void isOnVerifikasiWajahPage() {
        assertIsDisplay("TEXT_APPBAR_VERIFIKASI_WAJAH");
        assertIsDisplay("TEXT_VERIFIKASI_WAJAH");
    }

    public void isOnFotoWajahPage() {
        assertIsDisplay("SCREEN_FOTO_WAJAH");
        assertIsDisplay("TEXT_HADAPKAN_WAJAH");
    }

    public void tapFotoWajah() {
        tap("BUTTON_FOTO_WAJAH");
    }

    public void tapBatalkanFotoWajah() {
        tap("BUTTON_BATALKAN_FOTO_WAJAH");
    }
}
