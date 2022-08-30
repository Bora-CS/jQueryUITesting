package apiTesting;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SecondAPITest {
	
	String token;
	

	@Test(priority = 2)
	public void addExpirence() {

		RestAssured.baseURI = "https://boratech.herokuapp.com";
		RequestSpecification request = RestAssured.given();

		request.header("Content-Type", "application/json");
		request.header("x-auth-token", token);

		Map<String, String> body = new HashMap<String, String>();
		body.put("company", "boraAPI");
		body.put("title", "API Tester");
		body.put("location", "");
		body.put("from", "2020-08-22");
		body.put("to", "2022-08-22");
		body.put("description", "This is crom from postman");
		
		request.body(body);
		
		Response resp = request.put("/api/profile/experience");
		System.out.println("Add Expirence body is: \n"+resp.getBody().asPrettyString());
 
	}

	@Test(priority = 1)
	public void login_user_test() {

		// base URL + endPoint
		// Method -> Get, Post, Put, Patch, Delete
		// Header -> Content-Type - Application/json
		// Body -> Json Format

		RestAssured.baseURI = "https://boratech.herokuapp.com";
		RequestSpecification request = RestAssured.given();

		request.header("Content-Type", "application/json");

		Map<String, String> body = new HashMap<String, String>();
		body.put("email", "muradil.erkin@boratechschool.com");
		body.put("password", "Boratech");

		request.body(body);

		Response response = request.post("/api/auth");

		int actualStatusCode = response.getStatusCode();
		int expectedStatusCode = 200;

		if (expectedStatusCode == actualStatusCode) {
			System.out.println("Test Passed");
		} else {
			System.out.println("Test Failed");
			System.out.println("Expected Status Code: " + expectedStatusCode);
			System.out.println("Actual Status Code: " + actualStatusCode);
		}

		String responseBody = response.getBody().asString();

		System.out.println(responseBody);

		token = response.jsonPath().get("token");

	}

}
