package StepDefinition;

import Pages.HomePage;
import Pages.WishlistPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class D08_WishList {
    HomePage homePage;
    WishlistPage wishpage;
    int num;

    @Given("user add item to wishlist")
    public void user_add_item_to_wishlist() {
        homePage = new HomePage(Hooks.driver);
        wishpage = new WishlistPage(Hooks.driver);
        homePage.AddWishList().get(2).click();
    }

    @Then("wishlist notification success is visible")
    public void success_notification() {
        SoftAssert soft = new SoftAssert();
        soft.assertTrue(homePage.WishSuccessMsg().isDisplayed(), "Success Message");

        String actual = homePage.WishSuccessMsg().getCssValue("background-color");
        String expected = "rgba(75, 176, 122, 1)";
        soft.assertEquals(actual, expected, "Message color");
    }

    @And("user get the number of wishlist items after adding item")
    public void items_increased() {
        String text = homePage.WishList().getText();
        text = text.replaceAll("[^0-9]", "");
        num = Integer.parseInt(text);
    }

    @Then("the number of wishlist increased")
    public void number_of_items_of_wishlist() throws InterruptedException {
        Assert.assertTrue(num > 0, "count of wishlist items");
    }

    @And("user go to wishlist page")
    public void user_go_to_wishlist() throws InterruptedException {
        homePage.CloseB().click();
        Thread.sleep(500);
        homePage.WishList().click();
    }

    @Then("the number of items greater than zero in wishlist page")
    public void wishlist_Page_Assertion() {
        // First Assertion
        SoftAssert soft = new SoftAssert();
        soft.assertTrue(Hooks.driver.getCurrentUrl().contains("https://demo.nopcommerce.com/wishlist"), "wishlist URL");
        // Second Assertion
        int size = wishpage.WishListItems();
        soft.assertTrue(size > 0,"wishlist items");
        // Assert All
        soft.assertAll();
    }
}
