package StepDefinition;

import Pages.HomePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.By;
import org.testng.Assert;

public class D03_ChangeCurrency {
    HomePage homepage;

    @When("user select “Euro” from currency dropdown list")
    public void user_select_Euro() {
        homepage = new HomePage(Hooks.driver);
        homepage.Currency().click();
        homepage.CurrencyEuro().click();
    }

    @Then("All $ sign change to € sign")
    public void €_sign() {
        int count = Hooks.driver.findElements(By.xpath("//option[@value=\"https://demo.nopcommerce.com/changecurrency/6?returnUrl=%2F\"]")).size();
        for (int x = 0; x < count; x++){
            String text = homepage.ProductPrices().getText();
            Assert.assertTrue(text.contains("€"));
        }
    }
}
