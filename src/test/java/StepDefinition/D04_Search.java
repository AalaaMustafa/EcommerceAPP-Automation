package StepDefinition;

import Pages.HomePage;
import Pages.SearchPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.testng.asserts.SoftAssert;

public class D04_Search {
    HomePage homePage;
    SearchPage searchpage;

    @Given("user click on search bar")
    public void user_click_on_searchbar() {
        homePage = new HomePage(Hooks.driver);
        searchpage = new SearchPage(Hooks.driver);
        homePage.SearchBar().click();
    }

    @When("user search for product like \"(.*)\"$")
    public void user_search_for_product(String search) {
        homePage.SearchBar().sendKeys(search);
    }

    @And("user click on search Button")
    public void user_click_on_searchButton() {
        homePage.SearchBtn().click();
    }

    @Then("user could search successfully and go to search page")
    public void search_successfully() {
        // First Assertion
        SoftAssert soft = new SoftAssert();
        soft.assertTrue(Hooks.driver.getCurrentUrl().contains("https://demo.nopcommerce.com/search?q=Nokia"), "search URL");
        // Second Assertion
        int size = searchpage.productsList();
        soft.assertTrue(size > 0,"Search Result");
        // Assert All
        soft.assertAll();
    }

    @Then("user could search successfully with SKU")
    public void search_with_sku_successfully() {
        // First Assertion
        SoftAssert soft = new SoftAssert();
        soft.assertTrue(Hooks.driver.getCurrentUrl().contains("https://demo.nopcommerce.com/search?q=AP_MBP_13"), "URL after search");
        // Second Assertion
        int size = searchpage.productsList();
        soft.assertTrue(size > 0,"Search Result");
        // Assert All
        soft.assertAll();
    }

    @Then("user could not search")
    public void no_products_found() {
        SoftAssert soft = new SoftAssert();
        soft.assertTrue(searchpage.NoProducts().isDisplayed(), "No products");
    }
}
