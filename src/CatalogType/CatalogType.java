package CatalogType;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Login.GoogleAuthenticatorTC;
import Login.LoginPage;

public class CatalogType {
	public WebDriver driver;
	public WebDriverWait wait;

	public CatalogType(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
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

	@FindBy(xpath = "//div[@data-automation-id='div3331472']")
	WebElement assetsManagementButton;

	public void waitAssetsManagementButton() {
		assetsManagementButton = wait.until(ExpectedConditions.visibilityOf(assetsManagementButton));
		return;
	}

	@FindBy(xpath = "//div[@data-automation-id='div2099793']")
	WebElement catalogTypeButton;

	public void waitCatalogTypeButton() {
		catalogTypeButton = wait.until(ExpectedConditions.visibilityOf(catalogTypeButton));
		return;
	}

	@FindBy(xpath = "//img[@alt='sideArrow']")
	WebElement sideArrow;

	public void waitSideArrow() {
		sideArrow = wait.until(ExpectedConditions.visibilityOf(sideArrow));
		return;
	}

	@FindBy(xpath = "//div[@style='transform: translateX(25px) translateY(-35px) rotate(180deg) translateZ(0px);']")
	WebElement closeSideMenu;

	public void waitCloseSideMenu() {
		closeSideMenu = wait.until(ExpectedConditions.visibilityOf(closeSideMenu));
		return;
	}

	@FindBy(xpath = "//button[@data-automation-id='button1702361']")
	WebElement addNewProduct;

	public void waitAddNewProduct() {
		addNewProduct = wait.until(ExpectedConditions.visibilityOf(addNewProduct));
		return;
	}

	@FindBy(xpath = "//input[@data-automation-id='input1931251']")
	WebElement productDescriptionField;

	public void waitProductDescriptionField() {
		productDescriptionField = wait.until(ExpectedConditions.visibilityOf(productDescriptionField));
		return;
	}

	@FindBy(xpath = "//button[@data-automation-id='button2853842']")
	WebElement itemTypeField;

	public void waitItemTypeField() {
		itemTypeField = wait.until(ExpectedConditions.visibilityOf(itemTypeField));
		return;
	}

	@FindBy(xpath = "// input[@data-automation-id='input2578031']")
	WebElement itemTypePropertiesTitle1;

	public void waitItemTypePropertiesTitle1() {
		itemTypePropertiesTitle1 = wait.until(ExpectedConditions.visibilityOf(itemTypePropertiesTitle1));
		return;
	}

	@FindBy(xpath = "//input[@data-automation-id='input2578032']")
	WebElement itemTypePropertiesTitle2;

	public void waitItemTypePropertiesTitle2() {
		itemTypePropertiesTitle2 = wait.until(ExpectedConditions.visibilityOf(itemTypePropertiesTitle2));
		return;
	}

	@FindBy(xpath = "//input[@data-automation-id='input2578033']")
	WebElement itemTypePropertiesTitle3;

	public void waitItemTypePropertiesTitle3() {
		itemTypePropertiesTitle3 = wait.until(ExpectedConditions.visibilityOf(itemTypePropertiesTitle3));
		return;
	}

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/section[1]/ol[1]/li[1]/div[1]/div[2]/div[1]/span[1]")
	WebElement toasterMessage;

	public void waitIToasterMessage() {
		toasterMessage = wait.until(ExpectedConditions.visibilityOf(toasterMessage));
		return;
	}

	@FindBy(xpath = "//span[@data-automation-id='span5037151']")
	WebElement toasterMessageUpdateCatalog;

	public void waitToasterMessageUpdateCatalog() {
		toasterMessageUpdateCatalog = wait.until(ExpectedConditions.visibilityOf(toasterMessageUpdateCatalog));
		return;
	}

	@FindBy(xpath = "//button[@data-automation-id='button3691431']")
	WebElement createButton;

	public void waitICreateButton() {
		createButton = wait.until(ExpectedConditions.visibilityOf(createButton));
		return;
	}

	@FindBy(xpath = "//button[@data-automation-id='button3537131']")
	WebElement cancelButton;

	public void waitCancelButton() {
		cancelButton = wait.until(ExpectedConditions.visibilityOf(cancelButton));
		return;
	}

	@FindBy(xpath = "(//input[@data-automation-id='input1954841'])[2]")
	WebElement searchfield;

	public void waitSearchfield() {
		searchfield = wait.until(ExpectedConditions.visibilityOf(searchfield));
		return;
	}

	@FindBy(xpath = "(//td)[2]")
	WebElement productDescriptionColumn;

	public void waitProductDescriptionColumn() {
		productDescriptionColumn = wait.until(ExpectedConditions.visibilityOf(productDescriptionColumn));
		return;
	}

	@FindBy(xpath = "//button[@data-automation-id='button1625121']")
	WebElement editProduct;

	public void waitEditProduct() {
		editProduct = wait.until(ExpectedConditions.visibilityOf(editProduct));
		return;
	}

	@FindBy(xpath = "//button[@data-automation-id='button2047411']")
	WebElement saveButton;

	public void waitSaveButton() {
		saveButton = wait.until(ExpectedConditions.visibilityOf(saveButton));
		return;
	}

	@FindBy(xpath = "//button[@data-automation-id='button2047411']")
	WebElement cancelButton2;

	public void waitCancelButton2() {
		cancelButton2 = wait.until(ExpectedConditions.visibilityOf(cancelButton2));
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