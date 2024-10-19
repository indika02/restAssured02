Feature: delete product using PUT API


  Scenario: validate delete products api status code works correctly
    Given I hit the url of delete products api endpoint
    When I pass the url of delete products in the request with 20
