package com.summit.login;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PhoneNumberOtp {
	public WebDriver driver;
	public WebDriverWait wait;

	public PhoneNumberOtp(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@aria-label='Character 1.']")
	WebElement digitsNumbersFields;

	public void waitDigitNumbersFields() {
		digitsNumbersFields = wait.until(ExpectedConditions.visibilityOf(digitsNumbersFields));
		return;
	}

	@FindBy(xpath = "//input[@aria-label='Character 1.']")
	WebElement digitNumber1;

	public void waitDigitNumber1() {
		digitNumber1 = wait.until(ExpectedConditions.visibilityOf(digitNumber1));
		return;
	}

	@FindBy(xpath = "//input[@aria-label='Character 6.']")
	WebElement digitNumber6;

	public void waitDigitNumber6() {
		digitNumber6 = wait.until(ExpectedConditions.visibilityOf(digitNumber6));
		return;
	}

	@FindBy(linkText = "try with phone number")
	WebElement tryWithPhoneNumberLink;

	public void waitTtryWithPhoneNumberLink() {
		tryWithPhoneNumberLink = wait.until(ExpectedConditions.visibilityOf(tryWithPhoneNumberLink));
		return;
	}

	@FindBy(xpath = "//button[@type='submit']")
	WebElement confirmButton;

	public void waitContinueButton() {
		confirmButton = wait.until(ExpectedConditions.visibilityOf(confirmButton));
		return;
	}

	@FindBy(xpath = "(//p)[2]")
	WebElement validationMsg;

	public void waitValidationMsg() {
		validationMsg = wait.until(ExpectedConditions.visibilityOf(validationMsg));
		return;
	}

	// ----------------------
	public void preTestMethod() throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);

		loginPage.waitUserName();
		loginPage.userName.sendKeys("NadsoftSummit");

		loginPage.waitPassword();
		loginPage.password.sendKeys("12345");

		loginPage.waitLoginButton();
		loginPage.loginButton.click();

		GoogleAuthenticatorPage googleAuth = new GoogleAuthenticatorPage(driver);

		googleAuth.waitTryWithPhoneNumberLink();
		googleAuth.tryWithPhoneNumberLink.click();

		PhoneNumberPage phoneNumberPage = new PhoneNumberPage(driver);

		phoneNumberPage.waitPhoneNumberField();
		phoneNumberPage.phoneNumberField.sendKeys("0880000000");

		phoneNumberPage.waitContinueButton();
		phoneNumberPage.continueButton.click();

	}

}
