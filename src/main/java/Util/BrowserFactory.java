package Util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {

	static WebDriver driver;
	static String browser;
	static String URL;

	public static void readConfig() {
		Properties prop = new Properties();
		try {
			InputStream input = new FileInputStream("src\\main\\java\\Config\\configfile.properties");
			prop.load(input);
			browser = prop.getProperty("browser");
			URL = prop.getProperty("URL");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

	}

	public static WebDriver init() {
		readConfig();
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get(URL);

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return driver;

	}

	public static void tearDown() {
		driver.close();

	}
}
