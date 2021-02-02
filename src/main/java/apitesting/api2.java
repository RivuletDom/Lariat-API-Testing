package apitesting;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class api2 extends login{
  @Test
  public void f() {   
		
		
		RestAssured.baseURI ="https://marcom20-production.whitelabeliq.net/";
		 RequestSpecification request = RestAssured.given();
		 request.header("Content-Type", "application/json");
		 request.header("Authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJhdWQiOiIxIiwianRpIjoiMGI5ZTc4MzhmZWZmZThkZmVjYzM3N2JmNThjOGQxMDdmN2NjY2NiNTU1MzE3NThmZDU3ZWE4MTQ4OWNhZDE4MzZkZTE0OTIxNjQyZDlkNDYiLCJpYXQiOjE2MTIyNjI4NDgsIm5iZiI6MTYxMjI2Mjg0OCwiZXhwIjoxNjQzNzk4ODQ4LCJzdWIiOiI1OCIsInNjb3BlcyI6W119.l7udRn8KPezPLig0sbsFctHY8CeIPuEARymzFAWUbhS5ZdCvxiTkm8-V08JfQzc8krw6oBx89Sw6dkpT9tRdXGQtJSoCiiIS_8vJa9rcqbfs8BXCpNxy4WLMqPp2_m-2-R5b7fivqrt6T2mo8vndn6wD3HxqD2m5BG75qQG3vR6n5RLD1RdrImAaOT_cMSTFQiJYuFgIlLKpzEhBrEKMM7P9g5ZHH136kYmIb7eMd_mMVcjeK0_-u7AmvaXyZGP4hSo1Z35OFNak-52QO01d4uFblE818xy5yeyNDkqIcMzAM9_n8vsxPICVpXrnXNrOgRe6B6W14K7XfEoy_NCazKo9hQHr1OzJDaHFphfmA41l5a5vMrwFrgStKlCKrf1-vKWYNac_JwRL2aWy97jIp0nReobjqMeHcHtTTKCBbYLE-V4sRZDGkfErjm8MROuNP1Uk1Qe6j18DBBmVCWrfInfhAKkW3DLtwnnwbCLeTRNPz3s8DzpRCPuRPgFYLyAT8SQO_VlSupk80l5Bc5CeXiK9qSPa8QUTSwhxeXidLCaEXbJFP6AmkdWlZ6NqE1-Lco1X0gK3iwTb50ZDoD-t5G6kAZhaUfK7SoozJMPBsJ-5tero9rfHUsGC_jPIhKpsij3D4Y-f2Me6jtAxQlULYT70UJMn27b1yc4S8hhwtQw");
		 
		 JSONObject requestParams = new JSONObject();
		 requestParams.put("user_id", "58");
		 requestParams.put("workspace_id", "278054311");
		 
		 request.body(requestParams.toJSONString());
		 
		 Response response = request.post("api/v1/user/details?url_workspace_id=278054311");
		 int statusCode = response.getStatusCode();
		 
		 System.out.println("The status code recieved: " + statusCode);
		 
		 System.out.println("Response body: " + response.getBody().jsonPath().prettify());
//		 System.out.println("token : " + (response.getBody().jsonPath().get("data.access_token")));
		 
		 String token = response.getBody().jsonPath().get("data.access_token");
		 System.out.println("token : " +token);
		 
		 Assert.assertEquals(statusCode, 200);
		 

	}
}
