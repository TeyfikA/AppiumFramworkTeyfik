package com.matthewappium.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.appium.java_client.AppiumDriver;

public abstract class AppiumUtils {
	
	AppiumDriver driver;
	
//	public AppiumUtils(AppiumDriver driver) {
//		this.driver = driver;
//	}
//	
	public Double getFormattedAmount(String amount) {
		return Double.parseDouble(amount.substring(1));
	}
	
	public String getScreenShotPath(AppiumDriver driver, String testCaseName) throws IOException {
		
		File source = driver.getScreenshotAs(OutputType.FILE);
		System.out.println(source);
		String destinationFile = "C://Users//the_g//eclipse-workspace//AppiumFrameworkDesign//ExtentReports//Screenshots//" +testCaseName+".png";
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;
		
		
	}

}
