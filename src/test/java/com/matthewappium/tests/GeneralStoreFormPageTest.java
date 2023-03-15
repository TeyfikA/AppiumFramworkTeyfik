package com.matthewappium.tests;

import org.testng.annotations.Test;
import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import com.matthewappium.testUtils.BaseTest;

public class GeneralStoreFormPageTest extends BaseTest {

	@BeforeMethod
	public void preSetup() {
		formPage.setActivity();
	}

	@Test(dataProvider = "getData", groups= {"first"})
	public void correctInfoAddedFormSubmit(String name, String genderFemale, String country, String genderMale)
			throws MalformedURLException, InterruptedException {

		formPage.writeInNameField(name);
		formPage.setGender(genderFemale);
		formPage.getDropMenu().click();
		formPage.clickDropDownBasedOnText(country);
		formPage.submitForm();
		Assert.assertEquals(true, false);
	}

	@Test(dataProvider = "getData")
	public void incorrectInfoAddedFormSubmit(String name, String genderFemale, String country, String genderMale)
			throws MalformedURLException, InterruptedException {

		formPage.writeInNameField("");
		formPage.setGender(genderMale);
		formPage.getDropMenu().click();
		formPage.clickDropDownBasedOnText(country);
		formPage.submitForm();

	}

	@DataProvider
	public Object[][] getData() {

		return new Object[][] { { "Matthew Price", "female", "Angola", "male" } };

	}

}
