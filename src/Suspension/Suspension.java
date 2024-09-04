package Suspension;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Suspension {
	public WebDriver driver;
	public WebDriverWait wait;

	public Suspension(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[@data-automation-id='button1823071']")

	WebElement adddNewSuspensionButton;

	public void waitAdddNewSuspensionButton() {
		adddNewSuspensionButton = wait.until(ExpectedConditions.visibilityOf(adddNewSuspensionButton));
		return;
	}

	@FindBy(xpath = "//button[@data-automation-id='button4489392']")
	WebElement managerNameField;

	public void waitManagerNameField() {
		managerNameField = wait.until(ExpectedConditions.visibilityOf(managerNameField));
		return;
	}

	@FindBy(xpath = "//span[@data-automation-id='span1408531']")
	WebElement selectManager;

	public void waitSelectManager() {
		selectManager = wait.until(ExpectedConditions.visibilityOf(selectManager));
		return;
	}

	@FindBy(xpath = "//input[@data-automation-id='input1954843']")
	WebElement unitField;

	public void waitUnitField() {
		unitField = wait.until(ExpectedConditions.visibilityOf(unitField));
		return;
	}

	@FindBy(xpath = "/html[1]/body[1]/div[2]/div[4]/div[1]/div[1]/div[1]/div[4]/div[1]")
	WebElement selectUnit;

	public void waitSelectUnit() {
		selectUnit = wait.until(ExpectedConditions.visibilityOf(selectUnit));
		return;
	}

	@FindBy(xpath = "//button[@data-automation-id='button3799462']")
	WebElement employeeNameField;

	public void waitEmployeeNameField() {
		employeeNameField = wait.until(ExpectedConditions.visibilityOf(employeeNameField));
		return;
	}

	@FindBy(xpath = "//div[@data-automation-id='div1869161']")
	WebElement selectEmployee;

	public void waitSelectEmployee() {
		selectEmployee = wait.until(ExpectedConditions.visibilityOf(selectEmployee));
		return;
	}

	@FindBy(xpath = "//div[@data-automation-id='div1672476']")
	WebElement fromDateField;

	public void waitFromDateField() {
		fromDateField = wait.until(ExpectedConditions.visibilityOf(fromDateField));
		return;
	}

	@FindBy(xpath = "/html[1]/body[1]/div[4]/div[2]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/span[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/button[18]")
	WebElement selectFromDate;

	public void waitSelectFromDate() {
		selectFromDate = wait.until(ExpectedConditions.visibilityOf(selectFromDate));
		return;
	}

	@FindBy(xpath = "//div[@data-automation-id='div1672478']")
	WebElement toDateField;

	public void waitToDateField() {
		toDateField = wait.until(ExpectedConditions.visibilityOf(toDateField));
		return;
	}

	@FindBy(xpath = "/html[1]/body[1]/div[4]/div[2]/div[2]/div[2]/div[2]/div[1]/div[2]/div[1]/span[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/button[19]/abbr[1]")
	WebElement selectToDate;

	public void waitSelectToDate() {
		selectToDate = wait.until(ExpectedConditions.visibilityOf(selectToDate));
		return;
	}

	@FindBy(tagName = "textarea")
	WebElement reasonField;

	public void waitReasonField() {
		reasonField = wait.until(ExpectedConditions.visibilityOf(reasonField));
		return;
	}

	@FindBy(xpath = "//button[@data-automation-id='button3691431']")
	WebElement createButton;

	public void waitCreateButton() {
		createButton = wait.until(ExpectedConditions.visibilityOf(createButton));
		return;
	}

	@FindBy(xpath = "//span[@data-automation-id='span1198001']")
	WebElement toasterMessage;

	public void waitToasterMessage() {
		toasterMessage = wait.until(ExpectedConditions.visibilityOf(toasterMessage));
		return;
	}

	@FindBy(xpath = "(//input[@data-automation-id='input1954841'])[2]")
	WebElement unitEmployeeNameField;

	public void waitUnitEmployeeNameField() {
		unitEmployeeNameField = wait.until(ExpectedConditions.visibilityOf(unitEmployeeNameField));
		return;
	}

	@FindBy(xpath = "//div[@data-automation-id='div5198962']")
	WebElement createDateColumn;

	public void waitCreateDateColumn() {
		createDateColumn = wait.until(ExpectedConditions.visibilityOf(createDateColumn));
		return;
	}

	@FindBy(xpath = "(//img[@alt='Edit Icon'])[1]")
	WebElement editSuspensionButton;

	public void waitEditSuspensionButton() {
		editSuspensionButton = wait.until(ExpectedConditions.visibilityOf(editSuspensionButton));
		return;
	}

	@FindBy(xpath = "(//button[@data-automation-id='button1108004'])[3]")
	WebElement statusButton;

	public void waitStatusButton() {
		statusButton = wait.until(ExpectedConditions.visibilityOf(statusButton));
		return;
	}

	@FindBy(xpath = "//button[@data-automation-id='button2047411']")
	WebElement saveButton;

	public void waitSaveButton() {
		saveButton = wait.until(ExpectedConditions.visibilityOf(saveButton));
		return;
	}

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/main[1]/div[2]/div[2]/div[1]/div[1]/div[3]/div[1]/table[1]/tbody[1]/tr[1]/td[8]")
	WebElement reasonColumn;

	public void waitReasonColumn() {
		reasonColumn = wait.until(ExpectedConditions.visibilityOf(reasonColumn));
		return;
	}

	@FindBy(xpath = "//span[@data-automation-id='span1954591']")
	WebElement updatedToasterMessage;

	public void waitUpdatedToasterMessage() {
		updatedToasterMessage = wait.until(ExpectedConditions.visibilityOf(updatedToasterMessage));
		return;
	}
}
