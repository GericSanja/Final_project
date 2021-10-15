package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage extends BasicPage {

	public ProfilePage(WebDriver driver, WebDriverWait wait, JavascriptExecutor js) {
		super(driver, wait, js);

	}

	public WebElement getFirstNameField() {
		return driver.findElement(By.xpath("//*[@name='user_first_name']"));
	}

	public WebElement getFirstLastField() {
		return driver.findElement(By.xpath("//*[@name='user_last_name']"));
	}

	public WebElement getEmailField() {
		return driver.findElement(By.xpath("//*[@name='user_email']"));
	}

	public WebElement getAddressField() {
		return driver.findElement(By.xpath("//*[@name='user_address']"));
	}

	public WebElement getPhoneField() {
		return driver.findElement(By.xpath("//*[@name='user_phone']"));
	}

	public WebElement getZipcodeField() {
		return driver.findElement(By.xpath("//*[@name='user_zip']"));
	}

	public WebElement getPCountryField() {
		return driver.findElement(By.xpath("//*[@name='user_country_id']"));
	}

	public WebElement getStateField() {
		return driver.findElement(By.xpath("//*[@name='user_state_id']"));
	}

}
