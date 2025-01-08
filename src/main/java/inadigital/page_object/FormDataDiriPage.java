package inadigital.page_object;

import dev.failsafe.internal.util.Assert;
import inadigital.utils.Utils;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FormDataDiriPage extends BasePage {
    public void isOnFormDataDiriPage() {
        assertIsDisplay("TEXT_APPBAR_FORM_DATA_DIRI");
        assertIsDisplay("TEXT_DATA_DIRI");
    }

    public void isOnPopupKonfirmasiData() {
        assertIsDisplay("POPUP_KONFIRMASI_DATA");
        assertIsDisplay("TEXT_POPUP_KONFIRMASI_DATA");
    }

    public void isPopupKonfirmasiDataClose() {
        assertIsNotDisplayed("POPUP_KONFIRMASI_DATA");
        assertIsNotDisplayed("TEXT_POPUP_KONFIRMASI_DATA");
    }

    public void isKonfirmasiNamaValid(String expectedNama) {
        isContentDescDisplayedOnElement("TEXT_KONFIRMASI_DATA_NAMA", expectedNama);
    }

    public void isKonfirmasiNIKValid(String expectedNIK) {
        isContentDescDisplayedOnElement("TEXT_KONFIRMASI_DATA_NIK", expectedNIK);
    }

    public void isKonfirmasiEmailValid(String expectedEmail) {
        isContentDescDisplayedOnElement("TEXT_KONFIRMASI_DATA_EMAIL", expectedEmail);
    }

    public void isKonfirmasiPhoneValid(String expectedPhone) {
        // Jika nomor telepon diawali dengan "0", ubah menjadi "62"
        if (expectedPhone.startsWith("0")) {
            expectedPhone = "62" + expectedPhone.substring(1);
        }
        isContentDescDisplayedOnElement("TEXT_KONFIRMASI_DATA_PHONE", expectedPhone);
    }

    public void isKonfirmasiTanggalLahirValid(String expectedTanggalLahir) {
        String reformattedTanggalLahir = reformatTanggalLahir(expectedTanggalLahir);

        isContentDescDisplayedOnElement("TEXT_KONFIRMASI_DATA_TANGGAL_LAHIR", reformattedTanggalLahir);
    }

    public String reformatTanggalLahir(String originalTanggalLahir) {
        try {
            // Contoh: originalTanggalLahir = "8, Kamis, 8 November 2007"

            // Pecah string untuk mengambil bagian tanggal, bulan, dan tahun
            String[] parts = originalTanggalLahir.split(", ");
            String[] dayMonthYear = parts[2].split(" ");

            // Ambil tanggal (dengan format dua digit), bulan, dan tahun
            String day = String.format("%02d", Integer.parseInt(dayMonthYear[0])); // "8" -> "08"
            String month = convertMonthToNumber(dayMonthYear[1]); // "November" -> "11"
            String year = dayMonthYear[2]; // "2007"

            // Gabungkan dalam format "DD-MM-YYYY"
            return day + "-" + month + "-" + year; // Contoh: "08-11-2007"
        } catch (Exception e) {
            System.out.println("Error formatting tanggal lahir: " + e.getMessage());
            return originalTanggalLahir; // Kembalikan string asli jika terjadi error
        }
    }

    // Fungsi untuk mengonversi nama bulan ke angka bulan dalam format dua digit
    private String convertMonthToNumber(String month) {
        switch (month.toLowerCase()) {
            case "januari": return "01";
            case "februari": return "02";
            case "maret": return "03";
            case "april": return "04";
            case "mei": return "05";
            case "juni": return "06";
            case "juli": return "07";
            case "agustus": return "08";
            case "september": return "09";
            case "oktober": return "10";
            case "november": return "11";
            case "desember": return "12";
            default: throw new IllegalArgumentException("Bulan tidak valid: " + month);
        }
    }

    public void isLanjutButtonDisabled() {
        assertIsDisabled("BUTTON_LANJUT");
    }

    public void isLanjutButtonEnabled() {
        assertIsEnabled("BUTTON_LANJUT");
    }

    public void isDropdownPilihanTahun() {
        assertIsDisplay("DROPDOWN_PILIHAN_TAHUN");
    }

    public void isInvalidErrorDukcapil() {
        assertIsDisplay("POPUP_DUKCAPIL_ERROR");
    }

    public void isInvalidError() {
        assertIsDisplay("POPUP_KESALAHAN_PROCESS");
    }

    public void isInvalidAlreadyRegistered() {
        assertIsDisplay("POPUP_ALREADY_REGISTERED");
    }

    public void isInvalidNIKValidation() {
        assertIsDisplay("TEXT_ERROR_VALIDATION_NIK");
    }

    public void isInvalidNamaValidation() {
        assertIsDisplay("TEXT_ERROR_VALIDATION_NAME");
    }

    public void isInvalidEmailValidation() {
        assertIsDisplay("TEXT_ERROR_VALIDATION_EMAIL");
    }

    public void isInvalidPhoneValidation() {
        assertIsDisplay("TEXT_ERROR_VALIDATION_HP");
    }

    public void isInvalidPhone14digitsValidation() {
        assertIsDisplay("TEXT_ERROR_VALIDATION_14_DIGIT_PHONE");
    }

    public void isInvalidTanggalLahirValidation() {
        assertIsDisplay("TEXT_ERROR_VALIDATION_TANGGAL_LAHIR");
    }

    public void inputNIK(String nik) {
        typeOn("FIELD_NIK", nik);  // Use the typeOn method to input the nik
        hideKeyboard();
    }

    public void inputNama(String nama) {
        typeOn("FIELD_NAMA", nama);  // Use the typeOn method to input the name
        hideKeyboard();
    }

    // Fungsi untuk mendapatkan bulan saat ini dalam bentuk integer (1 untuk Januari, 2 untuk Februari, dst.)
    private int getCurrentMonth() {
        LocalDate today = LocalDate.now();
        return today.getMonthValue();
    }

    public String getEnvValue(String key) {
        if (key.startsWith("ENV_")) {
            // Menghapus prefix "ENV_" untuk mencocokkan nama variabel di .env
            return Utils.env(key.replace("ENV_", ""));
        }
        return key; // Mengembalikan nilai asli jika tidak berawalan "ENV_"
    }

    // Fungsi untuk mendapatkan angka bulan dari nama bulan
    private int getMonthNumber(String bulan) {
        switch (bulan.toLowerCase()) {
            case "januari": return 1;
            case "februari": return 2;
            case "maret": return 3;
            case "april": return 4;
            case "mei": return 5;
            case "juni": return 6;
            case "juli": return 7;
            case "agustus": return 8;
            case "september": return 9;
            case "oktober": return 10;
            case "november": return 11;
            case "desember": return 12;
            default: throw new IllegalArgumentException("Bulan tidak valid: " + bulan);
        }
    }

    // Fungsi untuk memeriksa apakah bulan target sudah terlihat berdasarkan content-desc
    private boolean isTargetMonthVisible(String targetDateDescription) {
        try {
            driver().findElement(By.xpath("//android.widget.Button[contains(@content-desc, '" + targetDateDescription + "')]"));
            return true; // Jika elemen ditemukan, bulan target sudah terlihat
        } catch (Exception e) {
            return false; // Jika elemen tidak ditemukan, lanjutkan navigasi
        }
    }

    // Fungsi untuk menghitung jumlah klik yang diperlukan untuk mencapai target bulan
    private int calculateMonthClicks(int currentMonth, int targetMonth) {
        if (targetMonth < currentMonth) {
            return currentMonth - targetMonth;
        } else if (targetMonth > currentMonth) {
            return targetMonth - currentMonth;
        } else {
            return 0; // Jika bulan saat ini sudah sama dengan target, tidak perlu klik
        }
    }

    public void verifyDisplayedMonth(String targetMonthName) {
        // Setelah melakukan klik, cek apakah bulan target sudah terlihat
        if (isTargetMonthVisible(targetMonthName)) {
            System.out.println("Target bulan ditemukan.");
        } else {
            System.out.println("Target bulan tidak ditemukan.");
        }
    }

    public void navigateToTargetMonth(String targetMonthName, String targetDateDescription) {
        // Mendapatkan bulan saat ini dalam bentuk integer
        int currentMonth = getCurrentMonth();
        int targetMonth = getMonthNumber(targetMonthName);

        // Menghitung jarak klik antara bulan saat ini dan target bulan
        int clicksRequired = calculateMonthClicks(currentMonth, targetMonth);

        // Langsung klik tapPreviousMonth atau tapNextMonth sejumlah jarak yang diperlukan
        if (targetMonth < currentMonth) {
            // Jika target bulan lebih awal dari bulan saat ini, klik PreviousMonth sejumlah clicksRequired
            for (int i = 0; i < clicksRequired; i++) {
                tapPreviousMonth();
            }
        } else if (targetMonth > currentMonth) {
            // Jika target bulan lebih lambat dari bulan saat ini, klik NextMonth sejumlah clicksRequired
            for (int i = 0; i < clicksRequired; i++) {
                tapNextMonth();
            }
        }

        // Setelah melakukan klik, cek apakah bulan target sudah terlihat
        if (isTargetMonthVisible(targetDateDescription)) {
            System.out.println("Target bulan ditemukan.");
        } else {
            System.out.println("Target bulan tidak ditemukan.");
        }
    }

    // Fungsi untuk klik pada tanggal target jika terlihat
    private void clickTargetDate(String targetDateDescription) {
        try {
            // Menggunakan targetDateDescription yang sudah diformat
            driver().findElement(By.xpath("//android.widget.Button[contains(@content-desc, '" + targetDateDescription + "')]")).click();
        } catch (Exception e) {
            System.out.println("Tanggal yang diharapkan tidak ditemukan: " + e.getMessage());
        }
    }

    public void inputTanggalLahir(String tanggallahir) {
        tapTanggalLahir();

        // Pisahkan `tanggal` untuk mendapatkan hari, tanggal, bulan, dan tahun
        // Format contoh input: "10, Rabu, 10 Januari 1900"
        String[] dateParts = tanggallahir.split(", ");
        String dayOfMonth = dateParts[0];        // "10"
        String dayOfWeek = dateParts[1];         // "Rabu"
        String monthAndYear = dateParts[2];      // "10 Januari 1900"

        // Ekstraksi tahun dari bagian terakhir `monthAndYear`
        String[] monthYearParts = monthAndYear.split(" ");
        String year = monthYearParts[2];         // "1900"

        tapPilihTahun();
        scrollAndClickToElementByDescription(year);

        navigateToTargetMonth(monthYearParts[1],tanggallahir);

        clickTargetDate(tanggallahir);

        tapOkeTanggalLahir();
        driver().hideKeyboard();
    }

    public void validateDateOfBirth(String tanggallahir) {
        // Pisahkan tanggal, hari, bulan, dan tahun dari input tanggallahir
        String[] dateParts = tanggallahir.split(", ");
        String dayOfMonth = dateParts[0];        // Contoh: "10"
        String monthAndYear = dateParts[2];      // Contoh: "Januari 1900"

        // Ekstraksi tahun dari bagian terakhir `monthAndYear`
        String[] monthYearParts = monthAndYear.split(" ");
        String birthYear = monthYearParts[2];    // Contoh: "1900"
        int birthYearInt = Integer.parseInt(birthYear);

        String birthDay = dayOfMonth;            // Tanggal kelahiran
        int birthDayInt = Integer.parseInt(birthDay);
        String birthMonth = monthYearParts[1];   // Bulan kelahiran

        // Tanggal saat ini
        LocalDate currentDate = LocalDate.now();
        int currentYear = currentDate.getYear() - 17;
        int currentMonth = currentDate.getMonthValue();
        int currentDay = currentDate.getDayOfMonth();

        // Debug log untuk memastikan nilai
        System.out.println("Birth Year: " + birthYearInt);
        System.out.println("Current Year: " + currentYear);
        System.out.println("Birth Month: " + birthMonth);


        // Cek apakah tahun lahir lebih besar dari tahun saat ini
        if (birthYearInt > currentYear) {
            System.out.println("Birth year is in the future. Verifying...");
            verifyYearNotFound(birthYear); // Lakukan verifikasi
        } else if (birthYearInt == currentYear) {
            System.out.println("Birth year matches current year. Checking further...");
            int birthMonthNumber = getMonthNumber(birthMonth);
            System.out.println("Birth Month: " + birthMonthNumber);
            System.out.println("Current Month: " + currentMonth);
            // Jika bulan kelahiran lebih besar dari bulan saat ini
            if (birthMonthNumber > currentMonth) {
                System.out.println("Birth month is in the future.");
                verifyElementIsNotClickable("BUTTON_NEXT");
            } else if (birthMonthNumber == currentMonth) {
                // Jika bulan sama, cek tanggal
                if (birthDayInt > currentDay) {
                    System.out.println("Birth day is in the future.");
                    System.out.println(tanggallahir);
                    verifyElementIsNotClickable(tanggallahir);
                }
            }
        } else {
            // Jika tahun lebih kecil dari tahun saat ini
            System.out.println("Valid birthdate. Proceed with date selection.");
        }
    }

    public void userInputsBirthdate(String birthdate) {
        validateDateOfBirth(birthdate);
    }

    public void verifyNextButtonDisabled() {
        verifyElementIsNotClickable("BUTTON_NEXT");
    }

    public void verifyDaySelectionDisabled(String birthdate) {
        verifyElementIsNotClickable(birthdate);
    }

    public boolean verifyYearNotFound(String tanggallahir) {
        // Split input untuk mendapatkan tahun
        String[] dateParts = tanggallahir.split(", ");
        String monthAndYear = dateParts[2]; // Contoh: "10 Januari 1900"
        String[] monthYearParts = monthAndYear.split(" ");
        String year = monthYearParts[2]; // Ekstrak tahun dari input

        // Panggil metode untuk memilih tahun
        tapPilihTahun();

        // Coba scroll dan klik elemen berdasarkan deskripsi tahun
        boolean isYearFound = scrollAndClickToElementByDescription(year);

        if (isYearFound) {
            // Tahun ditemukan, tidak sesuai ekspektasi
            System.out.println("Error: Year '" + year + "' should not be found, but it was found.");
            return false; // Tahun ditemukan
        } else {
            // Tahun tidak ditemukan (meskipun tidak ada exception)
            System.out.println("Expected: Year '" + year + "' not found due to date picker restriction.");
            return true; // Tahun tidak ditemukan
        }
    }

    public void verifyYearNotFoundInDatePicker(String year) {
        boolean isYearNotFound = verifyYearNotFound(year);

        if (isYearNotFound) {
            System.out.println("Test Passed: The year '" + year + "' is correctly not found in the date picker.");
        } else {
            System.out.println("Test Failed: The year '" + year + "' should not have been found in the date picker.");
        }
    }

    public void inputEmail(String email) {
        typeOn("FIELD_EMAIL", email);  // Use the typeOn method to input the email
        hideKeyboard();
    }

    public void inputPhone(String phone) {
        typeOn("FIELD_PHONE", phone);  // Use the typeOn method to input the phone
        hideKeyboard();
    }

    public void tapPilihTahun() {
        tap("BUTTON_PILIH_TAHUN");
    }

    public void tapOkeTanggalLahir() {
        tap("BUTTON_OKE_TANGGAL_LAHIR");
    }

    public void tapBatalTanggalLahir() {
        tap("BUTTON_BATAL_TANGGAL_LAHIR");
    }

    public void tapPreviousMonth() {
        tap("BUTTON_PREVIOUS");
    }

    public void tapNextMonth() {
        tap("BUTTON_NEXT");
    }

    public void tapLanjutkan() {
        tap("BUTTON_LANJUTKAN_KONFIRMASI");
    }

    public void tapTanggalLahir() {
        tap("FIELD_TANGGAL_LAHIR");
    }
}
