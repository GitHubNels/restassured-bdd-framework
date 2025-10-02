Feature: Insert products using POST API call

  Scenario Outline: Validate the successful creation of Products
    Given I hit the get product url
    When  I pass the request body <filename> <code>
    Then verify the createAPI status code <code>
    And verify the response body matches the request body
    Examples:
      | code | filename            |
      | 201  | 'post_request.json' |