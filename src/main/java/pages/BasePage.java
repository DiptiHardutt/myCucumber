package pages;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BasePage {
	
public WebDriver driver;
String browser;

public static String getProperty(String key) {
	Properties properties = new Properties();
	try {
		FileReader fr = new FileReader("C:\\Users\\shavo\\Selenium_June23\\myCucumber\\src\\main\\java\\util\\config.properties");
		properties.load(fr);
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
	
	
	return properties.getProperty(key);
	
}
	public WebDriver initDriver() {
		browser = getProperty("browser");
		String browser = System.getProperty("browser")!=null ? System.getProperty("browser") :getProperty("browser");
		
		try {
			if(browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
				driver = new ChromeDriver();
			}else if(browser.equalsIgnoreCase("edge")) {
				System.setProperty("webdriver.edge.driver", "drivers\\msedgedriver.exe");
				driver = new EdgeDriver();
			}else if(browser.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", "drivers\\geckodriver.exe");
				driver = new FirefoxDriver();
			}else {
				System.out.println("please enter a valid browser");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
		
	}
	
}
