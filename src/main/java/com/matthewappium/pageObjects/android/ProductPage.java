package com.matthewappium.pageObjects.android;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.matthewappium.utils.AndroidActions;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;

public class ProductPage extends AndroidActions {

	AndroidDriver driver;

	public ProductPage(AndroidDriver driver) {

		super(driver);
		this.driver = driver;
		// this.dropMenu =
		// driver.findElement(By.xpath("//android.widget.TextView[@text='Afghanistan']"));

	}

	public List<WebElement> getProducts() {
		return driver.findElements(By.id("com.androidsample.generalstore:id/productName"));
	}

	public List<WebElement> getAddToCartButtons() {
		return driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart"));
	}

	public List<WebElement> getProductPrices() {
		return driver.findElements(AppiumBy.id("com.androidsample.generalstore:id/productPrice"));
	}
	
	public WebElement getCartButton() {
		return driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/appbar_btn_cart"));
	}


	// ACTION METHODS
	public void addProductBasedOnName(String name) {
		scrollIntoViewAction(name);
		
		ArrayList<WebElement> currentList = (ArrayList<WebElement>) getProducts();
		ArrayList<WebElement> addToCartList = (ArrayList<WebElement>) getAddToCartButtons();
		
		for (int i =0; i<currentList.size(); i++) {
			if(currentList.get(i).getText().equalsIgnoreCase(name)) {
				addToCartList.get(i).click();
			}
		}
	}
	
	public Double addMultipleProductsBasedOnName(List<String> names) {
		Double total = 0.0;
		for (String name : names) {
			scrollIntoViewAction(name);
			
			ArrayList<WebElement> currentList = (ArrayList<WebElement>) getProducts();
			ArrayList<WebElement> addToCartList = (ArrayList<WebElement>) getAddToCartButtons();
			ArrayList<WebElement> productPrices = (ArrayList<WebElement>) getProductPrices();
			
			for (int i =0; i<currentList.size(); i++) {
				if(currentList.get(i).getText().equalsIgnoreCase(name)) {
					addToCartList.get(i).click();
					total += getFormattedAmount(productPrices.get(i).getText());
				}
			}
			
		}
		return total;
	}
	
	public Double getProductPrice(String name) {
		scrollIntoViewAction(name);
		
		ArrayList<WebElement> currentList = (ArrayList<WebElement>) getProducts();
		ArrayList<WebElement> productPrices = (ArrayList<WebElement>) getProductPrices();
		
		for (int i =0; i<currentList.size(); i++) {
			if(currentList.get(i).getText().equalsIgnoreCase(name)) {
				return getFormattedAmount(productPrices.get(i).getText());			
			}
		}
		
		return null;
		
	}

	public void setActivity() {
		Activity activity = new Activity("com.androidsample.generalstore",
				"com.androidsample.generalstore.AllProductsActivity");
		driver.startActivity(activity);
	}



}
