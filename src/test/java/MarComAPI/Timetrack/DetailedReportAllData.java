package test.java.MarComAPI.Timetrack;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import test.java.MarComAPI.Login.login;

public class DetailedReportAllData extends login {

	@Test
	public void DetailedReportAllData() throws Throwable {

		System.out.println(" *** API: Detailed report data for all Project   ***  \n");

		String token = login_marcom();

		RestAssured.baseURI = "https://marcom20-production.whitelabeliq.net/";
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		System.out.println("Token : " + token);
		request.header("Authorization", "Bearer " + token);

		JSONObject requestParams = new JSONObject();

		JSONArray workspaceid = new JSONArray();
		workspaceid.add("278054311");
		workspaceid.add("195302813");

		requestParams.put("workspace_id", workspaceid);

		request.body(requestParams.toJSONString());

		Response response = request.post("api/v1/timetrack/reports/detailed/all-data?url_workspace_id=278054311");
		int statusCode = response.getStatusCode();

		System.out.println("The status code recieved: " + statusCode);
		System.out.println("/n Response body: " + response.getBody().jsonPath().prettify());

		AssertJUnit.assertEquals(statusCode, 200);

		System.out.println("\n\n ----------------------------------------------- \n\n");
		Thread.sleep(3000);

	}
}
