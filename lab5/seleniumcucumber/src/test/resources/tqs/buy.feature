Feature: Buy Ticket

  Scenario: test Buy
    When I navigate to "https://blazedemo.com/"
    And I choose from departure Portland
    And I choose destination Berlin
    And I click button find flights
    And I choose first flight
    And I click Purshase Flight
    Then I find a Thank you page