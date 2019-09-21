Feature: App Home

  Scenario: Welcome message test ONE
    Given I logged in to the app 'soneuser' as admin
    When I click on 'Contacts' menu item from 'Contact' menu
    When I click on 'Create contact' button
    When I create contacts with below deatils
    |Email|FirstName|LastName|
    |someone@gmail.com|First001|section001|