package Vendors;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.summit.login.GoogleAuthenticatorTC;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Contacts {
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
		Vendor expenseInvoice = new Vendor(driver);
		expenseInvoice.preTest();
	}

	@Test(priority = 1)
	public void click_on_finance_at_side_menu() throws InterruptedException {
		Vendor vendor = new Vendor(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		vendor.waitfinanceButton();
		vendor.financeButton.click();
		js.executeScript("arguments[0].scrollIntoView();", vendor.financeButton);
		vendor.waitexpandSideMenu();
		Thread.sleep(3000);
		String actualResult = vendor.expandSideMenu.getAttribute("style");
		String expectedResult = "width: 16rem; transform: none;";
		softassert.assertEquals(actualResult, expectedResult);
		softassert.assertAll();
	}

	@Test(priority = 2)
	public void Click_on_Accounting_Settings_at_side_menu() throws InterruptedException {
		Vendor vendor = new Vendor(driver);
		vendor.waitAccountingSettings();
		vendor.accountingSettings.click();
		Thread.sleep(3000);
		String actualResult = vendor.expandSubMenu.getAttribute("alt");
		String expectedResult = "arrowUp";
		softassert.assertEquals(actualResult, expectedResult);
		softassert.assertAll();
	}

	@Test(priority = 3)
	public void click_On_Vendor_Button() throws InterruptedException {
		Vendor vendor = new Vendor(driver);

		vendor.waitVendorButton();

		vendor.vendorButton.click();
		String actualResult = driver.getCurrentUrl();
		String expectedResult = "https://dev-summit.boxsyst.com/vendor";

		softassert.assertEquals(actualResult, expectedResult);
		softassert.assertAll();

		vendor.waitClosesideMenu();
		vendor.closesideMenu.click();

	}

	@Test(priority = 4)
	public void addNewContactsWithEmptyFields() throws InterruptedException {
		Vendor vendor = new Vendor(driver);

		vendor.waitSearchField();
		vendor.searchField.sendKeys("NadsoftTest");

		vendor.waitDetailsButton();
		vendor.detailsButton.click();

		vendor.waitContactsTab();
		vendor.contactsTab.click();

		vendor.waitAddNewContactButton();
		vendor.addNewContactButton.click();
		Thread.sleep(2000);

		vendor.waitSaveButtonInAddNewContactPopUp();
		vendor.saveButtonInAddNewContactPopUp.click();

		vendor.waitValidationMsgForFirstName();
		String actualValidationMsgForFirstName = vendor.validationMsgForFirstName.getText();
		String expectedValidationMsgForFirstName = "This is required.";

		softassert.assertEquals(actualValidationMsgForFirstName, expectedValidationMsgForFirstName);

		Thread.sleep(1000);
		vendor.waitValidationMsgForLastName();
		String actualValidationMsgForLastName = vendor.validationMsgForLastName.getText();
		String expectedValidationMsgForLastName = "This is required.";

		softassert.assertEquals(actualValidationMsgForLastName, expectedValidationMsgForLastName);

		vendor.waitValidationMsgForContactsType();
		String actualValidationMsgForContactsType = vendor.validationMsgForContactsType.getText();
		String expectedValidationMsgForContactsType = "This is required.";

		softassert.assertEquals(actualValidationMsgForContactsType, expectedValidationMsgForContactsType);

		vendor.waitValidationMsgForPosition();
		String actualValidationMsgForPosition = vendor.validationMsgForPosition.getText();
		String expectedValidationMsgForPosition = "This is required.";

		softassert.assertEquals(actualValidationMsgForPosition, expectedValidationMsgForPosition);

		vendor.waitEmailField();
		vendor.emailField.sendKeys("test@.com");

		vendor.waitInvalidEmailValidationMsg();
		String actualInvalidValidationMsg = vendor.invalidEmailValidationMsg.getText();
		String expectedInvalidValidationMsg = "Invalid email address";

		softassert.assertEquals(actualInvalidValidationMsg, expectedInvalidValidationMsg);

		softassert.assertAll();

	}

	@Test(priority = 5)
	public void addNewContactsWithValidData() {
		Vendor vendor = new Vendor(driver);

		vendor.waitfirstName();
		vendor.firstNameField.sendKeys("Mahmoud");

		vendor.waitLastNameField();
		vendor.lastNameField.sendKeys("Abu Wardeh");

		vendor.waitContactsTypeDropDown();
		vendor.contactsTypeDropDown.click();

		vendor.waitSelectPrimaryOption();
		vendor.selectPrimaryOption.click();

		vendor.waitPositionDropDown();
		vendor.positionDropDown.click();

		vendor.waitSelectMarketingManagerOption();
		vendor.selectMarketingManagerOption.click();

		vendor.waitPhoneNumberField();
		vendor.phoneNumberField.sendKeys("0798548754");

		vendor.waitMobileNumberField();
		vendor.mobileNumberField.sendKeys("0799999999");

		vendor.waitEmailField();
		vendor.emailField.click();
		vendor.emailField.clear();

		vendor.emailField.sendKeys("m@nadsoft.com");

		vendor.waitSkypeNameField();
		vendor.skypeNameField.sendKeys("M.skype");

		vendor.waitAddressLine1();
		vendor.addressLine1.sendKeys("Amman");

		vendor.waitAddressLine2();
		vendor.addressLine2.sendKeys("Mecca Street");

		vendor.waitCityFieldInContacts();
		vendor.cityFieldInContacts.sendKeys("Amman");

		vendor.waitCountyField();
		vendor.countyField.sendKeys("Yes");

		vendor.waitPostelCode();
		vendor.postelCode.sendKeys("0445");

		vendor.waitCountryDropDown();
		vendor.countryDropDown.click();

		vendor.waitSearchFieldInCountryInAddNewContact();
		vendor.searchFieldInCountryInAddNewContact.sendKeys("Jordan");
		vendor.searchFieldInCountryInAddNewContact.sendKeys(Keys.ENTER);
		
//		vendor.waitSaveButtonInAddNewContactPopUp();
//		vendor.saveButtonInAddNewContactPopUp.click();

	}

}
