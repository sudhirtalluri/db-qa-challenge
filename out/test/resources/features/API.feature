Feature: API Tests

  @api
  Scenario: Should be able to validate api response
    Given John is has an api request
    When he made api request
    Then response displayed with categories

#schema validations