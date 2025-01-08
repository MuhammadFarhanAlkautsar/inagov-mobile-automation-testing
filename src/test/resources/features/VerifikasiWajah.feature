Feature: Verifikasi Wajah Page

  Background:
    Given User is on splash page
    When User click aktifkan perangkat
    And User input inapas id as "ENV_INAPAS_ID_1"
    And User click lanjut

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
    Then User should navigate to aktifkan perangkat screen

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