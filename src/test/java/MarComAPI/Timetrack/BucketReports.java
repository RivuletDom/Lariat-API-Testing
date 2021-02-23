package test.java.MarComAPI.Timetrack;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import test.java.MarComAPI.Login.login;

public class BucketReports extends login {

	@Test
	public void BucketReportData() throws Throwable {

		System.out.println(" *** API: Bucket Project report data   ***  \n");

		String token = login_marcom();

		RestAssured.baseURI = "https://marcom20-production.whitelabeliq.net/";
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		System.out.println("Token : " + token);
		request.header("Authorization", "Bearer " + token);

		JSONObject requestParams = new JSONObject();

		
		JSONArray jsonarray = new JSONArray();
		jsonarray.add("278054311");
		
		requestParams.put("workspace_id", jsonarray);
		
		requestParams.put("user_id", "0");
		requestParams.put("start_date", "all");
		requestParams.put("end_date", "all");

		request.body(requestParams.toJSONString());

		Response response = request.post("api/v1/timetrack/reports/bucktes?sortvalue=&orderby=ASC&url_workspace_id=278054311");
		int statusCode = response.getStatusCode();

		System.out.println("The status code recieved: " + statusCode);
		System.out.println("/n Response body: " + response.getBody().jsonPath().prettify());

		AssertJUnit.assertEquals(statusCode, 200);

		System.out.println("\n\n ----------------------------------------------- \n\n");
		Thread.sleep(3000);

	}
}
