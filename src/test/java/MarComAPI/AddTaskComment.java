package test.java.MarComAPI;

import java.time.LocalTime;

import org.json.simple.JSONObject;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AddTaskComment extends login {

	@Test(priority = 2)
	public void AddingTaskComment() throws Throwable {

		System.out.println(" *** API: Add Task comment into Task #2038 *** \n");

		String token = login_marcom();

		LocalTime time = LocalTime.now();
	    System.out.println(time);
	    
	    String task_comment = "This is General Task comment added from Automate API run - " + time;
	    
	    
		RestAssured.baseURI = "https://marcom20-production.whitelabeliq.net/";
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		System.out.println("Token : " + token);
		request.header("Authorization", "Bearer " + token);

		JSONObject requestParams = new JSONObject();
		requestParams.put("workspace_id", workspace_id);
		requestParams.put("project_id", "1340298153");
		requestParams.put("task_id", "2038");
		requestParams.put("published", "1");
		requestParams.put("dom_render_id", "DOM");
		requestParams.put("comment", task_comment);
  
		request.body(requestParams.toJSONString());

		Response response = request.post("api/v1/project/task/add-task-comment?url_workspace_id=278054311");
		int statusCode = response.getStatusCode();

		System.out.println("The status code recieved: " + statusCode);

		System.out.println("Response body: " + response.getBody().jsonPath().prettify());

		AssertJUnit.assertEquals(statusCode, 200);

		System.out.println("\n\n ------------------------------------------------ \n\n");
		Thread.sleep(3000); 
	}
}
