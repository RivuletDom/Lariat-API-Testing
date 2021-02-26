/*
 * package test.java.MarComAPI;
 * 
 * import org.testng.annotations.Test;
 * 
 * import com.aventstack.extentreports.ExtentReports; import
 * com.aventstack.extentreports.ExtentTest; import
 * com.aventstack.extentreports.Status; import
 * com.aventstack.extentreports.reporter.ExtentHtmlReporter; import
 * com.aventstack.extentreports.reporter.configuration.Protocol; import
 * com.aventstack.extentreports.reporter.configuration.Theme;
 * 
 * import org.testng.annotations.BeforeSuite; import
 * org.testng.annotations.AfterSuite;
 * 
 * public class Base {
 * 
 * public static ExtentHtmlReporter htmlReporter; public static ExtentReports
 * extent; public static ExtentTest test;
 * 
 * 
 * @BeforeSuite public void beforeSuite() { // htmlReporter = new
 * ExtentHtmlReporter(System.getProperty("user.dir") + //
 * "\\ExtentReports\\Automation_Report_"+ dateFormat.format(new Date()) + //
 * ".html");
 * 
 * // test = extent.createTest("Site Launch"); // test.log(Status.PASS,
 * "Launched success");
 * 
 * 
 * htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +
 * "/ExtentReports/API_Report.html"); extent = new ExtentReports();
 * extent.attachReporter(htmlReporter); //
 * htmlReporter.loadXMLConfig(".resources/extent-config.xml");
 * 
 * htmlReporter.config().setEncoding("utf-8");
 * htmlReporter.config().setJS("js-string");
 * htmlReporter.config().setProtocol(Protocol.HTTPS);
 * 
 * htmlReporter.config().setReportName("Tarang | API Automation Report");
 * htmlReporter.config().setDocumentTitle("API-Automation Report");
 * htmlReporter.config().setTheme(Theme.DARK);
 * 
 * htmlReporter.config().setCSS(
 * "body > nav > div > a > img { content:url('http://tarangchokshi.in/assets/img/apple-touch-icon.png') }"
 * ); System.out.println("report being generated"); }
 * 
 * @AfterSuite public void afterSuite() {
 * System.out.println("report generated");
 * 
 * extent.flush(); }
 * 
 * }
 */