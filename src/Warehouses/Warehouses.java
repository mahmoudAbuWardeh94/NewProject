package Warehouses;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Login.GoogleAuthenticatorTC;
import Login.LoginPage;

public class Warehouses {
	public WebDriver driver;
	public WebDriverWait wait;

	public Warehouses(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(13));
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

	@FindBy(xpath = "//div[@data-automation-id='div1078563']")
	WebElement warehouseButton;

	public void waitWarehouseButton() {
		warehouseButton = wait.until(ExpectedConditions.visibilityOf(warehouseButton));
		return;
	}

	@FindBy(xpath = "//button[@data-automation-id='button5333291']")
	WebElement addNewButton;

	public void waitAddNewButton() {
		addNewButton = wait.until(ExpectedConditions.visibilityOf(addNewButton));
		return;
	}

	@FindBy(xpath = "//input[@data-automation-id='input1047881']")
	WebElement warehouseNameField;

	public void waitWarehouseNameField() {
		warehouseNameField = wait.until(ExpectedConditions.visibilityOf(warehouseNameField));
		return;
	}

	@FindBy(xpath = "//div[@data-automation-id='div8860321']")
	WebElement unitNameField;

	public void waitUnitNameField() {
		unitNameField = wait.until(ExpectedConditions.visibilityOf(unitNameField));
		return;
	}

	@FindBy(xpath = "(//input[@data-automation-id='input1954841'])[3]")
	WebElement searchFieldInUnitName;

	public void waitSearchFieldInUnitName() {
		searchFieldInUnitName = wait.until(ExpectedConditions.visibilityOf(searchFieldInUnitName));
		return;
	}

	@FindBy(xpath = "//button[@data-automation-id='button8154162']")
	WebElement warehouseTypeField;

	public void waitWarehouseTypeField() {
		warehouseTypeField = wait.until(ExpectedConditions.visibilityOf(warehouseTypeField));
		return;
	}

	@FindBy(xpath = "//button[@data-automation-id='button3691431']")
	WebElement createButton;

	public void waitCreateButton() {
		createButton = wait.until(ExpectedConditions.visibilityOf(createButton));
		return;
	}

	@FindBy(xpath = "//span[@data-automation-id='span1889021']")
	WebElement successErrorMsg;

	public void waitSuccessErrorMsg() {
		successErrorMsg = wait.until(ExpectedConditions.visibilityOf(successErrorMsg));
		return;
	}

	@FindBy(xpath = "//button[@data-automation-id='button3537131']")
	WebElement closePopUp;

	public void waitClosePopUp() {
		closePopUp = wait.until(ExpectedConditions.visibilityOf(closePopUp));
		return;
	}

	@FindBy(xpath = "(//input[@data-automation-id='input1954841'])[2]")
	WebElement searchField;

	public void waitSearchField() {
		searchField = wait.until(ExpectedConditions.visibilityOf(searchField));
		return;
	}

	@FindBy(xpath = "(//td)[1]")
	WebElement warehouseNameColumn;

	public void waitWarehouseNameColumn() {
		warehouseNameColumn = wait.until(ExpectedConditions.visibilityOf(warehouseNameColumn));
		return;
	}

	@FindBy(xpath = "//button[@data-automation-id='button1953801']")
	WebElement editInfoButton;

	public void waitEditInfoButton() {
		editInfoButton = wait.until(ExpectedConditions.visibilityOf(editInfoButton));
		return;
	}

	@FindBy(xpath = "//button[@data-automation-id='button2051551']")
	WebElement editButton;

	public void waitEditButton() {
		editButton = wait.until(ExpectedConditions.visibilityOf(editButton));
		return;
	}

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
