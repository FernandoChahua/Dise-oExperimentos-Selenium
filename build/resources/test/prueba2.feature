Feature: Add the delivery address
  Scenario Outline: Verification that the order has been added
    Given I am a user with "<username>" and "<password>"
    And I select address menu
    And I select the add button
    When I fill "<name>" and fill "<latitud>" and "<longitud>"
    And I select confirm
    Then I am shown my addresses and confirm that the address has been created
    Examples:
      |username|password|name|latitud|longitud|
      |test10@gmail.com|12345|Test-1|-12.0771302|-77.0832421|