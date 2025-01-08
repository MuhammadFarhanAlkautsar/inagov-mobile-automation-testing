Feature: Bantuan Page

  Background:
    Given User is on splash page
    When User click pusat bantuan

  @Android
  Scenario:[Android] Validation Form Aduan Button
    When User click formulir aduan
    Then User see formulir aduan screen

  @Android
  Scenario:[Android] Validation FAQ Button
    When User click faq
    Then User see faq screen

  @Android
  Scenario:[Android] Validation INApas website social media button
    When User click INApas website icon button
    Then User should be navigate to the INA digital Browser

  @Android
  Scenario:[Android] Validation INApas twitter social media button
    When User click INApas twitter icon button
    Then User should be navigate to the INA digital Twitter

  @Android
  Scenario:[Android] Validation INApas youtube social media button
    When User click INApas youtube icon button
    Then User should be navigate to the INA digital Youtube

  @Android
  Scenario:[Android] Validation INApas facebook social media button
    When User click INApas facebook icon button
    Then User should be navigate to the INA digital Facebook

  @Android
  Scenario:[Android] Validation INApas linkedin social media button
    When User click INApas linkedin icon button
    Then User should be navigate to the INA digital linkedIn