Feature: Delete added address

  Scenario Outline: Delete freshly added address
    Given User is looged In
    When Go to addresses page to delete one
    And Find address keyword <addressAlias> and click delete button
    Then User will see "<deleteMessage>"
    And Browser is closed after deletion
    Examples:
      | deleteMessage                 | addressAlias |
      | Address successfully deleted! | Your teddyBear Company |
      | Address successfully deleted! | Your teddyBear Company |
