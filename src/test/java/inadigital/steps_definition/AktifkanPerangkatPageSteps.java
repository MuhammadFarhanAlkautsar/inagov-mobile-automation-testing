package inadigital.steps_definition;

import inadigital.page_object.AktifkanPerangkatPage;
import io.cucumber.java8.En;

public class AktifkanPerangkatPageSteps implements En {
    AktifkanPerangkatPage aktifkanPerangkatPage = new AktifkanPerangkatPage();
    public AktifkanPerangkatPageSteps() {
        When("User click lanjut", () -> aktifkanPerangkatPage.tapLanjut());
        When("^User input inapas id as \"([^\"]*)\"$", (String id) -> aktifkanPerangkatPage.inputINApasID(aktifkanPerangkatPage.getEnvValue(id)));
        Then("User should navigate to aktifkan perangkat screen", () -> aktifkanPerangkatPage.isOnAktifkanPerangkatPage());
        Then("User see pop up inapas id not found", () -> aktifkanPerangkatPage.isPopupErrorINApasIDNotFound());
        Then("User see pop up invalid inapas id", () -> aktifkanPerangkatPage.isPopupErrorInvalidINApasID());
        Then("User see error validation inapas id", () -> aktifkanPerangkatPage.isValidationErrorINApasID());
        Then("User should see the INApas ID is truncated to 10 characters", () -> aktifkanPerangkatPage.verifyInapasIdTruncated());
    }
}
