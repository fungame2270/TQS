Feature: Book search
  To allow a customer to find his favourite books quickly, the library must offer multiple ways to search for a book.
 
  Scenario: Search books by publication year
    Given a book with the title 'One good book', written by 'Anonymous', published in 14.03.2013
      And another book with the title 'Some other book', written by 'Tim Tomson', published in 23 August 2014
      And another book with the title 'How to cook a dino', written by 'Fred Flintstone', published in 01 January 2012
    When the customer searches for books published between 2012 and 2015
    Then 2 books should have been found
      And Book 1 should have the title 'Some other book'
      And Book 2 should have the title 'One good book'
  Scenario: Seach Books Table
    Given I have the following books in the store by list
      | The Devil in the White City          | Erik Larson | 14.03.2013 |
      | The Lion, the Witch and the Wardrobe | C.S. Lewis  | 14.03.2014 |
      | In the Garden of Beasts              | Erik Larson | 14.03.2011 |
    When the customer searches for books published between 2012 and 2015
    Then 2 books should have been found