Feature: Weather API Get Request


@by_city @temp
Scenario: Verify weather by city name
	Given Content and accept type is Json
	When I get the current weather using city name "London"
	Then Status code is 200 
	And  Json response Data should contain weather condition info

		
		
		
	
	

	
	
	
	