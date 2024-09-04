package Login;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PhoneNumberPage {
	public WebDriver driver;
	public WebDriverWait wait;

	public PhoneNumberPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "phoneNumber")
	WebElement phoneNumberField;

	public void waitPhoneNumberField() {
		phoneNumberField = wait.until(ExpectedConditions.visibilityOf(phoneNumberField));
		return;
	}

	@FindBy(xpath = "//button[@type='submit']")
	WebElement continueButton;

	public void waitContinueButton() {
		continueButton = wait.until(ExpectedConditions.elementToBeClickable(continueButton));
		return;
	}

	@FindBy(xpath = "(//p)[2]")
	WebElement validationMsg;

	public void waitValidationMsg() {
		validationMsg = wait.until(ExpectedConditions.visibilityOf(validationMsg));
		return;
	}

//-------------------------------------------
	public void preTestMethod() throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);

		loginPage.waitUserName();
		loginPage.userName.sendKeys("NadsoftSummit");

		loginPage.waitPassword();
		loginPage.password.sendKeys("12345");

		loginPage.waitLoginButton();
		loginPage.loginButton.click();

	}
}
