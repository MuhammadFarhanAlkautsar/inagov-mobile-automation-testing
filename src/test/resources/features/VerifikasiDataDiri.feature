Feature: Verifikasi Data Diri Page

  Background:
    Given User is on splash page
    When User click mulai verifikasi

  @Android
  Scenario:[Android] Validation Back Button on Verifikasi Data Diri
    When User click kembali button
    Then User see popup keluar

  @Android
  Scenario:[Android] Validation Cancel Button on Popup Keluar Halaman
    When User click kembali button
    Then User see popup keluar
    When User click batal button
    Then User should navigate to verifikasi data diri screen

  @Android
  Scenario:[Android] Validation Exit Button on Popup Keluar Halaman
    When User click kembali button
    Then User see popup keluar
    When User click keluar button
    Then User should navigate to splash screen

  @Android
  Scenario:[Android] Validation online verification button
    When User click verifikasi online
    Then User should navigate to verifikasi online screen