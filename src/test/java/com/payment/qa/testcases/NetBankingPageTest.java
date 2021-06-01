package com.payment.qa.testcases;

import com.payment.qa.baseclass.TestBase;
import com.payment.qa.pages.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NetBankingPageTest extends TestBase {

    CustomerInformationPage CustomerInfoPage;
    CouponCodePage CouponCodepage;
    PaymentDetailsPage paymentDetailspage;
    UpiPage UPIPage;
    NetBankingPage netbankingpage;


    public NetBankingPageTest()
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
        paymentDetailspage.SelectPaymentMethod("card-3");
        netbankingpage = new NetBankingPage();
    }

    @Test(priority = 1)
    public void CustomerInformationTitleTest()
    {
        String title = CustomerInfoPage.validatePageTitle();
        Assert.assertEquals(title, "ftcash");
    }

    @Test(priority = 2)
    public void CustomerInformationLogoTest()
    {
        boolean flag = CustomerInfoPage.validateLogo();
        Assert.assertTrue(flag);
    }

    @Test(priority = 3)
    public void VerifyProceedBtnTest()
    {
        Assert.assertTrue(netbankingpage.validateButtonAvailable());
    }

    @Test(priority = 4)
    public void SelectBankTest() throws InterruptedException {
        netbankingpage.validateBtn();
        String PageText = netbankingpage.validatetextonICICPage();
        Assert.assertEquals(PageText, "Payment through ICICI Bank");
    }

    @AfterMethod
    public void teardown()
    {
        driver.quit();
    }

}
