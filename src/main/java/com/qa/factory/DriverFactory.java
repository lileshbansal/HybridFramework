package com.qa.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	public static WebDriver driver;

	//public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
	

	/**
	 * This method is used to initialize the thradlocal driver on the basis of given
	 * browser
	 * 
	 * @param browser
	 * @return this will return tldriver.
	 */
	public void init_driver(String browser) {

		System.out.println("browser value is: " + browser);

		if (browser.equals("chrome")) {
			//WebDriverManager.chromedriver().setup();
			//tlDriver.set(new ChromeDriver());
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\lilesh bansal\\git\\HybridFramework\\Drivers\\chromedriver.exe");
		    driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			//tlDriver.set(new FirefoxDriver());
		} else if (browser.equals("safari")) {
			//tlDriver.set(new SafariDriver());
		} else {
			System.out.println("Please pass the correct browser value: " + browser);
		}

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		//return driver;
	}
	}

	/**
	 * this is used to get the driver with ThreadLocal
	 * 
	 * @return
	 *//*
	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}
}*/
