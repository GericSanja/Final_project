package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AuthPage extends BasicPage {

	public AuthPage(WebDriver driver, WebDriverWait wait, JavascriptExecutor js, Actions actions) {
		super(driver, wait, js, actions);
	}

	public WebElement getAuth() {
		return driver.findElement(By.xpath("/html/body/header/div[2]/div/div[2]/div[2]"));
	}

	public WebElement getMyAccount() {
		return driver.findElement(By.xpath("//*[text()='My Account']"));

	}

	public WebElement getLogout() {
		return driver.findElement(By.xpath("//*[text()='Logout']"));

	}

	public void logut() {
		this.getAuth().click();
		this.getLogout().click();
	}
}
