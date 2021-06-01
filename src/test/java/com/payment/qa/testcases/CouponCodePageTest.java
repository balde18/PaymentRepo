package com.payment.qa.testcases;

import com.payment.qa.baseclass.TestBase;
import com.payment.qa.pages.CouponCodePage;
import com.payment.qa.pages.CustomerInformationPage;
import com.payment.qa.pages.PaymentDetailsPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CouponCodePageTest extends TestBase {

    CustomerInformationPage CustomerInfoPage;
    CouponCodePage CouponCodepage;
    PaymentDetailsPage paymentDetailspage;

    public CouponCodePageTest()
    {
        super();
    }

    @BeforeMethod
    public void setup()
    {
        initialization();
        CustomerInfoPage = new CustomerInformationPage();
        paymentDetailspage = new PaymentDetailsPage();
        CouponCodepage = CustomerInfoPage.EnterCustomerInformation("Rahul", "rahul@example.com",
                "9098007752", "200", "Testing coupon code page");
       // CouponCodepage = CustomerInfoPage.PaymentPage(prop.getProperty("name"), prop.getProperty("email"),
         //       prop.getProperty("number"), prop.getProperty("amount"), prop.getProperty("description"));
      //  CouponCodepage = CustomerInfoPage.EnterCustomerInformation("Tom Peter",
      //          "peter@example.com", "9098007752", "100",
      //          "Automation Test");
    }

    @Test(priority = 1)
    public void VerifyTitleOnCouponPageTest()
    {
        String CouponCodepageTitle = CouponCodepage.VerifyTitleOnCouponCodePage();
        Assert.assertEquals(CouponCodepageTitle, "ftcash", "Page Title is not correct");
    }

    @Test(priority = 2)
    public void CustomerInformationStoreNameTest()
    {
        String storeName = CouponCodepage.VerifyStoreNameOnCouponCodePage();
        System.out.println(storeName);
        Assert.assertEquals(storeName, "OurTesting store");
    }

    @Test(priority = 3)
    public void VerifyCouponCodeLabelTest()
    {
        boolean label = CouponCodepage.VerifyCouponLabel();
        Assert.assertTrue(label);
    }

    @Test(priority = 4)
    public void VerifyCouponCodeFieldTest()
    {
        boolean field = CouponCodepage.VerifyCouponCodeField();
        Assert.assertTrue(field);
    }

    @Test(priority = 5)
    public void VerifyApplyButtonTest()
    {
       // boolean btn = CouponCodepage.VerifyOfferButton();
       // Assert.assertTrue(btn);
        Assert.assertTrue(CouponCodepage.VerifyOfferButton());
    }

    @Test(priority = 5)
    public void VerifyApplyOfferButton()
    {
        System.out.println("Executed");
        paymentDetailspage = CouponCodepage.VerifyCouponCodeButtonClick();
    }

    @AfterMethod
    public void teardown()
    {
       driver.quit();
    }
}
