package test.java.MarComAPI;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AllReportData extends login {

	@Test
	public void EditClientDetails() throws Throwable {

		System.out.println(" *** API: All report data of projects***  \n");

		String token = login_marcom();

		RestAssured.baseURI = "https://marcom20-production.whitelabeliq.net/";
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		System.out.println("Token : " + token);
		request.header("Authorization", "Bearer " + token);

		JSONObject requestParams = new JSONObject();
		requestParams.put("workspace_id", workspace_id);

		JSONArray jsonarray = new JSONArray();
		jsonarray.add("278054311");

		requestParams.put("accessibleWorkspaces", jsonarray);
		requestParams.put("user_id", "60");
		requestParams.put("date", "2020-11-6");

		request.body(requestParams.toJSONString());

		Response response = request.post("api/v1/timetrack/day/all-data?url_workspace_id=278054311");
		int statusCode = response.getStatusCode();

		System.out.println("The status code recieved: " + statusCode);
		System.out.println("/n Response body: " + response.getBody().jsonPath().prettify());

		AssertJUnit.assertEquals(statusCode, 200);

		System.out.println("\n\n ----------------------------------------------- \n\n");
		Thread.sleep(3000);

	}
}
