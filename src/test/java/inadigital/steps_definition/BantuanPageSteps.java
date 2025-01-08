package inadigital.steps_definition;

import inadigital.page_object.BantuanPage;
import io.cucumber.java8.En;

public class BantuanPageSteps implements En {
    BantuanPage bantuanPage = new BantuanPage();
    public BantuanPageSteps() {
        When("User click formulir aduan", () -> bantuanPage.tapFormulirAduan());
        When("User click faq", () -> bantuanPage.tapFAQ());
        When("User click INApas website icon button", () -> bantuanPage.tapBrowserIcon());
        When("User click INApas twitter icon button", () -> bantuanPage.tapTwitterIcon());
        When("User click INApas youtube icon button", () -> bantuanPage.tapYoutubeIcon());
        When("User click INApas facebook icon button", () -> bantuanPage.tapFacebookIcon());
        When("User click INApas linkedin icon button", () -> bantuanPage.tapLinkedInIcon());
        Then("User should navigate to help center screen", () -> bantuanPage.isOnBantuanPage());
        Then("User see formulir aduan screen", () -> bantuanPage.isOnFormulirAduanPage());
        Then("User see faq screen", () -> bantuanPage.isOnFAQPage());
        Then("User should be navigate to the INA digital linkedIn", () -> bantuanPage.isOnLinkedinPage());
        Then("User should be navigate to the INA digital Facebook", () -> bantuanPage.isOnFacebookPage());
        Then("User should be navigate to the INA digital Youtube", () -> bantuanPage.isOnYoutubePage());
        Then("User should be navigate to the INA digital Twitter", () -> bantuanPage.isOnTwitterPage());
        Then("User should be navigate to the INA digital Browser", () -> bantuanPage.isOnBrowserPage());
    }
}
