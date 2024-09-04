package RetrieveSim;

import java.util.Random;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Login.GoogleAuthenticatorTC;
import io.github.bonigarcia.wdm.WebDriverManager;

public class RetrieveSimTC {

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

		RetrieveSim retrieveSim = new RetrieveSim(driver);
		retrieveSim.preTest();
	}

	@Test(priority = 1)
	public void click_on_operation_button() {
		RetrieveSim retrieveSim = new RetrieveSim(driver);
		retrieveSim.waitOperationButton();
		retrieveSim.operationButton.click();

		String actualResult = retrieveSim.expandSideMenu.getAttribute("style");
		String expectedResult = "transform: translateX(25px) translateY(-35px) rotate(0deg) translateZ(0px);";

		softassert.assertEquals(actualResult, expectedResult);
		softassert.assertAll();

	}

	@Test(priority = 2)
	public void click_on_assets_management() throws InterruptedException {
		RetrieveSim retrieveSim = new RetrieveSim(driver);
		retrieveSim.waitAssetsManagment();
		retrieveSim.assetsManagment.click();

		String actualResult = retrieveSim.assetsManagment.getAttribute("class");
		String expectedResult = "flex-1 capitalize whitespace-break-spaces text-[13px] font-medium text-white";

		softassert.assertEquals(actualResult, expectedResult);
		softassert.assertAll();
	}

	@Test(priority = 3)
	public void click_on_retrieve_sim_button() throws InterruptedException {
		RetrieveSim retrieveSim = new RetrieveSim(driver);
		retrieveSim.waitRetrieveSimButton();
		retrieveSim.retrieveSimButton.click();

		Thread.sleep(1000);
		String actualResult = driver.getCurrentUrl();
		String expectedResult = "https://dev-summit.boxsyst.com/retrieve_sim";

		softassert.assertEquals(actualResult, expectedResult);
		softassert.assertAll();
	}

	@Test(priority = 4)
	public void click_on_side_arrow() {
		RetrieveSim retrieveSim = new RetrieveSim(driver);

		retrieveSim.waitSideArrow();
		retrieveSim.sideArrow.click();

		String actualResult = retrieveSim.closeSideMenu.getAttribute("style");
		String expectedResult = "transform: translateX(25px) translateY(-35px) rotate(180deg) translateZ(0px);";

		softassert.assertEquals(actualResult, expectedResult);
		softassert.assertAll();
	}

	@Test(priority = 5)
	public void valid_and_exsist_retrieve_sim() throws InterruptedException {
		RetrieveSim retrieveSim = new RetrieveSim(driver);

		retrieveSim.waitSearchField();
		retrieveSim.searchField.sendKeys("Sim_dev_test_1");

		retrieveSim.waitActionButton();
		retrieveSim.actionButton.click();

		Actions action = new Actions(driver);

		action.moveToElement(retrieveSim.actionButton).sendKeys(Keys.ENTER).build().perform();

		Random rand = new Random();
		int randomNumber = rand.nextInt(10000);

		String testString = "Test" + randomNumber;

		retrieveSim.waitNewSimField();
		retrieveSim.newSimField.sendKeys(testString);

		retrieveSim.waitRetrieveButton();
		retrieveSim.retrieveButton.click();

		retrieveSim.waitErrorConfirmationMsg();

		String actualResultWithValidData = retrieveSim.errorConfirmationMsg.getText();
		String expectedResultWithValidData = "Succeed To Update Sim Serial Number.";

		softassert.assertEquals(actualResultWithValidData, expectedResultWithValidData);

		retrieveSim.waitOkButton();
		retrieveSim.okButton.click();

		retrieveSim.waitActionButton();
		retrieveSim.actionButton.click();

		action.moveToElement(retrieveSim.actionButton).sendKeys(Keys.ENTER).build().perform();

		retrieveSim.waitNewSimField();
		retrieveSim.newSimField.sendKeys(testString);

		retrieveSim.waitRetrieveButton();
		retrieveSim.retrieveButton.click();

		retrieveSim.waitErrorConfirmationMsg();

		String actualResultWithExsistData = retrieveSim.errorConfirmationMsg.getText();
		String expectedResultWithWzsistData = "New Serial Number Already Exists.";

		softassert.assertEquals(actualResultWithExsistData, expectedResultWithWzsistData);

		retrieveSim.waitOkButton();
		retrieveSim.okButton.click();

		softassert.assertAll();

	}

	@Test(priority = 6)
	public void verify_log() {
		RetrieveSim retrieveSim = new RetrieveSim(driver);

		retrieveSim.waitActionButton();
		retrieveSim.actionButton.click();

		Actions action = new Actions(driver);

		action.moveToElement(retrieveSim.actionButton).sendKeys(Keys.ARROW_DOWN).build().perform();

		retrieveSim.waitLogButton();
		action.moveToElement(retrieveSim.actionButton).click(retrieveSim.logButton).build().perform();

		retrieveSim.waitRecordOfChanges();

		Boolean actualResult = retrieveSim.recordOfChanges.isDisplayed();
		Boolean expectedResult = true;

		softassert.assertEquals(actualResult, expectedResult);
		softassert.assertAll();

	}

//	@AfterTest
//	public void after_test() {
//		if (driver != null) {
//
//			driver.quit();
//		}
//		driver = null;
//	}

}
