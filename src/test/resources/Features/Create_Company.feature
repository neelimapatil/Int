@CreateCompany 
Feature: ManageCompany 

@Regression 
Scenario: Delete the Newly created Company 
	Given User is on Login Page 
	When user login with "dummyfm" and "passw0rd" with data from json file 
	When user clicks on Financial Analysis link 
	And user clicks on Company link 
	And user clicks on Manage Company link 
	When user clicks on New button 
	And User enters Company name as "Tester86" 
	And User selects Company type as "IT" 
	And User Company Subtype as "Support" 
	And User enters Address as "Pune" 
	And User enters Phone as "0123456789" 
	And User enters Email as "abcdef@gmail.com" 
	And User enters Pan Details as "ARPPT3211265498" 
	And User enters Tin details as "32165432165487" 
	And User enters Country as "INDIA" 
	And User enters State as "MAHARASHTRA" 
	And User enters City name as "PUNE" 
	And User enters Total Employee as "1" 
	And User clicks on Save button 
#	When user deletes the company