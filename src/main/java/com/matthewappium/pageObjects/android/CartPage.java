package com.matthewappium.pageObjects.android;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.matthewappium.utils.AndroidActions;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;

public class CartPage extends AndroidActions {

	AndroidDriver driver;

	public CartPage(AndroidDriver driver) {

		super(driver);
		this.driver = driver;
		// this.dropMenu =
		// driver.findElement(By.xpath("//android.widget.TextView[@text='Afghanistan']"));

	}

	
	public WebElement getBackButton() {
		return driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/appbar_btn_back"));
	}
	
	public WebElement getTotalPurchaseAmount() {
		return driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/totalAmountLbl"));
	}
	
	public WebElement getCheckBox() {
		return driver.findElement(AppiumBy.xpath("//android.widget.CheckBox[@text='Send me e-mails on discounts related to selected products in future']"));
	}
	
	public WebElement getProceedButton() {
		return driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnProceed"));
	}
	
	public WebElement getPageTitle() {
		return driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/toolbar_title"));
	}
	

	// ACTION METHODS
	
	public Double getPurchaseTotal() {
		return getFormattedAmount(getTotalPurchaseAmount().getText());
	}
	

	public void setActivity() {
		Activity activity = new Activity("com.androidsample.generalstore",
				"com.androidsample.generalstore.CartActivity");
		driver.startActivity(activity);
	}



}
