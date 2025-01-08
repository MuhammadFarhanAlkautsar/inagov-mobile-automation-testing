Feature: Verifikasi Akses via Email

  Background:
    Given User is on splash page
    When User click aktifkan perangkat
    And User input inapas id as "ENV_INAPAS_ID_1"
    And User click lanjut
    And User click Foto Wajah
    And User waiting process liveness valid person
    And User click Verifikasi Akses via Email

  @Android
  Scenario Outline:[Android] Input incorrect OTP from email
    When User input otp as "<otp>"
    And User click lanjutkan on Verifikasi alamat email
    Then User user should see popup validate error message OTP tidak cocok
    Examples:
      | otp     |
      | 123356  |
      | 123456  |

  @Android
  Scenario:[Android]  Input expired OTP from email
    When User input expired otp
    And User click lanjutkan on Verifikasi alamat email
    Then User user should see popup validate error message OTP tidak cocok

  @Android
  Scenario:[Android]  Validate resend OTP button functionality
    When User waits until OTP timer reaches 00:00
    And User click kirim ulang otp
    Then User should see notify a new OTP
    And User should see OTP wait time is reset to the default of 2 minutes

  @Android
  Scenario:[Android]  Input valid OTP from email
    When User input otp from notif email
    And User click lanjutkan on Verifikasi alamat email
    Then User should see biometric request screen
    And User places an incorrect fingerprint
    When User input pin device as "111111"
    Then User user should see screen proses verifikasi berhasil
