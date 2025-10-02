Feature: To validate all the products

  Scenario Outline: Verify all the product and validate the schema
    Given I hit the get product url
    When Check the get product ID response
    Then verify the status code <code>
    And validate the schema

    Examples:
      | code |
      | 200  |

  Scenario Outline: Verify <item> response rate of the products
    Given I hit the get product url api endpoint <item>
    Then I verify the rate of the <rate> product

    Examples:
      | item | rate |
      | 1    | 3.9 |