package Login;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginPageTC {
	public static WebDriver driver;

	public SoftAssert softassert;

	public static WebDriver getDriver() {
		if (driver == null) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		return driver;
	}

	@BeforeMethod
	public void preTest() {
		driver = LoginPageTC.getDriver();
		driver.get("");
		driver.manage().window().maximize();
		softassert = new SoftAssert();
	}

	@Test(priority = 1, description = "Verify the login functionality when the user enters invalid user name and invalid password")
	public void TC1_invalid_username_invalid_password() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.waitUserName();

		loginPage.userName.sendKeys("test");
		loginPage.waitPassword();
		loginPage.password.sendKeys("1111");

		loginPage.waitLoginButton();
		loginPage.loginButton.click();

		loginPage.waitErrorMessage();
		String actualValue = loginPage.errorMessage.getText();
		String expectedValue = "Username or Password or both are wrong.";

		softassert.assertEquals(actualValue, expectedValue);
		softassert.assertAll();

	}

	@Test(priority = 2, description = "Verify the login functionality when the user enters invalid user name and valid password")
	public void TC2_invalid_username_valid_password() {
		LoginPage loginPage = new LoginPage(driver);

		loginPage.waitUserName();
		loginPage.userName.sendKeys("nadsoft");

		loginPage.waitPassword();
		loginPage.password.sendKeys("1234");

		loginPage.waitLoginButton();
		loginPage.loginButton.click();

		loginPage.waitErrorMessage();
		String actualValueMsg = loginPage.errorMessage.getText();
		String expectedValueMsg = "Username or Password or both are wrong.";

		softassert.assertEquals(actualValueMsg, expectedValueMsg);
		softassert.assertAll();

	}

	@Test(priority = 3, description = "Verify the login functionality when the user enters valid user name and invalid password")
	public void TC3_valid_username_invalid_password() {
		LoginPage loginPage = new LoginPage(driver);

		loginPage.waitUserName();
		loginPage.userName.sendKeys("summit");

		loginPage.waitPassword();
		loginPage.password.sendKeys("11111");

		loginPage.waitLoginButton();
		loginPage.loginButton.click();

		loginPage.waitErrorMessage();
		String actualValMsg = loginPage.errorMessage.getText();
		String expectedValMsg = "Username or Password or both are wrong.";

		softassert.assertEquals(actualValMsg, expectedValMsg);
		softassert.assertAll();

	}

	@Test(priority = 4, description = "Verify the login functionality when the user enters empty user name and valid password")
	public void TC4_empty_username_valid_password() {
		LoginPage loginPage = new LoginPage(driver);

		loginPage.waitUserName();
		loginPage.userName.sendKeys("1");
		loginPage.userName.sendKeys(Keys.BACK_SPACE);

		loginPage.waitPassword();
		loginPage.password.sendKeys("1234");

		loginPage.waitemptyUserNameField();
		String actualValMessage = loginPage.emptyUserNameField.getText();
		String expectedValMessage = "User Name is required";

		softassert.assertEquals(actualValMessage, expectedValMessage);
		softassert.assertAll();
	}

	@Test(priority = 5, description = "Verify the login functionality when the user enters valid user name and empty password")
	public void TC5_valid_username_empty_password() {
		LoginPage loginPage = new LoginPage(driver);

		loginPage.waitUserName();
		loginPage.userName.sendKeys("summit");

		loginPage.waitPassword();
		loginPage.password.sendKeys("1");
		loginPage.password.sendKeys(Keys.BACK_SPACE);

		loginPage.waitemptyPasswordField();
		String actualValMessage1 = loginPage.emptyPasswordField.getText();
		String expectedValMessage1 = "Password is required";

		softassert.assertEquals(actualValMessage1, expectedValMessage1);
		softassert.assertAll();

	}

	@Test(priority = 6, description = "Verify the login functionality when the user enters empty user name and empty password")
	public void TC6_empty_username_empty_password() {
		LoginPage loginPage = new LoginPage(driver);

		loginPage.waitUserName();
		loginPage.userName.sendKeys("s");
		loginPage.userName.sendKeys(Keys.BACK_SPACE);

		loginPage.waitPassword();
		loginPage.password.sendKeys("1");
		loginPage.password.sendKeys(Keys.BACK_SPACE);

		loginPage.waitemptyUserNameField();
		loginPage.waitsecValMsg();

		String actualValMessage1 = loginPage.emptyUserNameField.getText();
		String expectedValMessage1 = "User Name is required";

		String actualValMessage2 = loginPage.secValMsg.getText();
		String expectedValMessage2 = "Password is required";

		softassert.assertEquals(actualValMessage1, expectedValMessage1);
		softassert.assertEquals(actualValMessage2, expectedValMessage2);

		softassert.assertAll();
	}

	@Test(priority = 7, description = "Verify the login functionality when the user enters empty user name and empty password")
	public void TC7_valid_username_valid_password() throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);

		loginPage.waitUserName();
		loginPage.userName.sendKeys("NadsoftSummit");

		loginPage.waitPassword();
		loginPage.password.sendKeys("12345");

		loginPage.waitLoginButton();
		loginPage.loginButton.click();
		Thread.sleep(2000);

		if (loginPage.waitLoginPopUp() && loginPage.loginPopUp.isDisplayed()) {
			loginPage.waitLoginButton();
			loginPage.continueButtonInPopUp.click();

		}
		else {
			System.out.println(" ");
		}
		
		Thread.sleep(2000);

		String actualUrl = driver.getCurrentUrl();
		String expectedUrl = "https://dev-summit.boxsyst.com/otp";

		softassert.assertEquals(actualUrl, expectedUrl);
		softassert.assertAll();

	}

	@Test(priority = 8)
	public void TC8_verify_the_title() {
		String actualTitlt = driver.getTitle();
		String expectedTitle = "Winners Summit";
		softassert.assertEquals(actualTitlt, expectedTitle);
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
