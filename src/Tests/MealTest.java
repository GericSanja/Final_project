package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MealTest extends BasicTest {
	
	@Test
	public void addMealToCartTest() throws InterruptedException {
		driver.get("http://demo.yo-meals.com/meal/baked-caldereta-provin%C3%83%C2%A7ale");
		locationPopupPage.closePopupLocation();

		mealPage.addToTheCart("2");

		Assert.assertTrue(notificationSistemPage.returnMessage().contains("The Following Errors Occurred:"),
				"[ERROR] First error message 'The Following Errors Occurred:' is not shown");
		Assert.assertTrue(notificationSistemPage.returnMessage().contains("Please Select Location"),
				"[ERROR] Second error message ' Please Select Location' is not shown");
		notificationSistemPage.waitMessageToDispear();

		String location = "City Center - Albany";
		locationPopupPage.openPopupLocation();
		//locationPopupPage.setLocation(locationName);
		Thread.sleep(4000);

		
	}
	}