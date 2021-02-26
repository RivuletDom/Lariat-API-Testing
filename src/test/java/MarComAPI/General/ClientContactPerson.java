package test.java.MarComAPI.General;

import org.json.simple.JSONObject;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import test.java.MarComAPI.Login.login;

public class ClientContactPerson extends login {
	public static String clientemail;
	@Test
	public void ClientContactPersonDetail() throws Throwable {

		System.out.println(" *** API: List of Client Contact Person  *** \n" );
		general = extent.createTest("API Testing for General API request");

		String token = login_marcom();
		
		RestAssured.baseURI = "https://marcom20-production.whitelabeliq.net/";
		general.log(Status.INFO, "Request API info: List of Client Contact Person ");

		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		System.out.println("Token : " + token);
		request.header("Authorization", "Bearer " + token);

		JSONObject requestParams = new JSONObject();
		requestParams.put("workspace_id", workspace_id);
		requestParams.put("client_id", "71");
		requestParams.put("person_id", "2");

		request.body(requestParams.toJSONString());

		Response response = request.post("api/v1/client/contact-person?url_workspace_id=278054311");
		int statusCode = response.getStatusCode();

		System.out.println("The status code recieved: " + statusCode);

		System.out.println("Response body: " + response.getBody().jsonPath().prettify());

		AssertJUnit.assertEquals(statusCode, 200);
		
		clientemail = response.getBody().jsonPath().get("data.email");
		System.out.println(clientemail);

		System.out.println("\n\n ------------------------------------------------ \n\n");
		Thread.sleep(3000);
		
	}
	

}
