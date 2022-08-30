package boraApiFunctions;

import java.util.HashMap;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class APICalls {

	public static String loginCall(String userName, String password) {

		// 1. Start API - define API RestAssured object
		RestAssured.baseURI = "https://boratech.herokuapp.com";
		RequestSpecification request = RestAssured.given();

		// 2. Create header
		request.header("Content-Type", "application/json");

		// 3. Create body
		Map<String, String> body = new HashMap<String, String>();
		body.put("email", userName);
		body.put("password", password);

		request.body(body);

		// 4. Do API call
		Response respon = request.post("/api/auth");

		int statusCode = respon.getStatusCode();
		System.out.println("Login status is: " + statusCode);
		String token = respon.getBody().jsonPath().get("token");

		return token;
	}

	public static ResponseBody addExpirenceCall(String token, HashMap<String, String> body) {

		RestAssured.baseURI = "https://boratech.herokuapp.com";
		RequestSpecification request = RestAssured.given();

		request.header("Content-Type", "application/json");
		request.header("x-auth-token", token);

		request.body(body);

		Response resp = request.put("/api/profile/experience");

		System.out.println("Add Expirence status code is: " + resp.getStatusCode());

		return resp.getBody();

	}

	public static ResponseBody addEducationCall(String token, HashMap<String, String> body) {

		RestAssured.baseURI = "https://boratech.herokuapp.com";
		RequestSpecification request = RestAssured.given();

		request.header("Content-Type", "application/json");
		request.header("x-auth-token", token);

		request.body(body);

		Response resp = request.put("/api/profile/education");

		System.out.println("Add Education status code is: " + resp.getStatusCode());

		return resp.getBody();

	}

}
