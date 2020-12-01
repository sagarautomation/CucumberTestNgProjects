Feature: FB Feature Automation

Scenario: Count the tolal number of links
Given user is already on FB Login Page
Then user enters "sagarforjob28@gmail.com" and "Password@12345"
Then user clicks on login button
#Then user should be able to view the stories
When user search "jhy" in search field
Then user should be able to see filter options
Then user selects "Your groups and Pages" under post from and "Your groups" under posted in groups
And click choose a group link
Then enter "Naveen Automation labs" in the field




