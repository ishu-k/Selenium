Feature:baskettest
  As an end user
  I want to add a produts randomly and increase the quantity in the basket
  so that i should able to see the total price got doubled

  Scenario: baskettest for product price
    Given i search for a product nike
    When i collect all the nike products in to the list and randomly select a product
    And  i add the product to basket
    And i increase the number of products to 2
    Then i should be able to see the expected equal to actual




