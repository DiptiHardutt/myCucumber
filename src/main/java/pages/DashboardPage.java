package pages;

import org.openqa.selenium.WebDriver;

public class DashboardPage extends BasePage {

	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		
	}
	public String getTitle() {
		return driver.getTitle();
	}
}
