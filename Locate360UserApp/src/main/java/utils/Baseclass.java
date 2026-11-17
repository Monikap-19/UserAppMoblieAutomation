package utils;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Driverfactory.DriverManager;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class Baseclass {
	public static AndroidDriver driver;
	public static WebDriverWait wait;

	public static AndroidDriver BrowserLaunch() throws MalformedURLException {
		driver = Driverfactory.DriverFactory.createDriver();
		DriverManager.setDriver(driver);
		return driver;
	}

	public static void closeApp() {
		if (driver != null) {
			try {
				driver.quit();
			} finally {
				driver = null;
				DriverManager.setDriver(null);
			}
		}
	}

	public static boolean isDisplayed(WebElement e) {
		try {
			return e.isDisplayed();
		} catch (Exception ex) {
			return false;
		}
	}

	public void click(WebElement e) {
		wait.until(ExpectedConditions.elementToBeClickable(e)).click();
	}

	public static void sendKeys(WebElement e, String t) {
		wait.until(ExpectedConditions.visibilityOf(e)).clear();
		e.sendKeys(t);
	}

	public static String getText(WebElement e) {
		return wait.until(ExpectedConditions.visibilityOf(e)).getText();
	}

	public static void viewWait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	public void Scrolldown() {
		driver.executeScript("mobile:swipeGesture",
				Map.of("left", 100, "top", 100, "width", 200, "height", 600, "direction", "down", "percent", 0.75));
	}

	public void Scrollup() {
		driver.executeScript("mobile:swipeGesture",
				Map.of("left", 100, "top", 100, "width", 200, "height", 600, "direction", "up", "percent", 0.75));
	}

	public void scrollToElementByText(String text) {
		driver.findElement(AppiumBy.androidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"" + text
						+ "\"))"));
	}

	public static void jsclick(WebElement e) {
		wait.until(ExpectedConditions.elementToBeClickable(e));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", e);
	}

	public static void Alertaccept() {
		driver.switchTo().alert().accept();
	}

	public void clickunder(WebElement e) {
		wait.until(ExpectedConditions.elementToBeClickable(e)).click();
	}

	public void waitForVisibility(WebElement element) {
		new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(element));
	}

	public static void search(WebElement e) {
		e.sendKeys(Keys.ENTER);
	}
}
