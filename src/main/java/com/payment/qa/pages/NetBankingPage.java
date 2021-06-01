package com.payment.qa.pages;

import com.payment.qa.baseclass.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NetBankingPage extends TestBase {

    @FindBy(xpath = "//h1[contains(text(), 'OurTesting store')]")
    WebElement store_name;

    @FindBy(xpath = "//button[contains(text(), 'Click To Pay.')]")
    WebElement btn;

    @FindBy(xpath = "//a[contains(@class, 'navbar-brand')]")
    WebElement logo;

    @FindBy(xpath = "//input[@type='radio'] [@value='4']")
    WebElement SelectBank;

    @FindBy(id = "btnSubmit")
    WebElement ProceedForPayment;

    @FindBy(id = "LabelForControl16117102")
    WebElement text;

    public NetBankingPage()
    {
        PageFactory.initElements(driver, this);
    }

    public String validateStoreNameOnNetBankingPage()
    {
        return store_name.getText();
    }

    public String validatePageTitle()
    {
        return driver.getTitle();
    }

    public boolean validateButtonAvailable()
    {
        return btn.isDisplayed();
    }

    public void validateBtn() throws InterruptedException {
        btn.click();
        Thread.sleep(2000);
        SelectBank.click();
        ProceedForPayment.click();
    }

    public String validatetextonICICPage()
    {
        return text.getText();
    }
}
