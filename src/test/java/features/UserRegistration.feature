Feature: User Registration
   i want to check the user can register in e-commerce website
   
   Scenario Outline: Verfiy User Registration Success
   Given the user in the home page
   When I click on the register link
   And I enterd "<firstname>" ,"<lastname>" , "<email>" , "<password>"
   Then the Registration is displayed Successfully
   
   Examples:
   | firstname | lastname | email | password |
   | osama | as | test@yahoo.com | 12345678 |
   | ah | as | user1@yahoo.com | 87654321 |
   

