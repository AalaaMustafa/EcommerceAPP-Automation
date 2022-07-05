package StepDefinition;
import Pages.HomePage;
import Pages.RegisterationPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

public class D01_Register {
    RegisterationPage registerationPage;
    HomePage homePage;

    @Given("user navigate to register page")
    public void user_navigate_to_register_page() {
        registerationPage = new RegisterationPage(Hooks.driver);
        homePage = new HomePage(Hooks.driver);
        homePage.NavigateToRegisterPage().click();
    }

    @And("user choose male or female")
    public void user_choose_Gender_Option (){
        registerationPage.FemaleRadioButton().click();
}

    @And("user enter valid data")
    public void user_enter_first_name(){
        registerationPage.FristNameTxT().sendKeys("Aalaa");

        registerationPage.LastNameTxT().sendKeys("Osama");

        Select select = new Select(registerationPage.DAY());
        select.selectByIndex(30);

        select = new Select(registerationPage.MonTh());
        select.selectByVisibleText("August");

        select = new Select(registerationPage.Year());
        select.selectByValue("1994");


        registerationPage.EmailTXt().sendKeys("oshenoshaa9@gmail.com");

        registerationPage.CompanyTxT().sendKeys("ITworx");

        registerationPage.PasswordTxT().sendKeys("Password123");
        registerationPage.ConfirmPasswordxT().sendKeys("Password123");
    }

    @Then("user press on register button")
    public void user_register_successfully(){
        registerationPage.RegisterBtn().click();
    }

    @And("user could register successfully")
    public void register_successfully() {
        // 1st Assertion
        SoftAssert soft = new SoftAssert();
        soft.assertTrue(registerationPage.SuccessfulMsg().isDisplayed(), "Success Message");
        // 2nd Assertion
        String actual = registerationPage.SuccessfulMsg().getCssValue("color");
        String expected = "rgba(76, 177, 124, 1)";
        soft.assertEquals(actual, expected, "color is correct");
        // Assert All
        soft.assertAll();
    }
}
