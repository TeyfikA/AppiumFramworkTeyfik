package com.matthewappium.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;


public class AndroidActions extends AppiumUtils{
	
	public AndroidDriver driver;
	
	public AndroidActions(AndroidDriver driver) {
//		super(driver);
		this.driver = driver;
	}
	
	public boolean checkIfActiveElement(WebElement ele) {

		if (ele.equals(driver.switchTo().activeElement())) {
			return true;

		}
		return false;
	}

	public void longPressAction(WebElement ele) {
		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) ele).getId(), "duration", 2000));
	}

	public void openAtActivityWindowAction(String packageName, String appActivityName) {
		// adb shell dumpsys window | grep -E 'mCurrentFocus' ---> MAC
		// adb shell dumpsys window | find "mCurrentFocus" ----> WINDOWS

		Activity activity = new Activity(packageName, appActivityName);
		driver.startActivity(activity);
	}

	public void swipeWithElementAction(WebElement ele, String direction, double percent) {
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of("elementId",
				((RemoteWebElement) ele).getId(), "direction", direction, "percent", percent));
	}

	public boolean canScrollMoreAction(int left, int top, int width, int height, String direction, double percent) {

		boolean canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture",
				ImmutableMap.of("left", left, "top", top, "width", width, "height", height, "direction", direction,
						"percent", percent));

		return canScrollMore;

	}
	
	public void clickDropDownBasedOnText(String text) {
		scrollIntoViewAction(text);
		driver.findElement(By.xpath(String.format("//android.widget.TextView[@text='%s']", text))).click();
	}

	public void scrollToEndAction() {
		
		while (canScrollMoreAction(100, 100, 200, 200, "down", 3.0)) {
			canScrollMoreAction(100, 100, 200, 200, "down", 3.0);
		}
		
	}

	public void dragAndDropAction(WebElement ele, int endXCoordinates, int endYCoordinates) {

		((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of("elementId",
				((RemoteWebElement) ele).getId(), "endX", endXCoordinates, "endY", endYCoordinates));
	}

	public void rotateDeviceAction(int x, int y, int z) {

		DeviceRotation r = new DeviceRotation(x, y, z);
		driver.rotate(r);
	}

	public void scrollIntoViewAction(String nameItemScrollingTo) {

		String info = nameItemScrollingTo;
		String s1 = String.format("new UiScrollable(new UiSelector()).scrollIntoView(text(\"%s\"));", info);
		driver.findElement(AppiumBy.androidUIAutomator(s1));
	}
	

}
