Feature: Get all products from the api

  @getProducts @products
  Scenario: Verify the get api for the products
    Given I hit the url of products api endpoint
    When I pass the url of products in the request
    Then I receive the response code as 200

  @getProducts @products
  Scenario: Verify the rate of the first product is correct
    Given I hit the url of products api endpoint
    When I pass the url of products in the request
    Then I verify that the rate of the first product is 3.9
    Then I receive the response code as 200

  @getProducts @products
  Scenario: Verify the get the product category related to the jewelery
    Given I hit the url of products api endpoint
    Then Retrieve the products of category as jewelery
    Then I receive the response code as 200

  @getProducts @products
  Scenario: Get the products only related to specific Id
    Given I hit the url of products api endpoint
    Then Retrieve the product details of product id 8
    Then I receive the response code as 200


