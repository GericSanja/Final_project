package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

public class ProfilePage extends BasicPage {

	public ProfilePage(WebDriver driver, WebDriverWait wait, JavascriptExecutor js, Actions actions) {
		super(driver, wait, js, actions);

	}

	public WebElement getFirstNameField() {
		return driver.findElement(By.xpath("//*[@name='user_first_name']"));
	}

	public WebElement getLastNameField() {
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

	public Select selectCountry() {
		return new Select(driver.findElement(By.xpath("//*[@name='user_country_id']")));
	}

	public Select selectState() {
		return new Select(driver.findElement(By.xpath("//*[@name='user_state_id']")));
	}

	public Select selectCity() {
		return new Select(driver.findElement(By.xpath("//*[@name = 'user_city']")));
	}

	public WebElement getSaveBtn() {
		return driver.findElement(By.xpath("btn_submit"));
	}

	public WebElement getCurrentPassword() {
		return driver.findElement(By.name("current_password"));
	}

	public WebElement getNewPassword() {
		return driver.findElement(By.name("new_password"));
	}

	public WebElement getConfirmNewPassword() {
		return driver.findElement(By.name("conf_new_password"));
	}
	
	public WebElement getAvatarArea () {
		return driver.findElement(By.className("avatar"));
	}
	public WebElement getProfileImgArea() {
		return this.driver.findElement(By.xpath("//*[@id=\"profileInfo\"]/div/div[1]/img"));
	}
	public WebElement getUploadPhotoBtn () {
		return driver.findElement(By.className("upload"));
	}
	public WebElement getRemovePhotoBtn () {
		return driver.findElement(By.className("remove"));
	}
	public WebElement getImageInput() {
		return this.driver.findElement(By.xpath("//*[@id='form-upload']/input"));
	}

	public void uploadProfilePicture(String imgName) throws IOException, AWTException, InterruptedException {
		actions.moveToElement(this.getProfileImgArea()).build().perform();
		this.getUploadPhotoBtn().click();
		Thread.sleep(1000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ESCAPE);
		robot.keyRelease(KeyEvent.VK_ESCAPE);
		String imgPath = new File(System.getProperty("user.dir") + "/img/" + imgName).getAbsolutePath();
		this.getImageInput();
		this.getImageInput().sendKeys(imgPath);
		Thread.sleep(1000);
	}

	public void setUserInformation(String firstName, String lastName, String address, String phoneNumber,
			String Zipcode, String country, String state, String city) throws InterruptedException {

		getFirstNameField().clear();
		getFirstNameField().sendKeys(firstName);

		getLastNameField().clear();
		getLastNameField().sendKeys(lastName);

		getAddressField().clear();
		getAddressField().sendKeys(address);

		getPhoneField().clear();
		getPhoneField().sendKeys(phoneNumber);

		getZipcodeField().clear();
		getZipcodeField().sendKeys(Zipcode);

		Thread.sleep(1000);
		selectCountry().deselectByVisibleText(country);

		Thread.sleep(1000);
		selectState().deselectByVisibleText(state);

		Thread.sleep(1000);
		selectCity().deselectByVisibleText(city);

		getSaveBtn().click();
	}
}
