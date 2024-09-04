package TransferAsset;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Login.GoogleAuthenticatorTC;
import Login.LoginPage;

public class TransferAsset {
	public WebDriver driver;
	public WebDriverWait wait;

	public TransferAsset(WebDriver driver) {
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
	WebElement assetsManagment;

	public void waitAssetsManagment() {
		assetsManagment = wait.until(ExpectedConditions.visibilityOf(assetsManagment));
		return;
	}

	@FindBy(xpath = "//div[@data-automation-id='div2244243']")
	WebElement transferAssetButton;

	public void waitTransferAssetButton() {
		transferAssetButton = wait.until(ExpectedConditions.visibilityOf(transferAssetButton));
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

	@FindBy(xpath = "//div[@data-automation-id='div1218301']")
	WebElement fromField;

	public void waitFromField() {
		fromField = wait.until(ExpectedConditions.visibilityOf(fromField));
		return;
	}

	@FindBy(xpath = "//div[@data-automation-id='div7139604']")
	WebElement fromField1;

	public void waitFromField1() {
		fromField1 = wait.until(ExpectedConditions.visibilityOf(fromField1));
		return;
	}

	@FindBy(xpath = "/html[1]/body[1]/div[2]/div[3]/input[1]")
	WebElement searchFromField1;

	public void waitSearchFromField1() {
		searchFromField1 = wait.until(ExpectedConditions.visibilityOf(searchFromField1));
		return;
	}

	@FindBy(xpath = "//div[@data-automation-id='div1218302']")
	WebElement toFeaild;

	public void waittoFeaild() {
		toFeaild = wait.until(ExpectedConditions.visibilityOf(toFeaild));
		return;
	}

	@FindBy(xpath = "//div[@data-automation-id='div7139608']")
	WebElement toFeaild1;

	public void waittoFeaild1() {
		toFeaild1 = wait.until(ExpectedConditions.visibilityOf(toFeaild1));
		return;
	}

	@FindBy(xpath = "/html[1]/body[1]/div[2]/div[6]/input[1]")
	WebElement toFeaildSearch;

	public void waitToFeaildSearch() {
		toFeaildSearch = wait.until(ExpectedConditions.visibilityOf(toFeaildSearch));
		return;
	}

	@FindBy(xpath = "//div[@data-automation-id='div1614884']")
	WebElement fromField2;

	public void waitFromField2() {
		fromField2 = wait.until(ExpectedConditions.visibilityOf(fromField2));
		return;
	}

	@FindBy(xpath = "/html[1]/body[1]/div[2]/div[4]/input[1]")
	WebElement searchFromField2;

	public void waitsearchFromField2() {
		searchFromField2 = wait.until(ExpectedConditions.visibilityOf(searchFromField2));
		return;
	}

	@FindBy(xpath = "//button[@data-automation-id='button7604591']")
	WebElement browseItemsButton;

	public void waitBrowseItemsButton() {
		browseItemsButton = wait.until(ExpectedConditions.visibilityOf(browseItemsButton));
		return;
	}

	@FindBy(xpath = "//tr[@class='transition-colors data-[state=selected]:bg-muted border-b border-dashed border-[#e4e6ef] h-16 hover:bg-inherit normal-case']")
	WebElement items;

	public void waitItems() {
		items = wait.until(ExpectedConditions.visibilityOf(items));
		return;
	}

	@FindBy(xpath = "//input[@type='checkbox']")
	WebElement checkBoxButton;

	public void waitCheckBoxButton() {
		checkBoxButton = wait.until(ExpectedConditions.visibilityOf(checkBoxButton));
		return;
	}

	@FindBy(xpath = "//button[@data-automation-id='button2020331']")
	WebElement transferButton;

	public void waitTransferButton() {
		transferButton = wait.until(ExpectedConditions.visibilityOf(transferButton));
		return;
	}

	@FindBy(xpath = "//textarea[@name='note']")
	WebElement noteField;

	public void waitNoteField() {
		noteField = wait.until(ExpectedConditions.visibilityOf(noteField));
		return;
	}

	@FindBy(xpath = "//button[@data-automation-id='button2456351']")
	WebElement transferAsset;

	public void waittransferAsset() {
		transferAsset = wait.until(ExpectedConditions.visibilityOf(transferAsset));
		return;
	}

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/section[1]/ol[1]/li[1]/div[2]/div[2]/div[1]/span[1]")
	WebElement toasterMeesage;

	public void waitToasterMeesage() {
		toasterMeesage = wait.until(ExpectedConditions.visibilityOf(toasterMeesage));
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