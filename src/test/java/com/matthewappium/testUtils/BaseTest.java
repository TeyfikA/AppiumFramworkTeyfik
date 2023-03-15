package com.matthewappium.testUtils;

import org.testng.annotations.BeforeClass;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.testng.annotations.AfterClass;

import com.matthewappium.pageObjects.android.CartPage;
import com.matthewappium.pageObjects.android.FormPage;
import com.matthewappium.pageObjects.android.ProductPage;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseTest {

	public AndroidDriver driver;
	public AppiumDriverLocalService service;
	public FormPage formPage;
	public ProductPage productPage;
	public CartPage cartPage;

	// SWITCHING CONTEXT BETWEEN THE APP AND IN MOBILE BROWSER REQUIRES
	// driver.context("insert_context_here");
	// YOU CAN FIND THE CONTEXT WITH THIS CODE Set<String> contexts =
	// driver.getContextHandles();
	// then loop through the contexts outputting them to the system

	@BeforeClass(alwaysRun=true)
	public void configureAppium() throws InterruptedException, IOException {
		
		Properties props = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\the_g\\eclipse-workspace\\AppiumFrameworkDesign\\src\\main\\java\\com\\matthewappium\\resources\\data.properties");
		props.load(fis);
		String ipAdress = props.getProperty("ipAddress");
		String port = props.getProperty("port");
		String emulator = props.getProperty("androidDeviceName");
		
		// Code to start the server
		service = new AppiumServiceBuilder()
				.withAppiumJS(
						new File("C:\\Users\\the_g\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress(ipAdress).usingPort(Integer.parseInt(port)).build();
		// Start the service
		service.start();

		// AndroidDriver, IOSDriver
		// Appium code -> Appium Server -> Mobile
		// What Operating system do you want to trigger on
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName(emulator);
		options.setChromedriverExecutable(
				"C:\\Users\\the_g\\eclipse-workspace\\Appium\\src\\test\\java\\resources\\chromedriver.exe");

		String generalStore = "C:\\Users\\the_g\\eclipse-workspace\\Appium\\src\\test\\java\\resources\\General-Store.apk";
		String apiDemos = "C:\\Users\\the_g\\eclipse-workspace\\Appium\\src\\test\\java\\resources\\ApiDemos-debug.apk";
		options.setApp(generalStore);
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		formPage = new FormPage(driver);
		productPage = new ProductPage(driver);
		cartPage = new CartPage(driver);

	}

	@AfterClass(alwaysRun=true)
	public void tearDown() {
		driver.quit();
		service.stop();
		// Stop server
	}

}
