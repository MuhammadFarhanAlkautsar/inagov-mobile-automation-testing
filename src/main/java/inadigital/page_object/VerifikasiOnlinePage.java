package inadigital.page_object;

public class VerifikasiOnlinePage extends BasePage {
    public void isOnVerifikasiOnlinePage() {
        assertIsDisplay("TEXT_APPBAR_VERIFIKASI_ONLINE");
        assertIsDisplay("TEXT_VERIFIKASI_ONLINE");
    }

    public void tapFormInput() {
        tap("BUTTON_FORM_INPUT");
    }

    public void tapFotoKTP() {
        tap("BUTTON_FOTO_E_KTP");
    }

    public void tapPindaiNFC() {
        tap("BUTTON_PINDAI_NFC");
    }
}
