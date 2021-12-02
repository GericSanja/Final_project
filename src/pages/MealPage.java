package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MealPage extends BasicPage {

	public MealPage(WebDriver driver, WebDriverWait wait, JavascriptExecutor js, Actions actions) {
		super(driver, wait, js, actions);
	}

	public WebElement getSelectFavourite() {
//		return this.driver.findElement(By.xpath("//*[@id='item_79']/i/svg/g"));
		return this.driver.findElement(By.className("itemfav"));

	}

	public WebElement getChooseMeal() {
		return this.driver.findElement(By.xpath("//*[@id=\"listing\"]/div[2]/div/div[1]/div/div/a/img"));

	}

	public WebElement getQuantity() {
		return this.driver.findElement(By.xpath("//*[@class='js-current-product-qty']"));

	}

	public WebElement getAddToCartButton() {
		return this.driver.findElement(By.xpath("//*[@class='js-proceedtoAddInCart']"));

	}

	public void addToTheCart(String amount) {
		this.getChooseMeal().click();
		this.getQuantity().clear();
		this.getQuantity();
		this.getAddToCartButton().click();

	}
	public void addToTheFavorite () {
		this.getSelectFavourite();
		this.getSelectFavourite().click();
		
	}


	public WebElement getErrorNotification() {
		return driver.findElement(By.xpath("//*[contains(@class, 'alert--success')]"));
	}

	public String getAddedMealText() {
		return driver.findElement(By.xpath("/html/body/div[2]/div")).getText();

	}

	public String getLocationErrorText() {
		return driver.findElement(By.xpath("/html/body/div[2]/div")).getText();
	}

	public String getAttentionText() {
		return driver.findElement(By.xpath("/html/body/div[2]/div")).getText();
	}

	public String getAddedToFavouritesText() {
		return driver.findElement(By.xpath("/html/body/div[2]/div")).getText();
	}

	public void waitUntilElementNotPresent() {
		wait.until(ExpectedConditions.attributeContains(getErrorNotification(), "hidden", "hidden"));
		System.out.println("Element is no longer visible.");
	}
	
}
