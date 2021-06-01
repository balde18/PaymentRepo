package com.payment.qa.pages;

import com.payment.qa.baseclass.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CouponCodePage extends TestBase {

    @FindBy(xpath = "//label[contains(text(), 'Coupon Code')]")
    WebElement CouponCodeLabel;

    @FindBy(name = "code")
    WebElement CouponCodeField;

    @FindBy(id ="offer-to-payment")
    WebElement Offerbtn;

    @FindBy(xpath = "//h1[contains(text(), 'OurTesting store')]")
    WebElement store_name;

    public String VerifyTitleOnCouponCodePage()
    {
        return driver.getTitle();
    }


    public CouponCodePage()
    {
        PageFactory.initElements(driver, this);
    }

    public String VerifyStoreNameOnCouponCodePage()
    {
        return store_name.getText();
    }

    public boolean VerifyCouponLabel()
    {
        return CouponCodeLabel.isDisplayed();
    }

    public boolean VerifyCouponCodeField(){
        return CouponCodeField.isDisplayed();
    }

    public boolean VerifyOfferButton()
    {
        return Offerbtn.isDisplayed();
    }

    public PaymentDetailsPage VerifyCouponCodeButtonClick()
    {
        Offerbtn.click();
        return new PaymentDetailsPage();
    }
}
