Feature: Mulai Verifikasi - Aktifkan PIN

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
    And User click Foto Wajah
    And User waiting process liveness valid person for Mulai Verifikasi
    And User input otp from notif email
    And User click lanjutkan on Verifikasi alamat email

  @Android
  Scenario Outline:[Android] Creating PIN with less than 6 digits
    Then User should navigate to aktifkan pin screen
    When User input pin as "<pin>"
    Then User stay on buat pin screen
    Examples:
      | pin    |
      | 1233   |
      | 12345  |

  @Android
  Scenario Outline:[Android] Create PIN with special character combination
    Then User should navigate to aktifkan pin screen
    When User input pin as "<pin>"
    Then Only numeric characters should be accepted and displayed as "<viewpin>" on field PIN
    And User stay on buat pin screen
    Examples:
      | pin     | viewpin |
      | 12*4#5  | 1245    |
      | 1.34,7  | 1347    |

  @Android
  Scenario:[Android]  Validate "Show PIN" button and "Hidden PIN" button functionality in Buat PIN
    When User input pin as "98765"
    And User click tampilkan pin
    Then User see displayed pin as "98765" in Field PIN
    When User click sembunyikan pin
    Then User see not displayed pin as "•••••" in Field PIN


  @Android
  Scenario:[Android] Creating PIN with than 6 digits
    When User input pin as "ENV_PIN_1"
    Then User should navigate to konfirmasi pin screen

  @Android
  Scenario Outline:[Android] Creating confirmation PIN with less than 6 digits
    When User input pin as "ENV_PIN_1"
    Then User should navigate to konfirmasi pin screen
    When User input pin as "<pin>"
    Then User stay on konfirmasi pin screen
    Examples:
      | pin   |
      | 123   |
      | 1345  |

  @Android
  Scenario:[Android] Validate "Show PIN" button and "Hidden PIN" button functionality in Konfirmasi PIN
    When User input pin as "ENV_PIN_1"
    Then User should navigate to konfirmasi pin screen
    When User input pin as "98765"
    And User click tampilkan pin
    Then User see displayed pin as "98765" in Field PIN
    When User click sembunyikan pin
    Then User see not displayed pin as "•••••" in Field PIN

  @Android
  Scenario Outline:[Android] PIN confirmation does not match
    When User input pin as "ENV_PIN_1"
    Then User should navigate to konfirmasi pin screen
    When User input konfirmasi pin as "<pin>"
    Then User should see popup not match pin
    Examples:
      | pin     |
      | 098762  |
      | 654732  |

  @Android
  Scenario:[Android] Successful PIN confirmation
    When User input pin as "ENV_PIN_1"
    Then User should navigate to konfirmasi pin screen
    When User input konfirmasi pin as "ENV_PIN_1"
    Then User should see biometric request screen
    When User places an correct fingerprint
    Then User user should see screen proses verifikasi berhasil
    When User click masuk ke beranda
    Then User should navigate to Beranda screen