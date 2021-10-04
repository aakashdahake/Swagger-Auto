Feature: Pet Store Tests

  Scenario: Verify that user can add pet of store inventory
    Given user gathers details about pet
    Then user adds pet to inventory
    Then user validates addition of pet to inventory