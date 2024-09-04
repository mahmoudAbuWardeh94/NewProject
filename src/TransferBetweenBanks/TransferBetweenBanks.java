package TransferBetweenBanks;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TransferBetweenBanks {
	public WebDriver driver;
	public WebDriverWait wait;

	public TransferBetweenBanks(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[@data-automation-id='span4897831']")
	WebElement fromBankAccount;

	public void waitFromBankAccount() {
		fromBankAccount = wait.until(ExpectedConditions.visibilityOf(fromBankAccount));
		return;

	}

	@FindBy(xpath = "//button[@data-automation-id='button5526742']")
	WebElement fromBankAccountfield;

	public void waitFromBankAccountfield() {
		fromBankAccountfield = wait.until(ExpectedConditions.visibilityOf(fromBankAccountfield));
		return;

	}

	@FindBy(xpath = "//input[@data-automation-id='input9150001']")
	WebElement amountField;

	public void waitamountField() {
		amountField = wait.until(ExpectedConditions.visibilityOf(amountField));
		return;

	}

	@FindBy(xpath = "//button[@data-automation-id='button5526744']")
	WebElement toBankAccountfield;

	public void waitToBankAccountfield() {
		toBankAccountfield = wait.until(ExpectedConditions.visibilityOf(toBankAccountfield));
		return;

	}

	@FindBy(xpath = "//span[@data-automation-id='span1055111']")
	WebElement toBankAccount;

	public void waittoBankAccount() {
		toBankAccount = wait.until(ExpectedConditions.visibilityOf(toBankAccount));
		return;

	}

	@FindBy(xpath = "//input[@data-automation-id='input4638121']")
	WebElement actionDate;

	public void waitactionDate() {
		actionDate = wait.until(ExpectedConditions.visibilityOf(actionDate));
		return;

	}

	@FindBy(xpath = "//button[@data-automation-id='button1152663']")
	WebElement selectActionDate;

	public void waitSelectActionDate() {
		selectActionDate = wait.until(ExpectedConditions.visibilityOf(selectActionDate));
		return;

	}

	@FindBy(xpath = "//input[@data-automation-id='input4638122']")
	WebElement valueDate;

	public void waitValueDate() {
		valueDate = wait.until(ExpectedConditions.visibilityOf(valueDate));
		return;

	}

	@FindBy(xpath = "//button[@data-automation-id='button35732736']")
	WebElement selectValueDate;

	public void waitSelectValueDate() {
		selectValueDate = wait.until(ExpectedConditions.visibilityOf(selectValueDate));
		return;

	}

	@FindBy(xpath = "//input[@data-automation-id='input1394981']")
	WebElement slipField;

	public void waitslipField() {
		slipField = wait.until(ExpectedConditions.visibilityOf(slipField));
		return;

	}

	@FindBy(xpath = "//textarea")
	WebElement noteField;

	public void waitNoteField() {
		noteField = wait.until(ExpectedConditions.visibilityOf(noteField));
		return;

	}

	@FindBy(xpath = "//button[@data-automation-id='button2020331']")
	WebElement transferButton;

	public void waitTransferButton() {
		transferButton = wait.until(ExpectedConditions.visibilityOf(transferButton));
		return;

	}

	@FindBy(xpath = "//p[@class='text-sm font-medium']")
	WebElement popUp;

	public void waitPopUp() {
		popUp = wait.until(ExpectedConditions.visibilityOf(popUp));
		return;

	}

	@FindBy(xpath = "//button[@data-automation-id='button2051751']")
	WebElement doneButton;

	public void waitDoneButton() {
		doneButton = wait.until(ExpectedConditions.visibilityOf(doneButton));
		return;

	}

}
