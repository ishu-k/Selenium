@filter
  Feature: filter
     As an end user
     I want to apply filters
     So that I can find desired output
    @smoke
    Scenario: Filter by review
      Given  I am on homepage
      When   I search for a product "nike"
      And    I apply filter review "2or more"
      Then   I should be able to see product rating "2"

     