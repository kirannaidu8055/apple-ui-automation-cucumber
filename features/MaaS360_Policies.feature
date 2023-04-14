Feature: Policy page scenario


Scenario: Policy page create scenario

Given I have the Passcode Policy Name
When I click on Policy Tab
And I click on the Add Policy Button
And I give policy name
And I select the type
And I select start from
And I click on continue
And I click on Device Settings tab
And I configure Passcode Settings
And I click Next
And I click on Publish
Then I will see the policy version as one.