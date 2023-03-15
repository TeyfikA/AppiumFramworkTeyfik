package com.matthewappium.testUtils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	
	public static ExtentReports extent;

	public static ExtentReports getReporterObject() {
		
		// Extent Reports
				String path = "C:\\Users\\the_g\\eclipse-workspace\\AppiumFrameworkDesign\\ExtentReports\\index.html";
				ExtentSparkReporter reporter = new ExtentSparkReporter(path);
				reporter.config().setReportName("MainActivity Form Automation Results");
				reporter.config().setDocumentTitle("Test Results");
				
				extent = new ExtentReports();
				extent.attachReporter(reporter);
				extent.setSystemInfo("Tester", "Matthew Price");
				
				return extent;
	}

}
