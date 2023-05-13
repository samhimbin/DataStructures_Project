package driverFactory;

import java.time.Duration;
import java.util.ResourceBundle;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import utils.LoggerLoad;

public class DriverSetUp {
	private static WebDriver driver;
	// public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();
	static ResourceBundle rb; // for reading properties file
	static String browserType ;// to store browser name

	public static WebDriver getDesireDriver() {

		rb = ResourceBundle.getBundle("Config");
		 browserType = rb.getString("browser");

		if (browserType.equals("Chrome")) {
			LoggerLoad.info("enter getchromedriver");
			/*
			 * System.setProperty("webdriver.chrome.driver",
			 * ".\\src/test/resources/drivers/chromedriver.exe"); ChromeOptions options=new
			 * ChromeOptions(); options.addArguments("--remote-allow-origins=*");
			 * options.addArguments("--incognito"); driver=new ChromeDriver(options);
			 */

			WebDriverManager.chromedriver().setup();
			// tlDriver.set(new ChromeDriver());
			driver = new ChromeDriver();
		}
		/*
		 * else if br.equals("FIREFOX"){ //Firefox
		 * WebDriverManager.firefoxdriver().setup(); tlDriver.set(new FirefoxDriver());
		 * }
		 */
		else if (browserType.equals("edge")) {
			// System.setProperty("webdriver.msedge.driver","C:/Users/sange/OneDrive/Desktop/Drivers/msedgedriver.exe");
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}

		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		// return getDriver();
		return driver;
	}

	public static void openPage(String url) {
		getDriver().get(url);
	}

	public static String getTitle() {
		return getDriver().getTitle();
	}

	public static void NavBack() {
		getDriver().navigate().back();
	}

	public static WebDriver getDriver() {
		LoggerLoad.info("enter getdriver");
		// return tlDriver.get();
		return driver;
	}

	public static void setUpDriver() {
		if (getDriver() == null) {
			getDesireDriver();
		}
	}

	public static void setBrowserType(String browser) {
		browserType = browser;
	
	}
    public static String getBrowserType() {
    	if(browserType!=null)
    		
			return browserType;
		else
			throw new RuntimeException("browser not exists");
    }
	public static void tearDown() {
		if (getDriver() != null) {
			LoggerLoad.info("enter teardown");
			getDriver().close();
			getDriver().quit();
		}
		driver = null;
	}

}
