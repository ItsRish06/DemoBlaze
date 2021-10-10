package com.page;

import com.base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BuyPage extends Base {

    @FindBy(xpath="//div[@id='page-wrapper']/div/div[2]/button")
    WebElement placeOrderBtn;

    @FindBy(xpath = "//div[@id='orderModal']/div/div/div[3]/button[2]")
    WebElement purchaseBtn;

    @FindBy(id ="name")
    WebElement nameIn;

    @FindBy(id ="country")
    WebElement countryIn;

    @FindBy(id ="city")
    WebElement cityIn;

    @FindBy(id ="card")
    WebElement cardIn;

    @FindBy(id ="month")
    WebElement monthIn;

    @FindBy(id ="year")
    WebElement yearIn;


    public BuyPage(){
        PageFactory.initElements(driver,this);
    }

    public void placeOrder(){
        //placeOrderBtn.click();
        placeOrderBtn.click();
    }

    public String validateDetailPopup(){
        WebDriverWait wait = new WebDriverWait(driver,10);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='orderModal']/div/div/div/h5"))).getText();
    }

    public void enterDetails(String name, String country, String city, String creditcard, String month, String year){
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='orderModal']/div/div")));
        nameIn.sendKeys(name);
        countryIn.sendKeys(country);
        cityIn.sendKeys(city);
        cardIn.sendKeys(creditcard);
        monthIn.sendKeys(month);
        yearIn.sendKeys(year);
    }

    public void clickPurchase(){
        purchaseBtn.click();
    }

    public String validatePurchase(){
        WebDriverWait wait = new WebDriverWait(driver,10);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='sweet-alert  showSweetAlert visible']/h2"))).getText();

    }

}
