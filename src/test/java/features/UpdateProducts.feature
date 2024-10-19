Feature: update products using PUT API

  @UpdateProducts
  Scenario: validate put products api status code works correctly
    Given I hit the url of put products api endpoint
    When I pass the url of products in the request with 6, test product
    Then I receive the response code as 200
