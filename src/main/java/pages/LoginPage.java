package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
		
	
//	public LoginPage(WebDriver driver) {
//		this.driver=driver;
//		
//	}
	
	@FindBy(xpath="//input[@id='user_name']") private WebElement userName;
	@FindBy(xpath="//input[@id='password']")private WebElement password;
	@FindBy(xpath="//button[@id='login_submit']")private WebElement submit;
	
	public void insertUserName(String name) {
		userName.sendKeys(name);
	}
	
	public void insertPassword(String pswd) {
		password.sendKeys(pswd);
	}
	public void clickSubmit() {
		submit.click();
	}
}
