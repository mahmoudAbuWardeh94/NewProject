package Login;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	public WebDriver driver;
	public WebDriverWait wait;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "username")
	public WebElement userName;

	public void waitUserName() {
		userName = wait.until(ExpectedConditions.visibilityOf(userName));
		return;
	}

	@FindBy(name = "userPassword")
	public WebElement password;

	public void waitPassword() {
		password = wait.until(ExpectedConditions.visibilityOf(password));
		return;
	}

	@FindBy(xpath = "//button[normalize-space()='Sign In']")
	public WebElement loginButton;

	public void waitLoginButton() {
		loginButton = wait.until(ExpectedConditions.visibilityOf(loginButton));
		return;
	}

	@FindBy(xpath = "(//p)[2]")
	public WebElement errorMessage;

	public void waitErrorMessage() {
		errorMessage = wait.until(ExpectedConditions.visibilityOf(errorMessage));
		return;
	}

	@FindBy(tagName = "p")
	public WebElement emptyUserNameField;

	public void waitemptyUserNameField() {
		emptyUserNameField = wait.until(ExpectedConditions.visibilityOf(emptyUserNameField));
		return;
	}

	@FindBy(tagName = "p")
	public WebElement emptyPasswordField;

	public void waitemptyPasswordField() {
		emptyUserNameField = wait.until(ExpectedConditions.visibilityOf(emptyPasswordField));
		return;
	}

	@FindBy(xpath = "(//p)[2]")
	public WebElement secValMsg;

	public void waitsecValMsg() {
		secValMsg = wait.until(ExpectedConditions.visibilityOf(secValMsg));
		return;
	}

	@FindBy(xpath = "//div[@data-automation-id='div1225251']")
	public WebElement loginPopUp;


	public boolean waitLoginPopUp() {
		try {
			loginPopUp=	wait.until(ExpectedConditions.visibilityOf(loginPopUp));
			return true; // Element is visible
		} catch (Exception e) {
			return false; // Element is not visible within the timeout
		}
	}

	@FindBy(xpath = "//button[@data-automation-id='button1722461']")
	public WebElement continueButtonInPopUp;

	public void waitContinueButtonInPopUp() {
		continueButtonInPopUp = wait.until(ExpectedConditions.visibilityOf(continueButtonInPopUp));
		return;
	}

}
