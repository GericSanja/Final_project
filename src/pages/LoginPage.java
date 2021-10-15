package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasicPage{

	public LoginPage(WebDriver driver, WebDriverWait wait, JavascriptExecutor js) {
		super(driver, wait, js);
	}
	
	public WebElement getUsername () {
		return driver.findElement(By.name("username"));
	}
	public WebElement getPassword () {
		return driver.findElement(By.name("password"));
	}
	public WebElement getRememberMe () {
		return driver.findElement(By.name("btn_submit"));
	}
	public WebElement getSubmit () {
		return driver.findElement(By.name("remember_me"));
	}
	public void markRememberMe () {
	this.getRememberMe().click();
	}
	public void userLogin () throws InterruptedException {
		//provera
		this.getUsername().sendKeys(Keys.CONTROL + " ", Keys.DELETE);
		Thread.sleep(3000);
		this.getPassword().sendKeys(Keys.CONTROL + " ", Keys.DELETE);
		Thread.sleep(3000);
		this.getUsername().sendKeys("customer@dummyid.com");
		Thread.sleep(3000);
		this.getPassword().sendKeys("12345678a");
		Thread.sleep(3000);
		this.getSubmit().click();
	}

}
