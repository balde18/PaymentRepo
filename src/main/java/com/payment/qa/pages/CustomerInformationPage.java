package com.payment.qa.pages;

import com.payment.qa.baseclass.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerInformationPage extends TestBase {

    //Page Factory - OR (Object repository)

    @FindBy(name = "name")
    WebElement name;

    @FindBy(name = "email")
    WebElement email;

    @FindBy(name = "mobile")
    WebElement mobile;

    @FindBy(name = "amount")
    WebElement amount;

    @FindBy(name ="description")
    WebElement description;

    @FindBy(xpath = "//button[contains(text(),'Proceed to pay')]")
    WebElement proceed_to_pay_button;

    @FindBy(xpath = "//a[contains(@class, 'navbar-brand')]")
    WebElement logo;

    @FindBy(xpath = "//h1[contains(text(), 'OurTesting store')]")
    WebElement store_name;

    //Initializing the page objects

    public CustomerInformationPage()
    {
        PageFactory.initElements(driver, this);
    }

    //Actions

    public String validatePageTitle()
    {
        return driver.getTitle();
    }

    public boolean validateLogo()
    {
        return logo.isDisplayed();
    }

    public String validateStoreName()
    {
        return store_name.getText();
    }

//    public CouponCodePage PaymentPage(String merchant_name, String merchant_email, String merchant_number, String payable_amount,
//                            String desc){
//        name.sendKeys(merchant_name);
//        email.sendKeys(merchant_email);
//        mobile.sendKeys(merchant_number);
//        amount.sendKeys(payable_amount);
//        description.sendKeys(desc);
//
//        proceed_to_pay_button.click();
//
//        return new CouponCodePage();
//
//    }

     public CouponCodePage EnterCustomerInformation(String merchant_name, String merchant_email, String merchant_number,
                                         String payable_amount, String desc)

    {
        name.sendKeys(merchant_name);
        email.sendKeys(merchant_email);
        mobile.sendKeys(merchant_number);
        amount.sendKeys(payable_amount);
        description.sendKeys(desc);

        proceed_to_pay_button.click();
        return new CouponCodePage();
    }

}
