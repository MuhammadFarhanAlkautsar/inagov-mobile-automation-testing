Feature: Form Data Diri Page

  Background:
    Given User is on splash page
    When User click mulai verifikasi
    And User does scrolls through the terms and conditions to end
    And  User click checkbox syarat ketentuan
    And User click checkbox kebijakan privasi
    And User click lanjut

  @Android
  Scenario:[Android] Validation Back Button on Form Data Diri
    When User click kembali button
    Then User see popup keluar

  @Android
  Scenario:[Android] Validation Cancel Button on Popup Keluar Halaman
    When User click kembali button
    Then User see popup keluar
    When User click batal button
    Then User should navigate to form data diri screen

  @Android
  Scenario:[Android] Validation Exit Button on Popup Keluar Halaman
    When User click kembali button
    Then User see popup keluar
    When User click keluar button
    Then User should navigate to splash screen

  @Android
  Scenario Outline:[Android] Validation invalid inputs NIK with less than 16 digits
    When User input nik as "<nik>"
    And User input name as "<nama>"
    And User input tanggal lahir as date "<tanggal>"
    And User input email as "<email>"
    And User input phone as "<phone>"
    Then User see validation invalid nik
    And User see lanjut button is disabled
    Examples:
      | nik            |  nama            |  tanggal                     |  email                |  phone         |
      | 123456789      |  Alberto Carlos  |  8, Kamis, 8 November 2007   |  alberto@xyz.com      |  0812345678910 |
      | 12345678901    |  John Doe        |  25, Jumat, 25 Desember 1998 |  johndoe@gmail.com    |  0812564327189 |
      | 1234567890123  |  Roberto         |  10, Rabu, 10 Januari 1900   |  RobertoC@icloud.com  |  086198752415  |

  @Android
  Scenario Outline:[Android] Validation invalid inputs NIK with More than 16 digits
    When User input nik as "<nik>"
    And User input name as "<nama>"
    And User input tanggal lahir as date "<tanggal>"
    And User input email as "<email>"
    And User input phone as "<phone>"
    Then User see validation invalid nik
    And User see lanjut button is disabled
    Examples:
      | nik                     |  nama            |  tanggal                     |  email                |  phone         |
      | 123456789012345678      |  Alberto Carlos  |  8, Kamis, 8 November 2007   |  alberto@xyz.com      |  0812345678910 |
      | 12345678901234567890    |  John Doe        |  25, Jumat, 25 Desember 1998 |  johndoe@gmail.com    |  0812564327189 |
      | 1234567890123456789012  |  Roberto         |  10, Rabu, 10 Januari 1900   |  RobertoC@icloud.com  |  086198752415  |

  @Android
  Scenario Outline:[Android] Validation invalid inputs NIK with combination alphanumerik
    When User input nik as "<nik>"
    And User input name as "<nama>"
    And User input tanggal lahir as date "<tanggal>"
    And User input email as "<email>"
    And User input phone as "<phone>"
    And User click lanjut
    Then User see pop up konfirmasi data diri
    And User see NIK as "<nik>" in Konfirmasi Data
    And User see Nama as "<nama>" in Konfirmasi Data
    And User see Tanggal Lahir as "<tanggal>" in Konfirmasi Data
    And User see Email as "<email>" in Konfirmasi Data
    And User see Phone as "<phone>" in Konfirmasi Data
    When User click lanjutkan on popup konfirmasi data
    Then User see pop up invalid data process failed
    Examples:
      | nik               |  nama            |  tanggal                     |  email                |  phone         |
      | 1234567890.,3456  |  Alberto Carlos  |  8, Kamis, 8 November 2007   |  alberto@xyz.com      |  0812345678910 |
      | 12345678901234,.  |  John Doe        |  25, Jumat, 25 Desember 1998 |  johndoe@gmail.com    |  0812564327189 |
      | .,34567890123456  |  Roberto         |  10, Rabu, 10 Januari 1900   |  RobertoC@icloud.com  |  086198752415  |

  @Android
  Scenario Outline:[Android] Validation invalid inputs NIK already Registered
    When User input nik as "<nik>"
    And User input name as "<nama>"
    And User input tanggal lahir as date "<tanggal>"
    And User input email as "<email>"
    And User input phone as "<phone>"
    And User click lanjut
    Then User see pop up konfirmasi data diri
    And User see NIK as "<nik>" in Konfirmasi Data
    And User see Nama as "<nama>" in Konfirmasi Data
    And User see Tanggal Lahir as "<tanggal>" in Konfirmasi Data
    And User see Email as "<email>" in Konfirmasi Data
    And User see Phone as "<phone>" in Konfirmasi Data
    When User click lanjutkan on popup konfirmasi data
    Then User see pop up invalid data already registered
    Examples:
      | nik        |  nama        |  tanggal             |  email          |  phone       |
      | ENV_NIK_1  |  ENV_NAMA_1  |  ENV_TANGGAL_LAHIR_1 |  ENV_EMAIL_1    |  ENV_PHONE_1 |
      | ENV_NIK_2  |  ENV_NAMA_2  |  ENV_TANGGAL_LAHIR_2 |  ENV_EMAIL_2    |  ENV_PHONE_2 |

  @Android
  Scenario Outline:[Android] Validation fails to verify data due to abbreviated name input
    When User input nik as "<nik>"
    And User input name as "<nama>"
    And User input tanggal lahir as date "<tanggal>"
    And User input email as "<email>"
    And User input phone as "<phone>"
    And User click lanjut
    Then User see pop up konfirmasi data diri
    And User see NIK as "<nik>" in Konfirmasi Data
    And User see Nama as "<nama>" in Konfirmasi Data
    And User see Tanggal Lahir as "<tanggal>" in Konfirmasi Data
    And User see Email as "<email>" in Konfirmasi Data
    And User see Phone as "<phone>" in Konfirmasi Data
    When User click lanjutkan on popup konfirmasi data
    Then User see pop up invalid data dukcapil not match
    Examples:
      | nik        |  nama                  |  tanggal             |  email          |  phone       |
      | ENV_NIK_1  |  ENV_NAMA_DISINGKAT_1  |  ENV_TANGGAL_LAHIR_1 |  ENV_EMAIL_1    |  ENV_PHONE_1 |
      | ENV_NIK_2  |  ENV_NAMA_DISINGKAT_2  |  ENV_TANGGAL_LAHIR_2 |  ENV_EMAIL_2    |  ENV_PHONE_2 |
      | ENV_NIK_3  |  ENV_NAMA_DISINGKAT_3  |  ENV_TANGGAL_LAHIR_3 |  ENV_EMAIL_3    |  ENV_PHONE_3 |

  @Android
  Scenario:[Android] Validation invalid inputs Name with with XSS script
    When User input nik as "ENV_NIK_2"
    And User input name as "<script>alert('XSS - Mohammad Imam Fauzul')</script>"
    And User input tanggal lahir as date "ENV_TANGGAL_LAHIR_2"
    And User input email as "ENV_EMAIL_2"
    And User input phone as "ENV_PHONE_2"
    Then User see validation invalid nama
    And User see lanjut button is disabled

  @Android
  Scenario:[Android] Validation invalid inputs Name with with XSS script
    When User input nik as "ENV_NIK_2"
    And User input name as "<script>alert('XSS - Mohammad Imam Fauzul')</script>"
    And User input tanggal lahir as date "ENV_TANGGAL_LAHIR_2"
    And User input email as "ENV_EMAIL_2"
    And User input phone as "ENV_PHONE_2"
    Then User see validation invalid nama
    And User see lanjut button is disabled

  @Android
  Scenario:[Android]  Validation Birth Year Dropdown Button Functionality
    When User click field tanggal lahir
    And User click dropdown tahun lahir
    Then User see all option years

  @Android
  Scenario:[Android] Validation Button Next & Previous Month
    When User click field tanggal lahir
    And User click previous month
    Then Verify that the displayed month is updated to the previous month
    When User click next month
    Then Verify that the displayed month is updated to the next month

  @Android
  Scenario Outline:[Android] Validation Invalid Input email address in incorrect format
    When User input nik as "ENV_NIK_2"
    And User input name as "ENV_NAMA_2"
    And User input tanggal lahir as date "ENV_TANGGAL_LAHIR_2"
    And User input email as "<email>"
    And User input phone as "ENV_PHONE_2"
    Then User see validation invalid email
    And User see lanjut button is disabled
    Examples:
      | email                 |
      | imamfauzul69@gmailcom |
      | imamfauzul69@.com     |
      | imamfauzul69gmail.com |

  @Android
  Scenario Outline:[Android] Validation Invalid Input phone number with less than 8 digits
    When User input nik as "ENV_NIK_2"
    And User input name as "ENV_NAMA_2"
    And User input tanggal lahir as date "ENV_TANGGAL_LAHIR_2"
    And User input email as "ENV_EMAIL_2"
    And User input phone as "<phone>"
    Then User see validation invalid phone
    And User see lanjut button is disabled
    Examples:
      | phone    |
      | 0895073  |
      | 62895073 |


  @Android
  Scenario Outline:[Android] Validation Invalid Input phone number with more than 14 digits
    When User input nik as "ENV_NIK_2"
    And User input name as "ENV_NAMA_2"
    And User input tanggal lahir as date "ENV_TANGGAL_LAHIR_2"
    And User input email as "ENV_EMAIL_2"
    And User input phone as "<phone>"
    Then User see validation invalid phone more than 14 digit
    And User see lanjut button is disabled
    Examples:
      | phone            |
      | 089536543616444  |
      | 6289536543616444 |

  @Android
  Scenario Outline:[Android] Validation Invalid Input phone number with with alphanumeric combination
    When User input nik as "ENV_NIK_2"
    And User input name as "ENV_NAMA_2"
    And User input tanggal lahir as date "ENV_TANGGAL_LAHIR_2"
    And User input email as "ENV_EMAIL_2"
    And User input phone as "<phone>"
    Then User see validation invalid phone
    And User see lanjut button is disabled
    Examples:
      | phone        |
      | 0895O73372OI |
      | 08GSO7EE72OI |

  @Android
  Scenario Outline:[Android] Validation Invalid Input phone number with with special characters
    When User input nik as "ENV_NIK_2"
    And User input name as "ENV_NAMA_2"
    And User input tanggal lahir as date "ENV_TANGGAL_LAHIR_2"
    And User input email as "ENV_EMAIL_2"
    And User input phone as "<phone>"
    Then User see validation invalid phone
    And User see lanjut button is disabled
    Examples:
      | phone          |
      | 08950733*20#   |
      | 0812 7577 1360 |

  @Android
  Scenario Outline:[Android] Validation Invalid Input date of birth for a user under 17 years old
    When User click field tanggal lahir
    And User input birthdate as "<tanggallahir>"
    Then The date "<tanggallahir>" is not found in the date picker
    Examples:
      | tanggallahir                 |
      | 24, Senin, 24 Desember 2007  |
      | 27, Selasa, 27 November 2007 |

  @Android
  Scenario Outline:[Android] Input personal data that does not match Dukcapil
    When User input nik as "<nik>"
    And User input name as "<nama>"
    And User input tanggal lahir as date "<tanggal>"
    And User input email as "<email>"
    And User input phone as "<phone>"
    And User click lanjut
    Then User see pop up konfirmasi data diri
    And User see NIK as "<nik>" in Konfirmasi Data
    And User see Nama as "<nama>" in Konfirmasi Data
    And User see Tanggal Lahir as "<tanggal>" in Konfirmasi Data
    And User see Email as "<email>" in Konfirmasi Data
    And User see Phone as "<phone>" in Konfirmasi Data
    When User click lanjutkan on popup konfirmasi data
    Then User see pop up invalid data dukcapil not match
    Examples:
      | nik        |  nama        |  tanggal             |  email          |  phone       |
      | ENV_NIK_1  |  ENV_NAMA_2  |  ENV_TANGGAL_LAHIR_3 |  ENV_EMAIL_1    |  ENV_PHONE_1 |
      | ENV_NIK_2  |  ENV_NAMA_1  |  ENV_TANGGAL_LAHIR_3 |  ENV_EMAIL_2    |  ENV_PHONE_2 |
      | ENV_NIK_3  |  ENV_NAMA_2  |  ENV_TANGGAL_LAHIR_2 |  ENV_EMAIL_3    |  ENV_PHONE_3 |

  @Android
  Scenario Outline:[Android] Leave one of the personal data input fields empty
    When User input nik as "<nik>"
    And User input name as "<nama>"
    And User input tanggal lahir as date "<tanggal>"
    And User input email as "<email>"
    And User input phone as "<phone>"
    Then User see lanjut button is disabled
    Examples:
      | nik                     |  nama            |  tanggal                     |  email                |  phone         |
      | 123456789012345678      |                  |  8, Kamis, 8 November 2007   |  alberto@xyz.com      |  0812345678910 |
      | 12345678901234567890    |  John Doe        |                              |  johndoe@gmail.com    |  0812564327189 |
      | 1234567890123456789012  |  Roberto         |  10, Rabu, 10 Januari 1900   |                       |  086198752415  |

  @Android
  Scenario:[Android] User click the cancel button on data confirmation
    When User input nik as "ENV_NIK_1"
    And User input name as "ENV_NAMA_1"
    And User input tanggal lahir as date "ENV_TANGGAL_LAHIR_1"
    And User input email as "ENV_EMAIL_1"
    And User input phone as "ENV_PHONE_1"
    And User click lanjut
    Then User see pop up konfirmasi data diri
    And User see NIK as "ENV_NIK_1" in Konfirmasi Data
    And User see Nama as "ENV_NAMA_1" in Konfirmasi Data
    And User see Tanggal Lahir as "ENV_TANGGAL_LAHIR_1" in Konfirmasi Data
    And User see Email as "ENV_EMAIL_1" in Konfirmasi Data
    And User see Phone as "ENV_PHONE_1" in Konfirmasi Data
    When User click kembali button
    Then User should see popup confirmation data close
    And User should navigate to form data diri screen

  @Android
  Scenario Outline:[Android] User click the continue button on data confirmation
    When User input nik as "<nik>"
    And User input name as "<nama>"
    And User input tanggal lahir as date "<tanggal>"
    And User input email as "<email>"
    And User input phone as "<phone>"
    And User click lanjut
    Then User see pop up konfirmasi data diri
    And User see NIK as "<nik>" in Konfirmasi Data
    And User see Nama as "<nama>" in Konfirmasi Data
    And User see Tanggal Lahir as "<tanggal>" in Konfirmasi Data
    And User see Email as "<email>" in Konfirmasi Data
    And User see Phone as "<phone>" in Konfirmasi Data
    When User click lanjutkan on popup konfirmasi data
    Then User should navigate to verifikasi wajah screen
    Examples:
      | nik        |  nama        |  tanggal             |  email          |  phone       |
      | ENV_NIK_1  |  ENV_NAMA_1  |  ENV_TANGGAL_LAHIR_1 |  ENV_EMAIL_1    |  ENV_PHONE_1 |
      | ENV_NIK_2  |  ENV_NAMA_2  |  ENV_TANGGAL_LAHIR_2 |  ENV_EMAIL_2    |  ENV_PHONE_2 |
      | ENV_NIK_3  |  ENV_NAMA_3  |  ENV_TANGGAL_LAHIR_3 |  ENV_EMAIL_3    |  ENV_PHONE_3 |