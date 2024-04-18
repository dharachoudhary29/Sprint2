Feature: To test the functionality of notification
Background:
Given User is logged In and User is on notification Page
|dharachoudhary1129@gmail.com|Khushi@987|


@Notification
Scenario: Check the View Settings functionality
When User clicks on View Settings
And User clicks on Searching for a job 
And User switch on the toggle
Then notification searching for a job is on


@comment
Scenario: Check the comment functionality
When User clicks on my post
And User clicks on the post
And User comment on the post
|Congratulations|
Then comment should be reflected


@defect
Scenario: Check the viewing functionality
When User open the notification in which other user viewed your profile is reflected
Then profile picture and user name is not visible


@birthday
Scenario: Check Birthday functionality
When User click on other user Birthday notification
And Message box of other user should be open
And Happy Birthday message should be written
|Happy Birthday|
Then the message should be sent


@share
Scenario Outline: Check share functionality
When User click on a particular post notification
And clicks on send button of the post
And  Enters the <name>
And Select the box infront of the reciever
Then Click on the send button

Examples:
|name|
|Anika Joshi|
