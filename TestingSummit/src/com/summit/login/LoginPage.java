package com.summit.login;

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
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
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
	public
	WebElement loginButton;

	public void waitLoginButton() {
		password = wait.until(ExpectedConditions.visibilityOf(loginButton));
		return;
	}

	@FindBy(tagName = "p")
	WebElement errorMessage;

	public void waitErrorMessage() {
		errorMessage = wait.until(ExpectedConditions.visibilityOf(errorMessage));
		return;
	}

	@FindBy(tagName = "p")
	WebElement emptyUserNameField;

	public void waitemptyUserNameField() {
		emptyUserNameField = wait.until(ExpectedConditions.visibilityOf(emptyUserNameField));
		return;
	}

	@FindBy(tagName = "p")
	WebElement emptyPasswordField;

	public void waitemptyPasswordField() {
		emptyUserNameField = wait.until(ExpectedConditions.visibilityOf(emptyPasswordField));
		return;
	}

	@FindBy(xpath  = "(//p)[2]")
	WebElement secValMsg;

	public void waitsecValMsg() {
		secValMsg = wait.until(ExpectedConditions.visibilityOf(secValMsg));
		return;
	}
}
