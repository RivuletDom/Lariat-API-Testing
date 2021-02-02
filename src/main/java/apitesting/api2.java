package apitesting;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class api2 extends login{
  @Test
  public void f() {   
		
	  String token = login_marcom();

		RestAssured.baseURI = "https://marcom20-production.whitelabeliq.net/";
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		System.out.println("Token : " + token);
		request.header("Authorization", "Bearer " + token);

		JSONObject requestParams = new JSONObject();
		requestParams.put("user_id", "58");
		requestParams.put("workspace_id", "278054311");

		request.body(requestParams.toJSONString());

		Response response = request.post("api/v1/user/details?url_workspace_id=278054311");
		int statusCode = response.getStatusCode();

		System.out.println("The status code recieved: " + statusCode);

		System.out.println("Response body: " + response.getBody().jsonPath().prettify());

		String token1 = response.getBody().jsonPath().get("data.access_token");
		System.out.println("token : " + token1);

		Assert.assertEquals(statusCode, 200);
	}
}
