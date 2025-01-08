package inadigital.page_object;

public class BerandaPage extends BasePage {
    public void isOnBerandaPage() {
        assertIsDisplay(getFormattedLocator("TEXT_HALO_USER", "MUHAMMAD FARHAN ALKAUTSAR"));
    }
}
