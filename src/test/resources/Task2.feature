Feature: Products updated in the basket
  As an end user
  I want to add the 2 products to the basket randomly
  So I should able to see the 2 products in the basket

  Scenario: Basketupdate
    Given I search for a product
    When  I select all the products in list and on one product randomly
    And I add that product  trolley
    And I click on continue shopping
    And again i search for a product  add random product
    Then I add that product to basket and goto trolley
    And i should ale to see the trolley got 2 products
