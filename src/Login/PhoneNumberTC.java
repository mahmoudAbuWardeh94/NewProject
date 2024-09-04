package Login;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PhoneNumberTC {
	public static WebDriver driver;

	public SoftAssert softassert = new SoftAssert();

	public static WebDriver getDriver() {
		if (driver == null) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		return driver;
	}

	@BeforeTest
	public void preTest() throws InterruptedException {

		driver = PhoneNumberTC.getDriver();
		driver.get("");
		driver.manage().window().maximize();
		PhoneNumberPage phoneNumberPage = new PhoneNumberPage(driver);
		phoneNumberPage.preTestMethod();
	}

	@Test(priority = 1)
	public void TC1_verify_try_with_phon_number_link() {

		GoogleAuthenticatorPage googleAuth = new GoogleAuthenticatorPage(driver);

		googleAuth.waitTryWithPhoneNumberLink();
		googleAuth.tryWithPhoneNumberLink.click();

		String actualUrl = driver.getCurrentUrl();
		String expectedUrl = "https://dev-summit.boxsyst.com/phone-verification";
		softassert.assertEquals(actualUrl, expectedUrl);
		softassert.assertAll();
	}

	@Test(priority = 2)
	public void TC2_empty_phone_number() {
		PhoneNumberPage phoneNumberPage = new PhoneNumberPage(driver);

		phoneNumberPage.waitPhoneNumberField();
		phoneNumberPage.phoneNumberField.sendKeys("1");
		phoneNumberPage.phoneNumberField.sendKeys(Keys.BACK_SPACE);

		phoneNumberPage.waitValidationMsg();
		String actualResult = phoneNumberPage.validationMsg.getText();
		String expectedResult = "This is required.";

		softassert.assertEquals(actualResult, expectedResult);
		softassert.assertAll();

	}

	@Test(priority = 3)
	public void TC3_invalid_phone_number_with_try1() throws InterruptedException {
		PhoneNumberPage phoneNumberPage = new PhoneNumberPage(driver);

		phoneNumberPage.waitPhoneNumberField();

		phoneNumberPage.phoneNumberField.sendKeys("1111110113");

		phoneNumberPage.waitContinueButton();
		phoneNumberPage.continueButton.click();

		phoneNumberPage.waitValidationMsg();
		String actualResultTry1 = phoneNumberPage.validationMsg.getText();
		String expectedResultTry1 = "This number doesnt match the one you provided. try again (2).";

		softassert.assertEquals(actualResultTry1, expectedResultTry1);
		softassert.assertAll();

		phoneNumberPage.phoneNumberField.sendKeys(Keys.CONTROL + "a");
		phoneNumberPage.phoneNumberField.sendKeys(Keys.BACK_SPACE);

	}

	@Test(priority = 4)
	public void TC4_invalid_phone_number_with_try2() throws InterruptedException {
		PhoneNumberPage phoneNumberPage = new PhoneNumberPage(driver);

		phoneNumberPage.waitPhoneNumberField();

		phoneNumberPage.phoneNumberField.sendKeys("1111110114");

		phoneNumberPage.waitContinueButton();
		phoneNumberPage.continueButton.click();

		phoneNumberPage.waitValidationMsg();
		String actualResultTry2 = phoneNumberPage.validationMsg.getText();
		String expectedResultTry2 = "This number doesnt match the one you provided. try again (1).";

		softassert.assertEquals(actualResultTry2, expectedResultTry2);
		softassert.assertAll();

		phoneNumberPage.phoneNumberField.sendKeys(Keys.CONTROL + "a");
		phoneNumberPage.phoneNumberField.sendKeys(Keys.BACK_SPACE);

	}

	@Test(priority = 5)
	public void TC5_invalid_phone_number_with_try3() throws InterruptedException {
		PhoneNumberPage phoneNumberPage = new PhoneNumberPage(driver);

		phoneNumberPage.waitPhoneNumberField();

		phoneNumberPage.phoneNumberField.sendKeys("1111110174");

		phoneNumberPage.waitContinueButton();
		phoneNumberPage.continueButton.click();

		phoneNumberPage.waitValidationMsg();
		String actualResultTry3 = phoneNumberPage.validationMsg.getText();
		String expectedResultTry3 = "Your account has been temporarily blocked. Please contact our support team for assistance. 0888888888";

		softassert.assertEquals(actualResultTry3, expectedResultTry3);
		softassert.assertAll();

		phoneNumberPage.phoneNumberField.sendKeys(Keys.CONTROL + "a");
		phoneNumberPage.phoneNumberField.sendKeys(Keys.BACK_SPACE);

	}

	@Test(priority = 6)
	public void TC6_more_than_10_digits() throws InterruptedException {
		PhoneNumberPage phoneNumberPage = new PhoneNumberPage(driver);

		phoneNumberPage.waitPhoneNumberField();
		phoneNumberPage.phoneNumberField.sendKeys("088000000011");

		phoneNumberPage.waitValidationMsg();
		String actualResult = phoneNumberPage.validationMsg.getText();
		String expectedResult = "Maximum 10 characters";

		softassert.assertEquals(actualResult, expectedResult);
		softassert.assertAll();

		phoneNumberPage.phoneNumberField.sendKeys(Keys.CONTROL + "a");
		phoneNumberPage.phoneNumberField.sendKeys(Keys.BACK_SPACE);

	}

	@Test(priority = 7)
	public void TC7_valid_phone_number() throws InterruptedException {
		PhoneNumberPage phoneNumberPage = new PhoneNumberPage(driver);

		phoneNumberPage.waitPhoneNumberField();
		phoneNumberPage.phoneNumberField.sendKeys("0880000000");

		phoneNumberPage.waitContinueButton();
		phoneNumberPage.continueButton.click();

		Thread.sleep(2000);
		String actualUrl = driver.getCurrentUrl();
		String expectedUrl = "https://dev-summit.boxsyst.com/twoFactorAuthentication";
		softassert.assertEquals(actualUrl, expectedUrl);
		softassert.assertAll();

	}

	@AfterTest
	public void afterTest() {
		if (driver != null) {

			driver.quit();
		}
		driver = null;

	}

}
