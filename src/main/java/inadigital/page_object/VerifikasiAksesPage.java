package inadigital.page_object;

public class VerifikasiAksesPage extends BasePage {
    public void isOnVerifikasiAksesPage() {
        assertIsDisplay("TEXT_APPBAR_VERIFIKASI_AKSES");
        assertIsDisplay("TEXT_VERIFIKASI_AKSES");
    }

    public void tapAksesPIN() {
        tap("BUTTON_PIN");
    }

    public void tapAksesEmail() {
        tap("BUTTON_EMAIL");
    }
}
