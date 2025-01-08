package inadigital.steps_definition;

import inadigital.page_object.EmailPage;
import inadigital.page_object.PINPage;
import inadigital.page_object.VerifikasiWajahPage;
import io.cucumber.java8.En;

public class EmailPageSteps implements En {
    EmailPage emailPage = new EmailPage();
    public EmailPageSteps() {
        When("User input otp from notif email", () -> emailPage.inputOTPValid());
        When("User input expired otp", () -> emailPage.expiredOTP());
        When("User click lanjutkan on Verifikasi alamat email", () -> emailPage.tapLanjutkan());
        When("^User input otp as \"([^\"]*)\"$", (String valueOTP) -> emailPage.inputOTP(valueOTP));
        When("User click kirim ulang otp", () -> emailPage.tapKirimOTP());
        When("User waits until OTP timer reaches 00:00", () -> emailPage.waitTimerOTP());
        Then("User should see notify a new OTP", () -> emailPage.isNewOTP());
        When("User waiting process liveness valid person for Mulai Verifikasi", () -> emailPage.isOnVerifikasiEmailPage());
        Then("User should see OTP wait time is reset to the default of 2 minutes", () -> emailPage.isTimerReset());
        Then("User should navigate to verifikasi Email screen", () -> emailPage.isOnVerifikasiEmailPage());
        Then("User user should see popup validate error message OTP tidak cocok", () -> emailPage.isInvalidOTP());
    }
}
