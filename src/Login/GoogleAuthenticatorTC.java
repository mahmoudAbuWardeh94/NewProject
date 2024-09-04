package Login;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleAuthenticatorTC {

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
		driver = GoogleAuthenticatorTC.getDriver();
		driver.get("");
		driver.manage().window().maximize();
		GoogleAuthenticatorPage googleAuth = new GoogleAuthenticatorPage(driver);
		googleAuth.preTestMethod();
	}

	@Test(priority = 1)
	public void TC1_invalid_OTP_with_googleAuth() {

		GoogleAuthenticatorPage googleAuth = new GoogleAuthenticatorPage(driver);
		googleAuth.waitDigitNumbersFields();
		googleAuth.digitsNumbersFields.sendKeys("123456");

		googleAuth.waitContinueButton();
		googleAuth.confirmButton.click();

		googleAuth.waitValidationMsg();
		String actualResult = googleAuth.validationMsg.getText();
		String expectedResult = "The code does not match, please try again";

		softassert.assertEquals(actualResult, expectedResult);
		softassert.assertAll();
	}

	@Test(priority = 2)
	public void TC2_less_more_6_digits() {
		GoogleAuthenticatorPage googleAuth = new GoogleAuthenticatorPage(driver);
		googleAuth.digitNumber6.sendKeys(Keys.BACK_SPACE);

		googleAuth.waitValidationMsg();
		String actualResult = googleAuth.validationMsg.getText();
		String expectedResult = "AuthCode must be at least 6 characters";

		softassert.assertEquals(actualResult, expectedResult);
		softassert.assertAll();

	}

	@Test(priority = 3)
	public void TC3_empty_OTP_code() {
		GoogleAuthenticatorPage googleAuth = new GoogleAuthenticatorPage(driver);

		googleAuth.waitDigitNumber6();
		googleAuth.digitNumber6.click();

		List<WebElement> digits = driver.findElements(By.xpath("//input[@type='tel']"));
		for (int i = 0; i < 5; i++) {
			digits.get(i).sendKeys(Keys.BACK_SPACE);
		}

		googleAuth.waitValidationMsg();
		String actualResult = googleAuth.validationMsg.getText();
		String expectedResult = "AuthCode is required";

		softassert.assertEquals(actualResult, expectedResult);
		softassert.assertAll();
	}

	@Test(priority = 4)
	public void TC4_valid_OTP_code() throws InterruptedException {
		GoogleAuthenticatorPage googleAuth = new GoogleAuthenticatorPage(driver);
		googleAuth.waitDigitNumbersFields();
		googleAuth.digitsNumbersFields.sendKeys("444555");

		googleAuth.waitContinueButton();
		googleAuth.confirmButton.click();

		Thread.sleep(3000);
		String actualHomePageUrl = driver.getCurrentUrl();
		String expectedHomePageUrl = "https://dev-summit.boxsyst.com/";
		softassert.assertEquals(actualHomePageUrl, expectedHomePageUrl);
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
