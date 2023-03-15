package com.matthewappium.pageObjects.android;

import org.openqa.selenium.WebElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import com.matthewappium.utils.AndroidActions;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;

public class FormPage extends AndroidActions {

	AndroidDriver driver;
	

	public FormPage(AndroidDriver driver) {

		super(driver);
		this.driver = driver;
		// this.dropMenu =
		// driver.findElement(By.xpath("//android.widget.TextView[@text='Afghanistan']"));
//		PageFactory.initElements(new AppiumFieldDecorator(driver),this);

	}
	
//	@AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
//	private WebElement nameField;
	

	public WebElement getNameField() {
		return driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/nameField"));
	}

	public WebElement getMaleOption() {
		return driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/radioMale"));
	}

	public WebElement getFemaleOption() {
		return driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/radioFemale"));
	}

	public WebElement getDropMenu() {
		return driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/spinnerCountry"));
	}


	public WebElement getSubmitButton() {
		return driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop"));
	}


	// ACTION METHODS
	public void writeInNameField(String name) {
		 getNameField().sendKeys(name);
	}

	public void submitForm() {
		getSubmitButton().click();
	}

	public void setActivity() {
		//adb shell dumpsys window | find "mCurrentFocus"
		Activity activity = new Activity("com.androidsample.generalstore",
				"com.androidsample.generalstore.MainActivity");
		driver.startActivity(activity);
	}

	public void setGender(String radioButtonName) {
		if (radioButtonName.equalsIgnoreCase("male")) {
			getMaleOption().click();
		} else if (radioButtonName.equalsIgnoreCase("female")) {
			getFemaleOption().click();
		} else {
			System.out.println("No correct option selected, please enter: MALE or FEMALE as options");
		}

	}

}
