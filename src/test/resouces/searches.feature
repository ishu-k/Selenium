Feature: Search
  As a end user
  I want to search for product
  So that I can see desired product

  Scenario: Search for single product
    Given Im on homepage
    When I search for product "nike"
    Then I should able to see the nike product
