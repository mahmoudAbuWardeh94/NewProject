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

public class VendorTC {
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
		Thread.sleep(2000);

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
	public void add_New_Vendor() {
		Vendor vendor = new Vendor(driver);
		vendor.waitAddNewVendor();
		vendor.addNewVendor.click();

		String actualResult = driver.getCurrentUrl();
		String expectedResult = "https://dev-summit.boxsyst.com/finances/add-vendor";

		softassert.assertEquals(actualResult, expectedResult);
		softassert.assertAll();

	}

	@Test(priority = 5)
	public void enterValidDataWithEmptyCompanyName() throws InterruptedException {
		Vendor vendor = new Vendor(driver);

		vendor.waitCompanyBusinessName();
		vendor.companyBusinessName.click();
		vendor.companyBusinessName.sendKeys("");

		vendor.waitAccountReference();
		vendor.accountReference.click();
		vendor.accountReference.sendKeys("12");

		vendor.waitPhoneNumber();
		vendor.phoneNumber.click();
		vendor.phoneNumber.sendKeys("1234567890");

		vendor.waitWebsite();
		vendor.website.click();
		vendor.website.sendKeys("www.Facbock.com");

		vendor.waitStreet1();
		vendor.street1.click();
		vendor.street1.sendKeys("Salte");

		vendor.waitStreet2();
		vendor.street2.click();
		vendor.street2.sendKeys("60Street");

		vendor.waitCityField();
		vendor.cityField.click();
		vendor.cityField.sendKeys("Salte");

		vendor.waitCountry();
		vendor.country.click();
		vendor.waitCountrySearch();
		vendor.countrySearch.click();
		vendor.countrySearch.sendKeys("jord");

		vendor.countrySearch.sendKeys(Keys.ARROW_DOWN);
		vendor.countrySearch.sendKeys(Keys.ENTER);

		vendor.waitZipCode();
		vendor.zipCode.click();
		vendor.zipCode.sendKeys("1998");

		vendor.waitBillingAddressCheckBox();
		vendor.billingAddressCheckBox.click();

		vendor.waitFinanceTab();
		vendor.financeTab.click();

		vendor.waitAccountStatment();
		vendor.accountStatment.click();
		vendor.accountStatment.sendKeys("Husam Bani Odeh");

		Thread.sleep(2000);
		vendor.waitBankSortCode();
		vendor.bankSortCode.click();
		Thread.sleep(3000);
		vendor.waitValueOfBankSortCode();
		vendor.valueOfBankSortCode.click();

		vendor.waitDefaultCurrency();
		vendor.defaultCurrency.click();
		Thread.sleep(2000);
		vendor.waitValueOfDefaultCurrency();
		vendor.valueOfDefaultCurrency.click();

		vendor.waitDefaultPaymentMethod();
		vendor.defaultPaymentMethod.click();
		Thread.sleep(2000);
		vendor.waitValueOfDefaultPaymentMethod();
		vendor.valueOfDefaultPaymentMethod.click();

		vendor.waitOthersPaymentMethod();
		vendor.othersPaymentMethod.click();
		Thread.sleep(2000);
		vendor.waitValueOfOthersPaymentMethod();
		vendor.valueOfOthersPaymentMethod.click();

		vendor.waitTaxNumber1();
		vendor.taxNumber1.click();
		Thread.sleep(2000);
		vendor.waitValueOfTaxNumber1();
		vendor.valueOfTaxNumber1.click();
		vendor.waitFieldOfTaxNumber1();
		vendor.fieldOfTaxNumber1.click();
		vendor.fieldOfTaxNumber1.sendKeys("NadSoft11");

		vendor.waitTaxNumber2();
		vendor.taxNumber2.click();
		Thread.sleep(2000);
		vendor.waitValueOfTaxNumber2();
		vendor.valueOfTaxNumber2.click();
		vendor.waitFieldOfTaxNumber2();
		vendor.fieldOfTaxNumber2.click();
		vendor.fieldOfTaxNumber2.sendKeys("NadSoft22");

		vendor.waitTaxNumber3();
		vendor.taxNumber3.click();
		Thread.sleep(2000);
		vendor.waitValueOfTaxNumber3();
		vendor.valueOfTaxNumber3.click();
		vendor.waitFieldOfTaxNumber3();
		vendor.fieldOfTaxNumber3.click();
		vendor.fieldOfTaxNumber3.sendKeys("NadSoft33");

		vendor.waitBillsDuedateField();
		vendor.billsDuedateField.click();
		vendor.billsDuedateField.sendKeys("123");

		vendor.waitBillsDuedate();
		vendor.billsDuedate.click();
		vendor.waitValueOfBillsDuedate();
		Thread.sleep(2000);
		vendor.valueOfBillsDuedate.click();

		vendor.waitInvoiceDuedateField();
		vendor.invoiceDuedateField.click();
		vendor.invoiceDuedateField.sendKeys("456");

		vendor.waitInvoiceDuedate();
		vendor.invoiceDuedate.click();
		Thread.sleep(2000);
		vendor.waitValueOfInvoiceDuedate();
		vendor.valueOfInvoiceDuedate.click();

		vendor.waitSubmitButton();
		vendor.submitButton.click();

		vendor.waitPopUP();

		String actualResult = vendor.popUP.getText();

		String expectedResult = "Please fill company name.";

		softassert.assertEquals(actualResult, expectedResult);
		softassert.assertAll();

		driver.navigate().refresh();

	}

	@Test(priority = 6)
	public void enterValidDataWithEmptyPhoneNumber() throws InterruptedException {
		Vendor vendor = new Vendor(driver);

		vendor.waitCompanyBusinessName();
		vendor.companyBusinessName.click();
		vendor.companyBusinessName.sendKeys("Husam1");

		vendor.waitAccountReference();
		vendor.accountReference.click();
		vendor.accountReference.sendKeys("12");

		vendor.waitPhoneNumber();
		vendor.phoneNumber.click();
		vendor.phoneNumber.sendKeys("");

		vendor.waitWebsite();
		vendor.website.click();
		vendor.website.sendKeys("www.Facbock.com");

		vendor.waitStreet1();
		vendor.street1.click();
		vendor.street1.sendKeys("Salte");

		vendor.waitStreet2();
		vendor.street2.click();
		vendor.street2.sendKeys("60Street");

		vendor.waitCityField();
		vendor.cityField.click();
		vendor.cityField.sendKeys("Salte");

		vendor.waitCountry();
		vendor.country.click();
		vendor.waitCountrySearch();
		vendor.countrySearch.click();
		vendor.countrySearch.sendKeys("jord");

		vendor.countrySearch.sendKeys(Keys.ARROW_DOWN);
		vendor.countrySearch.sendKeys(Keys.ENTER);

		vendor.waitZipCode();
		vendor.zipCode.click();
		vendor.zipCode.sendKeys("1998");

		vendor.waitBillingAddressCheckBox();
		vendor.billingAddressCheckBox.click();

		vendor.waitFinanceTab();
		vendor.financeTab.click();

		vendor.waitAccountStatment();
		vendor.accountStatment.click();
		vendor.accountStatment.sendKeys("Husam Bani Odeh");

		Thread.sleep(2000);
		vendor.waitBankSortCode();
		vendor.bankSortCode.click();
		Thread.sleep(3000);
		vendor.waitValueOfBankSortCode();
		vendor.valueOfBankSortCode.click();

		vendor.waitDefaultCurrency();
		vendor.defaultCurrency.click();
		Thread.sleep(2000);
		vendor.waitValueOfDefaultCurrency();
		vendor.valueOfDefaultCurrency.click();

		vendor.waitDefaultPaymentMethod();
		vendor.defaultPaymentMethod.click();
		Thread.sleep(2000);
		vendor.waitValueOfDefaultPaymentMethod();
		vendor.valueOfDefaultPaymentMethod.click();

		vendor.waitOthersPaymentMethod();
		vendor.othersPaymentMethod.click();
		Thread.sleep(2000);
		vendor.waitValueOfOthersPaymentMethod();
		vendor.valueOfOthersPaymentMethod.click();

		vendor.waitTaxNumber1();
		vendor.taxNumber1.click();
		Thread.sleep(2000);
		vendor.waitValueOfTaxNumber1();
		vendor.valueOfTaxNumber1.click();
		vendor.waitFieldOfTaxNumber1();
		vendor.fieldOfTaxNumber1.click();
		vendor.fieldOfTaxNumber1.sendKeys("NadSoft11");

		vendor.waitTaxNumber2();
		vendor.taxNumber2.click();
		Thread.sleep(2000);
		vendor.waitValueOfTaxNumber2();
		vendor.valueOfTaxNumber2.click();
		vendor.waitFieldOfTaxNumber2();
		vendor.fieldOfTaxNumber2.click();
		vendor.fieldOfTaxNumber2.sendKeys("NadSoft22");

		vendor.waitTaxNumber3();
		vendor.taxNumber3.click();
		Thread.sleep(2000);
		vendor.waitValueOfTaxNumber3();
		vendor.valueOfTaxNumber3.click();
		vendor.waitFieldOfTaxNumber3();
		vendor.fieldOfTaxNumber3.click();
		vendor.fieldOfTaxNumber3.sendKeys("NadSoft33");

		vendor.waitBillsDuedateField();
		vendor.billsDuedateField.click();
		vendor.billsDuedateField.sendKeys("123");

		vendor.waitBillsDuedate();
		vendor.billsDuedate.click();
		vendor.waitValueOfBillsDuedate();
		Thread.sleep(2000);
		vendor.valueOfBillsDuedate.click();

		vendor.waitInvoiceDuedateField();
		vendor.invoiceDuedateField.click();
		vendor.invoiceDuedateField.sendKeys("456");

		vendor.waitInvoiceDuedate();
		vendor.invoiceDuedate.click();
		Thread.sleep(2000);
		vendor.waitValueOfInvoiceDuedate();
		vendor.valueOfInvoiceDuedate.click();

		vendor.waitSubmitButton();
		vendor.submitButton.click();

		vendor.waitPopUP();

		String actualResult = vendor.popUP.getText();

		String expectedResult = "Please fill phone number.";

		softassert.assertEquals(actualResult, expectedResult);
		softassert.assertAll();
		driver.navigate().refresh();

	}

	@Test(priority = 7)
	public void enterValidDataWithEmptyStreet() throws InterruptedException {
		Vendor vendor = new Vendor(driver);

		vendor.waitCompanyBusinessName();
		vendor.companyBusinessName.click();
		vendor.companyBusinessName.sendKeys("Husam1");

		vendor.waitAccountReference();
		vendor.accountReference.click();
		vendor.accountReference.sendKeys("12");

		vendor.waitPhoneNumber();
		vendor.phoneNumber.click();
		vendor.phoneNumber.sendKeys("00962775112511");

		vendor.waitWebsite();
		vendor.website.click();
		vendor.website.sendKeys("www.Facbock.com");

		vendor.waitStreet1();
		vendor.street1.click();
		vendor.street1.sendKeys("");

		vendor.waitStreet2();
		vendor.street2.click();
		vendor.street2.sendKeys("60Street");

		vendor.waitCityField();
		vendor.cityField.click();
		vendor.cityField.sendKeys("Salte");

		vendor.waitCountry();
		vendor.country.click();
		vendor.waitCountrySearch();
		vendor.countrySearch.click();
		vendor.countrySearch.sendKeys("jord");

		vendor.countrySearch.sendKeys(Keys.ARROW_DOWN);
		vendor.countrySearch.sendKeys(Keys.ENTER);

		vendor.waitZipCode();
		vendor.zipCode.click();
		vendor.zipCode.sendKeys("1998");

		vendor.waitBillingAddressCheckBox();
		vendor.billingAddressCheckBox.click();

		vendor.waitFinanceTab();
		vendor.financeTab.click();

		vendor.waitAccountStatment();
		vendor.accountStatment.click();
		vendor.accountStatment.sendKeys("Husam Bani Odeh");

		Thread.sleep(2000);
		vendor.waitBankSortCode();
		vendor.bankSortCode.click();
		Thread.sleep(3000);
		vendor.waitValueOfBankSortCode();
		vendor.valueOfBankSortCode.click();

		vendor.waitDefaultCurrency();
		vendor.defaultCurrency.click();
		Thread.sleep(2000);
		vendor.waitValueOfDefaultCurrency();
		vendor.valueOfDefaultCurrency.click();

		vendor.waitDefaultPaymentMethod();
		vendor.defaultPaymentMethod.click();
		Thread.sleep(2000);
		vendor.waitValueOfDefaultPaymentMethod();
		vendor.valueOfDefaultPaymentMethod.click();

		vendor.waitOthersPaymentMethod();
		vendor.othersPaymentMethod.click();
		Thread.sleep(2000);
		vendor.waitValueOfOthersPaymentMethod();
		vendor.valueOfOthersPaymentMethod.click();

		vendor.waitTaxNumber1();
		vendor.taxNumber1.click();
		Thread.sleep(2000);
		vendor.waitValueOfTaxNumber1();
		vendor.valueOfTaxNumber1.click();
		vendor.waitFieldOfTaxNumber1();
		vendor.fieldOfTaxNumber1.click();
		vendor.fieldOfTaxNumber1.sendKeys("NadSoft11");

		vendor.waitTaxNumber2();
		vendor.taxNumber2.click();
		Thread.sleep(2000);
		vendor.waitValueOfTaxNumber2();
		vendor.valueOfTaxNumber2.click();
		vendor.waitFieldOfTaxNumber2();
		vendor.fieldOfTaxNumber2.click();
		vendor.fieldOfTaxNumber2.sendKeys("NadSoft22");

		vendor.waitTaxNumber3();
		vendor.taxNumber3.click();
		Thread.sleep(2000);
		vendor.waitValueOfTaxNumber3();
		vendor.valueOfTaxNumber3.click();
		vendor.waitFieldOfTaxNumber3();
		vendor.fieldOfTaxNumber3.click();
		vendor.fieldOfTaxNumber3.sendKeys("NadSoft33");

		vendor.waitBillsDuedateField();
		vendor.billsDuedateField.click();
		vendor.billsDuedateField.sendKeys("123");

		vendor.waitBillsDuedate();
		vendor.billsDuedate.click();
		vendor.waitValueOfBillsDuedate();
		Thread.sleep(2000);
		vendor.valueOfBillsDuedate.click();

		vendor.waitInvoiceDuedateField();
		vendor.invoiceDuedateField.click();
		vendor.invoiceDuedateField.sendKeys("456");

		vendor.waitInvoiceDuedate();
		vendor.invoiceDuedate.click();
		Thread.sleep(2000);
		vendor.waitValueOfInvoiceDuedate();
		vendor.valueOfInvoiceDuedate.click();

		vendor.waitSubmitButton();
		vendor.submitButton.click();

		vendor.waitPopUP();

		String actualResult = vendor.popUP.getText();

		String expectedResult = "Please fill main address street.";

		softassert.assertEquals(actualResult, expectedResult);
		softassert.assertAll();
		driver.navigate().refresh();

	}

	@Test(priority = 8)
	public void enterValidDataWithEmptyCity() throws InterruptedException {
		Vendor vendor = new Vendor(driver);

		vendor.waitCompanyBusinessName();
		vendor.companyBusinessName.click();
		vendor.companyBusinessName.sendKeys("Husam1");

		vendor.waitAccountReference();
		vendor.accountReference.click();
		vendor.accountReference.sendKeys("12");

		vendor.waitPhoneNumber();
		vendor.phoneNumber.click();
		vendor.phoneNumber.sendKeys("00962775112511");

		vendor.waitWebsite();
		vendor.website.click();
		vendor.website.sendKeys("www.Facbock.com");

		vendor.waitStreet1();
		vendor.street1.click();
		vendor.street1.sendKeys("salte");

		vendor.waitStreet2();
		vendor.street2.click();
		vendor.street2.sendKeys("60Street");

		vendor.waitCityField();
		vendor.cityField.click();
		vendor.cityField.sendKeys("");

		vendor.waitCountry();
		vendor.country.click();
		vendor.waitCountrySearch();
		vendor.countrySearch.click();
		vendor.countrySearch.sendKeys("jord");

		vendor.countrySearch.sendKeys(Keys.ARROW_DOWN);
		vendor.countrySearch.sendKeys(Keys.ENTER);

		vendor.waitZipCode();
		vendor.zipCode.click();
		vendor.zipCode.sendKeys("1998");

		vendor.waitBillingAddressCheckBox();
		vendor.billingAddressCheckBox.click();

		vendor.waitFinanceTab();
		vendor.financeTab.click();

		vendor.waitAccountStatment();
		vendor.accountStatment.click();
		vendor.accountStatment.sendKeys("Husam Bani Odeh");

		Thread.sleep(2000);
		vendor.waitBankSortCode();
		vendor.bankSortCode.click();
		Thread.sleep(3000);
		vendor.waitValueOfBankSortCode();
		vendor.valueOfBankSortCode.click();

		vendor.waitDefaultCurrency();
		vendor.defaultCurrency.click();
		Thread.sleep(2000);
		vendor.waitValueOfDefaultCurrency();
		vendor.valueOfDefaultCurrency.click();

		vendor.waitDefaultPaymentMethod();
		vendor.defaultPaymentMethod.click();
		Thread.sleep(2000);
		vendor.waitValueOfDefaultPaymentMethod();
		vendor.valueOfDefaultPaymentMethod.click();

		vendor.waitOthersPaymentMethod();
		vendor.othersPaymentMethod.click();
		Thread.sleep(2000);
		vendor.waitValueOfOthersPaymentMethod();
		vendor.valueOfOthersPaymentMethod.click();

		vendor.waitTaxNumber1();
		vendor.taxNumber1.click();
		Thread.sleep(2000);
		vendor.waitValueOfTaxNumber1();
		vendor.valueOfTaxNumber1.click();
		vendor.waitFieldOfTaxNumber1();
		vendor.fieldOfTaxNumber1.click();
		vendor.fieldOfTaxNumber1.sendKeys("NadSoft11");

		vendor.waitTaxNumber2();
		vendor.taxNumber2.click();
		Thread.sleep(2000);
		vendor.waitValueOfTaxNumber2();
		vendor.valueOfTaxNumber2.click();
		vendor.waitFieldOfTaxNumber2();
		vendor.fieldOfTaxNumber2.click();
		vendor.fieldOfTaxNumber2.sendKeys("NadSoft22");

		vendor.waitTaxNumber3();
		vendor.taxNumber3.click();
		Thread.sleep(2000);
		vendor.waitValueOfTaxNumber3();
		vendor.valueOfTaxNumber3.click();
		vendor.waitFieldOfTaxNumber3();
		vendor.fieldOfTaxNumber3.click();
		vendor.fieldOfTaxNumber3.sendKeys("NadSoft33");

		vendor.waitBillsDuedateField();
		vendor.billsDuedateField.click();
		vendor.billsDuedateField.sendKeys("123");

		vendor.waitBillsDuedate();
		vendor.billsDuedate.click();
		vendor.waitValueOfBillsDuedate();
		Thread.sleep(2000);
		vendor.valueOfBillsDuedate.click();

		vendor.waitInvoiceDuedateField();
		vendor.invoiceDuedateField.click();
		vendor.invoiceDuedateField.sendKeys("456");

		vendor.waitInvoiceDuedate();
		vendor.invoiceDuedate.click();
		Thread.sleep(2000);
		vendor.waitValueOfInvoiceDuedate();
		vendor.valueOfInvoiceDuedate.click();

		vendor.waitSubmitButton();
		vendor.submitButton.click();

		vendor.waitPopUP();

		String actualResult = vendor.popUP.getText();

		String expectedResult = "Please fill main city." + "";

		softassert.assertEquals(actualResult, expectedResult);
		softassert.assertAll();
		driver.navigate().refresh();

	}

	@Test(priority = 9)
	public void enterValidDataWithEmptyCountry() throws InterruptedException {
		Vendor vendor = new Vendor(driver);
		vendor.waitCompanyBusinessName();
		vendor.companyBusinessName.click();
		vendor.companyBusinessName.sendKeys("Husam1");

		vendor.waitAccountReference();
		vendor.accountReference.click();
		vendor.accountReference.sendKeys("12");

		vendor.waitPhoneNumber();
		vendor.phoneNumber.click();
		vendor.phoneNumber.sendKeys("00962775112511");

		vendor.waitWebsite();
		vendor.website.click();
		vendor.website.sendKeys("www.Facbock.com");

		vendor.waitStreet1();
		vendor.street1.click();
		vendor.street1.sendKeys("salte");

		vendor.waitStreet2();
		vendor.street2.click();
		vendor.street2.sendKeys("60Street");

		vendor.waitCityField();
		vendor.cityField.click();
		vendor.cityField.sendKeys("salt");

		vendor.waitZipCode();
		vendor.zipCode.click();
		vendor.zipCode.sendKeys("1998");

		vendor.waitBillingAddressCheckBox();
		vendor.billingAddressCheckBox.click();

		vendor.waitFinanceTab();
		vendor.financeTab.click();

		vendor.waitAccountStatment();
		vendor.accountStatment.click();
		vendor.accountStatment.sendKeys("Husam Bani Odeh");

		Thread.sleep(2000);
		vendor.waitBankSortCode();
		vendor.bankSortCode.click();
		Thread.sleep(3000);
		vendor.waitValueOfBankSortCode();
		vendor.valueOfBankSortCode.click();

		vendor.waitDefaultCurrency();
		vendor.defaultCurrency.click();
		Thread.sleep(2000);
		vendor.waitValueOfDefaultCurrency();
		vendor.valueOfDefaultCurrency.click();

		vendor.waitDefaultPaymentMethod();
		vendor.defaultPaymentMethod.click();
		Thread.sleep(2000);
		vendor.waitValueOfDefaultPaymentMethod();
		vendor.valueOfDefaultPaymentMethod.click();

		vendor.waitOthersPaymentMethod();
		vendor.othersPaymentMethod.click();
		Thread.sleep(2000);
		vendor.waitValueOfOthersPaymentMethod();
		vendor.valueOfOthersPaymentMethod.click();

		vendor.waitTaxNumber1();
		vendor.taxNumber1.click();
		Thread.sleep(2000);
		vendor.waitValueOfTaxNumber1();
		vendor.valueOfTaxNumber1.click();
		vendor.waitFieldOfTaxNumber1();
		vendor.fieldOfTaxNumber1.click();
		vendor.fieldOfTaxNumber1.sendKeys("NadSoft11");

		vendor.waitTaxNumber2();
		vendor.taxNumber2.click();
		Thread.sleep(2000);
		vendor.waitValueOfTaxNumber2();
		vendor.valueOfTaxNumber2.click();
		vendor.waitFieldOfTaxNumber2();
		vendor.fieldOfTaxNumber2.click();
		vendor.fieldOfTaxNumber2.sendKeys("NadSoft22");

		vendor.waitTaxNumber3();
		vendor.taxNumber3.click();
		Thread.sleep(2000);
		vendor.waitValueOfTaxNumber3();
		vendor.valueOfTaxNumber3.click();
		vendor.waitFieldOfTaxNumber3();
		vendor.fieldOfTaxNumber3.click();
		vendor.fieldOfTaxNumber3.sendKeys("NadSoft33");

		vendor.waitBillsDuedateField();
		vendor.billsDuedateField.click();
		vendor.billsDuedateField.sendKeys("123");

		vendor.waitBillsDuedate();
		vendor.billsDuedate.click();
		vendor.waitValueOfBillsDuedate();
		Thread.sleep(2000);
		vendor.valueOfBillsDuedate.click();

		vendor.waitInvoiceDuedateField();
		vendor.invoiceDuedateField.click();
		vendor.invoiceDuedateField.sendKeys("456");

		vendor.waitInvoiceDuedate();
		vendor.invoiceDuedate.click();
		Thread.sleep(2000);
		vendor.waitValueOfInvoiceDuedate();
		vendor.valueOfInvoiceDuedate.click();

		vendor.waitSubmitButton();
		vendor.submitButton.click();

		vendor.waitPopUP();

		String actualResult = vendor.popUP.getText();

		String expectedResult = "Please select main address country.";

		softassert.assertEquals(actualResult, expectedResult);
		softassert.assertAll();
		driver.navigate().refresh();

	}

	@Test(priority = 10)
	public void enterValidDataWithEmptyZipCode() throws InterruptedException {
		Vendor vendor = new Vendor(driver);

		vendor.waitCompanyBusinessName();
		vendor.companyBusinessName.click();
		vendor.companyBusinessName.sendKeys("Husam1");

		vendor.waitAccountReference();
		vendor.accountReference.click();
		vendor.accountReference.sendKeys("12");

		vendor.waitPhoneNumber();
		vendor.phoneNumber.click();
		vendor.phoneNumber.sendKeys("00962775112511");

		vendor.waitWebsite();
		vendor.website.click();
		vendor.website.sendKeys("www.Facbock.com");

		vendor.waitStreet1();
		vendor.street1.click();
		vendor.street1.sendKeys("salte");

		vendor.waitStreet2();
		vendor.street2.click();
		vendor.street2.sendKeys("60Street");

		vendor.waitCityField();
		vendor.cityField.click();
		vendor.cityField.sendKeys("salte");

		vendor.waitCountry();
		vendor.country.click();
		vendor.waitCountrySearch();
		vendor.countrySearch.click();
		vendor.countrySearch.sendKeys("jord");

		vendor.countrySearch.sendKeys(Keys.ARROW_DOWN);
		vendor.countrySearch.sendKeys(Keys.ENTER);

		vendor.waitZipCode();
		vendor.zipCode.click();
		vendor.zipCode.sendKeys("");

		vendor.waitBillingAddressCheckBox();
		vendor.billingAddressCheckBox.click();

		vendor.waitFinanceTab();
		vendor.financeTab.click();

		vendor.waitAccountStatment();
		vendor.accountStatment.click();
		vendor.accountStatment.sendKeys("Husam Bani Odeh");

		Thread.sleep(2000);
		vendor.waitBankSortCode();
		vendor.bankSortCode.click();
		Thread.sleep(3000);
		vendor.waitValueOfBankSortCode();
		vendor.valueOfBankSortCode.click();

		vendor.waitDefaultCurrency();
		vendor.defaultCurrency.click();
		Thread.sleep(2000);
		vendor.waitValueOfDefaultCurrency();
		vendor.valueOfDefaultCurrency.click();

		vendor.waitDefaultPaymentMethod();
		vendor.defaultPaymentMethod.click();
		Thread.sleep(2000);
		vendor.waitValueOfDefaultPaymentMethod();
		vendor.valueOfDefaultPaymentMethod.click();

		vendor.waitOthersPaymentMethod();
		vendor.othersPaymentMethod.click();
		Thread.sleep(2000);
		vendor.waitValueOfOthersPaymentMethod();
		vendor.valueOfOthersPaymentMethod.click();

		vendor.waitTaxNumber1();
		vendor.taxNumber1.click();
		Thread.sleep(2000);
		vendor.waitValueOfTaxNumber1();
		vendor.valueOfTaxNumber1.click();
		vendor.waitFieldOfTaxNumber1();
		vendor.fieldOfTaxNumber1.click();
		vendor.fieldOfTaxNumber1.sendKeys("NadSoft11");

		vendor.waitTaxNumber2();
		vendor.taxNumber2.click();
		Thread.sleep(2000);
		vendor.waitValueOfTaxNumber2();
		vendor.valueOfTaxNumber2.click();
		vendor.waitFieldOfTaxNumber2();
		vendor.fieldOfTaxNumber2.click();
		vendor.fieldOfTaxNumber2.sendKeys("NadSoft22");

		vendor.waitTaxNumber3();
		vendor.taxNumber3.click();
		Thread.sleep(2000);
		vendor.waitValueOfTaxNumber3();
		vendor.valueOfTaxNumber3.click();
		vendor.waitFieldOfTaxNumber3();
		vendor.fieldOfTaxNumber3.click();
		vendor.fieldOfTaxNumber3.sendKeys("NadSoft33");

		vendor.waitBillsDuedateField();
		vendor.billsDuedateField.click();
		vendor.billsDuedateField.sendKeys("123");

		vendor.waitBillsDuedate();
		vendor.billsDuedate.click();
		vendor.waitValueOfBillsDuedate();
		Thread.sleep(2000);
		vendor.valueOfBillsDuedate.click();

		vendor.waitInvoiceDuedateField();
		vendor.invoiceDuedateField.click();
		vendor.invoiceDuedateField.sendKeys("456");

		vendor.waitInvoiceDuedate();
		vendor.invoiceDuedate.click();
		Thread.sleep(2000);
		vendor.waitValueOfInvoiceDuedate();
		vendor.valueOfInvoiceDuedate.click();

		vendor.waitSubmitButton();
		vendor.submitButton.click();

		vendor.waitPopUP();

		String actualResult = vendor.popUP.getText();

		String expectedResult = "Please fill main address postal code.";

		softassert.assertEquals(actualResult, expectedResult);
		softassert.assertAll();
		driver.navigate().refresh();

	}

	@Test(priority = 11)
	public void enterValidDataWithoutDefaultCurrency() throws InterruptedException {
		Vendor vendor = new Vendor(driver);

		vendor.waitCompanyBusinessName();
		vendor.companyBusinessName.click();
		vendor.companyBusinessName.sendKeys("Husam1");

		vendor.waitAccountReference();
		vendor.accountReference.click();
		vendor.accountReference.sendKeys("12");

		vendor.waitPhoneNumber();
		vendor.phoneNumber.click();
		vendor.phoneNumber.sendKeys("00962775112511");

		vendor.waitWebsite();
		vendor.website.click();
		vendor.website.sendKeys("www.Facbock.com");

		vendor.waitStreet1();
		vendor.street1.click();
		vendor.street1.sendKeys("salte");

		vendor.waitStreet2();
		vendor.street2.click();
		vendor.street2.sendKeys("60Street");

		vendor.waitCityField();
		vendor.cityField.click();
		vendor.cityField.sendKeys("salte");

		vendor.waitCountry();
		vendor.country.click();
		vendor.waitCountrySearch();
		vendor.countrySearch.click();
		vendor.countrySearch.sendKeys("jord");

		vendor.countrySearch.sendKeys(Keys.ARROW_DOWN);
		vendor.countrySearch.sendKeys(Keys.ENTER);

		vendor.waitZipCode();
		vendor.zipCode.click();
		vendor.zipCode.sendKeys("1998");

		vendor.waitBillingAddressCheckBox();
		vendor.billingAddressCheckBox.click();

		vendor.waitFinanceTab();
		vendor.financeTab.click();

		vendor.waitAccountStatment();
		vendor.accountStatment.click();
		vendor.accountStatment.sendKeys("Husam Bani Odeh");

		Thread.sleep(2000);
		vendor.waitBankSortCode();
		vendor.bankSortCode.click();
		Thread.sleep(3000);
		vendor.waitValueOfBankSortCode();
		vendor.valueOfBankSortCode.click();

		vendor.waitDefaultPaymentMethod();
		vendor.defaultPaymentMethod.click();
		Thread.sleep(2000);
		vendor.waitValueOfDefaultPaymentMethod();
		vendor.valueOfDefaultPaymentMethod.click();

		vendor.waitOthersPaymentMethod();
		vendor.othersPaymentMethod.click();
		Thread.sleep(2000);
		vendor.waitValueOfOthersPaymentMethod();
		vendor.valueOfOthersPaymentMethod.click();

		vendor.waitTaxNumber1();
		vendor.taxNumber1.click();
		Thread.sleep(2000);
		vendor.waitValueOfTaxNumber1();
		vendor.valueOfTaxNumber1.click();
		vendor.waitFieldOfTaxNumber1();
		vendor.fieldOfTaxNumber1.click();
		vendor.fieldOfTaxNumber1.sendKeys("NadSoft11");

		vendor.waitTaxNumber2();
		vendor.taxNumber2.click();
		Thread.sleep(2000);
		vendor.waitValueOfTaxNumber2();
		vendor.valueOfTaxNumber2.click();
		vendor.waitFieldOfTaxNumber2();
		vendor.fieldOfTaxNumber2.click();
		vendor.fieldOfTaxNumber2.sendKeys("NadSoft22");

		vendor.waitTaxNumber3();
		vendor.taxNumber3.click();
		Thread.sleep(2000);
		vendor.waitValueOfTaxNumber3();
		vendor.valueOfTaxNumber3.click();
		vendor.waitFieldOfTaxNumber3();
		vendor.fieldOfTaxNumber3.click();
		vendor.fieldOfTaxNumber3.sendKeys("NadSoft33");

		vendor.waitBillsDuedateField();
		vendor.billsDuedateField.click();
		vendor.billsDuedateField.sendKeys("123");

		vendor.waitBillsDuedate();
		vendor.billsDuedate.click();
		vendor.waitValueOfBillsDuedate();
		Thread.sleep(2000);
		vendor.valueOfBillsDuedate.click();

		vendor.waitInvoiceDuedateField();
		vendor.invoiceDuedateField.click();
		vendor.invoiceDuedateField.sendKeys("456");

		vendor.waitInvoiceDuedate();
		vendor.invoiceDuedate.click();
		Thread.sleep(2000);
		vendor.waitValueOfInvoiceDuedate();
		vendor.valueOfInvoiceDuedate.click();

		vendor.waitSubmitButton();
		vendor.submitButton.click();

		vendor.waitValidationOfDefaultCurrency();

		String actualResult = vendor.validationOfDefaultCurrency.getText();

		String expectedResult = "This is required.";

		softassert.assertEquals(actualResult, expectedResult);
		softassert.assertAll();
		driver.navigate().refresh();

	}

	@Test(priority = 12)
	public void enterValidData() throws InterruptedException {
		Vendor vendor = new Vendor(driver);

		vendor.waitCompanyBusinessName();
		vendor.companyBusinessName.click();
		vendor.companyBusinessName.sendKeys("husam1");

		vendor.waitAccountReference();
		vendor.accountReference.click();
		vendor.accountReference.sendKeys("12");

		vendor.waitPhoneNumber();
		vendor.phoneNumber.click();
		vendor.phoneNumber.sendKeys("1234567890");

		vendor.waitWebsite();
		vendor.website.click();
		vendor.website.sendKeys("www.Facbock.com");

		vendor.waitStreet1();
		vendor.street1.click();
		vendor.street1.sendKeys("Salte");

		vendor.waitStreet2();
		vendor.street2.click();
		vendor.street2.sendKeys("60Street");

		vendor.waitCityField();
		vendor.cityField.click();
		vendor.cityField.sendKeys("Salte");

		vendor.waitCountry();
		vendor.country.click();
		vendor.waitCountrySearch();
		vendor.countrySearch.click();
		vendor.countrySearch.sendKeys("jord");

		vendor.countrySearch.sendKeys(Keys.ARROW_DOWN);
		vendor.countrySearch.sendKeys(Keys.ENTER);

		vendor.waitZipCode();
		vendor.zipCode.click();
		vendor.zipCode.sendKeys("1998");

		vendor.waitBillingAddressCheckBox();
		vendor.billingAddressCheckBox.click();

		vendor.waitNextButton();
		vendor.nextButton.click();

		vendor.waitAccountStatment();
		vendor.accountStatment.click();
		vendor.accountStatment.sendKeys("Husam Bani Odeh");

		Thread.sleep(2000);
		vendor.waitBankSortCode();
		vendor.bankSortCode.click();
		Thread.sleep(3000);
		vendor.waitValueOfBankSortCode();
		vendor.valueOfBankSortCode.click();

		vendor.waitDefaultCurrency();
		vendor.defaultCurrency.click();
		Thread.sleep(2000);
		vendor.waitValueOfDefaultCurrency();
		vendor.valueOfDefaultCurrency.click();

		vendor.waitDefaultPaymentMethod();
		vendor.defaultPaymentMethod.click();
		Thread.sleep(2000);
		vendor.waitValueOfDefaultPaymentMethod();
		vendor.valueOfDefaultPaymentMethod.click();

		vendor.waitOthersPaymentMethod();
		vendor.othersPaymentMethod.click();
		Thread.sleep(2000);
		vendor.waitValueOfOthersPaymentMethod();
		vendor.valueOfOthersPaymentMethod.click();

		vendor.waitTaxNumber1();
		vendor.taxNumber1.click();
		Thread.sleep(2000);
		vendor.waitValueOfTaxNumber1();
		vendor.valueOfTaxNumber1.click();
		vendor.waitFieldOfTaxNumber1();
		vendor.fieldOfTaxNumber1.click();
		vendor.fieldOfTaxNumber1.sendKeys("NadSoft11");

		vendor.waitTaxNumber2();
		vendor.taxNumber2.click();
		Thread.sleep(2000);
		vendor.waitValueOfTaxNumber2();
		vendor.valueOfTaxNumber2.click();
		vendor.waitFieldOfTaxNumber2();
		vendor.fieldOfTaxNumber2.click();
		vendor.fieldOfTaxNumber2.sendKeys("NadSoft22");

		vendor.waitTaxNumber3();
		vendor.taxNumber3.click();
		Thread.sleep(2000);
		vendor.waitValueOfTaxNumber3();
		vendor.valueOfTaxNumber3.click();
		vendor.waitFieldOfTaxNumber3();
		vendor.fieldOfTaxNumber3.click();
		vendor.fieldOfTaxNumber3.sendKeys("NadSoft33");

		vendor.waitBillsDuedateField();
		vendor.billsDuedateField.click();
		vendor.billsDuedateField.sendKeys("123");

		vendor.waitBillsDuedate();
		vendor.billsDuedate.click();
		vendor.waitValueOfBillsDuedate();
		Thread.sleep(2000);
		vendor.valueOfBillsDuedate.click();

		vendor.waitInvoiceDuedateField();
		vendor.invoiceDuedateField.click();
		vendor.invoiceDuedateField.sendKeys("456");

		vendor.waitInvoiceDuedate();
		vendor.invoiceDuedate.click();
		Thread.sleep(2000);
		vendor.waitValueOfInvoiceDuedate();
		vendor.valueOfInvoiceDuedate.click();

		vendor.waitSubmitButton();
		vendor.submitButton.click();

		vendor.waitPopUP();

		String actualResult = vendor.popUP.getText();

		String expectedResult = "Add vendor succeed.";

		softassert.assertEquals(actualResult, expectedResult);
		softassert.assertAll();

	}

}