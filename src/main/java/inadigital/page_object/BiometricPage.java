package inadigital.page_object;

public class BiometricPage extends BasePage {
    public void isOnBiometricPage() {
        assertIsTextDisplayedOnElement("TEXT_TITLE_BIOMETRIC", "Authentication required");
        assertIsTextDisplayedOnElement("TEXT_SUBTITLE_BIOMETRIC", "Verify identity");
        assertIsTextDisplayedOnElement("TEXT_DESCRIPTION_BIOMETRIC", "Konfirmasi dengan Sidik Jari");
    }

    public void isProsesVerifikasiBerhasil() {
        assertIsDisplay("TEXT_VERIFIKASI_BERHASIL");
        assertIsDisplay("BUTTON_MASUK_BERANDA");
    }

    public void simulateIncorrectFingerprint() {
        assertIsTextDisplayedOnElement("TEXT_TITLE_BIOMETRIC", "Coba Lagi");
        assertIsTextDisplayedOnElement("TEXT_SUBTITLE_BIOMETRIC", "Verify identity");
        assertIsTextDisplayedOnElement("TEXT_DESCRIPTION_BIOMETRIC", "Konfirmasi dengan Sidik Jari");
        pause(3000);
        assertIsDisplay("BUTTON_SANDI_BIOMETRIC");
        tap("BUTTON_SANDI_BIOMETRIC");
    }

    public void simulateCorrectFingerprint() {
        pause(6000);
        System.out.println("Simulasi fingerprint yang sesuai.");
    }

    public void biometricSandi(String sandi) {
        typeOn("FIELD_SANDI", sandi);
        tap("ICON_CONFIRM");
    }

    public void tapMasukBeranda() {
        tap("BUTTON_MASUK_BERANDA");
    }
}
