package Vendors;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.summit.login.GoogleAuthenticatorTC;
import com.summit.login.LoginPage;

public class Vendor {
	public WebDriver driver;
	public WebDriverWait wait;

	public Vendor(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//img[@alt='sideArrow']")
	WebElement closesideMenu;

	public void waitClosesideMenu() {
		closesideMenu = wait.until(ExpectedConditions.visibilityOf(closesideMenu));
		return;
	}

	@FindBy(xpath = "//img[@alt='Finances']")
	WebElement financeButton;

	public void waitfinanceButton() {
		financeButton = wait.until(ExpectedConditions.visibilityOf(financeButton));
		return;
	}

	@FindBy(xpath = "//p[normalize-space()='Expenses']")
	WebElement expenseButton;

	public void waitExpenseButton() {
		expenseButton = wait.until(ExpectedConditions.visibilityOf(expenseButton));
		return;
	}

	@FindBy(xpath = "//div[contains(@class,'md:relative fixed h-full')]")
	WebElement expandSideMenu;

	public void waitexpandSideMenu() {
		expandSideMenu = wait.until(ExpectedConditions.visibilityOf(expandSideMenu));
		return;
	}

	@FindBy(xpath = "(//img[contains(@alt,'arrowUp')])[1]")
	WebElement expandSubMenu;

	public void waitExpandSubMenu() {
		expandSubMenu = wait.until(ExpectedConditions.visibilityOf(expandSubMenu));
		return;
	}

	@FindBy(xpath = "//p[normalize-space()='Expense Invoice']")
	WebElement expenseInvoiceButton;

	public void waitExpenseInvoiceButton() {
		expenseInvoiceButton = wait.until(ExpectedConditions.visibilityOf(expenseInvoiceButton));
		return;
	}

	@FindBy(xpath = "(//input[@type='text'])[2]")
	WebElement searchField;

	public void waitSearchField() {
		searchField = wait.until(ExpectedConditions.visibilityOf(searchField));
		return;
	}

	@FindBy(xpath = "//li[@role='status']")
	WebElement toasterMessage;

	public void waitToasterMessage() {
		toasterMessage = wait.until(ExpectedConditions.visibilityOf(toasterMessage));
		return;
	}

	@FindBy(xpath = "//div[@id='root']//ol[contains(@class,'fixed top-0 z-[100] flex max-h-screen w-full flex-col-reverse p-4 sm:bottom-0 sm:right-0 sm:top-auto sm:flex-col md:max-w-[420px]')]//span[1]")
	WebElement invalidToasterMessage;

	public void waitInvalidToasterMessage() {
		invalidToasterMessage = wait.until(ExpectedConditions.visibilityOf(invalidToasterMessage));
		return;
	}

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/main[1]/div[1]/div[2]/div[2]/div[1]/div[1]/ul[1]/div[5]/li[1]/img[1]")
	WebElement accountingSettings;

	public void waitAccountingSettings() {
		accountingSettings = wait.until(ExpectedConditions.visibilityOf(accountingSettings));
		return;
	}

	@FindBy(xpath = "//p[normalize-space()='Vendor']")
	WebElement vendorButton;

	public void waitVendorButton() {
		vendorButton = wait.until(ExpectedConditions.visibilityOf(vendorButton));
		return;
	}

	@FindBy(xpath = "//button[normalize-space()='add new vendor']")
	WebElement addNewVendor;

	public void waitAddNewVendor() {
		addNewVendor = wait.until(ExpectedConditions.visibilityOf(addNewVendor));
		return;
	}

	@FindBy(name = "companyName")
	WebElement companyBusinessName;

	public void waitCompanyBusinessName() {
		companyBusinessName = wait.until(ExpectedConditions.visibilityOf(companyBusinessName));
		return;
	}

	@FindBy(name = "accountReference")
	WebElement accountReference;

	public void waitAccountReference() {
		accountReference = wait.until(ExpectedConditions.visibilityOf(accountReference));
		return;
	}

	@FindBy(name = "phoneNumber")
	WebElement phoneNumber;

	public void waitPhoneNumber() {
		phoneNumber = wait.until(ExpectedConditions.visibilityOf(phoneNumber));
		return;
	}

	@FindBy(name = "website")
	WebElement website;

	public void waitWebsite() {
		website = wait.until(ExpectedConditions.visibilityOf(website));
		return;
	}

	@FindBy(name = "addressStreet1")
	WebElement street1;

	public void waitStreet1() {
		street1 = wait.until(ExpectedConditions.visibilityOf(street1));
		return;
	}

	@FindBy(name = "addressStreet2")
	WebElement street2;

	public void waitStreet2() {
		street2 = wait.until(ExpectedConditions.visibilityOf(street2));
		return;
	}

	@FindBy(name = "billingStreet1")
	WebElement billingStreet1;

	public void waitBillingStreet1() {
		billingStreet1 = wait.until(ExpectedConditions.visibilityOf(billingStreet1));
		return;
	}

	@FindBy(name = "addressCountyName")
	WebElement cityField;

	public void waitCityField() {
		cityField = wait.until(ExpectedConditions.visibilityOf(cityField));
		return;
	}

	@FindBy(xpath = "(//span[@class='Theme__Placeholder-sc-1udffqo-3 eZRgFT'])[1]")
	WebElement country;

	public void waitCountry() {
		country = wait.until(ExpectedConditions.visibilityOf(country));
		return;
	}

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/main[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[4]/div[1]/div[1]/div[1]/div[1]/input[1]")
	WebElement countrySearch;

	public void waitCountrySearch() {
		countrySearch = wait.until(ExpectedConditions.visibilityOf(countrySearch));
		return;
	}

	@FindBy(name = "addressPostalCode")
	WebElement zipCode;

	public void waitZipCode() {
		zipCode = wait.until(ExpectedConditions.visibilityOf(zipCode));
		return;
	}

	@FindBy(xpath = "//button[@role='checkbox']")
	WebElement billingAddressCheckBox;

	public void waitBillingAddressCheckBox() {
		billingAddressCheckBox = wait.until(ExpectedConditions.visibilityOf(billingAddressCheckBox));
		return;
	}

	@FindBy(xpath = "//span[normalize-space()='next']")
	WebElement nextButton;

	public void waitNextButton() {
		nextButton = wait.until(ExpectedConditions.visibilityOf(nextButton));
		return;
	}

	@FindBy(xpath = "(//button[@type='button'])[3]")
	WebElement financeTab;

	public void waitFinanceTab() {
		financeTab = wait.until(ExpectedConditions.visibilityOf(financeTab));
		return;
	}

	@FindBy(name = "statementName")
	WebElement accountStatment;

	public void waitAccountStatment() {
		accountStatment = wait.until(ExpectedConditions.visibilityOf(accountStatment));
		return;
	}

	@FindBy(xpath = "//*[@id=\"sortCodeId\"]/button")
	WebElement bankSortCode;

	public void waitBankSortCode() {
		bankSortCode = wait.until(ExpectedConditions.visibilityOf(bankSortCode));
		return;
	}

	@FindBy(xpath = "(//div[@role='menuitem'])[1]")
	WebElement valueOfBankSortCode;

	public void waitValueOfBankSortCode() {
		valueOfBankSortCode = wait.until(ExpectedConditions.visibilityOf(valueOfBankSortCode));
		return;
	}

	@FindBy(xpath = "//*[@id=\"defaultCurrencyId\"]/button")
	WebElement defaultCurrency;

	public void waitDefaultCurrency() {
		defaultCurrency = wait.until(ExpectedConditions.visibilityOf(defaultCurrency));
		return;
	}

	@FindBy(xpath = "(//div[@role='menuitem'])[2]")
	WebElement valueOfDefaultCurrency;

	public void waitValueOfDefaultCurrency() {
		valueOfDefaultCurrency = wait.until(ExpectedConditions.visibilityOf(valueOfDefaultCurrency));
		return;
	}

	@FindBy(xpath = "//*[@id=\"defaultPaymentMethodId\"]")
	WebElement defaultPaymentMethod;

	public void waitDefaultPaymentMethod() {
		defaultPaymentMethod = wait.until(ExpectedConditions.visibilityOf(defaultPaymentMethod));
		return;
	}

	@FindBy(xpath = "(//div[@role='menuitem'])[2]")
	WebElement valueOfDefaultPaymentMethod;

	public void waitValueOfDefaultPaymentMethod() {
		valueOfDefaultPaymentMethod = wait.until(ExpectedConditions.visibilityOf(valueOfDefaultPaymentMethod));
		return;
	}

	@FindBy(xpath = "//*[@id=\"othersPaymentMethodId\"]/button")
	WebElement othersPaymentMethod;

	public void waitOthersPaymentMethod() {
		othersPaymentMethod = wait.until(ExpectedConditions.visibilityOf(othersPaymentMethod));
		return;
	}

	@FindBy(xpath = "(//div[@role='menuitem'])[2]")
	WebElement valueOfOthersPaymentMethod;

	public void waitValueOfOthersPaymentMethod() {
		valueOfOthersPaymentMethod = wait.until(ExpectedConditions.elementToBeClickable(valueOfOthersPaymentMethod));
		return;
	}

	@FindBy(xpath = "//*[@id=\"taxId1\"]")
	WebElement taxNumber1;

	public void waitTaxNumber1() {
		taxNumber1 = wait.until(ExpectedConditions.visibilityOf(taxNumber1));
		return;
	}

	@FindBy(xpath = "(//div[@role='menuitem'])[1]")
	WebElement valueOfTaxNumber1;

	public void waitValueOfTaxNumber1() {
		valueOfTaxNumber1 = wait.until(ExpectedConditions.visibilityOf(valueOfTaxNumber1));
		return;
	}

	@FindBy(name = "taxText1")
	WebElement fieldOfTaxNumber1;

	public void waitFieldOfTaxNumber1() {
		fieldOfTaxNumber1 = wait.until(ExpectedConditions.visibilityOf(fieldOfTaxNumber1));
		return;
	}

	@FindBy(xpath = "//*[@id=\"taxId2\"]")
	WebElement taxNumber2;

	public void waitTaxNumber2() {
		taxNumber2 = wait.until(ExpectedConditions.visibilityOf(taxNumber2));
		return;
	}

	@FindBy(xpath = "(//div[@role='menuitem'])[2]")
	WebElement valueOfTaxNumber2;

	public void waitValueOfTaxNumber2() {
		valueOfTaxNumber2 = wait.until(ExpectedConditions.visibilityOf(valueOfTaxNumber2));
		return;
	}

	@FindBy(name = "taxText2")
	WebElement fieldOfTaxNumber2;

	public void waitFieldOfTaxNumber2() {
		fieldOfTaxNumber2 = wait.until(ExpectedConditions.visibilityOf(fieldOfTaxNumber2));
		return;
	}

	@FindBy(xpath = "//*[@id=\"taxId3\"]")
	WebElement taxNumber3;

	public void waitTaxNumber3() {
		taxNumber3 = wait.until(ExpectedConditions.visibilityOf(taxNumber3));
		return;
	}

	@FindBy(xpath = "(//div[@role='menuitem'])[3]")
	WebElement valueOfTaxNumber3;

	public void waitValueOfTaxNumber3() {
		valueOfTaxNumber3 = wait.until(ExpectedConditions.visibilityOf(valueOfTaxNumber3));
		return;
	}

	@FindBy(name = "taxText3")
	WebElement fieldOfTaxNumber3;

	public void waitFieldOfTaxNumber3() {
		fieldOfTaxNumber3 = wait.until(ExpectedConditions.visibilityOf(fieldOfTaxNumber3));
		return;
	}

	@FindBy(name = "billsDueDate")
	WebElement billsDuedateField;

	public void waitBillsDuedateField() {
		billsDuedateField = wait.until(ExpectedConditions.visibilityOf(billsDuedateField));
		return;
	}

	@FindBy(xpath = "//button[@id='billsDueDateId']//button[@class='Theme__TriggerBox-sc-g0n1ik-0 fywwoR w-full']")
	WebElement billsDuedate;

	public void waitBillsDuedate() {
		billsDuedate = wait.until(ExpectedConditions.visibilityOf(billsDuedate));
		return;
	}

	@FindBy(xpath = "(//div[@role='menuitem'])[1]")
	WebElement valueOfBillsDuedate;

	public void waitValueOfBillsDuedate() {
		valueOfBillsDuedate = wait.until(ExpectedConditions.visibilityOf(valueOfBillsDuedate));
		return;
	}

	@FindBy(name = "invoiceDueValue")
	WebElement invoiceDuedateField;

	public void waitInvoiceDuedateField() {
		invoiceDuedateField = wait.until(ExpectedConditions.visibilityOf(invoiceDuedateField));
		return;
	}

	@FindBy(xpath = "//button[@id='invoiceDueDateId']//button[@class='Theme__TriggerBox-sc-g0n1ik-0 fywwoR w-full']")
	WebElement invoiceDuedate;

	public void waitInvoiceDuedate() {
		invoiceDuedate = wait.until(ExpectedConditions.visibilityOf(invoiceDuedate));
		return;
	}

	@FindBy(xpath = "(//div[@role='menuitem'])[2]")
	WebElement valueOfInvoiceDuedate;

	public void waitValueOfInvoiceDuedate() {
		valueOfInvoiceDuedate = wait.until(ExpectedConditions.visibilityOf(valueOfInvoiceDuedate));
		return;
	}

	@FindBy(xpath = "//div[@class='text-sm font-semibold']")
	WebElement popUP;

	public void waitPopUP() {
		popUP = wait.until(ExpectedConditions.visibilityOf(popUP));
		return;
	}

	@FindBy(xpath = "//span[normalize-space()='submit']")
	WebElement submitButton;

	public void waitSubmitButton() {
		submitButton = wait.until(ExpectedConditions.visibilityOf(submitButton));
		return;
	}

	@FindBy(xpath = "//p[@class='text-sm font-medium text-destructive mt-4 text-start']")
	WebElement validationOfDefaultCurrency;

	public void waitValidationOfDefaultCurrency() {
		validationOfDefaultCurrency = wait.until(ExpectedConditions.visibilityOf(validationOfDefaultCurrency));
		return;
	}

	// ------------------------------------------------
	// Contact Elements: ------>
	// Contact Elements: ------>

	@FindBy(xpath = "//button[normalize-space()='Details']")
	WebElement detailsButton;

	public void waitDetailsButton() {
		detailsButton = wait.until(ExpectedConditions.visibilityOf(detailsButton));
		return;
	}

	@FindBy(xpath = "(//button[@role='tab'])[3]")
	WebElement contactsTab;

	public void waitContactsTab() {
		contactsTab = wait.until(ExpectedConditions.visibilityOf(contactsTab));
		return;
	}

	@FindBy(xpath = "//span[normalize-space()='add new contact']")
	WebElement addNewContactButton;

	public void waitAddNewContactButton() {
		addNewContactButton = wait.until(ExpectedConditions.visibilityOf(addNewContactButton));
		return;
	}

	@FindBy(xpath = "//button[@type='submit']")
	WebElement saveButtonInAddNewContactPopUp;

	public void waitSaveButtonInAddNewContactPopUp() {
		saveButtonInAddNewContactPopUp = wait.until(ExpectedConditions.visibilityOf(saveButtonInAddNewContactPopUp));
		return;
	}

	@FindBy(xpath = "(//p[@class='text-sm font-medium text-destructive'])[1]")
	WebElement validationMsgForFirstName;

	public void waitValidationMsgForFirstName() {
		validationMsgForFirstName = wait.until(ExpectedConditions.visibilityOf(validationMsgForFirstName));
		return;
	}

	@FindBy(xpath = "(//p[@class='text-sm font-medium text-destructive'])[2]")
	WebElement validationMsgForLastName;

	public void waitValidationMsgForLastName() {
		validationMsgForLastName = wait.until(ExpectedConditions.visibilityOf(validationMsgForLastName));
		return;
	}

	@FindBy(xpath = "(//p[@class='text-sm font-medium text-destructive mt-4 text-start'])[1]")
	WebElement validationMsgForContactsType;

	public void waitValidationMsgForContactsType() {
		validationMsgForContactsType = wait.until(ExpectedConditions.visibilityOf(validationMsgForContactsType));
		return;
	}

	@FindBy(xpath = "(//p[@class='text-sm font-medium text-destructive mt-4 text-start'])[2]")
	WebElement validationMsgForPosition;

	public void waitValidationMsgForPosition() {
		validationMsgForPosition = wait.until(ExpectedConditions.visibilityOf(validationMsgForPosition));
		return;
	}

	@FindBy(name = "firstName")
	WebElement firstNameField;

	public void waitfirstName() {
		firstNameField = wait.until(ExpectedConditions.visibilityOf(firstNameField));
		return;
	}

	@FindBy(name = "lastName")
	WebElement lastNameField;

	public void waitLastNameField() {
		lastNameField = wait.until(ExpectedConditions.visibilityOf(lastNameField));
		return;
	}

	@FindBy(xpath = "(//button[@class='Theme__TriggerBox-sc-g0n1ik-0 fywwoR w-full'])[1]")
	WebElement contactsTypeDropDown;

	public void waitContactsTypeDropDown() {
		contactsTypeDropDown = wait.until(ExpectedConditions.visibilityOf(contactsTypeDropDown));
		return;
	}

	@FindBy(xpath = "(//div[@role='menuitem'])[1]")
	WebElement selectPrimaryOption;

	public void waitSelectPrimaryOption() {
		selectPrimaryOption = wait.until(ExpectedConditions.visibilityOf(selectPrimaryOption));
		return;
	}

	@FindBy(xpath = "(//div[@role='menuitem'])[2]")
	WebElement selectSeconderyOption;

	public void waitSelectSeconderyOption() {
		selectSeconderyOption = wait.until(ExpectedConditions.visibilityOf(selectSeconderyOption));
		return;
	}

	@FindBy(xpath = "(//div[@role='menuitem'])[2]")
	WebElement selectOtherOption;

	public void waitSelectOtherOption() {
		selectOtherOption = wait.until(ExpectedConditions.visibilityOf(selectOtherOption));
		return;
	}

	@FindBy(xpath = "(//button[@class='Theme__TriggerBox-sc-g0n1ik-0 fywwoR w-full'])[2]")
	WebElement positionDropDown;

	public void waitPositionDropDown() {
		positionDropDown = wait.until(ExpectedConditions.visibilityOf(positionDropDown));
		return;
	}

	@FindBy(xpath = "(//div[@role='menuitem'])[1]")
	WebElement selectMarketingManagerOption;

	public void waitSelectMarketingManagerOption() {
		selectMarketingManagerOption = wait.until(ExpectedConditions.visibilityOf(selectMarketingManagerOption));
		return;
	}

	@FindBy(name = "phoneNumber")
	WebElement phoneNumberField;

	public void waitPhoneNumberField() {
		phoneNumberField = wait.until(ExpectedConditions.visibilityOf(phoneNumberField));
		return;
	}

	@FindBy(name = "mobileNumber")
	WebElement mobileNumberField;

	public void waitMobileNumberField() {
		mobileNumberField = wait.until(ExpectedConditions.visibilityOf(mobileNumberField));
		return;
	}

	@FindBy(name = "email")
	WebElement emailField;

	public void waitEmailField() {
		emailField = wait.until(ExpectedConditions.visibilityOf(emailField));
		return;
	}

	@FindBy(xpath = "(//p[@class='text-sm font-medium text-destructive'])[3]")
	WebElement invalidEmailValidationMsg;

	public void waitInvalidEmailValidationMsg() {
		invalidEmailValidationMsg = wait.until(ExpectedConditions.visibilityOf(invalidEmailValidationMsg));
		return;
	}

	@FindBy(name = "skype")
	WebElement skypeNameField;

	public void waitSkypeNameField() {
		skypeNameField = wait.until(ExpectedConditions.visibilityOf(skypeNameField));
		return;
	}

	@FindBy(name = "address1")
	WebElement addressLine1;

	public void waitAddressLine1() {
		addressLine1 = wait.until(ExpectedConditions.visibilityOf(addressLine1));
		return;
	}

	@FindBy(name = "address2")

	WebElement addressLine2;

	public void waitAddressLine2() {
		addressLine2 = wait.until(ExpectedConditions.visibilityOf(addressLine2));
		return;
	}

	@FindBy(name = "city")
	WebElement cityFieldInContacts;

	public void waitCityFieldInContacts() {
		cityFieldInContacts = wait.until(ExpectedConditions.visibilityOf(cityFieldInContacts));
		return;
	}

	@FindBy(name = "CountyName")
	WebElement countyField;

	public void waitCountyField() {
		countyField = wait.until(ExpectedConditions.visibilityOf(countyField));
		return;
	}

	@FindBy(name = "postalCode")
	WebElement postelCode;

	public void waitPostelCode() {
		postelCode = wait.until(ExpectedConditions.visibilityOf(postelCode));
		return;
	}

	@FindBy(xpath = "//div[@data-placeholder='Select option']")
	WebElement countryDropDown;

	public void waitCountryDropDown() {
		countryDropDown = wait.until(ExpectedConditions.visibilityOf(countryDropDown));
		return;
	}

	@FindBy(xpath = "(//input[@role='combobox'])[2]")
	WebElement searchFieldInCountryInAddNewContact;

	public void waitSearchFieldInCountryInAddNewContact() {
		searchFieldInCountryInAddNewContact = wait
				.until(ExpectedConditions.visibilityOf(searchFieldInCountryInAddNewContact));
		return;
	}

	// ------------------------------------------------
	public void preTest() throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.waitUserName();
		loginPage.userName.sendKeys("NadsoftSummit");
		loginPage.waitPassword();
		loginPage.password.sendKeys("12345");
		loginPage.waitLoginButton();
		loginPage.loginButton.click();
		GoogleAuthenticatorTC googleAuthenticatorTC = new GoogleAuthenticatorTC();
		googleAuthenticatorTC.TC4_valid_OTP_code();
	}
}