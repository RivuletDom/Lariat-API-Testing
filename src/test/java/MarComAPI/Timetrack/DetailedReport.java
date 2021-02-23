package test.java.MarComAPI.Timetrack;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import test.java.MarComAPI.Login.login;

public class DetailedReport extends login {

	@Test
	public void DetailedReportData() throws Throwable {

		System.out.println(" *** API: Detailed report data for specific Project   ***  \n");

		String token = login_marcom();

		RestAssured.baseURI = "https://marcom20-production.whitelabeliq.net/";
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		System.out.println("Token : " + token);
		request.header("Authorization", "Bearer " + token);

		JSONObject requestParams = new JSONObject();

		JSONArray workspaceid = new JSONArray();
		workspaceid.add("278054311");
		requestParams.put("workspace_id", workspaceid);

		JSONArray projectid = new JSONArray();
		projectid.add("1340298153");
		requestParams.put("projects", projectid);

		requestParams.put("start_date", "all");
		requestParams.put("end_date", "all");
		requestParams.put("group_by", "Date");
		requestParams.put("is_billable", "2");
		requestParams.put("sortvalue", "");
		requestParams.put("orderby", "ASC");

		request.body(requestParams.toJSONString());

		Response response = request.post("api/v1/timetrack/reports/detailed/list?url_workspace_id=278054311");
		int statusCode = response.getStatusCode();

		System.out.println("The status code recieved: " + statusCode);
		System.out.println("/n Response body: " + response.getBody().jsonPath().prettify());

		AssertJUnit.assertEquals(statusCode, 200);

		System.out.println("\n\n ----------------------------------------------- \n\n");
		Thread.sleep(3000);

	}
}
