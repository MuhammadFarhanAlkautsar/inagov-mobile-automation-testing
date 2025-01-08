package inadigital.steps_definition;

import inadigital.page_object.PINPage;
import io.cucumber.java8.En;

public class PINPageSteps implements En {
    PINPage pinPage = new PINPage();
    public PINPageSteps() {
        When("^User input pin as \"([^\"]*)\"$", (String pin) -> pinPage.inputPIN(pinPage.getEnvValue(pin)));
        When("^User input konfirmasi pin as \"([^\"]*)\"$", (String pin) -> pinPage.enterPinWithKeyCodes(pinPage.getEnvValue(pin)));
        When("User click tampilkan pin", () -> pinPage.tapTampilkanPIN());
        When("User click sembunyikan pin", () -> pinPage.tapSembunyikanPIN());
        Then("User should navigate to verifikasi pin screen", () -> pinPage.isOnVerifikasiPINPage());
        Then("User should navigate to aktifkan pin screen", () -> pinPage.isOnAktifkanPINPage());
        Then("User should navigate to buat pin screen", () -> pinPage.isOnBuatPINPage());
        Then("User should navigate to konfirmasi pin screen", () -> pinPage.isOnKonfirmasiPINPage());
        Then("User stay on buat pin screen", () -> pinPage.isOnBuatPINPage());
        Then("User stay on konfirmasi pin screen", () -> pinPage.isOnKonfirmasiPINPage());
        Then("User stay on verifikasi pin screen", () -> pinPage.isOnVerifikasiPINPage());
        Then("User should see popup validate error message data not found", () -> pinPage.isInvalidPIN());
        Then("User should see popup not match pin", () -> pinPage.isNotMatchPIN());
        Then("^User see displayed pin as \\\"([^\\\"]*)\\\" in Field PIN$", (String pin) -> pinPage.verifyPINisShow(pin));
        Then("^Only numeric characters should be accepted and displayed as \\\"([^\\\"]*)\\\" on field PIN$", (String pin) -> pinPage.verifyPINisShow(pin));
        Then("^User see not displayed pin as \\\"([^\\\"]*)\\\" in Field PIN$", (String pin) -> pinPage.verifyPINisShow(pin));
    }
}
