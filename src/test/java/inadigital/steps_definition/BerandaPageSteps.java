package inadigital.steps_definition;

import inadigital.page_object.BerandaPage;
import inadigital.page_object.BiometricPage;
import io.cucumber.java8.En;

public class BerandaPageSteps implements En {
    BerandaPage berandaPage = new BerandaPage();
    public BerandaPageSteps() {
        Then("User should navigate to Beranda screen", () -> berandaPage.isOnBerandaPage());
    }
}
