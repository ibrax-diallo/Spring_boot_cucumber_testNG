Feature: Modify a subscriber address

  Scenario: Modification of the address of a subscriber residing in France without or with effective date
    Given a subscriber with an active main address in France
    When the advisor connected to canal changes the subscriber address
    Then  the changed subscriber address is recorded on all of the subscriber contracts
    And an address modification movement is created
