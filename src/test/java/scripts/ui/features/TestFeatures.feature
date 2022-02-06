Feature: Login With Valid Info
  Verify if user is able to login with valid info
  Scenario: Enter valid "email or phone", "password" and select Login button
    Given user is on Login page
    When user enters valid "Email or Phone" such as "leo1@gmail.com"
    And user enters valid "Password" such as "123456"
    And user selects Login button
    Then user logs in successfully
    And user navigates to Orders page