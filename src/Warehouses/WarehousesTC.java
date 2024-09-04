package Warehouses;

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
import RetrieveSim.RetrieveSim;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WarehousesTC {
	public static WebDriver driver;

	public SoftAssert softassert = new SoftAssert();

	Random rand = new Random();
	int randomNumber = rand.nextInt(10000);

	public String testString = "Test" + randomNumber;

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

		Warehouses warehouses = new Warehouses(driver);
		warehouses.preTest();
	}

	@Test(priority = 1)
	public void clickOnOperationButton() {
		Warehouses warehouses = new Warehouses(driver);
		warehouses.waitOperationButton();
		warehouses.operationButton.click();

		String actualResult = warehouses.expandSideMenu.getAttribute("style");
		String expectedResult = "transform: translateX(25px) translateY(-35px) rotate(0deg) translateZ(0px);";

		softassert.assertEquals(actualResult, expectedResult);
		softassert.assertAll();

	}

	@Test(priority = 2)
	public void clickOnWarehousesButton() throws InterruptedException {
		Warehouses warehouses = new Warehouses(driver);
		warehouses.waitWarehouseButton();
		warehouses.warehouseButton.click();
		Thread.sleep(2000);

		String actualResult = driver.getCurrentUrl();
		String expectedResult = "https://dev-summit.boxsyst.com/warehouse_management";
		softassert.assertEquals(actualResult, expectedResult);
		softassert.assertAll();
	}

	@Test(priority = 3)
	public void click_on_side_arrow() {
		RetrieveSim retrieveSim = new RetrieveSim(driver);

		retrieveSim.waitSideArrow();
		retrieveSim.sideArrow.click();

		String actualResult = retrieveSim.closeSideMenu.getAttribute("style");
		String expectedResult = "transform: translateX(25px) translateY(-35px) rotate(180deg) translateZ(0px);";

		softassert.assertEquals(actualResult, expectedResult);
		softassert.assertAll();
	}

	@Test(priority = 4)
	public void addValidNewWarehouse() throws InterruptedException {
		Warehouses warehouses = new Warehouses(driver);

		warehouses.waitAddNewButton();
		warehouses.addNewButton.click();

		warehouses.waitWarehouseNameField();
		warehouses.warehouseNameField.sendKeys(testString);

		warehouses.waitUnitNameField();
		warehouses.unitNameField.click();

		warehouses.waitSearchFieldInUnitName();
		warehouses.searchFieldInUnitName.sendKeys("Test");
		Thread.sleep(2000);
		warehouses.searchFieldInUnitName.sendKeys(Keys.ENTER);

		warehouses.waitWarehouseTypeField();
		warehouses.warehouseTypeField.click();

		Actions action = new Actions(driver);

		action.moveToElement(warehouses.warehouseTypeField).sendKeys(Keys.ARROW_DOWN).build().perform();
		action.moveToElement(warehouses.warehouseTypeField).sendKeys(Keys.ENTER).build().perform();

		warehouses.waitCreateButton();
		warehouses.createButton.click();

		warehouses.waitSuccessErrorMsg();
		String actualResult = warehouses.successErrorMsg.getText();
		String expectedResult = "Succeed to add warehouse.";

		softassert.assertEquals(actualResult, expectedResult);

		softassert.assertAll();
	}

	@Test(priority = 5)
	public void addExsistNewWarehouse() throws InterruptedException {
		Warehouses warehouses = new Warehouses(driver);

		warehouses.waitAddNewButton();
		warehouses.addNewButton.click();

		warehouses.waitWarehouseNameField();
		warehouses.warehouseNameField.sendKeys(testString);

		warehouses.waitUnitNameField();
		warehouses.unitNameField.click();

		warehouses.waitSearchFieldInUnitName();
		warehouses.searchFieldInUnitName.sendKeys("Test");
		Thread.sleep(2000);
		warehouses.searchFieldInUnitName.sendKeys(Keys.ENTER);

		warehouses.waitWarehouseTypeField();
		warehouses.warehouseTypeField.click();

		Actions action = new Actions(driver);

		action.moveToElement(warehouses.warehouseTypeField).sendKeys(Keys.ARROW_DOWN).build().perform();
		action.moveToElement(warehouses.warehouseTypeField).sendKeys(Keys.ENTER).build().perform();

		warehouses.waitCreateButton();
		warehouses.createButton.click();

		Thread.sleep(2000);
		warehouses.waitSuccessErrorMsg();
		String actualExsistResult = warehouses.successErrorMsg.getText();
		String expectedExsistResult = "Warehouse Name Already Exists .";

		softassert.assertEquals(actualExsistResult, expectedExsistResult);

		warehouses.waitClosePopUp();
		warehouses.closePopUp.click();

		softassert.assertAll();

	}

	@Test(priority = 6)
	public void searchWithValidData() throws InterruptedException {
		Warehouses warehouses = new Warehouses(driver);

		warehouses.waitSearchField();
		warehouses.searchField.sendKeys(testString);
		Thread.sleep(2000);

		warehouses.waitWarehouseNameColumn();

		String actualResult = warehouses.warehouseNameColumn.getText();
		String expectedResult = testString;

		softassert.assertEquals(actualResult, expectedResult);
		softassert.assertAll();
	}

	@Test(priority = 7)
	public void editWarehouse() throws InterruptedException {
		Warehouses warehouses = new Warehouses(driver);

		warehouses.waitEditInfoButton();
		warehouses.editInfoButton.click();

		Actions action = new Actions(driver);

		warehouses.waitWarehouseTypeField();

		warehouses.warehouseTypeField.click();

		action.moveToElement(warehouses.warehouseTypeField).sendKeys(Keys.ARROW_DOWN).build().perform();
		action.moveToElement(warehouses.warehouseTypeField).sendKeys(Keys.ARROW_DOWN).build().perform();
		action.moveToElement(warehouses.warehouseTypeField).sendKeys(Keys.ENTER).build().perform();

		warehouses.waitEditButton();
		warehouses.editButton.click();

		Thread.sleep(2000);
		warehouses.waitSuccessErrorMsg();
		String actualResult = warehouses.successErrorMsg.getText();
		String expectedResult = "Succeed to edit warehouse info.";

		softassert.assertEquals(actualResult, expectedResult);
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
