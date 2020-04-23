Feature: Search product and order it

  Scenario Outline: Choose your product and buy it
    Given User go to the main page and log in
    When Search for the product
    And Choose product and validate discount
    And Choose keyword <size> and keyword <quantity>
    And Add to cart and go to checkout
    And Confirm Address
    And Choose shipping method
    And Choose payment
    And Confirm transaction
    Then See success message "<orderSuccessMessage>" and get screenshot
    And Validate order with payment status message "<paymentStatusMessage>"
    Examples:
     | paymentStatusMessage   | orderSuccessMessage     | size | quantity |
     | Awaiting check payment | YOUR ORDER IS CONFIRMED | M    | 5        |
