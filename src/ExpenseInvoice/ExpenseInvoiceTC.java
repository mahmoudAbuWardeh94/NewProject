package ExpenseInvoice;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Login.GoogleAuthenticatorTC;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ExpenseInvoiceTC {
	public static WebDriver driver;

	public SoftAssert softassert = new SoftAssert();

	public String enterQuantityForBillOne = "100";
	public String enterQuantityForBillTwo = "100";
	public String enterQuantityForBillThree = "100";
	public String enterQuantityForBillFour = "4000";

	public String enterUnitPriceForBillOne = "10";
	public String enterUnitPriceForBillTwo = "300";
	public String enterUnitPriceForBillThree = "50";
	public String enterUnitPriceForBillFour = "400";

	public static double actualAmountWithNoTax;
	public static double actualAmountWith10Tax;
	public static double actualAmountWith15Tax;
	public static double actualAmountWith20Tax;

	public static double taxValueForBillOne;
	public static double taxValueForBillTwo;
	public static double taxValueForBillThree;
	public static double taxValueForBillFour;

	public static double expectedTotalAmountInFooter;

	public static double actualGSTNumber;
	public static double actualTotalAmount;

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

		ExpenseInvoice expenseInvoice = new ExpenseInvoice(driver);
		expenseInvoice.preTest();
	}

	@Test(priority = 1)
	public void clickOnFinanceAtSideMenu() throws InterruptedException {
		ExpenseInvoice expenseInvoice = new ExpenseInvoice(driver);
		expenseInvoice.waitfinanceButton();
		expenseInvoice.financeButton.click();
		expenseInvoice.waitexpandSideMenu();
		Thread.sleep(3000);
		String actualResult = expenseInvoice.expandSideMenu.getAttribute("style");
		String expectedResult = "width: 16rem; transform: none;";
		softassert.assertEquals(actualResult, expectedResult);
		softassert.assertAll();
	}

	@Test(priority = 2)
	public void Click_on_expense_button_at_side_menu() {
		ExpenseInvoice expenseInvoice = new ExpenseInvoice(driver);

		expenseInvoice.waitExpenseButton();
		expenseInvoice.expenseButton.click();

		String actualResult = expenseInvoice.expandSubMenu.getAttribute("alt");
		String expectedResult = "arrowUp";
		softassert.assertEquals(actualResult, expectedResult);
		softassert.assertAll();

	}

	@Test(priority = 3)
	public void click_on_expenseInvoice_button() throws InterruptedException {
		ExpenseInvoice expenseInvoice = new ExpenseInvoice(driver);

		expenseInvoice.waitExpenseInvoiceButton();
		expenseInvoice.expenseInvoiceButton.click();

		Thread.sleep(2000);

		String actualResult = driver.getCurrentUrl();
		String expectedResult = "https://dev-summit.boxsyst.com/expense_invoice";
		softassert.assertEquals(actualResult, expectedResult);
		softassert.assertAll();
	}

	@Test(priority = 4)
	public void clicOnSideArrow() throws InterruptedException {
		ExpenseInvoice expenseInvoice = new ExpenseInvoice(driver);
		expenseInvoice.waitSideArrow();
		expenseInvoice.sideArrow.click();
		Thread.sleep(2000);
		String actualResult = expenseInvoice.expandSideMenu.getAttribute("style");

		String expectedResult = "width: 4rem; transform: none;";

		softassert.assertEquals(actualResult, expectedResult);
		softassert.assertAll();
	}

	@Test(priority = 5)
	public void clickOnAddNewBill() throws InterruptedException {
		ExpenseInvoice expenseInvoice = new ExpenseInvoice(driver);
		expenseInvoice.waitAddNewBill();
		expenseInvoice.addNewBill.click();
		Thread.sleep(1000);

		String actualResult = driver.getCurrentUrl();
		String expectedResult = "https://dev-summit.boxsyst.com/expense_invoice/add_bill";
		softassert.assertEquals(actualResult, expectedResult);
		softassert.assertAll();

	}

	@Test(priority = 6)

	public void verifyIfTheUserCanEnterAFirstRowInBillPage() throws InterruptedException {

		ExpenseInvoice expenseInvoice = new ExpenseInvoice(driver);
		expenseInvoice.waitVendorName();
		expenseInvoice.vendorName.sendKeys("coca");

		expenseInvoice.waitselectVendor();

		Actions action = new Actions(driver);

		action.moveToElement(expenseInvoice.selectVendor).click().build().perform();

		expenseInvoice.waitDatePicker();
		expenseInvoice.datePicker.click();

		expenseInvoice.waitSelectDate();
		expenseInvoice.selectDate.click();

		expenseInvoice.waitDueDate();
		expenseInvoice.dueDate.click();

		expenseInvoice.waitSelectDate2();
		expenseInvoice.selectDate2.click();

		expenseInvoice.waitInvoiceNumber();
		expenseInvoice.invoiceNumber.sendKeys("154");

		expenseInvoice.waitEnterTotalOnHeader();
		expenseInvoice.enterTotalOnHeader.sendKeys("1");

		expenseInvoice.waitAttachmentButton();
		boolean actualAttachmentButtonIsClickable = expenseInvoice.attachmentButton.isEnabled();
		boolean expectedAttchmentButtonIsClickable = true;
		softassert.assertEquals(actualAttachmentButtonIsClickable, expectedAttchmentButtonIsClickable);

		expenseInvoice.attachmentButton.click();

		expenseInvoice.waitPopUp();

		String actualResultPopUpIsOpened = expenseInvoice.popUp.getAttribute("data-state");

		String expectedResultPopUpIsOpened = "open";

		softassert.assertEquals(actualResultPopUpIsOpened, expectedResultPopUpIsOpened);

		softassert.assertAll();

	}

	@Test(priority = 7)
	public void uploadAttachment() throws AWTException, InterruptedException {
		ExpenseInvoice expenseInvoice = new ExpenseInvoice(driver);
		expenseInvoice.waitUploadFileButton();
		expenseInvoice.uploadFileButton.click();

		Robot rb = new Robot();
		Thread.sleep(3000);

		StringSelection str = new StringSelection(
				"C:\\Users\\husam\\Desktop\\upload File\\Conditional Branching.pdf");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);

		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);

		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);

		expenseInvoice.waitCloseButton();

		boolean actualResult = expenseInvoice.closeButton.isDisplayed();

		boolean expectedResult = true;
		softassert.assertEquals(actualResult, expectedResult);
		softassert.assertAll();

		expenseInvoice.waitConfirmButton();
		expenseInvoice.confirmButton.click();

	}

	@Test(priority = 8)
	public void addNewBillWithEmptyData() {
		ExpenseInvoice expenseInvoice = new ExpenseInvoice(driver);

		expenseInvoice.waitAddButton();
		expenseInvoice.addButton.click();

		expenseInvoice.waitRequiredItemField();
		String actualMsgItem = expenseInvoice.requiredItemField.getText();
		String expectedMsgItem = "Required";

		softassert.assertEquals(actualMsgItem, expectedMsgItem);

		expenseInvoice.waitRequiredQuantityField();
		String actualMsgQuantity = expenseInvoice.requiredQuantityField.getText();
		String expectedMsgQuantity = "Required";

		softassert.assertEquals(actualMsgQuantity, expectedMsgQuantity);

		expenseInvoice.waitRequiredUnitPriceField();
		String actualMsgUnitPrice = expenseInvoice.requiredQuantityField.getText();
		String expectedMsgUnitPrice = "Required";

		softassert.assertEquals(actualMsgUnitPrice, expectedMsgUnitPrice);

		expenseInvoice.waitRequiredTaxRateField();
		String actualMsgTaxRate = expenseInvoice.requiredTaxRateField.getText();
		String expectedMsgTaxRate = "Required";

		softassert.assertEquals(actualMsgTaxRate, expectedMsgTaxRate);

		softassert.assertAll();

	}

	@Test(priority = 9)
	public void addNewBill() throws InterruptedException {
		ExpenseInvoice expenseInvoice = new ExpenseInvoice(driver);

		expenseInvoice.waitItemField();
		expenseInvoice.itemField.sendKeys("123");

		expenseInvoice.waitSelectItem();
		Actions action = new Actions(driver);

		action.moveToElement(expenseInvoice.selectItem).click().build().perform();

		expenseInvoice.waitDescriptionField();
		expenseInvoice.descriptionField.sendKeys("New Bill 1");

		expenseInvoice.waitQuantityField();
		expenseInvoice.quantityField.sendKeys(enterQuantityForBillOne);

		expenseInvoice.waitUnitPriceField();
		expenseInvoice.unitPriceField.sendKeys(enterUnitPriceForBillOne);

		expenseInvoice.waitExpType();
		expenseInvoice.expType.click();

		expenseInvoice.waitSearchExpType();
		expenseInvoice.searchExpType.sendKeys("Bikes Gas");

		expenseInvoice.waitSelectFromExpType();
		expenseInvoice.selectFromExpType.click();

		expenseInvoice.waitEntityField();
		expenseInvoice.entityField.click();

		expenseInvoice.waitSearchExpType();
		expenseInvoice.searchFieldInExpType.sendKeys("101 Gas Station");

		expenseInvoice.searchFieldInExpType.sendKeys(Keys.ENTER);

		expenseInvoice.waitConfirmButtonInExpType();
		expenseInvoice.confirmButtonInExpType.click();

		expenseInvoice.waitTaxRate();
		expenseInvoice.taxRate.click();

		expenseInvoice.waitSelectNoTax();
		expenseInvoice.selectNoTax.click();

		expenseInvoice.waitAddButton();
		expenseInvoice.addButton.click();

		expenseInvoice.waitCloseButtonInRow();

		boolean actualResult = expenseInvoice.closeButtonInRow.isDisplayed();
		boolean expctedResult = true;

		softassert.assertEquals(actualResult, expctedResult);
		softassert.assertAll();
	}

	@Test(priority = 10)
	public void verifyTheAmountWithNoTax() {
		ExpenseInvoice expenseInvoice = new ExpenseInvoice(driver);

		String noTax = expenseInvoice.selectNoTax.getText();

		HashMap<String, Integer> taxMap = new HashMap<>();
		taxMap.put(noTax, 1);

		expenseInvoice.waitEnteredQuantity();
		String quantity = expenseInvoice.enteredQuantity.getText();

		String removeCommaFromQuantity = quantity;
		if (quantity.contains(",")) {

			removeCommaFromQuantity = quantity.replace(",", "");

		}

		double quantityNumber = Double.parseDouble(removeCommaFromQuantity);

		expenseInvoice.waitEnteredUnitPrice();
		String unitPrice = expenseInvoice.enteredUnitPrice.getText();

		String removeCommaFromUnitPrice = unitPrice;
		if (unitPrice.contains(",")) {
			removeCommaFromUnitPrice = unitPrice.replace(",", "");

		}

		double unitPriceNumber = Double.parseDouble(removeCommaFromUnitPrice);

		double calculateTotal = taxMap.get(noTax) * unitPriceNumber * quantityNumber;

		double expectedTotal = Double.parseDouble(String.format("%.2f", calculateTotal));

		expenseInvoice.waitGetAmount();
		String stringAmount = expenseInvoice.getAmount1.getText();

		String updateAmount = stringAmount.replace("LRD ", "");

		String removeCommaFromAmount = updateAmount;
		if (updateAmount.contains(",")) {
			removeCommaFromAmount = updateAmount.replace(",", "");
		}

		actualAmountWithNoTax = Double.parseDouble(removeCommaFromAmount);
		System.out.println(actualAmountWithNoTax + " No Tax");

		softassert.assertEquals(expectedTotal, actualAmountWithNoTax);
		softassert.assertAll();
	}

	@Test(priority = 11)
	public void addTwoNewLineBill() {
		ExpenseInvoice expenseInvoice = new ExpenseInvoice(driver);

		JavascriptExecutor js = (JavascriptExecutor) driver;

		expenseInvoice.waitAddNewLineButton();
		js.executeScript("arguments[0].scrollIntoView();", expenseInvoice.addNewLineButton);
		expenseInvoice.addNewLineButton.click();
		expenseInvoice.waitItemField();
		expenseInvoice.itemField.sendKeys("123");

		expenseInvoice.waitSelectItem();
		Actions action = new Actions(driver);

		action.moveToElement(expenseInvoice.selectItem).click().build().perform();

		expenseInvoice.waitDescriptionField();
		expenseInvoice.descriptionField.sendKeys("New Bill 2");

		expenseInvoice.waitQuantityField();
		expenseInvoice.quantityField.sendKeys(enterQuantityForBillTwo);

		expenseInvoice.waitUnitPriceField();
		expenseInvoice.unitPriceField.sendKeys(enterUnitPriceForBillTwo);

		expenseInvoice.waitExpType();
		expenseInvoice.expType.click();

		expenseInvoice.waitSearchExpType();
		expenseInvoice.searchExpType.sendKeys("Bikes Gas");

		expenseInvoice.waitSelectFromExpType();
		expenseInvoice.selectFromExpType.click();

		expenseInvoice.waitEntityField();
		expenseInvoice.entityField.click();

		expenseInvoice.waitSearchExpType();
		expenseInvoice.searchFieldInExpType.sendKeys("101 Gas Station");

		expenseInvoice.searchFieldInExpType.sendKeys(Keys.ENTER);

		expenseInvoice.waitConfirmButtonInExpType();
		expenseInvoice.confirmButtonInExpType.click();

		expenseInvoice.waitTaxRate();
		expenseInvoice.taxRate.click();

		expenseInvoice.waitSelect10Tax();
		expenseInvoice.select10Tax.click();

		expenseInvoice.waitAddButton();
		expenseInvoice.addButton.click();

		expenseInvoice.waitCloseButtonInRow2();

		boolean actualResult = expenseInvoice.closeButtonInRow2.isDisplayed();
		boolean expctedResult = true;

		softassert.assertEquals(actualResult, expctedResult);
		softassert.assertAll();

	}

	@Test(priority = 12)
	public void verifyTheAmountWith10Tax() {
		ExpenseInvoice expenseInvoice = new ExpenseInvoice(driver);

		String tenTax = expenseInvoice.select10Tax.getText();

		HashMap<String, Double> taxMap = new HashMap<>();
		taxMap.put(tenTax, 1.10);

		expenseInvoice.waitEnteredQuantity1();
		String quantity = expenseInvoice.enteredQuantity1.getText();
		String removeCommaFromQuantity = quantity;
		if (quantity.contains(",")) {

			removeCommaFromQuantity = quantity.replace(",", "");

		}

		double quantityNumber = Double.parseDouble(removeCommaFromQuantity);

		expenseInvoice.waitEnteredUnitPrice1();
		String unitPrice = expenseInvoice.enteredUnitPrice1.getText();
		String removeCommaFromUnitPrice = unitPrice;
		if (unitPrice.contains(",")) {
			removeCommaFromUnitPrice = unitPrice.replace(",", "");

		}

		double unitPriceNumber = Double.parseDouble(removeCommaFromUnitPrice);

		double calculateTotal = taxMap.get(tenTax) * unitPriceNumber * quantityNumber;

		double expectedTotal = Double.parseDouble(String.format("%.2f", calculateTotal));

		expenseInvoice.waitGetAmount2();
		String stringAmount = expenseInvoice.getAmount2.getText();

		String updateAmount = stringAmount.replace("LRD ", "");
		String removeCommaFromAmount = updateAmount;
		if (updateAmount.contains(",")) {
			removeCommaFromAmount = updateAmount.replace(",", "");
		}
		actualAmountWith10Tax = Double.parseDouble(removeCommaFromAmount);

		System.out.println(actualAmountWith10Tax + " 10%");

		softassert.assertEquals(actualAmountWith10Tax, expectedTotal);
		softassert.assertAll();

	}

	@Test(priority = 13)
	public void addThreeNewLineBill() {
		ExpenseInvoice expenseInvoice = new ExpenseInvoice(driver);

		JavascriptExecutor js = (JavascriptExecutor) driver;

		expenseInvoice.waitAddNewLineButton();
		js.executeScript("arguments[0].scrollIntoView();", expenseInvoice.addNewLineButton);
		expenseInvoice.addNewLineButton.click();
		expenseInvoice.waitItemField();
		expenseInvoice.itemField.sendKeys("123");

		expenseInvoice.waitSelectItem();
		Actions action = new Actions(driver);

		action.moveToElement(expenseInvoice.selectItem).click().build().perform();

		expenseInvoice.waitDescriptionField();
		expenseInvoice.descriptionField.sendKeys("New Bill 3");

		expenseInvoice.waitQuantityField();
		expenseInvoice.quantityField.sendKeys(enterQuantityForBillThree);

		expenseInvoice.waitUnitPriceField();
		expenseInvoice.unitPriceField.sendKeys(enterUnitPriceForBillThree);

		expenseInvoice.waitExpType();
		expenseInvoice.expType.click();

		expenseInvoice.waitSearchExpType();
		expenseInvoice.searchExpType.sendKeys("Bikes Gas");

		expenseInvoice.waitSelectFromExpType();
		expenseInvoice.selectFromExpType.click();

		expenseInvoice.waitEntityField();
		expenseInvoice.entityField.click();

		expenseInvoice.waitSearchExpType();
		expenseInvoice.searchFieldInExpType.sendKeys("101 Gas Station");

		expenseInvoice.searchFieldInExpType.sendKeys(Keys.ENTER);

		expenseInvoice.waitConfirmButtonInExpType();
		expenseInvoice.confirmButtonInExpType.click();

		expenseInvoice.waitTaxRate();
		expenseInvoice.taxRate.click();

		expenseInvoice.waitSelect15Tax();
		expenseInvoice.select15Tax.click();

		expenseInvoice.waitAddButton();
		expenseInvoice.addButton.click();

		expenseInvoice.waitCloseButtonInRow3();

		boolean actualResult = expenseInvoice.closeButtonInRow3.isDisplayed();
		boolean expctedResult = true;

		softassert.assertEquals(actualResult, expctedResult);
		softassert.assertAll();

	}

	@Test(priority = 14)
	public void verifyThe15TaxRate() {

		ExpenseInvoice expenseInvoice = new ExpenseInvoice(driver);

		String fifteenTax = expenseInvoice.select15Tax.getText();

		HashMap<String, Double> taxMap = new HashMap<>();
		taxMap.put(fifteenTax, 1.15);

		expenseInvoice.waitEnteredQuantity2();
		String quantity = expenseInvoice.enteredQuantity2.getText();

		String removeQommaFromQuantity = quantity;
		if (quantity.contains(",")) {

			removeQommaFromQuantity = quantity.replace(",", "");
		}

		double quantityNumber = Double.parseDouble(removeQommaFromQuantity);

		expenseInvoice.waitEnteredUnitPrice2();
		String unitPrice = expenseInvoice.enteredUnitPrice2.getText();

		String removeQommaFromUnitPrice = unitPrice;
		if (unitPrice.contains(",")) {
			removeQommaFromUnitPrice = unitPrice.replace(",", "");
		}

		double unitPriceNumber = Double.parseDouble(removeQommaFromUnitPrice);

		double calculateTotal = taxMap.get(fifteenTax) * unitPriceNumber * quantityNumber;

		double expectedTotal = Double.parseDouble(String.format("%.2f", calculateTotal));

		expenseInvoice.waitGetAmount3();
		String stringAmount = expenseInvoice.getAmount3.getText();

		String updateAmount = stringAmount.replace("LRD ", "");

		String removeCommaFromAmount = updateAmount;
		if (updateAmount.contains(",")) {
			removeCommaFromAmount = updateAmount.replace(",", "");
		}
		actualAmountWith15Tax = Double.parseDouble(removeCommaFromAmount);
		System.out.println(actualAmountWith15Tax + " 15%");

		softassert.assertEquals(expectedTotal, actualAmountWith15Tax);
		softassert.assertAll();
	}

	@Test(priority = 15)
	public void addFourNewLineBill() {
		ExpenseInvoice expenseInvoice = new ExpenseInvoice(driver);

		JavascriptExecutor js = (JavascriptExecutor) driver;

		expenseInvoice.waitAddNewLineButton();
		js.executeScript("arguments[0].scrollIntoView();", expenseInvoice.addNewLineButton);
		expenseInvoice.addNewLineButton.click();
		expenseInvoice.waitItemField();
		expenseInvoice.itemField.sendKeys("123");

		expenseInvoice.waitSelectItem();
		Actions action = new Actions(driver);

		action.moveToElement(expenseInvoice.selectItem).click().build().perform();

		expenseInvoice.waitDescriptionField();
		expenseInvoice.descriptionField.sendKeys("New Bill 4");

		expenseInvoice.waitQuantityField();
		expenseInvoice.quantityField.sendKeys(enterQuantityForBillFour);

		expenseInvoice.waitUnitPriceField();
		expenseInvoice.unitPriceField.sendKeys(enterUnitPriceForBillFour);

		expenseInvoice.waitExpType();
		expenseInvoice.expType.click();

		expenseInvoice.waitSearchExpType();
		expenseInvoice.searchExpType.sendKeys("Bikes Gas");

		expenseInvoice.waitSelectFromExpType();
		expenseInvoice.selectFromExpType.click();

		expenseInvoice.waitEntityField();
		expenseInvoice.entityField.click();

		expenseInvoice.waitSearchExpType();
		expenseInvoice.searchFieldInExpType.sendKeys("101 Gas Station");

		expenseInvoice.searchFieldInExpType.sendKeys(Keys.ENTER);

		expenseInvoice.waitConfirmButtonInExpType();
		expenseInvoice.confirmButtonInExpType.click();

		expenseInvoice.waitTaxRate();
		expenseInvoice.taxRate.click();

		expenseInvoice.waitSelect15Tax();
		expenseInvoice.select20Tax.click();

		expenseInvoice.waitAddButton();
		expenseInvoice.addButton.click();

		expenseInvoice.waitCloseButtonInRow4();

		boolean actualResult = expenseInvoice.closeButtonInRow4.isDisplayed();
		boolean expctedResult = true;

		softassert.assertEquals(actualResult, expctedResult);
		softassert.assertAll();

	}

	@Test(priority = 16)
	public void verifyThe20TaxRate() {

		ExpenseInvoice expenseInvoice = new ExpenseInvoice(driver);
		String twentyTax = expenseInvoice.select20Tax.getText();

		HashMap<String, Double> taxMap = new HashMap<>();
		taxMap.put(twentyTax, 1.20);

		expenseInvoice.waitEnteredQuantity3();
		String quantity = expenseInvoice.enteredQuantity3.getText();

		String removeCommaFromQuantity = quantity;
		if (quantity.contains(",")) {

			removeCommaFromQuantity = quantity.replace(",", "");
		}

		double quantityNumber = Double.parseDouble(removeCommaFromQuantity);

		expenseInvoice.waitEnteredUnitPrice3();
		String unitPrice = expenseInvoice.enteredUnitPrice3.getText();

		String removeCommaFromUnitPrice = unitPrice;
		if (unitPrice.contains(",")) {
			removeCommaFromUnitPrice = unitPrice.replace(",", "");
		}

		double unitPriceNumber = Double.parseDouble(removeCommaFromUnitPrice);

		double calculateTotal = taxMap.get(twentyTax) * unitPriceNumber * quantityNumber;

		double expectedTotal = Double.parseDouble(String.format("%.2f", calculateTotal));

		expenseInvoice.waitGetAmount4();
		String stringAmount = expenseInvoice.getAmount4.getText();

		String updateAmount = stringAmount.replace("LRD ", "");

		String removeCommaFromAmount = updateAmount;
		if (updateAmount.contains(",")) {
			removeCommaFromAmount = updateAmount.replace(",", "");
		}

		actualAmountWith20Tax = Double.parseDouble(removeCommaFromAmount);
		System.out.println(actualAmountWith20Tax + " 20%");

		softassert.assertEquals(expectedTotal, actualAmountWith20Tax);
		softassert.assertAll();
	}

	@Test(priority = 17)
	public void verifyIfTotalAmountInFooterGreaterThanTotalAmountOnHeader() throws InterruptedException {
		ExpenseInvoice expenseInvoice = new ExpenseInvoice(driver);

		String getTotalAmountOnHeader = expenseInvoice.enterTotalOnHeader.getAttribute("value");
		double totalAmountOnHeader = Double.parseDouble(getTotalAmountOnHeader);

		expenseInvoice.waitSaveAsDraftButton();
		expenseInvoice.saveAsDraftButton.click();

		expenseInvoice.waitTotalAmountOnFooter();
		String getTotalAmountOnfooter = expenseInvoice.totalAmountOnFooter.getText();

		double totalAmountOnfooter = Double.parseDouble(getTotalAmountOnfooter);

		expenseInvoice.waitValidationMessegePopup();
		String actualResult = expenseInvoice.validationMessegePopup.getText();

		if (totalAmountOnfooter > totalAmountOnHeader) {

			String expectedResult = "The sum of the items is greater than the total.";
			softassert.assertEquals(actualResult, expectedResult);
		}

		softassert.assertAll();
		expenseInvoice.waitOkButton();
		expenseInvoice.okButton.click();

	}

	@Test(priority = 18)
	public void verifyIfTotalAmountInFooterLessThanTotalAmountOnHeader() throws InterruptedException {
		ExpenseInvoice expenseInvoice = new ExpenseInvoice(driver);

		expenseInvoice.waitEnterTotalOnHeader();
		expenseInvoice.enterTotalOnHeader.click();
		expenseInvoice.enterTotalOnHeader.clear();
		expenseInvoice.enterTotalOnHeader.sendKeys("10000000000000");

		expenseInvoice.waitSaveAsDraftButton();
		expenseInvoice.saveAsDraftButton.click();

		expenseInvoice.waitValidationMessegePopup();
		String actualResult = expenseInvoice.validationMessegePopup.getText();
		String expectedResult = "Save Bill Succeed.";
		softassert.assertEquals(actualResult, expectedResult);
		softassert.assertAll();

		expenseInvoice.waitOkButton();
		expenseInvoice.okButton.click();

	}

	@Test(priority = 19)
	public void verifyTheTotalAmountOnFooter() throws InterruptedException {

		ExpenseInvoice expenseInvoice = new ExpenseInvoice(driver);

		expectedTotalAmountInFooter = actualAmountWith20Tax + actualAmountWith15Tax + actualAmountWith10Tax
				+ actualAmountWithNoTax;

		double expectedTotalInFooter = Double.parseDouble(String.format("%.2f", expectedTotalAmountInFooter));

		System.out.println(expectedTotalAmountInFooter + "<-- total Amount");
		expenseInvoice.waitTotalAmountOnFooter();
		String totalInFooter = expenseInvoice.totalAmountOnFooter.getText();

		String removeCommaFromTotalAmountInFooter = totalInFooter;
		if (totalInFooter.contains(",")) {
			removeCommaFromTotalAmountInFooter = totalInFooter.replace(",", "");

		}
		actualTotalAmount = Double.parseDouble(removeCommaFromTotalAmountInFooter);

		softassert.assertEquals(actualTotalAmount, expectedTotalInFooter);
		softassert.assertAll();

	}

	@Test(priority = 20)
	public void verifyGSTNumberFromNoTaxField() {

		ExpenseInvoice expenseInvoice = new ExpenseInvoice(driver);
		expenseInvoice.waitEnteredQuantity();

		String enteredQtyNumber = expenseInvoice.enteredQuantity.getText();

		String removeCommaFromQty = enteredQtyNumber;
		if (enteredQtyNumber.contains(",")) {

			removeCommaFromQty = enteredQtyNumber.replace(",", "");
		}

		double quantityNumber = Double.parseDouble(removeCommaFromQty);

		expenseInvoice.waitEnteredUnitPrice();
		String enteredUnitPriceNumber = expenseInvoice.enteredUnitPrice.getText();

		String removeCommaFromUnitPrice = enteredUnitPriceNumber;
		if (enteredUnitPriceNumber.contains(",")) {
			removeCommaFromUnitPrice = enteredUnitPriceNumber.replace(",", "");

		}

		double unitPriceNumber = Double.parseDouble(removeCommaFromUnitPrice);

		expenseInvoice.waitSelectNoTax();
		String enteredNoTaxValue = expenseInvoice.selectNoTax.getText();

		HashMap<String, Double> taxMap = new HashMap<>();
		taxMap.put(enteredNoTaxValue, 0.0);

		taxValueForBillOne = taxMap.get(enteredNoTaxValue) * unitPriceNumber * quantityNumber;

		System.out.println(taxValueForBillOne);
	}

	@Test(priority = 21)
	public void verifyGSTNumberFrom10TaxField() {

		ExpenseInvoice expenseInvoice = new ExpenseInvoice(driver);

		expenseInvoice.waitEnteredQuantity1();
		String enteredQtyNumber = expenseInvoice.enteredQuantity1.getText();

		String removeCommaFromQty = enteredQtyNumber;
		if (enteredQtyNumber.contains(",")) {
			removeCommaFromQty = enteredQtyNumber.replace(",", "");
		}

		double quantityNumber = Double.parseDouble(removeCommaFromQty);

		expenseInvoice.waitEnteredUnitPrice1();
		String enteredUnitPriceNumber = expenseInvoice.enteredUnitPrice1.getText();

		String removeComma = enteredUnitPriceNumber;
		if (enteredUnitPriceNumber.contains(",")) {
			removeComma = enteredUnitPriceNumber.replace(",", "");

		}

		double unitPriceNumber = Double.parseDouble(removeComma);

		expenseInvoice.waitSelect10Tax();
		String enteredNoTaxValue = expenseInvoice.select10Tax.getText();

		HashMap<String, Double> taxMap = new HashMap<>();
		taxMap.put(enteredNoTaxValue, 0.10);

		taxValueForBillTwo = taxMap.get(enteredNoTaxValue) * unitPriceNumber * quantityNumber;

		System.out.println(taxValueForBillTwo);
	}

	@Test(priority = 22)
	public void verifyGSTNumberFrom15TaxField() {

		ExpenseInvoice expenseInvoice = new ExpenseInvoice(driver);

		expenseInvoice.waitEnteredQuantity2();
		String enteredQtyNumber = expenseInvoice.enteredQuantity2.getText();

		String removeCommaFromQty = enteredQtyNumber;
		if (enteredQtyNumber.contains(",")) {
			removeCommaFromQty = enteredQtyNumber.replace(",", "");

		}

		double quantityNumber = Double.parseDouble(removeCommaFromQty);

		expenseInvoice.waitEnteredUnitPrice2();
		String enteredUnitPriceNumber = expenseInvoice.enteredUnitPrice2.getText();

		String removeCommaFromUnitPrice = enteredUnitPriceNumber;
		if (enteredUnitPriceNumber.contains(",")) {
			removeCommaFromUnitPrice = enteredUnitPriceNumber.replace(",", "");
		}

		double unitPriceNumber = Double.parseDouble(removeCommaFromUnitPrice);

		expenseInvoice.waitSelect15Tax();
		String enteredNoTaxValue = expenseInvoice.select15Tax.getText();

		HashMap<String, Double> taxMap = new HashMap<>();
		taxMap.put(enteredNoTaxValue, 0.15);

		taxValueForBillThree = taxMap.get(enteredNoTaxValue) * unitPriceNumber * quantityNumber;

		System.out.println(taxValueForBillThree);
	}

	@Test(priority = 23)
	public void verifyGSTNumberFrom20TaxField() {

		ExpenseInvoice expenseInvoice = new ExpenseInvoice(driver);

		expenseInvoice.waitEnteredQuantity3();
		String enteredQtyNumber = expenseInvoice.enteredQuantity3.getText();

		String removeComma = enteredQtyNumber;
		if (enteredQtyNumber.contains(",")) {

			removeComma = enteredQtyNumber.replace(",", "");
		}

		double quantityNumber = Double.parseDouble(removeComma);

		expenseInvoice.waitEnteredUnitPrice3();
		String enteredUnitPriceNumber = expenseInvoice.enteredUnitPrice3.getText();

		String removeCommaFromUnitPrice = enteredUnitPriceNumber;
		if (enteredUnitPriceNumber.contains(",")) {
			removeCommaFromUnitPrice = enteredUnitPriceNumber.replace(",", "");
		}

		double unitPriceNumber = Double.parseDouble(removeCommaFromUnitPrice);

		expenseInvoice.waitSelect20Tax();
		String enteredNoTaxValue = expenseInvoice.select20Tax.getText();

		HashMap<String, Double> taxMap = new HashMap<>();
		taxMap.put(enteredNoTaxValue, 0.20);

		taxValueForBillFour = taxMap.get(enteredNoTaxValue) * unitPriceNumber * quantityNumber;

		System.out.println(taxValueForBillFour);
	}

	@Test(priority = 24)
	public void verifyTheTotalGST() {
		ExpenseInvoice expenseInvoice = new ExpenseInvoice(driver);
		double expectedTotalGST = taxValueForBillFour + taxValueForBillThree + taxValueForBillTwo + taxValueForBillOne;
		System.out.println(expectedTotalGST + " <-- this is a total GST ");

		expenseInvoice.waitGSTNumber();
		String getGSTNumber = expenseInvoice.GSTNumber.getText();

		String removeComma = getGSTNumber;
		if (getGSTNumber.contains(",")) {
			removeComma = getGSTNumber.replace(",", "");
		}

		actualGSTNumber = Double.parseDouble(removeComma);

		softassert.assertEquals(actualGSTNumber, expectedTotalGST);
		softassert.assertAll();
	}

	@Test(priority = 25)
	public void verifySubTotalAmount() {
		ExpenseInvoice expenseInvoice = new ExpenseInvoice(driver);

		System.out.println(actualGSTNumber + " GST NUMBER");
		System.out.println(actualTotalAmount + " TOTAL AMOUNT NUMBER");

		double expectedSubTotalAmount = actualTotalAmount - actualGSTNumber;

		System.out.println(expectedSubTotalAmount + " Sub Total");

		expenseInvoice.waitSubTotal();
		String getSubTotal = expenseInvoice.subTotal.getText();

		String removeComma = getSubTotal;
		if (getSubTotal.contains(",")) {
			removeComma = getSubTotal.replace(",", "");
		}

		double actualSubTotal = Double.parseDouble(removeComma);

		System.out.println(actualSubTotal + " Sub Total");

		softassert.assertEquals(actualSubTotal, expectedSubTotalAmount);
		softassert.assertAll();

	}

	@Test(priority = 26)
	public void verifyApprovedButtonIsNotClickableWhenTheTotalAmountNotEqualAmout() {
		ExpenseInvoice expenseInvoice = new ExpenseInvoice(driver);

		expenseInvoice.waitEnterTotalOnHeader();

		String getTotalAmountInHeader = expenseInvoice.enterTotalOnHeader.getAttribute("value");

		double totalAmountInHeader = Double.parseDouble(getTotalAmountInHeader);

		expenseInvoice.waitTotalAmountOnFooter();
		String getTotalAmountInFooter = expenseInvoice.totalAmountOnFooter.getText();

		String removeComma = getTotalAmountInFooter;

		if (getTotalAmountInFooter.contains(",")) {
			removeComma = getTotalAmountInFooter.replace(",", "");
		}

		double totalAmountInFooter = Double.parseDouble(removeComma);

		if (totalAmountInHeader != totalAmountInFooter) {

			boolean actualResult = expenseInvoice.approveButton.isEnabled();

			softassert.assertEquals(actualResult, false);
		}

		softassert.assertAll();

	}

	@Test(priority = 27)
	public void verifyApprovedButtonIsClickableWhenTotalAmountEqualAmout() throws InterruptedException {

		ExpenseInvoice expenseInvoice = new ExpenseInvoice(driver);

		expenseInvoice.waitEnterTotalOnHeader();

		Actions action = new Actions(driver);

		Thread.sleep(1000);
		action.doubleClick(expenseInvoice.enterTotalOnHeader).build().perform();

		Thread.sleep(1000);
		expenseInvoice.enterTotalOnHeader.sendKeys(Keys.BACK_SPACE);

		String stringValue = String.valueOf(expectedTotalAmountInFooter);

		System.out.println(stringValue + "<-- String Value **");

		expenseInvoice.enterTotalOnHeader.sendKeys(stringValue);

		expenseInvoice.waitSaveAsDraftButton();
		expenseInvoice.saveAsDraftButton.click();

		expenseInvoice.waitOkButton();
		expenseInvoice.okButton.click();

		String getTotalAmountInHeader = expenseInvoice.enterTotalOnHeader.getDomAttribute("value");
		double totalAmountInHeader = Double.parseDouble(getTotalAmountInHeader);

		expenseInvoice.waitTotalAmountOnFooter();
		String getTotalAmountInFooter = expenseInvoice.totalAmountOnFooter.getText();

		String removeComma = getTotalAmountInFooter;
		if (getTotalAmountInFooter.contains(",")) {
			removeComma = getTotalAmountInFooter.replace(",", "");
		}

		double totalAmountInFooter = Double.parseDouble(removeComma);

		if (totalAmountInHeader == totalAmountInFooter) {

			expenseInvoice.waitApproveButton();
			boolean actualResult = expenseInvoice.approveButton.isEnabled();

			softassert.assertEquals(actualResult, true);
		}

		softassert.assertAll();

	}

	@Test(priority = 28)
	public void verifyClickOnApprovedButton() throws InterruptedException {
		ExpenseInvoice expenseInvoice = new ExpenseInvoice(driver);

		expenseInvoice.waitApproveButton();
		expenseInvoice.approveButton.click();

		expenseInvoice.waitConfirmationPopUp();
		Thread.sleep(2000);

		String actualconfirmPopUp = expenseInvoice.confirmationPopUp.getText();

		String expectedconfirmPopUp = "Are You Sure You Want To Approve This Bill? This Action Will Confirm And Finalize The Bill.";

		softassert.assertEquals(actualconfirmPopUp, expectedconfirmPopUp);
		softassert.assertAll();

	}

	@Test(priority = 29)
	public void verifyClickOnApprovedButtonInPopup() {
		ExpenseInvoice expenseInvoice = new ExpenseInvoice(driver);

		expenseInvoice.waitApproveButtonInPupUp();
		expenseInvoice.approveButtonInPupUp.click();

		expenseInvoice.waitConfirmedMsg();
		String actualConfirmedMessage = expenseInvoice.confirmedMsg.getText();

		System.out.println(actualConfirmedMessage + " <-- MMMMMM");
		String expectedConfirmedMessage = "Save Bill Succeed.";

		softassert.assertEquals(actualConfirmedMessage, expectedConfirmedMessage);
		softassert.assertAll();

		expenseInvoice.waitOkButton();
		expenseInvoice.okButton.click();

	}

	@Test(priority = 30)
	public void verifyTheNumberOfAttchment() {
		ExpenseInvoice expenseInvoice = new ExpenseInvoice(driver);

		expenseInvoice.waitNumberOfAttachment();
		String actualNumberOfAttachment = expenseInvoice.numberOfAttachment.getText();
		String expectedNumberOfAttachment = "1";

		softassert.assertEquals(actualNumberOfAttachment, expectedNumberOfAttachment);
		softassert.assertAll();

	}

//	@Test(priority = 31)
//	public void clickOnBackButton() {
//		ExpenseInvoice expenseInvoice = new ExpenseInvoice(driver);
//
//		expenseInvoice.waitBackButton();
//		expenseInvoice.backButton.click();
//
//		expenseInvoice.waitConfirmButtonInBackPopUp();
//		expenseInvoice.confirmButtonInBackPopUp.click();
//	}
//
//	@Test(priority = 32)
//	public void search_with_spaces() throws InterruptedException {
//		ExpenseInvoice expenseInvoice = new ExpenseInvoice(driver);
//		expenseInvoice.waitSearchField();
//		expenseInvoice.searchField.sendKeys("      ");
//
//		expenseInvoice.waitToasterMessage();
//
//		String actualResult = expenseInvoice.toasterMessage.getText();
//		String expectedResult = "The minimum characters for searching is 3";
//
//		softassert.assertEquals(actualResult, expectedResult);
//		softassert.assertAll();
//
//		expenseInvoice.searchField.sendKeys(Keys.CONTROL + "a");
//		expenseInvoice.searchField.sendKeys(Keys.BACK_SPACE);
//
//	}
//
//	@Test(priority = 33)
//	public void search_with_invalid_data() throws InterruptedException {
//		ExpenseInvoice expenseInvoice = new ExpenseInvoice(driver);
//		expenseInvoice.waitSearchField();
//		expenseInvoice.searchField.sendKeys("Nadsoft Tester");
//
//		expenseInvoice.waitInvalidToasterMessage();
//
//		String actualResult = expenseInvoice.invalidToasterMessage.getText();
//		String expectedResult = "No vendors found for 'Nadsoft Tester' search.";
//
//		softassert.assertEquals(actualResult, expectedResult);
//		softassert.assertAll();
//
//		expenseInvoice.searchField.sendKeys(Keys.CONTROL + "a");
//		expenseInvoice.searchField.sendKeys(Keys.BACK_SPACE);
//	}
//
//	@Test(priority = 34)
//	public void searchWithValidData() throws InterruptedException {
//		ExpenseInvoice expenseInvoice = new ExpenseInvoice(driver);
//
//		expenseInvoice.waitSearchField();
//		expenseInvoice.searchField.sendKeys("Coca Cola");
//
//		expenseInvoice.waitSearchResultInMainSearch();
//
//		Actions action = new Actions(driver);
//		action.moveToElement(expenseInvoice.searchResultInMainSearch).click().build().perform();
//
//		expenseInvoice.waitCountOfSearch();
//
//		List<WebElement> countOfSearch = driver.findElements(By.xpath("//tbody//tr"));
//		int numberOfResults = countOfSearch.size();
//
//		System.out.println(numberOfResults);
//		for (int i = 0; i < numberOfResults; i++) {
//			System.out.println("Result text:" + countOfSearch.get(i).getText());
//
//			if (countOfSearch.get(i).getText().contains("Coca Cola")) {
//				softassert.assertTrue(true);
//
//			}
//		}
//		softassert.assertAll();
//	}

//	@AfterTest
//	public void afterTest() {
//		if (driver != null) {
//
//			driver.quit();
//		}
//		driver = null;
//
//	}

}