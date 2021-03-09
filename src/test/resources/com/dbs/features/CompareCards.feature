@CompareCards
Feature: Compare the cards and print similarities and differences between cards

  @CompareCards
  Scenario Outline: Compare Cards
    Given I navigate to dbs credit cards page
    When I select two cards "<card1>" and "<card2>" on credit cards page
    Then Print the similarities and differences between the cards

    Examples: 
      |             card1                 |          card2          |
      | DBS Altitude Visa Signature Card  |   DBS Black Visa Card   |