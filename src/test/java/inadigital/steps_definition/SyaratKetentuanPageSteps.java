package inadigital.steps_definition;

import inadigital.page_object.SplashPage;
import inadigital.page_object.SyaratKetentuanPage;
import io.cucumber.java8.En;

public class SyaratKetentuanPageSteps implements En {
    SyaratKetentuanPage syaratKetentuanPage = new SyaratKetentuanPage();
    SplashPage splashPage = new SplashPage();
    public SyaratKetentuanPageSteps() {
        When("User click checkbox syarat ketentuan", () -> syaratKetentuanPage.tapCheckboxSyaratKetentuan());
        When("User click checkbox kebijakan privasi", () -> syaratKetentuanPage.tapCheckboxKebijakanPrivasi());
        When("User does not scrolls through the terms and conditions", () -> syaratKetentuanPage.scrollForwardSyaratKetentuan(0));
        When("User scrolls through the terms and conditions to up again", () -> syaratKetentuanPage.scrollBackwardSyaratKetentuan(2));
        When("User does scrolls through the terms and conditions to end", () -> syaratKetentuanPage.scrollToEndSyaratKetentuan(2));
        When("User scrolls through the terms and conditions but does not reach the end", () -> syaratKetentuanPage.scrollForwardSyaratKetentuan(2));
        When("User click link kebijakan privasi", () -> syaratKetentuanPage.tapKebijakanPrivasi());
        Then("User should navigate to syarat ketentuan screen", () -> syaratKetentuanPage.isOnSyaratKetentuanPage());
        Then("User should navigate to kebijakan privasi dan perjanjian pelanggan screen", () -> syaratKetentuanPage.isOnKebijakanPrivasiPage());
        Then("The checkbox Terms and Condition remains hidden", () -> syaratKetentuanPage.isCheckboxSyaratKetentuanDisabled());
        Then("The checkbox privacy policy remains hidden", () -> syaratKetentuanPage.isCheckboxKebijakanPrivasiDisabled());
        Then("The checkbox Terms and Condition should be displayed", () -> syaratKetentuanPage.isCheckboxSyaratKetentuanEnabled());
        Then("The checkbox privacy policy should be displayed", () -> syaratKetentuanPage.isCheckboxKebijakanPrivasiEnabled());
        Then("The checkbox Terms and Condition should be unchecked", () -> syaratKetentuanPage.isCheckboxSyaratKetentuanUnchecked());
        Then("The checkbox privacy policy should be unchecked", () -> syaratKetentuanPage.isCheckboxKebijakanPrivasiUnchecked());
        Then("The checkbox Terms and Condition should be checked", () -> syaratKetentuanPage.isCheckboxSyaratKetentuanChecked());
        Then("The checkbox privacy policy should be checked", () -> syaratKetentuanPage.isCheckboxKebijakanPrivasiChecked());
    }
}
