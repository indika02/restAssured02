Feature: insert products using POST API

  @InsertProducts @products
  Scenario: validate post products api status code works correctly
    Given Go to main url of products as productsUri
    Then Pass the request body for product details as shoes, 123.33, fjsfhjsd vdhf, https://fakestoreapi.com/img/61pHAEJ4NML._AC_UX679_.jpg, shoes
    Then Confirm the response code as 200
    Then Verify the new product' id as 21
