Feature: Splash Page

  @Android
  Scenario:[Android] Validation Help Center Button
    Given User is on splash page
    When User click pusat bantuan
    Then User should navigate to help center screen

  @Android
  Scenario:[Android] Validation Mulai Verifikasi Button
    Given User is on splash page
    When User click mulai verifikasi
    Then User should navigate to syarat ketentuan screen

  @Android
  Scenario:[Android] Validation Aktifkan Perangkat Button
    Given User is on splash page
    When User click aktifkan perangkat
    Then User should navigate to aktifkan perangkat screen