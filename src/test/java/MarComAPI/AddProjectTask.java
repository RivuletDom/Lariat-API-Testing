package test.java.MarComAPI;

import java.time.LocalTime;

import org.json.simple.JSONObject;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AddProjectTask extends login {

	@Test(priority = 2)
	public void AddingProjectTask() throws Throwable {

		System.out.println(" *** API: Add Task in Project *** \n");

		LocalTime time = LocalTime.now();
	    System.out.println(time);
	    
		String token = login_marcom();
		String task_name = "Task is added by API-QA - " + time;

		RestAssured.baseURI = "https://marcom20-production.whitelabeliq.net/";
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		System.out.println("Token : " + token);
		request.header("Authorization", "Bearer " + token);

		JSONObject requestParams = new JSONObject();
		requestParams.put("workspace_id", workspace_id);
		requestParams.put("project_id", "1340298153");
		requestParams.put("task_id", "0");
		requestParams.put("task_title", task_name );

		request.body(requestParams.toJSONString());

		Response response = request.post("api/v1/project/task/add?url_workspace_id=278054311");
		int statusCode = response.getStatusCode();

		System.out.println("The status code recieved: " + statusCode);

		System.out.println("Response body: " + response.getBody().jsonPath().prettify());

		AssertJUnit.assertEquals(statusCode, 200);

		System.out.println("\n\n ------------------------------------------------ \n\n");
		Thread.sleep(3000); 
	}
}
