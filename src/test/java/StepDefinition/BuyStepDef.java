package StepDefinition;

import com.base.Base;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class BuyStepDef extends Base {


    @Given("^b\\-User is into cart$")
    public void buser_is_into_cart() throws Throwable {
        initialization();
        getPage("https://www.demoblaze.com/cart.html");
    }

    @When("^b\\-User clicks PlaceOrder$")
    public void buser_clicks_placeorder() throws Throwable {
        driver.findElement(By.xpath("//div[@id='page-wrapper']/div/div[2]/button")).click();
    }

    @Then("^b\\-User Gets Popup For Details$")
    public void buser_gets_popup_for_details() throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver,10);
        String actualResult = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='orderModal']/div/div/div"))).getText();
        System.out.println(actualResult);
        String expectedResult = "Place order";
        Assert.assertEquals(actualResult,expectedResult);
    }


    @Given("^b\\-User is on cart and Clicks PlaceOrder$")
    public void buser_is_on_cart_and_clicks_placeorder() throws Throwable {
        initialization();
        getPage("https://www.demoblaze.com/cart.html");
        driver.findElement(By.xpath("//div[@id='page-wrapper']/div/div[2]/button")).click();
    }



    @When("^b-User Enters (.+) (.+) (.+) (.+) (.+) (.+)$")
    public void buser_enters(String name, String country, String city, String creditcard, String month, String year) throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='orderModal']/div/div")));
        driver.findElement(By.id("name")).sendKeys(name);
        driver.findElement(By.id("country")).sendKeys(country);
        driver.findElement(By.id("city")).sendKeys(city);
        driver.findElement(By.id("card")).sendKeys(creditcard);
        driver.findElement(By.id("month")).sendKeys(month);
        driver.findElement(By.id("year")).sendKeys(year);

    }

    @And("^b\\-User Clicks Purchase$")
    public void buser_clicks_purchase() throws Throwable {
        driver.findElement(By.xpath("//div[@id='orderModal']/div/div/div[3]/button[2]")).click();
    }


    @Then("^b\\-Validate successfull purchase$")
    public void bvalidate_successfull_purchase() throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='sweet-alert  showSweetAlert visible']")));
        String actualResult = driver.findElement(By.xpath("//div[@class='sweet-alert  showSweetAlert visible']/h2")).getText();
        String expectedResult = "Thank you for your purchase!";
        System.out.println(actualResult);
        Assert.assertEquals(actualResult,expectedResult);
    }

    @Then("^b\\-validate unsuccessful purchase$")
    public void bvalidate_unsuccessful_purchase() throws Throwable {
        boolean result;
        try{
            WebDriverWait wait = new WebDriverWait(driver,10);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='sweet-alert  showSweetAlert visible']")));
            result=true;
        }catch (Exception e){
          result = false;
        }
        Assert.assertFalse(result);
    }

}
