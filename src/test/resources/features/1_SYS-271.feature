@SYS-219
Feature: As a Librarian I should be able to edit users

	Background:
		#@SYS-271
		Given librarian should be on base page
		

	
	@SYS-275 @SYS-279
	Scenario: /şenol/use user group dropdown
		
		Given librarin goes to "Users" page from Basepage
		And librarian can select "Librarian" from dropdown
		Then verify that selected option is "Librarian"
		And librarian can select "Students" from dropdown
		Then verify that selected option is "Students"	

	
	@SYS-274 @SYS-279
	Scenario: /şenol/Status should have ACTIVE and INACTIVE
		
		    Given librarin goes to "Users" page from Basepage
		    When librarian click status button
		    Then Status should have
		    |ACTIVE|
		    |INACTIVE|
			

	
	@SYS-269 @SYS-279
	Scenario: /şenol/Librarian can edit new user
		Librarian can edit new user
		
		    Given librarin goes to "Users" page from Basepage
		    When librarian click edit button
		    Then librarian should be able to send following credential
				|Full Name|ali demir|
				|Password|asdf|
				|Email|ak@gmail.com|
				|Address|dafsdfadfsdfjlj|
		    Then librarian can see the edited user on the table	

	
	@SYS-276 @SYS-279
	Scenario: /şenol/using show records dropdown
		
		Given librarin goes to "Users" page from Basepage
		When librarian clicks the show dropdown
		And ten must be first selected options
		Then librarian should see the following numbers
		|5|
		|10|
		|15|
		|50|
		|100|
		|200|
		|500|
		Then librarian should select all dropdowns
		|5|
		|10|
		|15|
		|50|
		|100|
		|200|
		|500|	

	
	@SYS-278 @SYS-279
	Scenario: /şenol/use Status dropdown for selecting status
		use Status dropdown for selecting status
		
		    Given librarin goes to "Users" page from Basepage
		    Given first selected option of Status must be ACTIVE
		    When librarian clicks the Status dropdown
		    Then all the options should be able to select
		    |ACTIVE|
		    |INACTIVE|

	
	@SYS-277 @SYS-279
	Scenario: /şenol/find user by using search
		
		    Given librarin goes to "Users" page from Basepage
		    When librarian enters "ali" to the search button
		    Then all the results have "ali" string

	
	@SYS-273 @SYS-279
	Scenario: /şenol/2 user types as Librarian and Students
		    Given librarin goes to "Users" page from Basepage
		    When librarian click user group
		    Then User Group should have two user types as
			|ALL|
		    |Librarian|
		    |Students|

	@SYS-272 @SYS-279
	Scenario: /şenol/Edit user information should have following parameters


		Given librarin goes to "Users" page from Basepage
		When librarin clicks the edit
		Then Edit user information should have following parameters
			|Full Name|
			|Password|
			|Email|
			|User Group|
			|Status|
			|Start Date|
			|End Date|
			|Address|

	@SYS-284 @SYS-279 @wip
	Scenario Outline: /şenol/editin address for negatif scenario
		Given librarin goes to "Users" page from Basepage
		When librarian click edit button
		Then librarian should be able to send following credential
			|Address|<invalid>|
		Then librarian gives invalid credentials for user name

		Examples:
			|<invalid>|
			||
			|a|
			|1|
			|*=)(|

	@SYS-281 @SYS-279
	Scenario Outline: /şenol/editin user for negatif scenario
		Given librarin goes to "Users" page from Basepage
		When librarian click edit button
		Then librarian should be able to send following credential
			|Full Name|<invalid>|
		Then librarian gives invalid credentials for user name

		Examples:
			|<invalid>|
			||
			|.asdf|
			|?=)(|
			|1234|
			|a|
			|asdf234dsf|
			|ahmet a|
			|ahmet|
			|ahmet 12134|
			|ahmet *=)(|

	@SYS-283 @SYS-279
	Scenario Outline: /şenol/editin email for negatif scenario
		Given librarin goes to "Users" page from Basepage
		When librarian click edit button
		Then librarian should be able to send following credential
			|Email|<invalid>|
		Then librarian gives invalid credentials for user name

		Examples:
			|<invalid>|
			||
			|.asdf|
			|?=)(|
			|1234|
			|@a|
			|asdf234dsf@|
			|-123|

	@SYS-282 @SYS-279
	Scenario Outline: /şenol/editin password for negatif scenario
		Given librarin goes to "Users" page from Basepage
		When librarian click edit button
		Then librarian should be able to send following credential
			|Password|<invalid>|
		Then librarian gives invalid credentials for user name

		Examples:
			|<invalid>|
			||
			|a|
			|1|