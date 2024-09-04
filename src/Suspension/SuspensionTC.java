package Suspension;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Login.GoogleAuthenticatorTC;
import RetrieveSim.RetrieveSim;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SuspensionTC {
	public static WebDriver driver;

	Random rand = new Random();
	int randomNumber = rand.nextInt(10000);

	public String testString = "TestReason" + randomNumber;

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
		driver.navigate().to("https://dev-summit.boxsyst.com/suspension");
	}

	@Test(priority = 1)
	public void addNewSuspension() throws InterruptedException {
		Suspension suspension = new Suspension(driver);

		suspension.waitAdddNewSuspensionButton();
		suspension.adddNewSuspensionButton.click();

		suspension.waitManagerNameField();
		suspension.managerNameField.click();

		suspension.waitSelectManager();
		suspension.selectManager.click();

		suspension.waitUnitField();
		suspension.unitField.sendKeys("Head Office");

		suspension.unitField.click();

		suspension.waitSelectUnit();
		suspension.selectUnit.click();

		suspension.waitEmployeeNameField();
		suspension.employeeNameField.click();

		suspension.waitSelectEmployee();
		suspension.selectEmployee.click();

		suspension.waitFromDateField();
		suspension.fromDateField.click();

		suspension.waitSelectFromDate();
		suspension.selectFromDate.click();

		suspension.waitToDateField();
		suspension.toDateField.click();

		suspension.waitSelectToDate();
		suspension.selectToDate.click();

		suspension.waitReasonField();
		suspension.reasonField.sendKeys(testString);

		suspension.waitCreateButton();
		suspension.createButton.click();

		suspension.waitToasterMessage();

		String actualResult = suspension.toasterMessage.getText();
		String expectedResult = "Add suspension succeed.";

		softassert.assertEquals(actualResult, expectedResult);
		softassert.assertAll();
	}

	@Test(priority = 2)
	public void searchWithValidData() throws InterruptedException {
		Suspension suspension = new Suspension(driver);

		suspension.waitUnitEmployeeNameField();
		suspension.unitEmployeeNameField.sendKeys("Testing IDT700VI");

		suspension.waitCreateDateColumn();
		Thread.sleep(2000);
		suspension.createDateColumn.click();
		suspension.createDateColumn.click();

		suspension.waitReasonColumn();
		String actualResult = suspension.reasonColumn.getText();
		String expectedResult = testString;

		softassert.assertEquals(actualResult, expectedResult);
		softassert.assertAll();
	}

	@Test(priority = 3)
	public void updateSuspension() throws InterruptedException {

		Suspension suspension = new Suspension(driver);

		suspension.waitEditSuspensionButton();
		suspension.editSuspensionButton.click();

		suspension.waitStatusButton();
		suspension.statusButton.click();

		suspension.waitSaveButton();
		suspension.saveButton.click();

		Thread.sleep(2000);
		suspension.waitUpdatedToasterMessage();

		String actualResult = suspension.updatedToasterMessage.getText();
		String expectedResult = "Update suspension succeed.";

		softassert.assertEquals(actualResult, expectedResult);
		softassert.assertAll();

	}

}
