package com.payment.qa.pages;

import com.payment.qa.baseclass.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UPIPaymentProcessingPage extends TestBase {

    @FindBy(xpath = "//h4[contains(text(), 'Transaction Initiated. waiting for customer approval.')]")
    WebElement UPIText;

    public UPIPaymentProcessingPage()
    {
        PageFactory.initElements(driver, this);
    }

    public boolean VerifyTextOnUpiScreen()
    {
        return UPIText.isDisplayed();
    }

}
