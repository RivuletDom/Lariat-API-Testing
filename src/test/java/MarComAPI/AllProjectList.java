package test.java.MarComAPI;

import org.json.simple.JSONObject;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import groovyjarjarantlr4.v4.parse.GrammarTreeVisitor.tokenSpec_return;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AllProjectList extends login {
	
	@Test
	public void accessProfile() throws Throwable {

		System.out.println(" *** API: All Project List  *** \n" );

		String token = login_marcom();
		
		RestAssured.baseURI = "https://marcom20-production.whitelabeliq.net/";
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		System.out.println("Token : " + token);
		request.header("Authorization", "Bearer " + token);

		JSONObject requestParams = new JSONObject();
		requestParams.put("workspace_id", workspace_id);
		requestParams.put("client_id", "0");
		requestParams.put("clientsOrNot", "");
		requestParams.put("sortvalue", "");
		requestParams.put("orderby", "");
		requestParams.put("favourite_project", "0");
		requestParams.put("recent_project", "0");
		requestParams.put("project_owner_id", "0");
		requestParams.put("archive_project", "0");
		requestParams.put("is_collaborate", "0");

		request.body(requestParams.toJSONString());

		Response response = request.post("api/v1/project/list-all?page=1&sortvalue=null&orderBy=null&url_workspace_id=278054311");
		int statusCode = response.getStatusCode();

		System.out.println("The status code recieved: " + statusCode);

		System.out.println("Response body: " + response.getBody().jsonPath().prettify());

		AssertJUnit.assertEquals(statusCode, 200);

		System.out.println("\n\n ------------------------------------------------ \n\n");

		Thread.sleep(3000);
	}
}
