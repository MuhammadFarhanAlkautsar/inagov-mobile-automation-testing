package inadigital.steps_definition;

import inadigital.page_object.VerifikasiAksesPage;
import inadigital.page_object.VerifikasiWajahPage;
import io.cucumber.java8.En;

public class VerifikasiAksesPageSteps implements En {
    VerifikasiAksesPage verifikasiAksesPage = new VerifikasiAksesPage();
    public VerifikasiAksesPageSteps() {
        When("User click Verifikasi Akses via PIN", () -> verifikasiAksesPage.tapAksesPIN());
        When("User click Verifikasi Akses via Email", () -> verifikasiAksesPage.tapAksesEmail());
        When("User waiting process liveness valid person", () -> verifikasiAksesPage.isOnVerifikasiAksesPage());
        Then("User should navigate to verifikasi Akses screen", () -> verifikasiAksesPage.isOnVerifikasiAksesPage());
    }
}
