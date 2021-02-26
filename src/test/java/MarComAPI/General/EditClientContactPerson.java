package test.java.MarComAPI.General;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import test.java.MarComAPI.Login.login;

public class EditClientContactPerson extends login {

	@Test
	public void EditClientDetails() throws Throwable {

		System.out.println(" *** API: Edit Client Contact Person Details ***  \n");
		general = extent.createTest("Login into MarCom");

		String token = login_marcom();

		RestAssured.baseURI = "https://marcom20-production.whitelabeliq.net/";
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		System.out.println("Token : " + token);
		request.header("Authorization", "Bearer " + token);

		JSONObject requestParams = new JSONObject();
		requestParams.put("workspace_id", workspace_id);
		requestParams.put("client_id", "71");
		requestParams.put("person_id", "6");
		requestParams.put("full_name", "Rajesh Kumar");
		requestParams.put("email", "rajesh@texasaol.com"); //non-editable field. just static value of user email
		requestParams.put("phone_number", "1236547896");
		requestParams.put("user_or_not", "1");
		requestParams.put("show_in_list", "1");

		request.body(requestParams.toJSONString());

		Response response = request.post("api/v1/client/update-contact-person?url_workspace_id=278054311");
		int statusCode = response.getStatusCode();

		System.out.println("The status code recieved: " + statusCode);
		System.out.println("/n Response body: " + response.getBody().jsonPath().prettify());

		AssertJUnit.assertEquals(statusCode, 200);

		System.out.println("\n\n ----------------------------------------------- \n\n");
		Thread.sleep(3000);

	}
}
