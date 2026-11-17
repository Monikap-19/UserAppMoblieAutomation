package Driverfactory;
import io.appium.java_client.android.AndroidDriver;
public class DriverManager {
    private static AndroidDriver driver;
    public static void setDriver(AndroidDriver value) { driver = value; }
    public static AndroidDriver getDriver() { return driver; }
    public static void quitDriver() { if (driver != null) { driver.quit(); driver = null; } }
}
