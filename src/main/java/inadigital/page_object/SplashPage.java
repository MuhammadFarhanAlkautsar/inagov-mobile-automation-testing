package inadigital.page_object;

public class SplashPage extends BasePage {
    public void isOnSplashPage() {
        assertIsDisplay("TEXT_SPLASH");
        assertIsDisplay("BUTTON_PUSAT_BANTUAN");
    }

    public void tapMulaiVerifikasi() {
        tap("BUTTON_MULAI_VERIFIKASI");
    }

    public void tapAktifkanPerangkat() {
        tap("BUTTON_AKTIFKAN_PERANGKAT");
    }

    public void tapPusatBantuan() {
        tap("BUTTON_PUSAT_BANTUAN");
    }

    public void tapLogin() {
        tap("BUTTON_LOGIN_INAPAS");
    }
}
