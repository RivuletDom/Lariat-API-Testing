package MarComAPI;

import org.json.simple.JSONObject;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import groovyjarjarantlr4.v4.parse.GrammarTreeVisitor.tokenSpec_return;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class MyTaskList extends login {
	
	@Test
	public void accessProfile() throws Throwable {

		System.out.println(" *** API: My Task List ***  \n" );

		String token = login_marcom();
		
		RestAssured.baseURI = "https://marcom20-production.whitelabeliq.net/";
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		System.out.println("Token : " + token);
		request.header("Authorization", "Bearer " + token);

		JSONObject requestParams = new JSONObject();
		requestParams.put("workspace_id", workspace_id);
		requestParams.put("user_id", "62");
		requestParams.put("search_name", "");
		requestParams.put("sort_value", "");
		requestParams.put("sort_by", "");
		requestParams.put("due_date", "");
		requestParams.put("task_priority", "Priority");

		request.body(requestParams.toJSONString());

		Response response = request.post("api/v1/project/task/my-task?page=1&url_workspace_id=278054311");
		int statusCode = response.getStatusCode();

		System.out.println("The status code recieved: " + statusCode);

		System.out.println("Response body: " + response.getBody().jsonPath().prettify());

		AssertJUnit.assertEquals(statusCode, 200);

		System.out.println("\n\n ------------------------------------------------ \n\n");
		Thread.sleep(3000);
	}
}
