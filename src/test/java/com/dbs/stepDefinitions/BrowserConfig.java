package com.dbs.stepDefinitions;

import java.io.IOException;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.After;
import gherkin.formatter.model.Result;
public class BrowserConfig {

	
	public static WebDriver driver = null;
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest test;
	public static ExtentTest parentTest;
	public static ExtentTest childTest;
	public static ExtentTest subChildTest;
	public static String reportTime;
	String expectedResult;
	
	@Before
	public void beforeScenario(Scenario scenario) throws Throwable {
		 createReport();
		 System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");	 
		 driver = new ChromeDriver();	
		 driver.manage().window().maximize();
		 parentTest = extent.createTest("Compare Cards and Assert Values");

	}
	
	public void createReport() throws Throwable {
		reportTime = new SimpleDateFormat("yyyy-MM-dd_HH-mm zzz").format(Calendar.getInstance().getTime());
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "\\ExtentReports\\" + reportTime + "_Results.html");
		htmlReporter.setAppendExisting(true);
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("OS", "Windows");
		extent.setSystemInfo("Environment", "DBS");
		extent.setSystemInfo("Host Name", "Web Automation");
		htmlReporter.config().setTimeStampFormat("MMM dd,yyyy hh:mm:ss a zzz");
	    
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setDocumentTitle("Compare Credit Cards");
		htmlReporter.config().setReportName("Compare Credit Cards on DBS Home page");
		htmlReporter.config().setTheme(Theme.STANDARD);
	    htmlReporter.config().setFilePath(System.getProperty("user.dir")+"//ExtentReports//");
	    
	   }
	
	@After
	public void afterScenario(Scenario scenario) throws Throwable {
		 extent.flush();		 
	}
}
