Feature: Verifikasi Akses Page

  Background:
    Given User is on splash page
    When User click aktifkan perangkat
    And User input inapas id as "ENV_INAPAS_ID_1"
    And User click lanjut

  @Android
  Scenario:[Android] Validation Back Button on Verifikasi Akses
    When User click kembali button
    Then User should navigate to verifikasi wajah screen

  @Android
  Scenario:[Android] Validate access to PIN verification
    When User click Verifikasi Akses via PIN
    Then User should navigate to foto wajah screen

  @Android
  Scenario:[Android] Validate access to Email verification
    When User click Verifikasi Akses via Email
    Then User should navigate to foto wajah screen
