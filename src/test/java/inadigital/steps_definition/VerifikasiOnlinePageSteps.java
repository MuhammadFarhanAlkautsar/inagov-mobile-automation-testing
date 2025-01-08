package inadigital.steps_definition;

import inadigital.page_object.VerifikasiOnlinePage;
import io.cucumber.java8.En;

public class VerifikasiOnlinePageSteps implements En {
    VerifikasiOnlinePage verifikasiOnlinePage = new VerifikasiOnlinePage();
    public VerifikasiOnlinePageSteps() {
        When("User click form input", () -> verifikasiOnlinePage.tapFormInput());
        When("User click foto ktp elektronik", () -> verifikasiOnlinePage.tapFotoKTP());
        When("User click pindai dengan nfc", () -> verifikasiOnlinePage.tapPindaiNFC());
        Then("User should navigate to verifikasi online screen", () -> verifikasiOnlinePage.isOnVerifikasiOnlinePage());
    }
}
