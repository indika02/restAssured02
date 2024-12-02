Feature: delete product using PUT API

  @products
  Scenario: validate delete products api status code works correctly
    Given Go to main url of products as productsUri
    When Pass the id for delete product as 20
    Then Confirm the response code as 200
