package com.qa.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class DriverFactory {

	public static WebDriver driver;

	public void init_driver(String browser) {

		System.out.println("browser value is: " + browser);

		if (browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\lilesh bansal\\git\\HybridFramework\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {
			System.setProperty("webdriver.firefox.driver","C:\\Users\\lilesh bansal\\git\\HybridFramework\\Drivers\\firefoxDriver.exe");
			driver = new FirefoxDriver();
		} else if (browser.equals("safari")) {
			System.setProperty("webdriver.ie.driver","C:\\Users\\lilesh bansal\\git\\HybridFramework\\Drivers\\geckodriver.exe");
			driver = new InternetExplorerDriver();
		} else {
			System.out.println("Please pass the correct browser value: " + browser);
		}

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
	}
	
	/*public void extentReport() {
		
		ExtentHtmlReporter r= new ExtentHtmlReporter("./PdfReport/ExtentHtml.html");
		ExtentReports r1 = new ExtentReports();
		//ExtentTest t = new ExtentTest(r1, null, null, null);
		r1.attachReporter(r);
		
	}*/
	
	

}
