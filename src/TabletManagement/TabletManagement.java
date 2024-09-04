package TabletManagement;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Login.GoogleAuthenticatorTC;
import Login.LoginPage;

public class TabletManagement {
	public WebDriver driver;
	public WebDriverWait wait;

	public TabletManagement(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[@data-automation-id='button1184161']")

	WebElement operationButton;

	public void waitOperationButton() {
		operationButton = wait.until(ExpectedConditions.visibilityOf(operationButton));
		return;
	}

	@FindBy(xpath = "//div[@style='transform: translateX(25px) translateY(-35px) rotate(0deg) translateZ(0px);']")

	WebElement expandSideMenu;

	public void waitExpandSideMenu() {
		expandSideMenu = wait.until(ExpectedConditions.visibilityOf(expandSideMenu));
		return;
	}

	@FindBy(xpath = "//img[@alt='sideArrow']")
	public WebElement sideArrow;

	public void waitSideArrow() {
		sideArrow = wait.until(ExpectedConditions.visibilityOf(sideArrow));
		return;
	}

	@FindBy(xpath = "//div[@style='transform: translateX(25px) translateY(-35px) rotate(180deg) translateZ(0px);']")
	public WebElement closeSideMenu;

	public void waitCloseSideMenu() {
		closeSideMenu = wait.until(ExpectedConditions.visibilityOf(closeSideMenu));
		return;
	}

	@FindBy(xpath = "//div[@data-automation-id='div4804842']")
	WebElement userManagament;

	public void waitUserManagament() {
		userManagament = wait.until(ExpectedConditions.visibilityOf(userManagament));
		return;
	}

	@FindBy(xpath = "//div[@data-automation-id='div1060113']")
	WebElement tabletsButton;

	public void waitTabletsButton() {
		tabletsButton = wait.until(ExpectedConditions.visibilityOf(tabletsButton));
		return;
	}

	@FindBy(xpath = "//button[@data-automation-id='button8748051']")
	WebElement addNewButton;

	public void waitAddNewButton() {
		addNewButton = wait.until(ExpectedConditions.visibilityOf(addNewButton));
		return;
	}

	@FindBy(xpath = "//input[@data-automation-id='input3136051']")
	WebElement tabletNameField;

	public void waitTabletNameField() {
		tabletNameField = wait.until(ExpectedConditions.visibilityOf(tabletNameField));
		return;
	}

	@FindBy(xpath = "//input[@data-automation-id='input1332691']")
	WebElement appVersionField;

	public void waitAppVersionField() {
		appVersionField = wait.until(ExpectedConditions.visibilityOf(appVersionField));
		return;
	}

	@FindBy(xpath = "//button[@data-automation-id='button8289561']")
	WebElement statusField;

	public void waitStatusField() {
		statusField = wait.until(ExpectedConditions.visibilityOf(statusField));
		return;
	}

	@FindBy(xpath = "//button[@data-automation-id='button2047411']")
	WebElement saveButton;

	public void waitSaveButton() {
		saveButton = wait.until(ExpectedConditions.visibilityOf(saveButton));
		return;
	}

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/section[1]/ol[1]/li[1]/div[2]/div[2]/div[1]/span[1]")
	WebElement toasterMessage;

	public void waitToasterMessage() {
		toasterMessage = wait.until(ExpectedConditions.visibilityOf(toasterMessage));
		return;
	}

	@FindBy(xpath = "(//input[@data-automation-id='input1954841'])[2]")
	WebElement searchField;

	public void waitSearchField() {
		searchField = wait.until(ExpectedConditions.visibilityOf(searchField));
		return;
	}

	@FindBy(xpath = "(//td)[2]")
	WebElement tabletNameColumn;

	public void waitTabletNameColumn() {
		tabletNameColumn = wait.until(ExpectedConditions.visibilityOf(tabletNameColumn));
		return;
	}

	@FindBy(xpath = "//button[@data-automation-id='button9122771']")
	WebElement detailsButton;

	public void waitDetailsButton() {
		detailsButton = wait.until(ExpectedConditions.visibilityOf(detailsButton));
		return;
	}

	@FindBy(xpath = "//button[@data-automation-id='button2051551']")
	WebElement editButton;

	public void waitEditButton() {
		editButton = wait.until(ExpectedConditions.visibilityOf(editButton));
		return;
	}

	@FindBy(xpath = "//button[@data-automation-id='button5725021']")
	WebElement inventoryTab;

	public void waitInventoryTab() {
		inventoryTab = wait.until(ExpectedConditions.visibilityOf(inventoryTab));
		return;
	}

	@FindBy(xpath = "//div[@data-automation-id='div1300704']")
	WebElement deviceIdField;

	public void waitDeviceIdField() {
		deviceIdField = wait.until(ExpectedConditions.visibilityOf(deviceIdField));
		return;
	}

	@FindBy(xpath = "//button[@data-automation-id='button1807731']")
	WebElement addButton;

	public void waitAddButton() {
		addButton = wait.until(ExpectedConditions.visibilityOf(addButton));
		return;
	}

	@FindBy(xpath = "//img[@alt='Edit Circle']")
	WebElement editButtonInTerminalsAndSims;

	public void waitEditButtonInTerminalsAndSims() {
		editButtonInTerminalsAndSims = wait.until(ExpectedConditions.visibilityOf(editButtonInTerminalsAndSims));
		return;
	}

	@FindBy(xpath = "/html[1]/body[1]/div[2]/div[2]/input[1]")
	WebElement searchFieldInDeviceIdField;

	public void waitSearchFieldInDeviceIdField() {
		searchFieldInDeviceIdField = wait.until(ExpectedConditions.visibilityOf(searchFieldInDeviceIdField));
		return;
	}

	@FindBy(xpath = "//div[@data-automation-id='div5964344']")
	WebElement deviceIdFieldInEditMode;

	public void waitDeviceIdFieldInEditMode() {
		deviceIdFieldInEditMode = wait.until(ExpectedConditions.visibilityOf(deviceIdFieldInEditMode));
		return;
	}

	@FindBy(xpath = "//img[@alt='Close Circle']")
	WebElement deleteTerminalAndSimButton;

	public void waitDeleteTerminalAndSimButton() {
		deleteTerminalAndSimButton = wait.until(ExpectedConditions.visibilityOf(deleteTerminalAndSimButton));
		return;
	}

	@FindBy(xpath = "//button[@data-automation-id='button2047331']")
	WebElement simsTab;

	public void waitSimsTab() {
		simsTab = wait.until(ExpectedConditions.visibilityOf(simsTab));
		return;
	}

	@FindBy(xpath = "//div[@data-automation-id='div9305334']")
	WebElement simCardNumberField;

	public void waitSimCardNumberField() {
		simCardNumberField = wait.until(ExpectedConditions.visibilityOf(simCardNumberField));
		return;
	}

	@FindBy(xpath = "//div[@data-automation-id='div3455674']")
	WebElement warehouseToTransferPreviousSimField;

	public void waitWarehouseToTransferPreviousSimField() {
		warehouseToTransferPreviousSimField = wait
				.until(ExpectedConditions.visibilityOf(warehouseToTransferPreviousSimField));
		return;
	}

	@FindBy(xpath = "//div[@data-automation-id='div6020374']")
	WebElement simCardNumberFieldInEditMode;

	public void waitSimCardNumberFieldInEditMode() {
		simCardNumberFieldInEditMode = wait.until(ExpectedConditions.visibilityOf(simCardNumberFieldInEditMode));
		return;
	}

	@FindBy(xpath = "//button[@data-automation-id='button2643111']")
	WebElement productsTab;

	public void waitProductsTab() {
		productsTab = wait.until(ExpectedConditions.visibilityOf(productsTab));
		return;
	}

	@FindBy(xpath = "//button[@role='switch']")
	WebElement productsItems;

	public void waitProductsItems() {
		productsItems = wait.until(ExpectedConditions.visibilityOf(productsItems));
		return;
	}

	@FindBy(xpath = "//button[@data-automation-id='button2051551']")
	WebElement editButtonInProducts;

	public void waitEditButtonInProducts() {
		editButtonInProducts = wait.until(ExpectedConditions.visibilityOf(editButtonInProducts));
		return;
	}

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/main[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/label[1]/*[name()='svg'][1]/*[name()='path'][1]")
	WebElement starIcon;

	public void waitStarIcon() {
		starIcon = wait.until(ExpectedConditions.visibilityOf(starIcon));
		return;
	}

	@FindBy(xpath = "//button[@data-automation-id='button1108006']")
	WebElement jackpotAccumulationButton;

	public void waitJackpotAccumulationButton() {
		jackpotAccumulationButton = wait.until(ExpectedConditions.visibilityOf(jackpotAccumulationButton));
		return;
	}
	
	@FindBy(xpath = "//button[@data-automation-id='button3537131']")
	WebElement cancelButton;
	
	public void waitCancelButton() {
		cancelButton = wait.until(ExpectedConditions.visibilityOf(cancelButton));
		return;
	}
	
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/section[1]/ol[1]/li[1]/button[1]/*[name()='svg'][1]")
WebElement xButtonInToasterMsg;
	
	public void waitXButtonInToasterMsg() {
		xButtonInToasterMsg = wait.until(ExpectedConditions.visibilityOf(xButtonInToasterMsg));
		return;
	}
	// ----------------------------------------------------

	public void preTest() throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);

		loginPage.waitUserName();
		loginPage.userName.sendKeys("NadsoftSummit");

		loginPage.waitPassword();
		loginPage.password.sendKeys("12345");

		loginPage.waitLoginButton();
		loginPage.loginButton.click();
		Thread.sleep(2000);

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
