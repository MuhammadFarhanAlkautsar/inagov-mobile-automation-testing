Feature: Mulai Verifikasi - Verifikasi Wajah Page

  Background:
    Given User is on splash page
    When User click mulai verifikasi
    And User does scrolls through the terms and conditions to end
    And  User click checkbox syarat ketentuan
    And User click checkbox kebijakan privasi
    And User click lanjut
    And User input nik as "ENV_NIK_1"
    And User input name as "ENV_NAMA_1"
    And User input tanggal lahir as date "ENV_TANGGAL_LAHIR_1"
    And User input email as "ENV_EMAIL_1"
    And User input phone as "ENV_PHONE_1"
    And User click lanjut
    And User click lanjutkan on popup konfirmasi data

  @Android
  Scenario:[Android] Validation Back Button on Verifikasi Wajah
    When User click kembali button
    Then User see popup keluar

  @Android
  Scenario:[Android] Validation Cancel Button on Popup Keluar Halaman
    When User click kembali button
    Then User see popup keluar
    When User click batal button
    Then User should navigate to verifikasi wajah screen

  @Android
  Scenario:[Android] Validation Exit Button on Popup Keluar Halaman
    When User click kembali button
    Then User see popup keluar
    When User click keluar button
    Then User should navigate to form data diri screen

  @Android
  Scenario:[Android] Validation foto wajah button
    When User click Foto Wajah
    Then User should navigate to foto wajah screen

  @Android
  Scenario:[Android] Validation batalkan foto wajah
    When User click Foto Wajah
    Then User should navigate to foto wajah screen
    When User click Batalkan Foto Wajah
    Then User should navigate to verifikasi wajah screen