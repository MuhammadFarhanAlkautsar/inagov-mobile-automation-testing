Feature: Syarat Ketentuan Page

  Background:
    Given User is on splash page
    When User click mulai verifikasi

  @Android
  Scenario:[Android] Does not scroll through Terms & Conditions
    When User does not scrolls through the terms and conditions
    Then The checkbox privacy policy remains hidden
    And The checkbox Terms and Condition remains hidden
    And User see lanjut button is disabled

  @Android
  Scenario:[Android] Scrolls through the terms and conditions but does not reach the end
    When User scrolls through the terms and conditions but does not reach the end
    Then The checkbox privacy policy remains hidden
    And The checkbox Terms and Condition remains hidden
    And User see lanjut button is disabled

  @Android
  Scenario:[Android] Reads T&C but does not agree to both T&C and privacy & customer agreement
    When User does scrolls through the terms and conditions to end
    Then The checkbox privacy policy should be displayed
    And The checkbox Terms and Condition should be displayed
    And The checkbox privacy policy should be unchecked
    And The checkbox Terms and Condition should be unchecked
    And User see lanjut button is disabled

  @Android
  Scenario:[Android] Reads T&C but agrees only to Terms & Conditions
    When User does scrolls through the terms and conditions to end
    Then The checkbox privacy policy should be displayed
    And The checkbox Terms and Condition should be displayed
    When User click checkbox syarat ketentuan
    Then The checkbox Terms and Condition should be checked
    And The checkbox privacy policy should be unchecked
    And User see lanjut button is disabled

  @Android
  Scenario:[Android] Reads T&C but agrees only to privacy & customer agreement
    When User does scrolls through the terms and conditions to end
    Then The checkbox privacy policy should be displayed
    And The checkbox Terms and Condition should be displayed
    When User click checkbox kebijakan privasi
    Then The checkbox Terms and Condition should be unchecked
    And The checkbox privacy policy should be checked
    And User see lanjut button is disabled

  @Android
  Scenario:[Android] Scrolls up TNC after agree to both T&C and privacy & customer agreement
    When User does scrolls through the terms and conditions to end
    Then The checkbox privacy policy should be displayed
    And The checkbox Terms and Condition should be displayed
    When User click checkbox kebijakan privasi
    And  User click checkbox syarat ketentuan
    Then The checkbox Terms and Condition should be checked
    And The checkbox privacy policy should be checked
    And User see lanjut button is enabled
    When User scrolls through the terms and conditions to up again
    Then The checkbox privacy policy remains hidden
    And The checkbox Terms and Condition remains hidden
    And User see lanjut button is disabled

  @Android
  Scenario:[Android] Reads T&C And agrees both to T&C and privacy & customer agreement
    When User does scrolls through the terms and conditions to end
    Then The checkbox privacy policy should be displayed
    And The checkbox Terms and Condition should be displayed
    When User click checkbox kebijakan privasi
    And  User click checkbox syarat ketentuan
    Then The checkbox Terms and Condition should be checked
    And The checkbox privacy policy should be checked
    And User see lanjut button is enabled
    When User click lanjut
    Then User should navigate to form data diri screen

