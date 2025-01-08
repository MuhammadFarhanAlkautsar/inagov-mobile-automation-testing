package inadigital.steps_definition;

import inadigital.page_object.VerifikasiDataDiriPage;
import io.cucumber.java8.En;

public class VerifikasiDataDiriPageSteps implements En {
    VerifikasiDataDiriPage verifikasiDataDiriPage = new VerifikasiDataDiriPage();
    public VerifikasiDataDiriPageSteps() {
        When("User click verifikasi online", () -> verifikasiDataDiriPage.tapVerifikasiOnline());
        When("User click verifikasi tatap muka", () -> verifikasiDataDiriPage.tapVerifikasiTatapMuka());
        When("User click kembali button", () -> verifikasiDataDiriPage.tapKembali());
        When("User click batal button", () -> verifikasiDataDiriPage.tapBatal());
        When("User click keluar button", () -> verifikasiDataDiriPage.tapKeluar());
        Then("User should navigate to verifikasi data diri screen", () -> verifikasiDataDiriPage.isOnVerifikasiDataDiriPage());
        Then("User see popup keluar", () -> verifikasiDataDiriPage.isOnPopupKeluar());
    }
}
