package StepDefinition;

import Pages.CategoryPage;
import Pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class D05_HoverCategories {
    HomePage homepage;
    CategoryPage categorypage;
    String subCategoryName;

    @When("user hover category and select subcategory")
    public void user_hover_category() throws InterruptedException {
        homepage = new HomePage(Hooks.driver);
        categorypage = new CategoryPage(Hooks.driver);
        Actions action = new Actions(Hooks.driver);
        action.moveToElement(homepage.Computers()).perform();
        action.moveToElement(homepage.Computers()).perform();

        subCategoryName = homepage.Desktops().getText().toLowerCase();

        Thread.sleep(1000);
    }

    @And("user click on subcategory")
    public void user_clicks_subcategory(){
        homepage.Desktops().click();
    }

    @Then("user go to relative product page")
    public void relative_subcategory(){
        Assert.assertEquals(categorypage.categoryList().getText().toLowerCase(),subCategoryName,"subcategory");
    }
}
