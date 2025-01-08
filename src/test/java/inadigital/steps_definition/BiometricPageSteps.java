package inadigital.steps_definition;

import inadigital.page_object.BiometricPage;
import inadigital.page_object.VerifikasiAksesPage;
import io.cucumber.java8.En;

public class BiometricPageSteps implements En {
    BiometricPage biometricPage = new BiometricPage();
    public BiometricPageSteps() {
        When("User places an incorrect fingerprint", () -> biometricPage.simulateIncorrectFingerprint());
        When("User places an correct fingerprint", () -> biometricPage.simulateCorrectFingerprint());
        When("User click masuk ke beranda", () -> biometricPage.tapMasukBeranda());
        When("^User input pin device as \"([^\"]*)\"$", (String pin) -> biometricPage.biometricSandi(pin));
        Then("User user should see screen proses verifikasi berhasil", () -> biometricPage.isProsesVerifikasiBerhasil());
        Then("User should see biometric request screen", () -> biometricPage.isOnBiometricPage());
    }
}
