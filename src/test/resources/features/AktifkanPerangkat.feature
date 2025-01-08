Feature: Aktifkan Perangkat Page

  Background:
    Given User is on splash page
    When User click aktifkan perangkat

  @Android
  Scenario:[Android] Validation Back Button on Aktifkan Perangkat
    When User click kembali button
    Then User see popup keluar

  @Android
  Scenario:[Android] Validation Cancel Button on Popup Keluar Halaman
    When User click kembali button
    Then User see popup keluar
    When User click batal button
    Then User should navigate to aktifkan perangkat screen

  @Android
  Scenario:[Android] Validation Exit Button on Popup Keluar Halaman
    When User click kembali button
    Then User see popup keluar
    When User click keluar button
    Then User should navigate to splash screen

  @Android
  Scenario:[Android] Leave INApas ID field empty
    When User click lanjut
    Then User see error validation inapas id

  @Android
  Scenario Outline:[Android] Input invalid/unregistered INApas ID
    When User input inapas id as "<inapasid>"
    And User click lanjut
    Then User see pop up inapas id not found
    Examples:
      | inapasid   |
      | MF986AUY12 |
      | MID979GH15 |
      | BISMILAAH1 |

  @Android
  Scenario Outline:[Android] Invalid INApas ID is less than 8 characters
    When User input inapas id as "<inapasid>"
    And User click lanjut
    Then User see pop up invalid inapas id
    Examples:
      | inapasid  |
      | MF986AUY  |
      | MIDOD     |
      | INAPASID  |

  @Android
  Scenario Outline:[Android] Invalid INApas ID is more than 10 characters
    When User input inapas id as "<inapasid>"
    Then User should see the INApas ID is truncated to 10 characters
    Examples:
      | inapasid     |
      | NJAH10291087 |
      | MKJ765906541 |

  @Android
  Scenario Outline:[Android] Valid/registered INApas ID
    When User input inapas id as "<inapasid>"
    And User click lanjut
    Then User should navigate to verifikasi wajah screen
    Examples:
      | inapasid        |
      | ENV_INAPAS_ID_1 |
      | ENV_INAPAS_ID_2 |
