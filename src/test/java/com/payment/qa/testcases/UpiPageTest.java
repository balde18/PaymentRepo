package com.payment.qa.testcases;

import com.payment.qa.baseclass.TestBase;
import com.payment.qa.pages.*;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UpiPageTest extends TestBase {

    CustomerInformationPage CustomerInfoPage;
    CouponCodePage CouponCodepage;
    PaymentDetailsPage paymentDetailspage;
    UpiPage UPIPage;
    UPIPaymentProcessingPage upipaymentprocessingpage;

    public UpiPageTest()
    {
        super();
    }

    @BeforeMethod
    public void setup()
    {
        initialization();
        CustomerInfoPage = new CustomerInformationPage();
        UPIPage = new UpiPage();
        CouponCodepage = CustomerInfoPage.EnterCustomerInformation("Rahul", "rahul@example.com",
                "9098007752", "201", "Testing for UPI page");
        paymentDetailspage = CouponCodepage.VerifyCouponCodeButtonClick();
        paymentDetailspage.SelectPaymentMethod("card-4");
    }
    @Test(priority = 1)
    public void VerifyUPIOptionSelectedTest() throws InterruptedException {
        Assert.assertTrue(UPIPage.VerifyUPIOptionIsSelected());
    }

    @Test(priority = 2)
    public void VerifyUPIFieldAvailableTest()
    {
        Assert.assertTrue(UPIPage.VerifyUPIFieldAvailable());
    }

    @Test(priority = 3)
    public void verifyPayButtonTest()
    {
        upipaymentprocessingpage = UPIPage.VerifyPayButton("9098007752@paytm");
        Assert.assertTrue(upipaymentprocessingpage.VerifyTextOnUpiScreen());
    }

    @AfterMethod
    public void teardown()
    {
        driver.quit();
    }
}
