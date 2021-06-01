package com.payment.qa.testcases;

import com.payment.qa.baseclass.TestBase;
import com.payment.qa.pages.CouponCodePage;
import com.payment.qa.pages.CustomerInformationPage;
import com.payment.qa.utility.TestUtil;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CustomerInformationPageTest extends TestBase {

    CustomerInformationPage customerinformationpage;
    CouponCodePage couponPage;
    TestUtil testutil;

    String sheetName = "sheet1";

    CustomerInformationPageTest()
    {
        super();
    }

    @BeforeMethod
    public void setup()
    {
        initialization();
        testutil  = new TestUtil();
        customerinformationpage = new CustomerInformationPage();
    }

    @Test(priority = 1)
    public void CustomerInformationTitleTest()
    {
        System.out.println("Title Verified");
        String title = customerinformationpage.validatePageTitle();
        Assert.assertEquals(title, "ftcash");
    }

    @Test(priority = 2)
    public void CustomerInformationLogoTest()
    {
        System.out.println("Logo Verified");
        boolean flag = customerinformationpage.validateLogo();
        Assert.assertTrue(flag);
    }

//    @Test(priority = 4)
//    public void CustomerInformationPaymentPageTest()
//    {
//       System.out.println("Insert data");
//       couponPage =  customerinformationpage.PaymentPage(prop.getProperty("name"), prop.getProperty("email"),
//                prop.getProperty("number"), prop.getProperty("amount"), prop.getProperty("description"));
//
//    }

    @Test(priority = 3)
    public void CustomerInformationStoreNameTest()
    {
        String storeName = customerinformationpage.validateStoreName();
        System.out.println(storeName);
        Assert.assertEquals(storeName, "OurTesting store");
    }

//    public void ValidateCustomerInformationTest()
//    {
//        customerinformationpage.EnterCustomerInformation("Tom Peter", "peter@example.com",
//                "9098007752", "100", "Automation Test");
//
//    }

    @DataProvider
    public Object[][] getCustomerData()
    {
        Object data[][] = TestUtil.getTestData(sheetName);
        return data;
    }

    @Test(priority = 4, dataProvider = "getCustomerData")
    public void CreateNewData(String name, String email, String number, String amount, String desc)
    {
        customerinformationpage.EnterCustomerInformation(name, email, number,amount, desc);
    }

    @AfterMethod
    public void teardown()
    {
        driver.quit();
    }
}
