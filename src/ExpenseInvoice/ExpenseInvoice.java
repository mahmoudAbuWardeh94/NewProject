package ExpenseInvoice;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Login.GoogleAuthenticatorTC;
import Login.LoginPage;

public class ExpenseInvoice {
	public WebDriver driver;
	public WebDriverWait wait;

	public ExpenseInvoice(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[@data-automation-id='button5824671']")
	WebElement financeButton;

	public void waitfinanceButton() {
		financeButton = wait.until(ExpectedConditions.visibilityOf(financeButton));
		return;
	}

	@FindBy(xpath = "//div[@data-automation-id='div2048602']")
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

	@FindBy(xpath = "//div[@data-automation-id='div9522883']")
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

	@FindBy(xpath = "//span[normalize-space()='The minimum characters for searching is 3']")
	WebElement toasterMessage;

	public void waitToasterMessage() {
		toasterMessage = wait.until(ExpectedConditions.visibilityOf(toasterMessage));
		return;
	}

	@FindBy(xpath = "(//span[contains(text(),\"No vendors found for '\")])[1]")
	WebElement invalidToasterMessage;

	public void waitInvalidToasterMessage() {
		invalidToasterMessage = wait.until(ExpectedConditions.visibilityOf(invalidToasterMessage));
		return;
	}

	@FindBy(xpath = "//button[normalize-space()='Add New Bills']")
	WebElement addNewBill;

	public void waitAddNewBill() {
		addNewBill = wait.until(ExpectedConditions.visibilityOf(addNewBill));
		return;
	}

	@FindBy(xpath = "//img[@alt='sideArrow']")
	WebElement sideArrow;

	public void waitSideArrow() {
		sideArrow = wait.until(ExpectedConditions.visibilityOf(sideArrow));
		return;
	}

	// ------------------------------------------------
	@FindBy(xpath = "//body//div//div//div//div//div//div//div//div[1]//div[1]//div[2]//div[1]//div[1]//button[1]//img[1]")
	WebElement datePicker;

	public void waitDatePicker() {
		datePicker = wait.until(ExpectedConditions.visibilityOf(datePicker));
		return;
	}

	@FindBy(xpath = "//div[contains(@class,'react-calendar__viewContainer')]//button[4]")
	WebElement selectDate;

	public void waitSelectDate() {
		selectDate = wait.until(ExpectedConditions.visibilityOf(selectDate));
		return;
	}

	@FindBy(xpath = "(//div[@data-automation-id='div1672473'])[2]")
	WebElement dueDate;

	public void waitDueDate() {
		dueDate = wait.until(ExpectedConditions.visibilityOf(dueDate));
		return;
	}

	@FindBy(xpath = "//*[@id=\"root\"]/div/main/div[2]/div[2]/div/div/div[1]/div/div[3]/div/div[2]/div/span/div/div/div[2]/div/div/div/div[2]/button[9]")
	WebElement selectDate2;

	public void waitSelectDate2() {
		selectDate2 = wait.until(ExpectedConditions.elementToBeClickable(selectDate2));
		return;
	}

	@FindBy(xpath = "(//input[@type='text'])[2]")
	WebElement vendorName;

	public void waitVendorName() {
		vendorName = wait.until(ExpectedConditions.visibilityOf(vendorName));
		return;
	}

	@FindBy(xpath = "(//div[@role='listbox'])[2]")
	WebElement selectVendor;

	public void waitselectVendor() {
		selectVendor = wait.until(ExpectedConditions.elementToBeClickable(selectVendor));
		return;
	}

	@FindBy(xpath = "")
	WebElement inputDatePicker1;

	@FindBy(name = "invoiceNumber")
	WebElement invoiceNumber;

	public void waitInvoiceNumber() {
		invoiceNumber = wait.until(ExpectedConditions.visibilityOf(invoiceNumber));
		return;
	}

	@FindBy(name = "total")
	WebElement enterTotalOnHeader;

	public void waitEnterTotalOnHeader() {
		enterTotalOnHeader = wait.until(ExpectedConditions.visibilityOf(enterTotalOnHeader));
		return;
	}

	@FindBy(xpath = "(//button[@data-automation-id='button1108004'])[2]")
	WebElement attachmentButton;

	public void waitAttachmentButton() {
		attachmentButton = wait.until(ExpectedConditions.visibilityOf(attachmentButton));
		return;
	}

	@FindBy(xpath = "//div[@data-automation-id='div2829541']")
	WebElement popUp;

	public void waitPopUp() {
		popUp = wait.until(ExpectedConditions.visibilityOf(popUp));
		return;
	}

	@FindBy(xpath = "//button[normalize-space()='Add A New Line']")
	WebElement addNewLineButton;

	public void waitAddNewLineButton() {
		addNewLineButton = wait.until(ExpectedConditions.visibilityOf(addNewLineButton));
		return;
	}

	@FindBy(xpath = "(//div[@class='flex gap-5 rounded-md border-dashed border border-[#044DA14D] p-8'])[1]")
	WebElement uploadFileButton;

	public void waitUploadFileButton() {
		uploadFileButton = wait.until(ExpectedConditions.visibilityOf(uploadFileButton));
		return;
	}

	@FindBy(xpath = "//button[normalize-space()='Confirm']")
	WebElement confirmButton;

	public void waitConfirmButton() {
		confirmButton = wait.until(ExpectedConditions.visibilityOf(confirmButton));
		return;
	}

	@FindBy(xpath = "//img[2]")
	WebElement closeButton;

	public void waitCloseButton() {
		closeButton = wait.until(ExpectedConditions.visibilityOf(closeButton));
		return;
	}

	@FindBy(xpath = "(//input[@type='text'])[3]")
	WebElement itemField;

	public void waitItemField() {
		itemField = wait.until(ExpectedConditions.visibilityOf(itemField));
		return;
	}

	@FindBy(xpath = "(//div[@role='listbox'])[3]")
	WebElement selectItem;

	public void waitSelectItem() {
		selectItem = wait.until(ExpectedConditions.visibilityOf(selectItem));
		return;
	}

	@FindBy(name = "description")
	WebElement descriptionField;

	public void waitDescriptionField() {
		descriptionField = wait.until(ExpectedConditions.visibilityOf(descriptionField));
		return;
	}

	@FindBy(name = "quantity")
	WebElement quantityField;

	public void waitQuantityField() {
		quantityField = wait.until(ExpectedConditions.visibilityOf(quantityField));
		return;
	}

	@FindBy(name = "unitPrice")
	WebElement unitPriceField;

	public void waitUnitPriceField() {
		unitPriceField = wait.until(ExpectedConditions.visibilityOf(unitPriceField));
		return;
	}

	@FindBy(xpath = "//input[@placeholder='Ex Type / Entity']")
	WebElement expType;

	public void waitExpType() {
		expType = wait.until(ExpectedConditions.visibilityOf(expType));
		return;
	}

	@FindBy(xpath = "//input[@placeholder='Search types']")
	WebElement searchExpType;

	public void waitSearchExpType() {
		searchExpType = wait.until(ExpectedConditions.visibilityOf(searchExpType));
		return;
	}

	@FindBy(xpath = "//span[@class='text-black text-sm font-normal pl-1 transition-all ease-in-out cursor-pointer h-4']")
	WebElement selectFromExpType;

	public void waitSelectFromExpType() {
		selectFromExpType = wait.until(ExpectedConditions.visibilityOf(selectFromExpType));
		return;
	}

	@FindBy(xpath = "//div[contains(@class,'fw-bolder w-full')]")
	WebElement entityField;

	public void waitEntityField() {
		entityField = wait.until(ExpectedConditions.visibilityOf(entityField));
		return;
	}

	@FindBy(xpath = "(//input[@placeholder='Search'])[2]")
	WebElement searchFieldInExpType;

	public void waitSearchFieldInExpTyp() {
		searchFieldInExpType = wait.until(ExpectedConditions.visibilityOf(searchFieldInExpType));
		return;
	}

	@FindBy(xpath = "//button[normalize-space()='Confirm']")
	WebElement confirmButtonInExpType;

	public void waitConfirmButtonInExpType() {
		confirmButtonInExpType = wait.until(ExpectedConditions.visibilityOf(confirmButtonInExpType));
		return;
	}

	@FindBy(xpath = "(//button[@role='combobox'])[2]")
	WebElement taxRate;

	public void waitTaxRate() {
		taxRate = wait.until(ExpectedConditions.visibilityOf(taxRate));
		return;
	}

	@FindBy(xpath = "//*[@id=\"0_amount\"]/span")
	WebElement selectedTaxRate1;

	public void waitSelectedTaxRate() {
		selectedTaxRate1 = wait.until(ExpectedConditions.visibilityOf(selectedTaxRate1));
		return;
	}

	@FindBy(xpath = "//*[@id=\"1_amount\"]/span")
	WebElement selectedTaxRate2;

	public void waitSelectedTaxRate2() {
		selectedTaxRate2 = wait.until(ExpectedConditions.visibilityOf(selectedTaxRate2));
		return;
	}

	@FindBy(css = "td[id='2_taxId'] span")
	WebElement selectedTaxRate3;

	public void waitSelectedTaxRate3() {
		selectedTaxRate3 = wait.until(ExpectedConditions.visibilityOf(selectedTaxRate3));
		return;
	}

	@FindBy(xpath = "//*[@id=\"0_amount\"]/span")
	WebElement selectedTaxRate4;

	public void waitSelectedTaxRate4() {
		selectedTaxRate4 = wait.until(ExpectedConditions.visibilityOf(selectedTaxRate4));
		return;
	}

	@FindBy(xpath = "//*[contains(text(),'No GST')]")
	WebElement selectNoTax;

	public void waitSelectNoTax() {
		selectNoTax = wait.until(ExpectedConditions.visibilityOf(selectNoTax));
		return;
	}

	@FindBy(xpath = "//*[contains(text(),'10%  GST')]")
	WebElement select10Tax;

	public void waitSelect10Tax() {
		select10Tax = wait.until(ExpectedConditions.visibilityOf(select10Tax));
		return;
	}

	@FindBy(xpath = "//span[normalize-space()='15% GST']")
	WebElement select15Tax;

	public void waitSelect15Tax() {
		select15Tax = wait.until(ExpectedConditions.visibilityOf(select15Tax));
		return;
	}

	@FindBy(xpath = "//*[contains(text(),'20% GST')]")
	WebElement select20Tax;

	public void waitSelect20Tax() {
		select20Tax = wait.until(ExpectedConditions.visibilityOf(select20Tax));
		return;
	}

	@FindBy(xpath = "//*[@id=\"0_amount\"]/span")
	WebElement getAmount1;

	public void waitGetAmount() {
		getAmount1 = wait.until(ExpectedConditions.visibilityOf(getAmount1));
		return;
	}

	@FindBy(xpath = "//*[@id=\"1_amount\"]/span")
	WebElement getAmount2;

	public void waitGetAmount2() {
		getAmount2 = wait.until(ExpectedConditions.visibilityOf(getAmount2));
		return;
	}

	@FindBy(xpath = "//*[@id=\"2_amount\"]/span")
	WebElement getAmount3;

	public void waitGetAmount3() {
		getAmount2 = wait.until(ExpectedConditions.visibilityOf(getAmount3));
		return;
	}

	@FindBy(xpath = "//*[@id=\"3_amount\"]/span")
	WebElement getAmount4;

	public void waitGetAmount4() {
		getAmount4 = wait.until(ExpectedConditions.visibilityOf(getAmount4));
		return;
	}

	@FindBy(xpath = "//button[normalize-space()='Add']")
	WebElement addButton;

	public void waitAddButton() {
		addButton = wait.until(ExpectedConditions.visibilityOf(addButton));
		return;
	}

	@FindBy(xpath = "//img[@alt='CloseCircle']")
	WebElement closeButtonInRow;

	public void waitCloseButtonInRow() {
		closeButtonInRow = wait.until(ExpectedConditions.visibilityOf(closeButtonInRow));
		return;
	}

	@FindBy(xpath = "(//img[@alt='CloseCircle'])[2]")
	WebElement closeButtonInRow2;

	public void waitCloseButtonInRow2() {
		closeButtonInRow2 = wait.until(ExpectedConditions.visibilityOf(closeButtonInRow2));
		return;
	}

	@FindBy(xpath = "(//img[@alt='CloseCircle'])[3]")
	WebElement closeButtonInRow3;

	public void waitCloseButtonInRow3() {
		closeButtonInRow3 = wait.until(ExpectedConditions.visibilityOf(closeButtonInRow3));
		return;
	}

	@FindBy(xpath = "(//img[@alt='CloseCircle'])[4]")
	WebElement closeButtonInRow4;

	public void waitCloseButtonInRow4() {
		closeButtonInRow4 = wait.until(ExpectedConditions.visibilityOf(closeButtonInRow4));
		return;
	}

	@FindBy(xpath = "//*[@id=\"0_quantity\"]/span")
	WebElement enteredQuantity;

	public void waitEnteredQuantity() {
		enteredQuantity = wait.until(ExpectedConditions.visibilityOf(enteredQuantity));
		return;
	}

	@FindBy(xpath = "//*[@id=\"1_quantity\"]/span")
	WebElement enteredQuantity1;

	public void waitEnteredQuantity1() {
		enteredQuantity1 = wait.until(ExpectedConditions.visibilityOf(enteredQuantity1));
		return;
	}

	@FindBy(xpath = "//*[@id=\"2_quantity\"]/span")
	WebElement enteredQuantity2;

	public void waitEnteredQuantity2() {
		enteredQuantity2 = wait.until(ExpectedConditions.visibilityOf(enteredQuantity2));
		return;
	}

	@FindBy(xpath = "//*[@id=\"3_quantity\"]/span")
	WebElement enteredQuantity3;

	public void waitEnteredQuantity3() {
		enteredQuantity2 = wait.until(ExpectedConditions.visibilityOf(enteredQuantity3));
		return;
	}

	@FindBy(xpath = "//*[@id=\"0_unitPrice\"]/span")
	WebElement enteredUnitPrice;

	public void waitEnteredUnitPrice() {
		enteredUnitPrice = wait.until(ExpectedConditions.visibilityOf(enteredUnitPrice));
		return;
	}

	@FindBy(xpath = "//*[@id=\"1_unitPrice\"]/span")
	WebElement enteredUnitPrice1;

	public void waitEnteredUnitPrice1() {
		enteredUnitPrice1 = wait.until(ExpectedConditions.visibilityOf(enteredUnitPrice1));
		return;
	}

	@FindBy(xpath = "//*[@id=\"2_unitPrice\"]/span")
	WebElement enteredUnitPrice2;

	public void waitEnteredUnitPrice2() {
		enteredUnitPrice2 = wait.until(ExpectedConditions.visibilityOf(enteredUnitPrice2));
		return;
	}

	@FindBy(xpath = "//*[@id=\"3_unitPrice\"]/span")
	WebElement enteredUnitPrice3;

	public void waitEnteredUnitPrice3() {
		enteredUnitPrice3 = wait.until(ExpectedConditions.visibilityOf(enteredUnitPrice3));
		return;
	}

	@FindBy(xpath = "//span[@data-automation-id='span1578831']")
	WebElement requiredItemField;

	public void waitRequiredItemField() {
		requiredItemField = wait.until(ExpectedConditions.visibilityOf(requiredItemField));
		return;
	}

	@FindBy(xpath = "(//p[@class='text-sm font-medium text-destructive'])[1]")
	WebElement requiredQuantityField;

	public void waitRequiredQuantityField() {
		requiredQuantityField = wait.until(ExpectedConditions.visibilityOf(requiredQuantityField));
		return;
	}

	@FindBy(xpath = "(//p[@class='text-sm font-medium text-destructive'])[2]")
	WebElement requiredUnitPriceField;

	public void waitRequiredUnitPriceField() {
		requiredUnitPriceField = wait.until(ExpectedConditions.visibilityOf(requiredUnitPriceField));
		return;
	}

	@FindBy(xpath = "(//p[@class='text-sm font-medium text-destructive'])[3]")
	WebElement requiredTaxRateField;

	public void waitRequiredTaxRateField() {
		requiredTaxRateField = wait.until(ExpectedConditions.visibilityOf(requiredTaxRateField));
		return;
	}

	@FindBy(xpath = "//button[normalize-space()='Save As Draft']")
	WebElement saveAsDraftButton;

	public void waitSaveAsDraftButton() {
		saveAsDraftButton = wait.until(ExpectedConditions.visibilityOf(saveAsDraftButton));
		return;
	}

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/main[1]/div[2]/div[2]/div[1]/div[1]/div[3]/div[1]/div[3]/div[1]/span[2]")
	WebElement totalAmountOnFooter;

	public void waitTotalAmountOnFooter() {
		totalAmountOnFooter = wait.until(ExpectedConditions.visibilityOf(totalAmountOnFooter));
		return;
	}

	@FindBy(xpath = "//p[@class='text-sm font-medium']")
	WebElement validationMessegePopup;

	public void waitValidationMessegePopup() {
		validationMessegePopup = wait.until(ExpectedConditions.visibilityOf(validationMessegePopup));
		return;
	}

	@FindBy(xpath = "(//button[@data-automation-id='button3573281'])[2]")
	WebElement okButton;

	public void waitOkButton() {
		okButton = wait.until(ExpectedConditions.visibilityOf(okButton));
		return;
	}

	@FindBy(xpath = "//*[@id=\"root\"]/div/main/div[2]/div[2]/div/div/div[3]/div[1]/div[2]/div/span[2]")
	WebElement GSTNumber;

	public void waitGSTNumber() {
		GSTNumber = wait.until(ExpectedConditions.visibilityOf(GSTNumber));
		return;
	}

	@FindBy(xpath = "//*[@id=\"root\"]/div/main/div[2]/div[2]/div/div/div[3]/div[1]/div[1]/div/span[2]")
	WebElement subTotal;

	public void waitSubTotal() {
		subTotal = wait.until(ExpectedConditions.visibilityOf(subTotal));
		return;
	}

	@FindBy(xpath = "//button[normalize-space()='Approve']")
	WebElement approveButton;

	public void waitApproveButton() {
		approveButton = wait.until(ExpectedConditions.visibilityOf(approveButton));
		return;
	}

	@FindBy(xpath = "//p[@class='text-sm font-medium']")
	WebElement confirmationPopUp;

	public void waitConfirmationPopUp() {
		confirmationPopUp = wait.until(ExpectedConditions.visibilityOf(confirmationPopUp));
		return;
	}

	@FindBy(xpath = "//button[@type='button'][normalize-space()='Approve']")
	WebElement approveButtonInPupUp;

	public void waitApproveButtonInPupUp() {
		approveButtonInPupUp = wait.until(ExpectedConditions.visibilityOf(approveButtonInPupUp));
		return;
	}

	@FindBy(xpath = "//p[contains(.,'Save bill succeed.')]")
	WebElement confirmedMsg;

	public void waitConfirmedMsg() {
		confirmedMsg = wait.until(ExpectedConditions.visibilityOf(confirmedMsg));
		return;
	}

	@FindBy(xpath = "//*[@id=\"root\"]/div/main/div[2]/div[2]/div/div/div[1]/div/div[5]/button[2]/div")
	WebElement numberOfAttachment;

	public void waitNumberOfAttachment() {
		numberOfAttachment = wait.until(ExpectedConditions.visibilityOf(numberOfAttachment));
		return;
	}

	@FindBy(xpath = "//button[normalize-space()='Back']")
	WebElement backButton;

	public void waitBackButton() {
		backButton = wait.until(ExpectedConditions.visibilityOf(backButton));
		return;
	}

	@FindBy(xpath = "//button[normalize-space()='Confirm']")
	WebElement confirmButtonInBackPopUp;

	public void waitConfirmButtonInBackPopUp() {
		confirmButtonInBackPopUp = wait.until(ExpectedConditions.visibilityOf(confirmButtonInBackPopUp));
		return;
	}

	@FindBy(xpath = "(//div[@role='listbox'])[2]")
	WebElement searchResultInMainSearch;

	public void waitSearchResultInMainSearch() {
		searchResultInMainSearch = wait.until(ExpectedConditions.visibilityOf(searchResultInMainSearch));
		return;
	}

	@FindBy(xpath = "")
	WebElement lastSaveTitle;

	public void waitLastSaveTitle() {
		lastSaveTitle = wait.until(ExpectedConditions.visibilityOf(lastSaveTitle));
		return;
	}

	@FindBy(xpath = "//tbody//tr")
	WebElement countOfSearch;

	public void waitCountOfSearch() {
		countOfSearch = wait.until(ExpectedConditions.visibilityOf(countOfSearch));
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
		if (loginPage.waitLoginPopUp() && loginPage.loginPopUp.isDisplayed()) {
			loginPage.waitLoginButton();
			loginPage.continueButtonInPopUp.click();

		} else {
			System.out.println(" ");
		}
		GoogleAuthenticatorTC googleAuthenticatorTC = new GoogleAuthenticatorTC();
		googleAuthenticatorTC.TC4_valid_OTP_code();

	}
}
