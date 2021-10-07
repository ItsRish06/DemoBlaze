package com.page;

import com.base.Base;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class SearchFunction extends Base {

    public static String product;

    @FindBy(xpath = "//div[@class='list-group']/a[2]")
    WebElement phone;

    @FindBy(xpath = "//div[@class='list-group']/a[3]")
    WebElement laptop;

    @FindBy(xpath = "//div[@class='list-group']/a[4]")
    WebElement monitor;

    @FindBy(xpath = "//a[text()='Samsung galaxy s6']")
    WebElement phoneItem;

    @FindBy(xpath = "//a[text()='Sony vaio i5']")
    WebElement laptopItem;

    @FindBy(xpath = "//a[text()='Apple monitor 24']")
    WebElement monitorItem;

    @FindBy(xpath = "//div[@class='card-block']/h4/a")
    WebElement productItem;

    @FindBy(xpath = "//div[@class='row']/div[2]/div[2]/div/a")
    WebElement addToCart;

    @FindBy(id = "cartur")
    WebElement cart;

    @FindBy(xpath = "//tr[@class='success']/td[2]")
    WebElement productList;

    public SearchFunction() {
        PageFactory.initElements(driver, this);
    }



    public void clickCategory(String category) {
        if(category == "PHONE") {
            phone.click();
            //driver.findElement(By.xpath("//div[@class='list-group']/a[2]")).click();
        }
        else if(category == "LAPTOP") {
            laptop.click();
            //driver.findElement(By.xpath("//div[@class='list-group']/a[3]")).click();
        }
        else {
            monitor.click();
            //driver.findElement(By.xpath("//div[@class='list-group']/a[4]")).click();
        }


    }


    public String validateSearch(String category) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        if(category == "PHONE") {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Samsung galaxy s6']")));
            //return phoneItem.getText();
            return driver.findElement(By.xpath("//a[text()='Samsung galaxy s6']")).getText();
            //return wait.until(ExpectedConditions.visibilityOf(phoneItem)).getText();
        }
        else if(category == "LAPTOP") {
            //wait.until(ExpectedConditions.visibilityOf(laptopItem));
            //return laptopItem.getText();
            //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Sony vaio i5']")));
            //return driver.findElement(By.xpath("//a[text()='Sony vaio i5']")).getText();
            return wait.until(ExpectedConditions.visibilityOf(laptopItem)).getText();
        }
        else {
            //wait.until(ExpectedConditions.visibilityOf(monitorItem));
            //return monitorItem.getText();
            //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Apple monitor 24']")));
            //return driver.findElement(By.xpath("//a[text()='Apple monitor 24']")).getText();
            return wait.until(ExpectedConditions.visibilityOf(monitorItem)).getText();
        }
    }

    public void clickProduct() {
        //laptopItem.click();
        WebDriverWait wait = new WebDriverWait(driver, 20);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='card-block']/h4/a"))).click();
        wait.until(ExpectedConditions.visibilityOf(productItem)).click();
    }

    public void clickAddCart() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='row']/div[2]/div[2]/div/a"))).click();
        wait.until(ExpectedConditions.visibilityOf(addToCart)).click();

    }

    public void clickCart() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();
        System.out.println("Alert accepted.");
        product = driver.findElement(By.xpath("//div[@class='row']/div[2]/h2")).getText();
        cart.click();
    }

    public String validateAddCart() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//tr[@class='success']")));
        List<WebElement> products = driver.findElements(By.xpath("//tr[@class='success']/td[2]"));
        //List<WebElement> products = (List<WebElement>) productList;
        System.out.println(products.size());
        System.out.println((products.get(0).getText()) + "|||" + product);
        System.out.println((products.get(0).getText()).equals(product));
        return products.get(0).getText();
    }

    public void clickItem() {
        phone.click();
    }

    /*public static void main(String[] args) {
        SearchFunction obj= new SearchFunction();
        obj.initialization("https://www.demoblaze.com/");
        //obj.clickProduct();
        //obj.clickAddCart();
        //obj.clickCart();
        //obj.validateAddCart();
        obj.clickItem();
    }*/

}
