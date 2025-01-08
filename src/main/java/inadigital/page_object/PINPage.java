package inadigital.page_object;

import inadigital.utils.Utils;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class PINPage extends BasePage {
    public void isOnVerifikasiPINPage() {
        assertIsDisplay("TEXT_APPBAR_VERIFIKASI_PIN");
        assertIsDisplay("TEXT_MASUKKAN_PIN");
    }

    public void isOnAktifkanPINPage() {
        assertIsDisplay("TEXT_APPBAR_AKTIFKAN_PIN");
        isOnBuatPINPage();
    }

    public void isOnBuatPINPage() {
        assertIsDisplay("TEXT_BUAT_PIN");
        assertIsDisplay("SUBTEXT_BUAT_PIN");
    }

    public void isOnKonfirmasiPINPage() {
        assertIsDisplay("TEXT_KONFIRMASI_PIN");
        assertIsDisplay("SUBTEXT_KONFIRMASI_PIN");
    }

    private AndroidKey getAndroidKeyForDigit(char digit) {
        switch (digit) {
            case '0': return AndroidKey.DIGIT_0;
            case '1': return AndroidKey.DIGIT_1;
            case '2': return AndroidKey.DIGIT_2;
            case '3': return AndroidKey.DIGIT_3;
            case '4': return AndroidKey.DIGIT_4;
            case '5': return AndroidKey.DIGIT_5;
            case '6': return AndroidKey.DIGIT_6;
            case '7': return AndroidKey.DIGIT_7;
            case '8': return AndroidKey.DIGIT_8;
            case '9': return AndroidKey.DIGIT_9;
            default: return null;
        }
    }

    public void enterPinWithKeyCodes(String pin) {
        tap("FIELD_INPUT_PIN");
        for (char digit : pin.toCharArray()) {
            AndroidKey key = getAndroidKeyForDigit(digit);
            if (key != null) {
                driver().pressKey(new KeyEvent(key));
            } else {
                throw new IllegalArgumentException("Invalid character in PIN: " + digit);
            }
        }
    }

    public void isInvalidPIN() {
        assertIsDisplay("POPUP_PIN_SALAH");
    }

    public void isNotMatchPIN() {
        assertIsDisplay("POPUP_PIN_TIDAK_MATCH");
    }

    public void tapTampilkanPIN() {
        tap("BUTTON_TAMPILKAN_PIN");
    }

    public void tapSembunyikanPIN() {
        tap("BUTTON_SEMBUNYIKAN_PIN");
    }

    public void inputPIN(String pin) {
        typeOn("FIELD_INPUT_PIN", pin);  // Use the typeOn method to input the nik
        hideKeyboard();
    }

    public String getEnvValue(String key) {
        if (key.startsWith("ENV_")) {
            // Menghapus prefix "ENV_" untuk mencocokkan nama variabel di .env
            return Utils.env(key.replace("ENV_", ""));
        }
        return key; // Mengembalikan nilai asli jika tidak berawalan "ENV_"
    }

    public void verifyPINisShow(String pin) {
        assertIsTextDisplayedOnElement("FIELD_INPUT_PIN", pin);
    }

    public void verifyOnlyNumericCharacters(String expectedPin) {
        assertIsTextDisplayedOnElement("FIELD_INPUT_PIN", expectedPin);
    }
}
