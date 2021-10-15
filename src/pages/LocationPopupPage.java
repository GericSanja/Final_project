package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LocationPopupPage extends BasicPage {

	public LocationPopupPage(WebDriver driver, WebDriverWait wait, JavascriptExecutor js) {
		super(driver, wait, js);
	}

	public WebElement getLocationInHeader() {
		return driver.findElement(By.xpath("/html/body/header/div/div/div/div/div"));
	}

	public WebElement getCloseLocationBtn() {
		return driver.findElement(By.className("close-btn close-btn-white"));
	}

	public WebElement getgetLocationItem() {
		return driver.findElement(By.xpath("//*[@id='location_id']"));
	}

	public WebElement getKeyWord() {
		return driver.findElement(By.xpath("//*[@id='locality_keyword']"));
	}

	public WebElement getSubmit() {
		return driver.findElement(By.xpath("//*[@name='btn_submit']"));
	}

	public void openPopupLocation() {
		this.getLocationInHeader().click();
	}

	public void setLocation() throws InterruptedException {
		this.getKeyWord().click();
		Thread.sleep(3000);
		this.getgetLocationItem().click();
		js.executeScript("arguments[0].click();", this.getSubmit());
	}

	public void closePopupLocation() {
		js.executeScript("arguments[0].click()", this.getCloseLocationBtn());
	}
}
