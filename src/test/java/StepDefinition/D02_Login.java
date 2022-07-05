package StepDefinition;

import Pages.HomePage;
import Pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.asserts.SoftAssert;

public class D02_Login {
    LoginPage loginpage;
    HomePage homepage;

    @When("user navigate to login page")
    public void user_navigate_to_login_page() {
        homepage = new HomePage(Hooks.driver);
        loginpage = new LoginPage(Hooks.driver);
        homepage.NavigateToRegisterPage().click();
    }

    @And("user enter \"(.*)\" and \"(.*)\"$")
    public void vaild_data(String email, String password) throws InterruptedException {
        loginpage.LoginSteps(email, password);
        Thread.sleep(1000);
    }

    @Then("user click on login button")
    public void click_Login() {
        loginpage.PasswordTxT().sendKeys(Keys.ENTER);
    }

    @And("user could login successfully and go to home page")
    public void login_successfully() {
        // First Assertion
        SoftAssert soft = new SoftAssert();
        soft.assertEquals(Hooks.driver.getCurrentUrl(),"https://demo.nopcommerce.com/","URL login");
        // Second Assertion
        Hooks.driver.findElement(By.cssSelector("a[class=\"ico-account\"]")).isDisplayed();
        soft.assertTrue(loginpage.MyAccount().isDisplayed(), "My Account");
        // Assert All
        soft.assertAll();
    }

    @And("user could not login successfully and go to home page")
    public void cannot_login_successfully() {
        // First Assertion
        SoftAssert soft = new SoftAssert();
        loginpage.WrongMsg().isDisplayed();
        String actual = loginpage.WrongMsg().getText();
        soft.assertEquals(actual,"Login was unsuccessful. Please correct the errors and try again.\n" +
                "The credentials provided are incorrect","Wrong Message");
        // Second Assertion
        actual = loginpage.WrongMsg().getCssValue("color");
        String expected = "rgba(228, 67, 75, 1)";
        soft.assertEquals(actual, expected, "color");
        // Assert All
        soft.assertAll();
    }
}
