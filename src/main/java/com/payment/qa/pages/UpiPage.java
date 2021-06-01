package com.payment.qa.pages;

import com.payment.qa.baseclass.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UpiPage extends TestBase {

    @FindBy(id = "upi_vpa")
    WebElement UPI;

    @FindBy(id = "pay_by_upi")
    WebElement PayByUpi;

    @FindBy(xpath = "//label[contains(text(), 'VPA (Virtual Payment Address)')]")
    WebElement UpiLabel;

    @FindBy(id = "card-4")
    WebElement PaymentOptionUPI;


    public UpiPage()
    {
        PageFactory.initElements(driver, this);
    }

    public boolean VerifyUPIOption()
    {
        return PaymentOptionUPI.isDisplayed();
    }

    public boolean VerifyUPIOptionIsSelected()
    {
        return PaymentOptionUPI.isEnabled();
    }
    public boolean VerifyUPIFieldAvailable()
    {
        return UPI.isDisplayed();
    }

    public boolean VerifyUPIButton()
    {
        return PayByUpi.isDisplayed();
    }

    public UPIPaymentProcessingPage VerifyPayButton(String upi)
    {
        UPI.sendKeys(upi);
        PayByUpi.click();
        return new UPIPaymentProcessingPage();
    }
}
