Feature: Mulai Verifikasi - Verifikasi Alamat Email

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

  @Android
  Scenario Outline:[Android] Invalid or incorrect OTP from email
    When User input otp as "<otp>"
    And User click lanjutkan on Verifikasi alamat email
    Then User user should see popup validate error message OTP tidak cocok
    Examples:
      | otp     |
      | 223356  |
      | 323436  |

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
    Then User should navigate to aktifkan pin screen
