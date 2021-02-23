package test.java.MarComAPI.General;

import org.json.simple.JSONObject;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import test.java.MarComAPI.Login.login;

public class EditClient extends login {

	@Test
	public void EditClientDetails() throws Throwable {

		System.out.println(" *** API: Edit Client ***  \n");

		String token = login_marcom();

		RestAssured.baseURI = "https://marcom20-production.whitelabeliq.net/";
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		System.out.println("Token : " + token);
		request.header("Authorization", "Bearer " + token);

		JSONObject requestParams = new JSONObject();
		requestParams.put("workspace_id", workspace_id);
		requestParams.put("client_id", "71");
		requestParams.put("company_name", "DevOps International");
		requestParams.put("phone_number", "43432423423");
		requestParams.put("address_line1", "ahmedabad");
		requestParams.put("company_email", "devops@gmail.com");
		requestParams.put("city", "ahmedabad");
		requestParams.put("state", "Gujarat");
		requestParams.put("zip_code", "380051");

		request.body(requestParams.toJSONString());

		Response response = request.post("api/v1/client/edit?url_workspace_id=278054311");
		int statusCode = response.getStatusCode();

		System.out.println("The status code recieved: " + statusCode);
		System.out.println("Response body: " + response.getBody().jsonPath().prettify());

		AssertJUnit.assertEquals(statusCode, 200);

		System.out.println("\n\n ----------------------------------------------- \n\n");
		Thread.sleep(3000);

	}
}
