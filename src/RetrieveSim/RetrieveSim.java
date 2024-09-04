package RetrieveSim;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Login.GoogleAuthenticatorTC;
import Login.LoginPage;

public class RetrieveSim {
	public WebDriver driver;
	public WebDriverWait wait;

	public RetrieveSim(WebDriver driver) {
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

	@FindBy(xpath = "//div[@data-automation-id='div4766712']")
	WebElement attendanceButton;

	public void waitAttendanceButton() {
		attendanceButton = wait.until(ExpectedConditions.visibilityOf(attendanceButton));
		return;
	}

	@FindBy(xpath = "//div[@style='transform: translateX(25px) translateY(-35px) rotate(0deg) translateZ(0px);']")

	WebElement expandSideMenu;

	public void waitExpandSideMenu() {
		expandSideMenu = wait.until(ExpectedConditions.visibilityOf(expandSideMenu));
		return;
	}

	@FindBy(xpath = "//div[@style='transform: translateX(25px) translateY(-35px) rotate(180deg) translateZ(0px);']")
	public WebElement closeSideMenu;

	public void waitCloseSideMenu() {
		closeSideMenu = wait.until(ExpectedConditions.visibilityOf(closeSideMenu));
		return;
	}

	@FindBy(xpath = "//div[@data-automation-id='div3331472']")
	WebElement assetsManagment;

	public void waitAssetsManagment() {
		assetsManagment = wait.until(ExpectedConditions.visibilityOf(assetsManagment));
		return;
	}

	@FindBy(xpath = "//div[@data-automation-id='div1148143']")
	WebElement retrieveSimButton;

	public void waitRetrieveSimButton() {
		retrieveSimButton = wait.until(ExpectedConditions.visibilityOf(retrieveSimButton));
		return;
	}

	@FindBy(xpath = "//img[@alt='sideArrow']")
	public WebElement sideArrow;

	public void waitSideArrow() {
		sideArrow = wait.until(ExpectedConditions.visibilityOf(sideArrow));
		return;
	}

	@FindBy(xpath = "(//input[@data-automation-id='input1954841'])[2]")
	WebElement searchField;

	public void waitSearchField() {
		searchField = wait.until(ExpectedConditions.visibilityOf(searchField));
		return;
	}

	// button[@data-automation-id='button2984871']

	@FindBy(xpath = "(//button[@role='combobox'])[1]")
	WebElement actionButton;

	public void waitActionButton() {
		actionButton = wait.until(ExpectedConditions.visibilityOf(actionButton));
		return;
	}

	@FindBy(xpath = "//input[@data-automation-id='input9128371']")
	WebElement newSimField;

	public void waitNewSimField() {
		newSimField = wait.until(ExpectedConditions.visibilityOf(newSimField));
		return;
	}

	@FindBy(xpath = "//button[@data-automation-id='button4294151']")
	WebElement retrieveButton;

	public void waitRetrieveButton() {
		retrieveButton = wait.until(ExpectedConditions.visibilityOf(retrieveButton));
		return;
	}

	@FindBy(xpath = "//p[@class='text-sm font-medium']")
	WebElement errorConfirmationMsg;

	public void waitErrorConfirmationMsg() {
		errorConfirmationMsg = wait.until(ExpectedConditions.visibilityOf(errorConfirmationMsg));
		return;
	}

	@FindBy(xpath = "(//button[@data-automation-id='button3573281'])[2]")
	WebElement okButton;

	public void waitOkButton() {
		okButton = wait.until(ExpectedConditions.visibilityOf(okButton));
		return;
	}

	@FindBy(xpath = "//td[@id='0_createDate']")
	WebElement recordOfChanges;

	public void waitRecordOfChanges() {
		recordOfChanges = wait.until(ExpectedConditions.visibilityOf(recordOfChanges));
		return;
	}

	@FindBy(xpath = "//*[text()='" + "Log" + "']")
	WebElement logButton;

	public void waitLogButton() {
		logButton = wait.until(ExpectedConditions.visibilityOf(logButton));
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
