package TransferAsset;

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

public class TransferAssetTC {
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
		TransferAsset transferAsset = new TransferAsset(driver);
		transferAsset.preTest();
	}

	@Test(priority = 1)
	public void click_on_operation_button() {
		TransferAsset transferAsset = new TransferAsset(driver);

		transferAsset.waitOperationButton();
		transferAsset.operationButton.click();

		String actualResult = transferAsset.expandSideMenu.getAttribute("style");
		String expectedResult = "transform: translateX(25px) translateY(-35px) rotate(0deg) translateZ(0px);";

		softassert.assertEquals(actualResult, expectedResult);
		softassert.assertAll();
	}

	@Test(priority = 2)
	public void click_on_assets_management() throws InterruptedException {
		TransferAsset transferAsset = new TransferAsset(driver);

		transferAsset.waitAssetsManagment();
		transferAsset.assetsManagment.click();

		String actualResult = transferAsset.assetsManagment.getAttribute("class");
		String expectedResult = "flex-1 capitalize whitespace-break-spaces text-[13px] font-medium text-white";

		softassert.assertEquals(actualResult, expectedResult);
		softassert.assertAll();
	}

	@Test(priority = 3)
	public void clickOnTransferAsset() throws InterruptedException {
		TransferAsset transferAsset = new TransferAsset(driver);

		transferAsset.waitTransferAssetButton();
		transferAsset.transferAssetButton.click();

		Thread.sleep(3000);

		String actualResult = driver.getCurrentUrl();
		String expectedResult = "https://dev-summit.boxsyst.com/transfer_assets";

		softassert.assertEquals(actualResult, expectedResult);
		softassert.assertAll();
	}

	@Test(priority = 4)
	public void closeSideArrow() {
		TransferAsset transferAsset = new TransferAsset(driver);

		transferAsset.waitSideArrow();
		transferAsset.sideArrow.click();

		String actualResult = transferAsset.closeSideMenu.getAttribute("style");
		String expectedResult = "transform: translateX(25px) translateY(-35px) rotate(180deg) translateZ(0px);";

		softassert.assertEquals(actualResult, expectedResult);
		softassert.assertAll();
	}

	@Test(priority = 5)
	public void browseItems() throws InterruptedException {
		TransferAsset transferAsset = new TransferAsset(driver);

		transferAsset.waitFromField();
		transferAsset.fromField.click();

		Thread.sleep(3000);

		Actions action = new Actions(driver);
//		action.moveToElement(transferAsset.fromField).sendKeys(Keys.ARROW_DOWN).build().perform();
//
		action.moveToElement(transferAsset.fromField).sendKeys(Keys.ENTER).build().perform();

		transferAsset.waitFromField1();
		transferAsset.fromField1.click();

		transferAsset.waitSearchFromField1();
		transferAsset.searchFromField1.sendKeys("test 012");

		Thread.sleep(3000);

		action.moveToElement(transferAsset.fromField1).sendKeys(Keys.ENTER).build().perform();

		transferAsset.waittoFeaild();
		transferAsset.toFeaild.click();

		action.moveToElement(transferAsset.toFeaild).sendKeys(Keys.ENTER).build().perform();

		transferAsset.waittoFeaild1();
		transferAsset.toFeaild1.click();

		transferAsset.waitToFeaildSearch();
		transferAsset.toFeaildSearch.sendKeys("test 012");

		Thread.sleep(3000);
		action.moveToElement(transferAsset.toFeaildSearch).sendKeys(Keys.ENTER).build().perform();

		transferAsset.waitFromField2();
		transferAsset.fromField2.click();

		transferAsset.waitsearchFromField2();
		transferAsset.searchFromField2.sendKeys("IDT700IV");

		Thread.sleep(3000);

		action.moveToElement(transferAsset.searchFromField2).sendKeys(Keys.ENTER).build().perform();

		transferAsset.waitBrowseItemsButton();
		transferAsset.browseItemsButton.click();

		transferAsset.waitItems();

		Boolean actualResult = transferAsset.items.isDisplayed();
		Boolean expectedResult = true;

		softassert.assertEquals(actualResult, expectedResult);
		softassert.assertAll();
	}

	@Test(priority = 6)
	public void transfer() throws InterruptedException {
		TransferAsset transferAsset = new TransferAsset(driver);

		transferAsset.waitCheckBoxButton();
		transferAsset.checkBoxButton.click();

		transferAsset.waitTransferButton();
		transferAsset.transferButton.click();

		transferAsset.waitNoteField();
		transferAsset.noteField.sendKeys("husam tester");

		transferAsset.waittransferAsset();
		transferAsset.transferAsset.click();

		transferAsset.waitToasterMeesage();

		String actualResult = transferAsset.toasterMeesage.getText();
		String expectedResult = "Add product transactions succeed.";

		softassert.assertEquals(actualResult, expectedResult);
		softassert.assertAll();
	}

//	@AfterTest
//	public void afterTest() {
//		if (driver != null) {
//
//			driver.quit();
//		}
//		driver = null;
//
//	}
}