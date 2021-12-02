package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LocationPopupPage extends BasicPage {

	public LocationPopupPage(WebDriver driver, WebDriverWait wait, JavascriptExecutor js, Actions actions) {
		super(driver, wait, js, actions);
	}

	public WebElement getLocationInHeader() {
		return driver.findElement(By.xpath("/html/body/header/div/div/div/div/div"));
	}

	public WebElement getCloseLocationBtn() {
		return driver.findElement(By.className("close-btn close-btn-white"));
	}

	public WebElement getLocationItem(String locationName) {
		return driver.findElement(By.xpath("//*[@id='location_id']"));
	}
	
	public WebElement getLocationInput() {
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

//	public void setLocation(String locationName) throws InterruptedException {
//		this.getKeyWord().click();
//		Thread.sleep(3000);
//		this.getgetLocationItem().click();
//		js.executeScript("arguments[0].click();", this.getSubmit());
//	}
	public void setLocation(String locationName) {
		this.getKeyWord().click();

		String dataValue = getLocationItem(locationName).getAttribute("data-value");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value=arguments[1];", getLocationInput(), dataValue);

		js.executeScript("arguments[0].click();", getSubmit());

	}
	

	public void closePopupLocation() throws InterruptedException {
	//	js.executeScript("arguments[0].click()", this.getCloseLocationBtn());
		Thread.sleep(300);
		this.getCloseLocationBtn().click();
	}
	
}
