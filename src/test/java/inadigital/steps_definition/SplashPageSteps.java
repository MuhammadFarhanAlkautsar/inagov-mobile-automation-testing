package inadigital.steps_definition;

import inadigital.page_object.SplashPage;
import io.cucumber.java8.En;

public class SplashPageSteps implements En {
    SplashPage splashPage = new SplashPage();
    public SplashPageSteps() {
        Given("User is on splash page", () -> splashPage.isOnSplashPage());
        When("User click pusat bantuan", () -> splashPage.tapPusatBantuan());
        When("User click mulai verifikasi", () -> splashPage.tapMulaiVerifikasi());
        When("User click aktifkan perangkat", () -> splashPage.tapAktifkanPerangkat());
        When("User click login", () -> splashPage.tapLogin());
        Then("User should navigate to splash screen", () -> splashPage.isOnSplashPage());
    }
}
