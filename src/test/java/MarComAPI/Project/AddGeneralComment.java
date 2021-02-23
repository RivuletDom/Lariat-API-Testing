package test.java.MarComAPI.Project;

import org.json.simple.JSONObject;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import test.java.MarComAPI.Login.login;

public class AddGeneralComment extends login {

	@Test(priority = 2)
	public void AddingGeneralComment() throws Throwable {

		System.out.println(" *** API: Add General Project in Project *** \n");

		String token = login_marcom();

		RestAssured.baseURI = "https://marcom20-production.whitelabeliq.net/";
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		System.out.println("Token : " + token);
		request.header("Authorization", "Bearer " + token);

		JSONObject requestParams = new JSONObject();
		requestParams.put("workspace_id", workspace_id);
		requestParams.put("project_id", "1340298153");
		requestParams.put("published", "1");
		requestParams.put("type", "general");
		requestParams.put("comment", "This is General Comment added by API - Tarang");

		request.body(requestParams.toJSONString());

		Response response = request.post("api/v1/project/comment/general/add?url_workspace_id=278054311");
		int statusCode = response.getStatusCode();

		System.out.println("The status code recieved: " + statusCode);

		System.out.println("Response body: " + response.getBody().jsonPath().prettify());

		AssertJUnit.assertEquals(statusCode, 200);

		System.out.println("\n\n ------------------------------------------------ \n\n");
		Thread.sleep(3000); 
	}
}
