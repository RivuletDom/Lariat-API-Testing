package test.java.MarComAPI.Bucket;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import test.java.MarComAPI.Login.login;

public class ViewBucketList extends login {

	@Test
	public void ViewBucketListing() throws Throwable {

		System.out.println(" *** API: View Bucket List ***  \n");

		String token = login_marcom();

		RestAssured.baseURI = "https://marcom20-production.whitelabeliq.net/";
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		System.out.println("Token : " + token);
		request.header("Authorization", "Bearer " + token);

		JSONObject requestParams = new JSONObject();
		
		JSONArray jsonarray = new JSONArray();
		jsonarray.add("278054311");
		jsonarray.add("195302813");

		requestParams.put("workspace_id", jsonarray);
		requestParams.put("project_id", "1340298153");
		requestParams.put("client_id", "0");
		requestParams.put("owner_id", "0");
		requestParams.put("sortvalue", "");
		requestParams.put("orderby", "");
		requestParams.put("favourite", "0");
		requestParams.put("recent", "0");
		requestParams.put("archive", "0");
		requestParams.put("start_date", "2020-12-01");
		requestParams.put("end_date", "2021-02-28");


		request.body(requestParams.toJSONString());

		Response response = request.post("api/v1/project/bucket/list?page=1&url_workspace_id=278054311");
		int statusCode = response.getStatusCode();

		System.out.println("The status code recieved: " + statusCode);

		System.out.println("Response body: " + response.getBody().jsonPath().prettify());

		AssertJUnit.assertEquals(statusCode, 200);

		System.out.println("\n\n ------------------------------------------------ \n\n");
		Thread.sleep(3000);
	}
}
