package test.java.MarComAPI;

import org.json.simple.JSONObject;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import groovyjarjarantlr4.v4.parse.GrammarTreeVisitor.tokenSpec_return;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ViewProjectTask extends login {
	
	@Test
	public void ViewTaskDetail() throws Throwable {

		System.out.println(" *** API: View Project Tasks ***  \n" );
		
		String token = login_marcom();
		
		RestAssured.baseURI = "https://marcom20-production.whitelabeliq.net/";
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		System.out.println("Token : " + token);
		request.header("Authorization", "Bearer " + token);

		JSONObject requestParams = new JSONObject();
		requestParams.put("workspace_id", workspace_id);
		requestParams.put("project_id", "1340298153");
		requestParams.put("task_id", "102");

		request.body(requestParams.toJSONString());

		Response response = request.post("api/v1/project/task/view?url_workspace_id=278054311");
		int statusCode = response.getStatusCode();

		System.out.println("The status code recieved: " + statusCode);

		System.out.println("Response body: " + response.getBody().jsonPath().prettify());

		AssertJUnit.assertEquals(statusCode, 200);
		
		System.out.println("\n\n ------------------------------------------------ \n\n");
		Thread.sleep(3000);
	}
}
