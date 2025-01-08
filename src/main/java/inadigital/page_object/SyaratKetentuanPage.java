package inadigital.page_object;

public class SyaratKetentuanPage extends BasePage {
    public void isOnSyaratKetentuanPage() {
        assertIsDisplay("TEXT_SYARAT_KETENTUAN");
        assertIsDisplay("TEXT_APPBAR_SYARAT_KETENTUAN");
    }

    public void isOnKebijakanPrivasiPage() {
        assertIsDisplay("WEBVIEW_KEBIJAKAN_PRIVASI");
        assertIsDisplay("TEXT_KEBIJAKAN_PRIVASI");
    }

    public void isCheckboxSyaratKetentuanDisabled(){
        verifyCheckboxEnabled("CHECKBOX_SYARAT_KETENTUAN", false);
    }

    public void isCheckboxSyaratKetentuanEnabled(){
        verifyCheckboxEnabled("CHECKBOX_SYARAT_KETENTUAN", true);
    }

    public void isCheckboxKebijakanPrivasiDisabled(){
        verifyCheckboxEnabled("CHECKBOX_KEBIJAKAN_PRIVASI", false);
    }

    public void isCheckboxKebijakanPrivasiEnabled(){
        verifyCheckboxEnabled("CHECKBOX_KEBIJAKAN_PRIVASI", true);
    }

    public void isCheckboxSyaratKetentuanUnchecked(){
        isCheckboxChecked("CHECKBOX_SYARAT_KETENTUAN", false);
    }

    public void isCheckboxSyaratKetentuanChecked(){
        isCheckboxChecked("CHECKBOX_SYARAT_KETENTUAN", true);
    }

    public void isCheckboxKebijakanPrivasiUnchecked(){
        isCheckboxChecked("CHECKBOX_KEBIJAKAN_PRIVASI", false);
    }

    public void isCheckboxKebijakanPrivasiChecked(){
        isCheckboxChecked("CHECKBOX_KEBIJAKAN_PRIVASI", true);
    }

    public void tapKebijakanPrivasi() {
        assertIsDisplay("TEXT_SETUJU_KEBIJAKAN_PRIVASI_LINK");
        tapOnElement("TEXT_SETUJU_KEBIJAKAN_PRIVASI_LINK");
    }

    public void tapCheckboxSyaratKetentuan() {
        tap("CHECKBOX_SYARAT_KETENTUAN");
    }

    public void tapCheckboxKebijakanPrivasi() {
        tap("CHECKBOX_KEBIJAKAN_PRIVASI");
    }

    public void scrollForwardSyaratKetentuan(int times){scrollForward(times);}

    public void scrollBackwardSyaratKetentuan(int times){scrollBackward(times);}

    public void scrollToEndSyaratKetentuan(int maxswipes){scrollToEnd(maxswipes);}
}
