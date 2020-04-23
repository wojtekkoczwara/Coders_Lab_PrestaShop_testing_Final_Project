Feature: Add new address

  Scenario Outline: Adding new shipping address
    Given User is logged in to PrestaShop
    When User goes to Address Page
    And User fulfills necessary pages, keyword <alias>, keyword <company>, keyword <address>, keyword <postcode>, keyword <city>, keyword <phone>, keyword <countryValue>
    And User submits changes
    Then User see "<creationMessage>"
    And Validate address data, keyword <alias>, keyword <company>, keyword <address>, keyword <postcode>, keyword <city>, keyword <phone>, keyword <country>
    And Quit browser
    Examples:
      | creationMessage             | alias               | company           | address              | postcode         | city            | phone     | countryValue  | country |
      | Address successfully added! | Your polarBear Company | Your polarBear company | Wroblewskiego 1-5    | 51-618           | Wroclaw         | 999999999 | 17            | United Kingdom |
      | Address successfully added! | Your polarBear2 Company | Your polarBear2 company | Wroblewskiego 1-5    | 51-618           | Wroclaw         | 999999999 | 17            | United Kingdom |