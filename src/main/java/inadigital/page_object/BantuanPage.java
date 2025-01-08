package inadigital.page_object;

public class BantuanPage extends BasePage {
    public void isOnBantuanPage() {
        assertIsDisplay("TEXT_PUSAT_BANTUAN");
        assertIsDisplay("TEXT_VERSI_INAPAS");
    }

    public void isOnFormulirAduanPage() {
        assertIsDisplay("SCREEN_FORMULIR_ADUAN");
    }

    public void isOnFAQPage() {
        assertIsDisplay("SCREEN_FAQ");
    }

    public void isOnLinkedinPage() {
        assertIsTextDisplayedOnElement("SCREEN_LINKEDIN", "INA DIGITAL | LinkedIn", "Daftar | LinkedIn");
        assertIsTextDisplayedOnElement("SCREEN_WEBVIEW", "linkedin.com");
    }

    public void isOnFacebookPage() {
        assertIsTextDisplayedOnElement("SCREEN_WEBVIEW", "m.facebook.com");
        assertIsDisplay("SCREEN_FACEBOOK");
    }

    public void isOnYoutubePage() {
        assertIsDisplay("SCREEN_YOUTUBE_INADIGITAL");
        assertIsDisplay("SCREEN_YOUTUBE");
    }

    public void isOnTwitterPage() {
        assertIsDisplay("SCREEN_TWITTER");
        assertIsTextDisplayedOnElement("SCREEN_WEBVIEW", "x.com");
    }

    public void isOnBrowserPage() {
        assertIsDisplay("SCREEN_BROWSER");
        assertIsTextDisplayedOnElement("SCREEN_WEBVIEW", "inadigital.co.id");
    }

    public void tapFormulirAduan() {
        tap("BUTTON_FORMULIR_ADUAN");
    }

    public void tapFAQ() {
        tap("BUTTON_FAQ");
    }

    public void tapHapusAkun() {
        tap("BUTTON_HAPUS_AKUN");
    }

    public void tapTutupTab() {
        tap("BUTTON_TUTUP_TAB");
    }

    public void tapLinkedInIcon() {
        tap("ICON_LINKEDIN");
    }

    public void tapFacebookIcon() {
        tap("ICON_FACEBOOK");
    }

    public void tapYoutubeIcon() {
        tap("ICON_YOUTUBE");
    }

    public void tapTwitterIcon() {
        tap("ICON_TWITTER");
    }

    public void tapBrowserIcon() {
        tap("ICON_BROWSER");
    }
}
