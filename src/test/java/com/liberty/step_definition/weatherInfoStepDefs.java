package com.liberty.step_definition;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class weatherInfoStepDefs {

	Response response;
	String weatherUrl;
	
	@Given("Content and accept type is Json")
	public void content_and_accept_type_is_Json() {
		given().accept(ContentType.JSON).and().contentType(ContentType.JSON);

	}

	@When("I get the current weather using city name {string}")
	public void i_get_the_current_weather_using_city_name(String city) {
		weatherUrl = "https://api.openweathermap.org/data/2.5/weather?q=" + city
				+ "&APPID=04a566a0cde4b45f95a7128fd9217c0d";

		given().accept(ContentType.JSON).when().get(weatherUrl).prettyPrint();
	}

	@Then("Status code is {int}")
	public void status_code_is(int statusCode) {
		response = given().accept(ContentType.JSON).when().get(weatherUrl);
		assertEquals(response.statusCode(), statusCode);
	}

	@Then("Json response Data should contain weather condition info")
	public void json_response_Data_should_contain_weather_condition_info() {
		Map<String, Object> getWeather = response.body().as(Map.class);

		Map<String, Object> weather = new HashMap<String, Object>();

		weather.put("main.temp_min", 286.15);
		weather.put("main.temp_max", 288.15);
		
	Set<Entry<String, Object>> set= weather.entrySet();

		for (Entry<String, Object> each : set) {
			assertEquals(getWeather.get(each), weather.get(each));
		}
	}
}
