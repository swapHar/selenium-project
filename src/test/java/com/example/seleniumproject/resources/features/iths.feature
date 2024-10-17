Feature: Test iths website

  Background:
    Given User visits iths.se

  Scenario:  iths.se should show correct title
    Then The title should be "iths.se"

  Scenario: menu element shoud be visible in website size compatible
    When user opens website in small size
    Then Menu should be visible

  Scenario: Menu should be clickable and first element should be "UTBILDNINGAR"
    When user clicks on Menu
    Then first element in menu list should be "UTBILDNINGAR"

  Scenario: Utbildningar page should open
     When user clicks on Alla Utbildningar button
     Then the page header should be "Utbildningar"

  Scenario: IT-utbildningar Göteborg page should open
    When user clicks on Göteborg button
    Then new page header should be "IT-utbildningar Göteborg"

  Scenario: IT-utbildningar Stockholm page should open
    When user clicks on Alla Stockholm button
    Then page header should be "IT-utbildningar Stockholm"

  Scenario: Utbildningar page should open
    When user clicks on Sen ansökan
    Then new page should open and page hearder should be "Utbildningar"

  Scenario: student name should change
    When user clicks on right arrow
    Then student name should change to "Joakim Johansson"

  Scenario: When clicked on Göteborg in Utbildningar page Göteborg should be selected
    When user clicks on Göteborg
    Then Göteborg should be selected

  Scenario: drop-down should open
    When user clicks on Utbildningsform button
    Then drop-down should open




