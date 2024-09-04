package TransferBetweenBanks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Login.GoogleAuthenticatorTC;
import TransferAsset.TransferAsset;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TransferBetweenBanksTC {
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

		driver.navigate().to("https://dev-summit.boxsyst.com/transfer_between_banks");
	}

	@Test(priority = 1)
	public void transferBetweenBanks() {
		TransferBetweenBanks transferBetweenBanks = new TransferBetweenBanks(driver);

		transferBetweenBanks.waitFromBankAccountfield();
		transferBetweenBanks.fromBankAccountfield.click();

		transferBetweenBanks.waitFromBankAccount();
		transferBetweenBanks.fromBankAccount.click();

		transferBetweenBanks.waitamountField();
		transferBetweenBanks.amountField.sendKeys("5");

		transferBetweenBanks.waitToBankAccountfield();
		transferBetweenBanks.toBankAccountfield.click();

		transferBetweenBanks.waittoBankAccount();
		transferBetweenBanks.toBankAccount.click();

		transferBetweenBanks.waitactionDate();
		transferBetweenBanks.actionDate.click();

		transferBetweenBanks.waitSelectActionDate();
		transferBetweenBanks.selectActionDate.click();

		transferBetweenBanks.waitValueDate();
		transferBetweenBanks.valueDate.click();

		transferBetweenBanks.waitSelectValueDate();
		transferBetweenBanks.selectValueDate.click();

		transferBetweenBanks.waitslipField();
		transferBetweenBanks.slipField.sendKeys("12");

		transferBetweenBanks.waitNoteField();
		transferBetweenBanks.noteField.sendKeys("Husam Bani odeh The Best Tester");

		transferBetweenBanks.waitTransferButton();
		transferBetweenBanks.transferButton.click();

		transferBetweenBanks.waitPopUp();
		String actualResult = transferBetweenBanks.popUp.getText();
		String expecterdResult = "Add Transfer Between Banks Succeed.";

		softassert.assertEquals(actualResult, expecterdResult);
		softassert.assertAll();

		transferBetweenBanks.waitDoneButton();
		transferBetweenBanks.doneButton.click();

	}

	@Test(priority = 2)
	public void transferBetweenBanksWithInvalidAmount() throws InterruptedException {
		TransferBetweenBanks transferBetweenBanks = new TransferBetweenBanks(driver);

		transferBetweenBanks.waitamountField();
		transferBetweenBanks.amountField.click();
		transferBetweenBanks.amountField.clear();
		transferBetweenBanks.amountField.sendKeys("3");

		transferBetweenBanks.valueDate.click();
		transferBetweenBanks.valueDate.click();

		transferBetweenBanks.waitTransferButton();
		transferBetweenBanks.transferButton.click();

		transferBetweenBanks.waitPopUp();
		String actualResult = transferBetweenBanks.popUp.getText();
		String expecterdResult = "Amount Must Be 5 Multiples.";

		softassert.assertEquals(actualResult, expecterdResult);
		softassert.assertAll();

	}

}
