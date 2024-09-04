package PerformDeposit;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PerformDeposit {
	public WebDriver driver;
	public WebDriverWait wait;

	public PerformDeposit(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[@data-automation-id='button5526742']")
	WebElement toBankAccountField;

	public void waitToBankAccountField() {
		toBankAccountField = wait.until(ExpectedConditions.visibilityOf(toBankAccountField));
		return;

	}

	@FindBy(xpath = "//div[@data-automation-id='div1847061']")
	WebElement selectToBankAccountField;

	public void waitSelectToBankAccountField() {
		selectToBankAccountField = wait.until(ExpectedConditions.visibilityOf(selectToBankAccountField));
		return;

	}

	@FindBy(xpath = "//input[@data-automation-id='input6852801']")
	WebElement amountField;

	public void waitAmountField() {
		amountField = wait.until(ExpectedConditions.visibilityOf(amountField));
		return;

	}

	@FindBy(xpath = "//input[@data-automation-id='input1394981']")
	WebElement slipField;

	public void waitSlipField() {
		slipField = wait.until(ExpectedConditions.visibilityOf(slipField));
		return;

	}

	@FindBy(xpath = "//button[@data-automation-id='button9155441']")
	WebElement depositButton;

	public void waitDepositButton() {
		depositButton = wait.until(ExpectedConditions.visibilityOf(depositButton));
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

	@FindBy(xpath = "(//button[@data-automation-id='button3573281'])[2]")
	WebElement okButton;

	public void waitOkButton() {
		okButton = wait.until(ExpectedConditions.visibilityOf(okButton));
		return;

	}

	@FindBy(xpath = "//p")
	WebElement currentCurrency;

	public void waitCurrentCurrency() {
		currentCurrency = wait.until(ExpectedConditions.visibilityOf(currentCurrency));
		return;

	}
	
	@FindBy(xpath = "(//td[@class='w-full text-center py-2 border-l border-[#e4e6ef]'])[1]")
	WebElement amountOfFirstAccount;

	public void waitAmountOfFirstAccount() {
		amountOfFirstAccount = wait.until(ExpectedConditions.visibilityOf(amountOfFirstAccount));
		return;

	}
}
