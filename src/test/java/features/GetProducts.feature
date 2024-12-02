Feature: Get all products from the api

  @getProducts @products
  Scenario: Verify the get api for the products
    Given Go to main url of products as productsUri
    When Pass the url for products
    Then Confirm the response code as 200

  @getProducts @products
  Scenario: Verify the rate of the first product is correct
    Given Go to main url of products as productsUri
    When Pass the url for products
    Then Verify the rate of the first product is 3.9
    Then Confirm the response code as 200

  @getProducts @products
  Scenario: Verify the get the products category related to the jewelery
    Given Go to main url of products as productsUri
    Then Retrieve the products of category as jewelery
    Then Confirm the response code as 200

  @getProducts @products
  Scenario: Get the products only related to specific Id
    Given Go to main url of products as productsUri
    Then Retrieve the product details of product id 8
    Then Confirm the response code as 200


