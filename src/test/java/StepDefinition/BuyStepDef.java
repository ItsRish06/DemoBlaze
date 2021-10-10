package StepDefinition;

import com.base.Base;
import com.page.BuyPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class BuyStepDef extends Base {

    BuyPage bp;

    @Before("@buy")
    public void initial(){
        initialization();
        bp = new BuyPage();
    }

    @Given("^b\\-User is into cart$")
    public void buser_is_into_cart() throws Throwable {
        getPage("https://www.demoblaze.com/cart.html");
    }

    @When("^b\\-User clicks PlaceOrder$")
    public void buser_clicks_placeorder() throws Throwable {
        bp.placeOrder();
    }

    @Then("^b\\-User Gets Popup For Details$")
    public void buser_gets_popup_for_details() throws Throwable {
        String actualResult = bp.validateDetailPopup();
        System.out.println(actualResult);
        String expectedResult = "Place order";
        Assert.assertEquals(actualResult,expectedResult);
    }


    @Given("^b\\-User is on cart and Clicks PlaceOrder$")
    public void buser_is_on_cart_and_clicks_placeorder() throws Throwable {
        getPage("https://www.demoblaze.com/cart.html");
        bp.placeOrder();
    }



    @When("^b-User Enters (.+) (.+) (.+) (.+) (.+) (.+)$")
    public void buser_enters(String name, String country, String city, String creditcard, String month, String year) throws Throwable {
        bp.enterDetails(name,country,city,creditcard,month,year);

    }

    @And("^b\\-User Clicks Purchase$")
    public void buser_clicks_purchase() throws Throwable {
        bp.clickPurchase();
    }


    @Then("^b\\-Validate successful purchase$")
    public void bvalidate_successfull_purchase() throws Throwable {
        String actualResult = bp.validatePurchase();
        String expectedResult = "Thank you for your purchase!";
        System.out.println(actualResult);
        Assert.assertEquals(actualResult,expectedResult);
    }

    @Then("^b\\-validate unsuccessful purchase$")
    public void bvalidate_unsuccessful_purchase() throws Throwable {
        boolean result;
        try{
            String actual = bp.validatePurchase();
            result=true;
        }catch (Exception e){
          result = false;
        }
        Assert.assertFalse(result);
    }

    @After("@buy")
    public void finish(){
        tearDown();
    }

}
