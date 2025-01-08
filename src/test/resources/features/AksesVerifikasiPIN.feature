Feature: Verifikasi Akses via PIN

  Background:
    Given User is on splash page
    When User click aktifkan perangkat
    And User input inapas id as "ENV_INAPAS_ID_1"
    And User click lanjut
    And User click Foto Wajah
    And User waiting process liveness valid person
    And User click Verifikasi Akses via PIN

  @Android
  Scenario Outline:[Android] Input PIN with less than 6 digits
    When User input pin as "<pin>"
    Then User stay on verifikasi pin screen
    Examples:
      | pin    |
      | 1233   |
      | 12345  |

  @Android
  Scenario Outline:[Android]  Input unregistered or incorrect PIN
    When User input pin as "<pin>"
    Then User should see popup validate error message data not found
    Examples:
      | pin     |
      | 123345  |
      | 123457  |

  @Android
  Scenario:[Android]  Validate "Show PIN" button and "Hidden PIN" button functionality
    When User input pin as "98765"
    And User click tampilkan pin
    Then User see displayed pin as "98765" in Field PIN
    When User click sembunyikan pin
    Then User see not displayed pin as "•••••" in Field PIN


  @Android
  Scenario:[Android] Input registered or correct PIN
    When User input pin as "ENV_PIN_1"
    Then User should see biometric request screen
