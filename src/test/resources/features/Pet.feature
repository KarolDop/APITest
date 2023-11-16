Feature: Pet

  Scenario: Add new pet
    Given I have a new pet from category pet with name azor that i want add to shop db
    When I add this pet
    Then Pet from category dog and name azor should be added
    #And Mock response content count should be 3
    #And Mocked resp purch amount should be 900
    #And First content name should be red