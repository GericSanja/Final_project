package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NotificationSistemPage extends BasicPage {

	public NotificationSistemPage(WebDriver driver, WebDriverWait wait, JavascriptExecutor js, Actions actions) {
		super(driver, wait, js, actions);
	}

	public WebElement getLoginMessageElement() {
		return this.driver.findElement(By.xpath("//*[contains(@class, 'alert--success')"));
	}

	public WebElement getSetUpMessageElement() {
		return this.driver.findElement(
				By.xpath("//*[contains(@class, 'system_message alert alert--positioned-top-full alert--success')"));
	}

	public WebElement getLogoutMessageElement() {
		return this.driver.findElement(By.xpath("//*contains(@class, 'system_message alert alert--success')"));
	}
	public void waitMessageToDispear() {
		wait.until(ExpectedConditions.attributeContains(By.xpath("//*[contains(@class, 'system_message')]"), "style",
				"display: none;"));
	}

	public String logoutMessage() {
		String message = getLogoutMessageElement().getText();
		return message;
	}

	public String setUpmMessage() {
		String message = getSetUpMessageElement().getText();
		return message;
	}
	public WebElement getMessage() {
		return driver.findElement(By.xpath(
				"//*[contains(@class, 'alert--success') or contains(@class, 'alert--danger')][contains(@style,'display: block')]"));
	}
	public String returnMessage() {
		return driver.findElement(By.xpath(
				"//*[contains(@class, 'alert--success') or contains(@class, 'alert--danger')][contains(@style,'display: block')]"))
				.getText();

	}

}
