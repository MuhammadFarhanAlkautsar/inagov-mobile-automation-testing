package inadigital.page_object;

public class VerifikasiDataDiriPage extends BasePage {
    public void isOnVerifikasiDataDiriPage() {
        assertIsDisplay("TEXT_APPBAR_VERIFIKASI_DATA_DIRI");
        assertIsDisplay("TEXT_VERIFIKASI_DIRI");
    }

    public void isOnPopupKeluar() {
        assertIsDisplay("POPUP_KELUAR");
        assertIsDisplay("BUTTON_BATAL");
        assertIsDisplay("BUTTON_EXIT");
    }

    public void tapVerifikasiOnline() {
        tap("BUTTON_VERIFIKASI_ONLINE");
    }

    public void tapVerifikasiTatapMuka() {
        tap("BUTTON_VERIFIKASI_TATAP_MUKA");
    }

    public void tapKembali() {
        tap("BUTTON_KEMBALI");
    }

    public void tapBatal() {
        tap("BUTTON_BATAL");
    }

    public void tapKeluar() {
        tap("BUTTON_EXIT");
    }
}
