package inadigital.steps_definition;

import inadigital.page_object.FormDataDiriPage;
import inadigital.page_object.VerifikasiOnlinePage;
import io.cucumber.java8.En;

public class FormDataDiriPageSteps implements En {
    FormDataDiriPage formDataDiriPage = new FormDataDiriPage();
    public FormDataDiriPageSteps() {
        When("User click lanjutkan on popup konfirmasi data", () -> formDataDiriPage.tapLanjutkan());
        When("User click batalkan tanggal lahir", () -> formDataDiriPage.tapBatalTanggalLahir());
        When("User click field tanggal lahir", () -> formDataDiriPage.tapTanggalLahir());
        When("User click dropdown tahun lahir", () -> formDataDiriPage.tapPilihTahun());
        When("User click previous month", () -> formDataDiriPage.tapPreviousMonth());
        When("User click next month", () -> formDataDiriPage.tapNextMonth());
        When("^User input nik as \"([^\"]*)\"$", (String nik) -> formDataDiriPage.inputNIK(formDataDiriPage.getEnvValue(nik)));
        When("^User input name as \"([^\"]*)\"$", (String nama) -> formDataDiriPage.inputNama(formDataDiriPage.getEnvValue(nama)));
        When("^User input tanggal lahir as date \"([^\"]*)\"$", (String tanggalLahir) -> formDataDiriPage.inputTanggalLahir(formDataDiriPage.getEnvValue(tanggalLahir)));
        When("^User input birthdate as \"([^\"]*)\"$", (String tanggalLahir) -> formDataDiriPage.userInputsBirthdate(tanggalLahir));
        When("^User input email as \"([^\"]*)\"$", (String email) -> formDataDiriPage.inputEmail(formDataDiriPage.getEnvValue(email)));
        When("^User input phone as \"([^\"]*)\"$", (String phone) -> formDataDiriPage.inputPhone(formDataDiriPage.getEnvValue(phone)));
        Then("User should navigate to form data diri screen", () -> formDataDiriPage.isOnFormDataDiriPage());
        Then("User see lanjut button is disabled", () -> formDataDiriPage.isLanjutButtonDisabled());
        Then("User see lanjut button is enabled", () -> formDataDiriPage.isLanjutButtonEnabled());
        Then("User see all option years", () -> formDataDiriPage.isDropdownPilihanTahun());
        Then("User see validation invalid nik", () -> formDataDiriPage.isInvalidNIKValidation());
        Then("User see validation invalid nama", () -> formDataDiriPage.isInvalidNamaValidation());
        Then("User see validation invalid tanggal lahir", () -> formDataDiriPage.isInvalidTanggalLahirValidation());
        Then("User see validation invalid email", () -> formDataDiriPage.isInvalidEmailValidation());
        Then("User see validation invalid phone", () -> formDataDiriPage.isInvalidPhoneValidation());
        Then("User see validation invalid phone more than 14 digit", () -> formDataDiriPage.isInvalidPhone14digitsValidation());
        Then("User see pop up konfirmasi data diri", () -> formDataDiriPage.isOnPopupKonfirmasiData());
        Then("User should see popup confirmation data close", () -> formDataDiriPage.isOnPopupKonfirmasiData());
        Then("Verify that the displayed month is updated to the previous month", () -> formDataDiriPage.verifyDisplayedMonth("Oktober"));
        Then("Verify that the displayed month is updated to the next month", () -> formDataDiriPage.verifyDisplayedMonth("November"));
        Then("^User see NIK as \\\"([^\\\"]*)\\\" in Konfirmasi Data$", (String expectedNIK) -> formDataDiriPage.isKonfirmasiNIKValid(expectedNIK));
        Then("^User see Nama as \\\"([^\\\"]*)\\\" in Konfirmasi Data$", (String expectedNama) -> formDataDiriPage.isKonfirmasiNamaValid(expectedNama));
        Then("^User see Tanggal Lahir as \\\"([^\\\"]*)\\\" in Konfirmasi Data$", (String expectedTanggalLahir) -> formDataDiriPage.isKonfirmasiTanggalLahirValid(expectedTanggalLahir));
        Then("^User see Email as \\\"([^\\\"]*)\\\" in Konfirmasi Data$", (String expectedEmail) -> formDataDiriPage.isKonfirmasiEmailValid(expectedEmail));
        Then("^User see Phone as \\\"([^\\\"]*)\\\" in Konfirmasi Data$", (String expectedPhone) -> formDataDiriPage.isKonfirmasiPhoneValid(expectedPhone));
        Then("User see pop up invalid data dukcapil not match", () -> formDataDiriPage.isInvalidErrorDukcapil());
        Then("User see pop up invalid data process failed", () -> formDataDiriPage.isInvalidError());
        Then("User see pop up invalid data already registered", () -> formDataDiriPage.isInvalidAlreadyRegistered());
        Then("^The date \\\"([^\\\"]*)\\\" is not found in the date picker$", (String tanggallahir) -> formDataDiriPage.validateDateOfBirth(tanggallahir));
        Then("The system should restrict input and disable the next button", () -> formDataDiriPage.verifyNextButtonDisabled());
        Then("^The system should restrict input date as \"([^\"]*)\" and disable the day selection$", (String tanggallahir) -> formDataDiriPage.verifyDaySelectionDisabled(tanggallahir));
    }
}
