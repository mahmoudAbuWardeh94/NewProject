package TabletManagement;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Login.GoogleAuthenticatorTC;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TabletManagementTC {
	public static WebDriver driver;

	public SoftAssert softassert = new SoftAssert();

	Random rand = new Random();
	int randomNumber = rand.nextInt(10000);

	public String testString = "Testing" + randomNumber;

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
		TabletManagement tabletManagement = new TabletManagement(driver);
		tabletManagement.preTest();
	}

	@Test(priority = 1)
	public void clickOnOperationButton() {
		TabletManagement tabletManagement = new TabletManagement(driver);
		tabletManagement.waitOperationButton();
		tabletManagement.operationButton.click();

		String actualResult = tabletManagement.expandSideMenu.getAttribute("style");
		String expectedResult = "transform: translateX(25px) translateY(-35px) rotate(0deg) translateZ(0px);";

		softassert.assertEquals(actualResult, expectedResult);
		softassert.assertAll();

	}

	@Test(priority = 2)
	public void navigateToTablets() throws InterruptedException {
		TabletManagement tabletManagement = new TabletManagement(driver);
		tabletManagement.waitUserManagament();
		tabletManagement.userManagament.click();

		tabletManagement.waitTabletsButton();
		tabletManagement.tabletsButton.click();

		Thread.sleep(2000);

		String actualResult = driver.getCurrentUrl();
		String expectedResult = "https://dev-summit.boxsyst.com/tablet_management";

		softassert.assertEquals(actualResult, expectedResult);
		softassert.assertAll();

	}

	@Test(priority = 3)
	public void click_on_side_arrow() {
		TabletManagement tabletManagement = new TabletManagement(driver);

		tabletManagement.waitSideArrow();
		tabletManagement.sideArrow.click();

		String actualResult = tabletManagement.closeSideMenu.getAttribute("style");
		String expectedResult = "transform: translateX(25px) translateY(-35px) rotate(180deg) translateZ(0px);";

		softassert.assertEquals(actualResult, expectedResult);
		softassert.assertAll();
	}

	@Test(priority = 4)

	public void addNewTablet() {
		TabletManagement tabletManagement = new TabletManagement(driver);

		tabletManagement.waitAddNewButton();
		tabletManagement.addNewButton.click();

		tabletManagement.waitTabletNameField();
		tabletManagement.tabletNameField.sendKeys(testString);

		tabletManagement.waitAppVersionField();
		tabletManagement.appVersionField.sendKeys("1.0");

		tabletManagement.waitStatusField();
		tabletManagement.statusField.click();

		Actions action = new Actions(driver);

		action.moveToElement(tabletManagement.statusField).sendKeys(Keys.ARROW_DOWN).build().perform();
		action.moveToElement(tabletManagement.statusField).sendKeys(Keys.ENTER).build().perform();

		tabletManagement.waitSaveButton();
		tabletManagement.saveButton.click();

		tabletManagement.waitToasterMessage();

		String actualResult = tabletManagement.toasterMessage.getText();
		String expectedResult = "Add Tablet User succeed.";

		softassert.assertEquals(actualResult, expectedResult);
		softassert.assertAll();

	}

	@Test(priority = 5)
	public void searchWithValidData() throws InterruptedException {
		TabletManagement tabletManagement = new TabletManagement(driver);

		driver.navigate().to("https://dev-summit.boxsyst.com/tablet_management");
		tabletManagement.waitSearchField();
		tabletManagement.searchField.sendKeys(testString);

		Thread.sleep(2000);
		tabletManagement.waitTabletNameColumn();

		String actualResult = tabletManagement.tabletNameColumn.getText();
		String expectedResult = testString;

		softassert.assertEquals(actualResult, expectedResult);
		softassert.assertAll();
	}

	@Test(priority = 6)
	public void updateGeneralDetails() {
		TabletManagement tabletManagement = new TabletManagement(driver);

		tabletManagement.waitDetailsButton();
		tabletManagement.detailsButton.click();

		tabletManagement.waitEditButton();
		tabletManagement.editButton.click();

		tabletManagement.waitAppVersionField();
		tabletManagement.appVersionField.sendKeys(Keys.BACK_SPACE);

		tabletManagement.appVersionField.sendKeys("1");

		tabletManagement.waitSaveButton();
		tabletManagement.saveButton.click();

		tabletManagement.waitToasterMessage();

		String actualResult = tabletManagement.toasterMessage.getText();
		String expectedResult = "Update tablet user general details succeed.";

		softassert.assertEquals(actualResult, expectedResult);
		softassert.assertAll();
	}

	@Test(priority = 7)
	public void addTerminals() throws InterruptedException {
		TabletManagement tabletManagement = new TabletManagement(driver);

		tabletManagement.waitInventoryTab();
		tabletManagement.inventoryTab.click();

		tabletManagement.waitDeviceIdField();
		tabletManagement.deviceIdField.click();

		Actions action = new Actions(driver);

		action.moveToElement(tabletManagement.deviceIdField).sendKeys(Keys.ENTER).build().perform();

		tabletManagement.waitAddButton();
		tabletManagement.addButton.click();

		Thread.sleep(2000);
		String actualResult = tabletManagement.toasterMessage.getText();
		String expectedResult = "Update Tablet Users Inventory Succeed.";

		softassert.assertEquals(actualResult, expectedResult);
		softassert.assertAll();

	}

	@Test(priority = 8)
	public void updateTerminals() throws InterruptedException {
		TabletManagement tabletManagement = new TabletManagement(driver);

		tabletManagement.waitEditButtonInTerminalsAndSims();
		tabletManagement.editButtonInTerminalsAndSims.click();

		Actions action = new Actions(driver);

		tabletManagement.waitDeviceIdFieldInEditMode();
		tabletManagement.deviceIdFieldInEditMode.click();

		action.moveToElement(tabletManagement.deviceIdFieldInEditMode).sendKeys(Keys.ARROW_DOWN).build().perform();

		action.moveToElement(tabletManagement.deviceIdFieldInEditMode).sendKeys(Keys.ENTER).build().perform();

		tabletManagement.waitSaveButton();
		tabletManagement.saveButton.click();

		Thread.sleep(2000);
		String actualResult = tabletManagement.toasterMessage.getText();
		String expectedResult = "Update Tablet Users Inventory Succeed.";

		softassert.assertEquals(actualResult, expectedResult);
		softassert.assertAll();

	}

	@Test(priority = 9)
	public void deleteTerminals() throws InterruptedException {
		TabletManagement tabletManagement = new TabletManagement(driver);

		tabletManagement.waitDeleteTerminalAndSimButton();
		tabletManagement.deleteTerminalAndSimButton.click();

		tabletManagement.waitSaveButton();
		tabletManagement.saveButton.click();

		Thread.sleep(2000);
		String actualResult = tabletManagement.toasterMessage.getText();
		String expectedResult = "Update Tablet Users Inventory Succeed.";

		softassert.assertEquals(actualResult, expectedResult);
		softassert.assertAll();
	}

	@Test(priority = 10)
	public void addNewSims() throws InterruptedException {
		TabletManagement tabletManagement = new TabletManagement(driver);

		tabletManagement.waitSimsTab();
		tabletManagement.simsTab.click();

		tabletManagement.waitSimCardNumberField();
		tabletManagement.simCardNumberField.click();

		Actions action = new Actions(driver);

		action.moveToElement(tabletManagement.simCardNumberField).sendKeys(Keys.ENTER).build().perform();

		tabletManagement.waitAddButton();
		tabletManagement.addButton.click();

		Thread.sleep(2000);
		String actualResult = tabletManagement.toasterMessage.getText();
		String expectedResult = "Update Tablet Users Inventory Succeed.";

		softassert.assertEquals(actualResult, expectedResult);
		softassert.assertAll();
	}

	@Test(priority = 11)
	public void updateSims() throws InterruptedException {
		TabletManagement tabletManagement = new TabletManagement(driver);

		tabletManagement.waitEditButtonInTerminalsAndSims();
		tabletManagement.editButtonInTerminalsAndSims.click();

		Actions action = new Actions(driver);

		tabletManagement.waitSimCardNumberFieldInEditMode();
		tabletManagement.simCardNumberFieldInEditMode.click();
		Thread.sleep(1000);

		action.moveToElement(tabletManagement.simCardNumberFieldInEditMode).sendKeys(Keys.ARROW_DOWN).build().perform();
		action.moveToElement(tabletManagement.simCardNumberFieldInEditMode).sendKeys(Keys.ENTER).build().perform();

		tabletManagement.waitWarehouseToTransferPreviousSimField();
		tabletManagement.warehouseToTransferPreviousSimField.click();

		action.moveToElement(tabletManagement.warehouseToTransferPreviousSimField).sendKeys(Keys.ARROW_DOWN).build()
				.perform();
		action.moveToElement(tabletManagement.warehouseToTransferPreviousSimField).sendKeys(Keys.ENTER).build()
				.perform();

		tabletManagement.waitSaveButton();
		tabletManagement.saveButton.click();

		Thread.sleep(2000);
		String actualResult = tabletManagement.toasterMessage.getText();
		String expectedResult = "Update Tablet Users Inventory Succeed.";

		softassert.assertEquals(actualResult, expectedResult);
		softassert.assertAll();

	}

	@Test(priority = 12)
	public void deleteSims() throws InterruptedException {
		TabletManagement tabletManagement = new TabletManagement(driver);

		tabletManagement.waitDeleteTerminalAndSimButton();
		tabletManagement.deleteTerminalAndSimButton.click();

		tabletManagement.waitWarehouseToTransferPreviousSimField();
		tabletManagement.warehouseToTransferPreviousSimField.click();

		Actions action = new Actions(driver);

		action.moveToElement(tabletManagement.warehouseToTransferPreviousSimField).sendKeys(Keys.ENTER).build()
				.perform();

		tabletManagement.waitSaveButton();
		tabletManagement.saveButton.click();

		Thread.sleep(2000);
		String actualResult = tabletManagement.toasterMessage.getText();
		String expectedResult = "Update Tablet Users Inventory Succeed.";

		softassert.assertEquals(actualResult, expectedResult);
		softassert.assertAll();

	}

	@Test(priority = 13)
	public void editProducts() throws InterruptedException {
		TabletManagement tabletManagement = new TabletManagement(driver);

		tabletManagement.waitProductsTab();
		tabletManagement.productsTab.click();

		Thread.sleep(3000);

		List<WebElement> productItems = driver.findElements(By.xpath("//button[@role='switch']"));

		for (int i = 0; i < productItems.size(); i++) {

			productItems.get(i).click();
		}

		tabletManagement.waitStarIcon();
		tabletManagement.starIcon.click();

		tabletManagement.waitJackpotAccumulationButton();
		tabletManagement.jackpotAccumulationButton.click();

		tabletManagement.waitSaveButton();
		tabletManagement.saveButton.click();

		tabletManagement.waitToasterMessage();

		String actualResult = tabletManagement.toasterMessage.getText();
		String expectedResult = "Update Tablet products succeed.";

		softassert.assertEquals(actualResult, expectedResult);

		tabletManagement.waitXButtonInToasterMsg();
		tabletManagement.xButtonInToasterMsg.click();

		tabletManagement.waitCancelButton();
		tabletManagement.cancelButton.click();

		List<WebElement> productItemsAfterUpdated = driver.findElements(By.xpath("//button[@aria-checked]"));
		for (int k = 0; k < productItemsAfterUpdated.size(); k++) {
			String actualResultAfterUpdated = productItemsAfterUpdated.get(k).getAttribute("aria-checked");

			String expectedResultAfterUpdated = "true";
			softassert.assertEquals(actualResultAfterUpdated, expectedResultAfterUpdated);

		}

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
