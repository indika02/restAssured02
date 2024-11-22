Feature: update products using PUT API

  @UpdateProducts @products
  Scenario: validate put products api status code works correctly
    Given I hit the url of products api endpoint
    When I pass the url of products in the request with id 7 and title test2
    Then I receive the response code as 200
