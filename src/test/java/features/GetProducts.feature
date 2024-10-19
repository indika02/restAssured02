Feature: Get all products from the api

  @getProducts
  Scenario: Verify the get api for the products
    Given I hit the url of get products api endpoint
    When I pass the url of products in the request
    Then I receive the response code as 200

  @getProducts
  Scenario: Verify the rate of the first product is correct
    Given I hit the url of get products api endpoint
    When I pass the url of products in the request
    Then I verify that the rate of the first product is 3.9
    Then I receive the response code as 200


