package inadigital.page_object;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class EmailPage extends BasePage {
    public void isOnVerifikasiEmailPage() {
        assertIsDisplay("APPBAR_VERIFIKASI_EMAIL");
        assertIsDisplay("TEXT_VERIFIKASI_EMAIL");
    }

    public void isInvalidOTP() {
        assertIsDisplay("POPUP_GAGAL_VERIFIKASI");
    }

    public void tapKirimOTP() {
        tap("BUTTON_KIRIM_ULANG_OTP");
    }

    public void tapLanjutkan() {
        tap("BUTTON_LANJUTKAN");
    }

    public void expiredOTP() {
        String expiredOTP = getValueOTP();
        waitTimerOTP();
        tapKirimOTP();
        inputOTP(expiredOTP);
    }

    public void inputOTPValid() {
        String valueOTP = getValueOTP();
        typeOn("FIELD_INPUT_OTP", valueOTP);  // Use the typeOn method to input the nik
        hideKeyboard();
    }

    public void waitTimerOTP() {
        waitUntil(ExpectedConditions.visibilityOfElementLocated(element("TEXT_TIMER_OTP")), 150);
    }

    public void inputOTP(String valueOTP) {
        typeOn("FIELD_INPUT_OTP", valueOTP);  // Use the typeOn method to input the nik
        hideKeyboard();
    }

    public String getValueOTP() {
        driver().openNotifications();
        WebElement element1 = waitUntil(ExpectedConditions.visibilityOfElementLocated(element("NEW_OTP")));
        if (element1.isDisplayed()) {
            System.out.println("Elemen NEW_OTP terlihat di layar.");
        } else {
            System.err.println("Elemen NEW_OTP tidak terlihat di layar.");
        }
        WebElement element = waitUntil(ExpectedConditions.visibilityOfElementLocated(element("NOTIFICATION_OTP")));
        String otpText = element.getText();
        System.out.println(otpText);
        String otp = otpText.replaceAll("[^0-9]", "");
        System.out.println("OTP dari notifikasi: " + otp);
        driver().navigate().back();
        return otp;
    }

    public void isNewOTP() {
        try {
            // Pause untuk memberi waktu notifikasi muncul
            pause(5000);

            // Buka notifikasi
            driver().openNotifications();

            // Periksa apakah elemen NEW_OTP terlihat
            WebElement element1 = waitUntil(ExpectedConditions.visibilityOfElementLocated(element("NEW_OTP")));
            if (element1.isDisplayed()) {
                System.out.println("Elemen NEW_OTP terlihat di layar.");
            } else {
                System.err.println("Elemen NEW_OTP tidak terlihat di layar.");
            }

            WebElement element = waitUntil(ExpectedConditions.visibilityOfElementLocated(element("NOTIFICATION_OTP")));
            String otpText = element.getText();

            if (otpText.contains("Kode OTP Verifikasi Email")) {
                System.out.println("Notifikasi mengandung teks 'Kode OTP Verifikasi Email': " + otpText);
            } else {
                System.err.println("Notifikasi tidak mengandung teks 'Kode OTP Verifikasi Email'.");
            }

            // Kembali ke aplikasi
            driver().navigate().back();
        } catch (Exception e) {
            System.err.println("Error saat memproses notifikasi OTP: " + e.getMessage());
            throw e; // Melempar ulang exception untuk pengujian
        }
    }

    public void isTimerReset() {
        assertIsDisplay("TEXT_TIMER_OTP_DEFAULT");
    }
}
