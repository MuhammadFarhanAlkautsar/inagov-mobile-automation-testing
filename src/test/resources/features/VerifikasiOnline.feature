Feature: Verifikasi Online Page

  Background:
    Given User is on splash page
    When User click mulai verifikasi
    And User click verifikasi online

  @Android
  Scenario:[Android] Validation Back Button on Verifikasi Online
    When User click kembali button
    Then User should navigate to verifikasi data diri screen

  @Android
  Scenario:[Android] Validation form input button
    When User click form input
    Then User should navigate to form data diri screen