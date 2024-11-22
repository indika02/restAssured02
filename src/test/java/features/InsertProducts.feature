Feature: insert products using POST API

  @InsertProducts @products
  Scenario: validate post products api status code works correctly
    Given I hit the url of products api endpoint
    When I pass the url of products in the request
    And I pass the request body of product details shoes, 123.33, fjsfhjsd vdhf, https://fakestoreapi.com/img/61pHAEJ4NML._AC_UX679_.jpg, shoes
    Then I receive the response code as 200

  @InsertProducts @products
  Scenario: validate post products api response body works correctly
    Given I hit the url of products api endpoint
    When I pass the url of products in the request
    And I pass the request body of product details shoes, 123.33, fjsfhjsd vdhf, https://fakestoreapi.com/img/61pHAEJ4NML._AC_UX679_.jpg, shoes
    Then I receive the response body with id as 21