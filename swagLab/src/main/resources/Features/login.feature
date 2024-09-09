Feature: Login functionality
  Background:
    Given User navigates to the page

  Scenario Outline: user can login using valid credentials
    When user enters "<validUsername>" and "<validPassword>"
    And user click on login button
    Then user is logged in successfully
    Examples:
      | validUsername | validPassword |
      | standard_user | secret_sauce  |

  Scenario Outline: user cannot login using invalid credentials
    When user enters "<Username>" and "<Password>"
    And user click on login button
    Then user cannot login
    Examples:
      | Username         | Password         |
      | standard_user    | invalid_password |
      | nonexisting_user | secret_sauce     |
      | nonexisting_user | invalid_password |

  Scenario Outline: user must fill the required fields
    When user enters "<Username>" and "<Password>"
    And user click on login button
    Then error message shows that the user must fill the "<missingField>" field
    Examples:
      | Username      | Password     | missingField |
      | standard_user |              | Password     |
      |               | secret_sauce | Username     |