package Tests;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.io.FileHandler;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import pages.AuthPage;
import pages.CartSummaryPage;
import pages.LocationPopupPage;
import pages.LoginPage;
import pages.MealPage;
import pages.NotificationSistemPage;
import pages.ProfilePage;

public class BasicTest {

	protected WebDriver driver;
	protected WebDriverWait wait;
	protected JavascriptExecutor js;

	// pages

	protected LocationPopupPage locationPopupPage;
	protected LoginPage loginPage;
	protected NotificationSistemPage notificationSistemPage;
	protected ProfilePage profilePage;
	protected AuthPage authPage;
	protected MealPage mealPage;
	protected CartSummaryPage cartSummaryPage;

	protected String baseUrl = "https://demo.yo-meals.com/";
	protected String loginPageUrl = baseUrl + "guest-user/login-form";
	protected String profilePageUrl = baseUrl + "member/profile";
	protected String lscqComboUrl = baseUrl + "meal/lobster-shrimp-chicken-quesadilla-combo";
	protected String mealsPageUrl = baseUrl + "meals";

	protected String username = "customer@dummyid.com";
	protected String password = "12345678a";

	@BeforeMethod
	public void beforeMethod() throws SecurityException, IOException {

		System.setProperty("webdriver.chrome.driver", "driver-lib\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 10);
		Actions actions = new Actions(driver);
		FileHandler fh = new FileHandler();

		this.locationPopupPage = new LocationPopupPage(driver, wait, js, actions);
		this.loginPage = new LoginPage(driver, wait, js, actions);
		this.profilePage = new ProfilePage(driver, wait, js, actions);
		this.authPage = new AuthPage(driver, wait, js, actions);
		this.mealPage = new MealPage(driver, wait, js, actions);
		this.notificationSistemPage = new NotificationSistemPage(driver, wait, js, actions);
		this.cartSummaryPage = new CartSummaryPage(driver, wait, js, actions);

	}

	@AfterMethod
	public void screeenshot(ITestResult result) throws InterruptedException {

		if (ITestResult.FAILURE == result.getStatus()) {
			try {
				TakesScreenshot ts = ((TakesScreenshot) driver);
				File scrShot = ts.getScreenshotAs(OutputType.FILE);
				Date date = new Date();
				SimpleDateFormat dtf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
				FileHandler.copy(scrShot, new File("screenshots/" + dtf.format(date) + ".png"));
			} catch (Exception e) {
				System.out.println("Screenshot exception.");
			}
		}

		Thread.sleep(3000);
		driver.quit();
	}

}
