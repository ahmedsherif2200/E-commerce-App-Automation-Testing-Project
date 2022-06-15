@SmokeTesting

  Feature: Follow us links open the corresponding URLs

  Background: User navigates to demo.nopcommerce website

  Scenario: user could open facebook
    When Click on facebook icon
    Then  User could open facebook page

  Scenario: user could open twitter
    When Click on twitter icon
    Then  User could open twitter page

  Scenario: user could open rss
    When Click on rss icon
    Then  User could open rss page

  Scenario: user could open youtube
    When Click on youtube icon
    Then  User could open youtube page