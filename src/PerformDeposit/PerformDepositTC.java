package PerformDeposit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Login.GoogleAuthenticatorTC;
import TransferAsset.TransferAsset;
import io.github.bonigarcia.wdm.WebDriverManager;

public class PerformDepositTC {
	public static WebDriver driver;
	public SoftAssert softassert = new SoftAssert();

	public static WebDriver getDriver() {
		if (driver == null) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		return driver;
	}

	@BeforeTest
	public void preTest() throws InterruptedException {
		driver = GoogleAuthenticatorTC.getDriver();
		driver.get("");
		driver.manage().window().maximize();
		TransferAsset transferAsset = new TransferAsset(driver);
		transferAsset.preTest();

		driver.navigate().to("https://dev-summit.boxsyst.com/perform_deposit");
	}

	@Test(priority = 1)
	public void verifyCurrentCurrencyAfterDeposit() throws InterruptedException {
		PerformDeposit performDeposit = new PerformDeposit(driver);

		performDeposit.waitCurrentCurrency();
		String balanceText = performDeposit.currentCurrency.getText();
		String[] parts = balanceText.split("LRD");
		String lrdBalance = null;
		if (parts.length > 1) {
			lrdBalance = parts[1].trim().split(" ")[0];
		}

		double doubleValue = Double.parseDouble(lrdBalance);

		int currentBalanceLRDBeforeDeposit = (int) doubleValue;

		System.out.println(currentBalanceLRDBeforeDeposit + " Before Deposit");

		performDeposit.waitToBankAccountField();
		performDeposit.toBankAccountField.click();

		performDeposit.waitSelectToBankAccountField();
		performDeposit.selectToBankAccountField.click();

		performDeposit.waitAmountField();
		performDeposit.amountField.sendKeys("5");

		performDeposit.waitSlipField();
		performDeposit.slipField.sendKeys("12");

		performDeposit.waitDepositButton();
		performDeposit.depositButton.click();

		performDeposit.waitPopUp();
		String actualResult = performDeposit.popUp.getText();
		String expectedResult = "Perform Deposit To Bank Succeed.";

		softassert.assertEquals(actualResult, expectedResult);

		performDeposit.waitDoneButton();
		performDeposit.doneButton.click();

		Thread.sleep(3000);

		performDeposit.waitCurrentCurrency();
		String balanceTextAfterDeposit = performDeposit.currentCurrency.getText();

		String[] partsAfter = balanceTextAfterDeposit.split("LRD");
		String lrdBalanceAfterDeposit = null;
		if (partsAfter.length > 1) {
			lrdBalanceAfterDeposit = partsAfter[1].trim().split(" ")[0];
		}

		double doubleValueAfterDeposit = Double.parseDouble(lrdBalanceAfterDeposit);

		int currentBalanceLRDAfterDeposit = (int) doubleValueAfterDeposit;

		System.out.println(currentBalanceLRDAfterDeposit + " After Deposit");

		int actualCurrentAmount = currentBalanceLRDAfterDeposit;
		int expectedCurrentAmount = currentBalanceLRDBeforeDeposit - 5;

		softassert.assertEquals(actualCurrentAmount, expectedCurrentAmount);
		softassert.assertAll();
	}

	@Test(priority = 2)
	public void checkAmount() {
		PerformDeposit performDeposit = new PerformDeposit(driver);
		performDeposit.waitAmountOfFirstAccount();
		String firstAccount = performDeposit.amountOfFirstAccount.getText();

		String numericText = firstAccount.replaceAll("[^0-9]", "");

		int intValue = Integer.parseInt(numericText);

		int actualResult = intValue;
		int expectedResult = 5;

		softassert.assertEquals(actualResult, expectedResult);
		softassert.assertAll();

	}

	@Test(priority = 3)
	public void errorPopUp() {
		PerformDeposit performDeposit = new PerformDeposit(driver);

		performDeposit.waitAmountField();
		performDeposit.amountField.sendKeys("2");

		performDeposit.waitSlipField();
		performDeposit.slipField.sendKeys("12");

		performDeposit.waitDepositButton();
		performDeposit.depositButton.click();

		performDeposit.waitPopUp();
		String actualResult = performDeposit.popUp.getText();
		String expectedResult = "Amount Must Be 5 Multiples.";

		softassert.assertEquals(actualResult, expectedResult);
		softassert.assertAll();

		performDeposit.waitOkButton();
		performDeposit.okButton.click();

	}
	
	

}
