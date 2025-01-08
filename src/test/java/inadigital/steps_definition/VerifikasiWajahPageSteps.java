package inadigital.steps_definition;

import inadigital.page_object.VerifikasiDataDiriPage;
import inadigital.page_object.VerifikasiWajahPage;
import io.cucumber.java8.En;

public class VerifikasiWajahPageSteps implements En {
    VerifikasiWajahPage verifikasiWajahPage = new VerifikasiWajahPage();
    public VerifikasiWajahPageSteps() {
        When("User click Foto Wajah", () -> verifikasiWajahPage.tapFotoWajah());
        When("User click Batalkan Foto Wajah", () -> verifikasiWajahPage.tapBatalkanFotoWajah());
        Then("User should navigate to verifikasi wajah screen", () -> verifikasiWajahPage.isOnVerifikasiWajahPage());
        Then("User should navigate to foto wajah screen", () -> verifikasiWajahPage.isOnFotoWajahPage());
    }
}
