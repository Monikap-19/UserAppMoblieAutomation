# Locate360 UserApp - CRM Reference Project Structure

This project keeps the original Locate360 UserApp page objects, step definitions, and feature scenarios. The package/folder layout follows the supplied CRMsalesPanel reference structure.

## Structure
- `src/main/java/Driverfactory` - Appium driver creation and management
- `src/main/java/Pom` - original Locate360 page objects and `@AndroidFindBy` locators
- `src/main/java/utils` - original Baseclass-compatible helper, config reader
- `src/test/java/StepDefinition` - original step definitions
- `src/test/java/Test/Testrunner.java` - Cucumber JUnit 4 runner
- `src/test/java/hooks` - scenario setup and teardown
- `src/test/resources/Feature` - original feature files

## Configure
Edit `src/test/resources/config.properties` and set `appPath`, `deviceName`, `udid`, app package/activity and Appium server URL for your machine. Start Appium and connect the Android device/emulator.

## Run with Java 11 and Maven
`mvn clean test`

## Allure report
`mvn allure:report` then open `target/site/allure-maven-plugin/index.html`, or run `mvn allure:serve`.

The project uses Cucumber 7 with the JUnit 4 runner (`@RunWith(Cucumber.class)`).
