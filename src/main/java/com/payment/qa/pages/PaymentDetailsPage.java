package com.payment.qa.pages;

import com.payment.qa.baseclass.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PaymentDetailsPage extends TestBase {

    @FindBy(id = "card-1")
    WebElement PaymentOptionCard;

    @FindBy(id = "card-2")
    WebElement PaymentOptionWallets;

    @FindBy(id = "card-3")
    WebElement PaymentOptionNetbanking;

    @FindBy(id = "card-4")
    WebElement PaymentOptionUPI;

    @FindBy(xpath = "//h1[contains(text(), 'OurTesting store')]")
    WebElement store_name;

    @FindBy(xpath = "//a[contains(text(), 'Debit/Credit')]")
    WebElement CardTypesHeader;

    @FindBy(id = "cc_name")
    WebElement NameOnCard;

    @FindBy(id = "checkout_card_number")
    WebElement CardNumber;

    @FindBy(id = "cvv")
    WebElement CVV;

    @FindBy(name = "expMonth")
    WebElement SelectMonth;

    @FindBy(id = "years_pop")
    WebElement SelectYear;

    @FindBy(id = "pay_by_cc")
    WebElement PaymenBtn;

    //*[@id="card-form"]/div[2]/div/div/label[1]

    public PaymentDetailsPage()
    {
        PageFactory.initElements(driver, this);
    }

    public boolean VerifyPaymentText()
    {
        return PaymentOptionCard.isDisplayed();
    }

    public boolean VerifyUPIOption()
    {
        return PaymentOptionUPI.isDisplayed();
    }

    public boolean VerifyUPIOptionIsSelected()
    {
        return PaymentOptionUPI.isSelected();
    }

    public boolean VerifyCardOptionIsSelected()
    {
        return PaymentOptionCard.isEnabled();
    }

    public void SelectPaymentMethod(String method)
    {
        driver.findElement(By.id(method)).click();
    }

    public String VerifyStoreNameOnPaymentDetailsPage()
    {
        return store_name.getText();
    }

    public boolean VerifyCardNumberField()
    {
        return CardNumber.isDisplayed();
    }

    public boolean VerifyNameOnCardField()
    {
        return NameOnCard.isDisplayed();
    }

    public boolean VerifyCvvField()
    {
        return CVV.isDisplayed();
    }

    public boolean VerifyMonthSelectList()
    {
        return SelectMonth.isDisplayed();
    }

    public boolean VerifyYearSelectList()
    {
        return SelectYear.isDisplayed();
    }

    public boolean VerifyPaymentButton()
    {
        return PaymenBtn.isDisplayed();
    }


    public BankPage EnterPaymentDetails(String number, String name, String cvv, String emonth, String eyear)
    {
       Select month = new Select(driver.findElement(By.name("expMonth")));
       month.selectByValue(emonth);

        Select year = new Select(driver.findElement(By.name("expYear")));
        year.selectByValue(eyear);

        NameOnCard.sendKeys(name);
        CardNumber.sendKeys(number);
        CVV.sendKeys(cvv);

        PaymenBtn.click();
        return new BankPage();

    }

}
