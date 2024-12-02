Feature: update products using PUT API

  @UpdateProducts @products
  Scenario: validate put products api status code works correctly
    Given Go to main url of products as productsUri
    Then Pass the data for updating with id as 8 and data as title test2
    Then Confirm the response code as 200
