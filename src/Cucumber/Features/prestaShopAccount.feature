Feature: PrestaShop Account Creation

  Scenario Outline: User create an account in PrestaShop

    Given An open browser with prestaShop
    When Open the AccCreation Website
    And Choose keyword <gender>, keyword <firstName>, keyword <lastName>, keyword <emailAddress>
    And Keyword <password>, keyword <birthDate> and clicks Create an account button
    Then User redirected to the main page as logged and then logged out
    And Validate account by logging in with keyword <emailAddress> and keyword <password>

    Examples:
      | gender | firstName | lastName | emailAddress     | password    | birthDate  |
      | Mrs.    | Slender   | Woman  | slenderwoman6@coders.com | User1@12345 | 12/12/2000 |