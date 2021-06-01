package com.payment.qa.testcases;

import com.payment.qa.baseclass.TestBase;
import com.payment.qa.pages.BankPage;
import com.payment.qa.pages.CouponCodePage;
import com.payment.qa.pages.CustomerInformationPage;
import com.payment.qa.pages.PaymentDetailsPage;
import com.payment.qa.utility.TestUtil;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PaymentDetailsPageTest extends TestBase {

    CustomerInformationPage CustomerInfoPage;
    CouponCodePage CouponCodepage;
    PaymentDetailsPage paymentDetailspage;
    BankPage bankpage;

    String sheetName = "sheet1";

    public PaymentDetailsPageTest()
    {
        super();
    }

    @BeforeMethod
    public void setup()
    {
        initialization();
        CustomerInfoPage = new CustomerInformationPage();
        paymentDetailspage = new PaymentDetailsPage();

        //CouponCodepage = CustomerInfoPage.ValidateCustomerInformationTest(prop.getProperty("name"), prop.getProperty("email"),
          //      prop.getProperty("number"), prop.getProperty("amount"), prop.getProperty("description"));

        CouponCodepage = CustomerInfoPage.EnterCustomerInformation("Rahul", "rahul@example.com",
                "9098007752", "201", "Testing for Payment details page");

      //  CouponCodepage = CustomerInfoPage.EnterCustomerInformation("Tom Peter",
        //        "peter@example.com", "9098007752", "100",
          //      "Automation Test");
        paymentDetailspage = CouponCodepage.VerifyCouponCodeButtonClick();
    }

    @Test(priority = 1)
    public void VerifyPaymentOptionIsSelected()
    {
        Assert.assertTrue(paymentDetailspage.VerifyPaymentText(), "Card Option is not available on the " +
                "page");
    }

    @Test(priority = 2)
    public void VerifyCardOptionSelected()
    {
        Assert.assertTrue(paymentDetailspage.VerifyCardOptionIsSelected(), "Card Option Is Not Selected");
    }

    @Test(priority = 2)
    public void SelectPaymentMethod()
    {
       paymentDetailspage.SelectPaymentMethod("card-4");
       paymentDetailspage.SelectPaymentMethod("card-1");
       paymentDetailspage.SelectPaymentMethod("card-3");
       paymentDetailspage.SelectPaymentMethod("card-2");
    }

    @Test(priority = 3)
    public void verifyCardNumberFieldPresent()
    {
        Assert.assertTrue(paymentDetailspage.VerifyCardNumberField());
    }

    @Test(priority = 4)
    public void VerifyNameOnCardFieldTest()
    {
        Assert.assertTrue(paymentDetailspage.VerifyNameOnCardField());
    }

    @Test(priority = 5)
    public void VerifyCVVFieldTest()
    {
        Assert.assertTrue(paymentDetailspage.VerifyCvvField());
    }

    @Test(priority = 6)
    public void VerifyMonthSelectListTest()
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Assert.assertTrue(paymentDetailspage.VerifyMonthSelectList());
    }

    @Test(priority = 7)
    public void VerifyYearSelectListTest()
    {
        Assert.assertTrue(paymentDetailspage.VerifyYearSelectList());
    }

    @Test(priority = 8)
    public void VerifyPaymentButtonTest()
    {
        Assert.assertTrue(paymentDetailspage.VerifyPaymentButton());
    }

    @DataProvider
    public Object[][] getCustomerData()
    {
        Object data[][] = TestUtil.getTestData1(sheetName);
        return data;
    }

    @Test(priority = 9, dataProvider = "getCustomerData")
    public void CreateTransactionData(String number, String name, String cvv, String month, String year)
    {
        paymentDetailspage.EnterPaymentDetails(number, name, cvv, month, year);
    }

    @AfterMethod
    public void teardown()
    {
       driver.quit();
    }
}
