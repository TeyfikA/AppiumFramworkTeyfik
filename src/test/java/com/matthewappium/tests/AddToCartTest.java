package com.matthewappium.tests;

import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.matthewappium.pageObjects.android.FormPage;
import com.matthewappium.testUtils.BaseTest;
import com.matthewappium.testUtils.ExtentReporterNG;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;

public class AddToCartTest extends BaseTest {

	@BeforeMethod
	public void preSetup() {
		productPage.setActivity();
	}

	@Test(dataProvider = "getData")
	public void addProductToCartCorrectlyTest(String name, String name2, String country, String genderMale)
			throws MalformedURLException, InterruptedException {
		
//		productPage.addProductBasedOnName(name);
//		System.out.println(productPage.getProductPrice(name));
//		
//		productPage.addProductBasedOnName(name2);
//		System.out.println(productPage.getProductPrice(name2));
		Double total = 0.0;
		total = productPage.addMultipleProductsBasedOnName(new ArrayList<String>(Arrays.asList(name, name2)));
		productPage.getCartButton().click();
		
		//System.out.println("TOTAL: "+total+" CARTPAGETOTAL: "+cartPage.getPurchaseTotal());
		Assert.assertEquals(total, cartPage.getPurchaseTotal());	
	
	}


	@DataProvider
	public Object[][] getData() {

		return new Object[][] { { "Converse All Star", "Jordan Lift Off", "Angola", "male" } };

	}

}
