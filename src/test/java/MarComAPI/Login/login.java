package test.java.MarComAPI.Login;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Protocol;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class login {

	public static String barriertoken = "";
	public static String email = "marcom.jassi@gmail.com";
	public static String password = "marcom2020";
	public static int user_id = 58;
	public static int workspace_id = 278054311;

	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest login;
	public static ExtentTest bucket;

	static DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy_HHmmss");

	@BeforeSuite
	public void beforeSuite() {
		 htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/ExtentReports/API_Report_"+ dateFormat.format(new Date()) +".html");

//		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/ExtentReports/API_Report.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
//		htmlReporter.loadXMLConfig(".resources/extent-config.xml");

		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setJS("js-string");
		htmlReporter.config().setProtocol(Protocol.HTTPS);

		htmlReporter.config().setReportName("Tarang | API Automation Report");
		htmlReporter.config().setDocumentTitle("API-Automation Report");
		htmlReporter.config().setTheme(Theme.DARK);

		htmlReporter.config().setCSS(
				"body > nav > div > a > img { content:url('http://tarangchokshi.in/assets/img/apple-touch-icon.png') }");
		System.out.println("report being generated");
	}

	@Test
	public String login_marcom() {

		login = extent.createTest("Login into MarCom");
		
		RestAssured.baseURI = "https://marcom20-production.whitelabeliq.net/";
		login.log(Status.INFO, "Request API info: Login into MarCom ");
		
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");

		JSONObject requestParams = new JSONObject();
		requestParams.put("email", email);
		requestParams.put("password", password);

		login.log(Status.INFO, "Login with username: "+email + " & password: " +password );

		request.body(requestParams.toJSONString());

		Response response = request.post("/api/v1/login");
		int statusCode = response.getStatusCode();

		System.out.println("The status code recieved: " + statusCode);
		
		login.log(Status.PASS, "Login successfull; Status code received : " +statusCode);


		System.out.println("Response body: " + response.getBody().jsonPath().prettify());

		Assert.assertEquals(statusCode, 200);

//		token1 = response.getBody().jsonPath().get("data.access_token");
//		System.out.println("Token of Email id "+ email + " is " + token1);
		return response.getBody().jsonPath().get("data.access_token");

	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("report generated");

		extent.flush();
	}
}
