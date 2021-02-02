package BaseAPI;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class login {
	
 public static String barriertoken = "";
	
 @Test
  public String login_marcom()
 {

		RestAssured.baseURI = "https://marcom20-production.whitelabeliq.net/";
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");

		JSONObject requestParams = new JSONObject();
		requestParams.put("email", "marcom.jassi@gmail.com");
		requestParams.put("password", "marcom2020");

		request.body(requestParams.toJSONString());

		Response response = request.post("/api/v1/login");
		int statusCode = response.getStatusCode();

		System.out.println("The status code recieved: " + statusCode);

		System.out.println("Response body: " + response.getBody().jsonPath().prettify());

		Assert.assertEquals(statusCode, 200);
		return response.getBody().jsonPath().get("data.access_token");

		
	}
}
