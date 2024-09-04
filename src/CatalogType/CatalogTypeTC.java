package CatalogType;

import java.util.Random;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
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

public class CatalogTypeTC {
	public static WebDriver driver;
	public SoftAssert softassert = new SoftAssert();
	Random rand = new Random();
	int randomNumber = rand.nextInt(10000);
	String testString = "Test" + randomNumber;

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
		CatalogType catalogType = new CatalogType(driver);
		catalogType.preTest();
	}

	@Test(priority = 1)
	public void clickOnOperationButton() {
		CatalogType catalogType = new CatalogType(driver);
		catalogType.waitOperationButton();
		catalogType.operationButton.click();
		String actualResult = catalogType.expandSideMenu.getAttribute("style");
		String expectedResult = "transform: translateX(25px) translateY(-35px) rotate(0deg) translateZ(0px);";
		softassert.assertEquals(actualResult, expectedResult);
		softassert.assertAll();
	}

	@Test(priority = 2)
	public void clickOnAssetsManagement() {
		CatalogType catalogType = new CatalogType(driver);
		catalogType.waitAssetsManagementButton();
		catalogType.assetsManagementButton.click();
		String actualResult = catalogType.assetsManagementButton.getAttribute("class");
		String expectedResult = "flex-1 capitalize whitespace-break-spaces text-[13px] font-medium text-white";
		softassert.assertEquals(actualResult, expectedResult);
		softassert.assertAll();
	}

	@Test(priority = 3)
	public void clickOnCatalogTypeButton() throws InterruptedException {
		CatalogType catalogType = new CatalogType(driver);

		catalogType.waitCatalogTypeButton();
		catalogType.catalogTypeButton.click();

		Thread.sleep(3000);
		String actualResult = driver.getCurrentUrl();
		String expectedResult = "https://dev-summit.boxsyst.com/catalog_type";

		softassert.assertEquals(actualResult, expectedResult);
		softassert.assertAll();
	}

	@Test(priority = 4)
	public void closeSideArrow() {
		CatalogType catalogType = new CatalogType(driver);
		catalogType.waitSideArrow();
		catalogType.sideArrow.click();
		String actualResult = catalogType.closeSideMenu.getAttribute("style");
		String expectedResult = "transform: translateX(25px) translateY(-35px) rotate(180deg) translateZ(0px);";
		softassert.assertEquals(actualResult, expectedResult);
		softassert.assertAll();
	}

	@Test(priority = 5)
	public void addNewProductWithValidData() {
		CatalogType catalogType = new CatalogType(driver);

		catalogType.waitAddNewProduct();
		catalogType.addNewProduct.click();

		catalogType.waitProductDescriptionField();
		catalogType.productDescriptionField.sendKeys(testString);

		catalogType.waitItemTypeField();
		catalogType.itemTypeField.click();

		Actions action = new Actions(driver);
		action.moveToElement(catalogType.itemTypeField).sendKeys(Keys.ARROW_DOWN).build().perform();
		action.moveToElement(catalogType.itemTypeField).sendKeys(Keys.ENTER).build().perform();

		catalogType.waitItemTypePropertiesTitle1();
		catalogType.itemTypePropertiesTitle1.sendKeys("1");

		catalogType.waitItemTypePropertiesTitle2();
		catalogType.itemTypePropertiesTitle2.sendKeys("2");

		catalogType.waitItemTypePropertiesTitle3();
		catalogType.itemTypePropertiesTitle3.sendKeys("3");

		catalogType.waitICreateButton();
		catalogType.createButton.click();

		catalogType.waitIToasterMessage();

		String actualResult = catalogType.toasterMessage.getText();

		String expectedResult = "Add catalog type product succeed.";

		softassert.assertEquals(actualResult, expectedResult);
		softassert.assertAll();
	}

	@Test(priority = 6)
	public void addNewProductWithInvalidData() throws InterruptedException {
		CatalogType catalogType = new CatalogType(driver);

		catalogType.waitAddNewProduct();
		catalogType.addNewProduct.click();

		catalogType.waitProductDescriptionField();
		catalogType.productDescriptionField.sendKeys(testString);

		catalogType.waitItemTypeField();
		catalogType.itemTypeField.click();

		Actions action = new Actions(driver);
		action.moveToElement(catalogType.itemTypeField).sendKeys(Keys.ARROW_DOWN).build().perform();

		action.moveToElement(catalogType.itemTypeField).sendKeys(Keys.ENTER).build().perform();

		catalogType.waitItemTypePropertiesTitle1();
		catalogType.itemTypePropertiesTitle1.sendKeys("1");

		catalogType.waitItemTypePropertiesTitle2();
		catalogType.itemTypePropertiesTitle2.sendKeys("2");

		catalogType.waitItemTypePropertiesTitle3();
		catalogType.itemTypePropertiesTitle3.sendKeys("3");

		catalogType.waitICreateButton();
		catalogType.createButton.click();

		catalogType.waitIToasterMessage();

		Thread.sleep(2000);
		String actualExsisttResult = catalogType.toasterMessage.getText();
		String expectedExsistResult = "Product Type Exists.";

		softassert.assertEquals(actualExsisttResult, expectedExsistResult);

		softassert.assertAll();

		catalogType.waitCancelButton();
		catalogType.cancelButton.click();
	}

	@Test(priority = 7)
	public void searchWithValidData() throws InterruptedException {
		CatalogType catalogType = new CatalogType(driver);

		catalogType.waitSearchfield();
		catalogType.searchfield.sendKeys(testString);

		catalogType.waitProductDescriptionColumn();
		Thread.sleep(3000);

		String actualResult = catalogType.productDescriptionColumn.getText();
		String expectedResult = testString;

		softassert.assertEquals(actualResult, expectedResult);
		softassert.assertAll();
	}

	@Test(priority = 8)
	public void editProduct() throws InterruptedException {
		CatalogType catalogType = new CatalogType(driver);

		catalogType.waitEditProduct();
		catalogType.editProduct.click();

		catalogType.waitItemTypePropertiesTitle1();
		catalogType.itemTypePropertiesTitle1.sendKeys(Keys.BACK_SPACE);
		catalogType.itemTypePropertiesTitle1.sendKeys("9");

		catalogType.waitSaveButton();
		catalogType.saveButton.click();

		catalogType.waitToasterMessageUpdateCatalog();

		Actions actions = new Actions(driver);

		actions.moveToElement(catalogType.toasterMessageUpdateCatalog).build().perform();
		Thread.sleep(2000);
		String actualResult = catalogType.toasterMessageUpdateCatalog.getText();
		String expectedResult = "Update catalog type product succeed.";

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