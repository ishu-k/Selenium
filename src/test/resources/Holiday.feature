 @Filter
Feature:Holiday
  As an end user
  I want to apply multiple filters
  So that i should see the desired product
    @Smoke
   Scenario: Filters
     Given Im on homepage
     And I search for a product "nike "
     When I apply the 3 filters
       |Category | Type      | Customer Rating|
       |BackPacks| BackPacks |4or More     |
     Then I should get the desired Product

