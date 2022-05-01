@test

Feature: Search

  Background:
    Given open page

  Scenario: Find place
    When type 'Hotel 52 Playa del Carmen'
    And click search
    Then validate hotel 'Hotel 52 Playa del Carmen' is displayed first
    And validate hotel rating is '8.1'