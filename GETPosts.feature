Feature: GETPosts
  Verify different GET operations using REST-assured

  Scenario: Verify one author of the post
    Given I perform GET operation for "/posts"
    Then I should see the author name as "Karthik KK"

  @smoke
  Scenario: Verify GET operation with bearer authentication token
    Given I perform authentication operation for "/auth/login" with body
      | email           | password |
      | bruno@email.com | bruno    |
    Given I perform GET operation for "/products/1"
    Then I should see the name as "Product001"
