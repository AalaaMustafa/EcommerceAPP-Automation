package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
        WebDriver driver;

        public LoginPage(WebDriver driver) {
            this.driver = driver;
            PageFactory.initElements(driver,this);
        }

        public WebElement EmailTXt()
        {
            return driver.findElement(By.id("Email"));
        }

        public WebElement PasswordTxT()
        {
            return driver.findElement(By.id("Password"));
        }

        public void LoginSteps(String email ,String password)
        {
            EmailTXt().clear();
            PasswordTxT().clear();

            EmailTXt().sendKeys( email );
            PasswordTxT().sendKeys( password );
        }

        public WebElement MyAccount() {
            return driver.findElement(By.cssSelector("a[class=\"ico-account\"]"));
        }

        public WebElement WrongMsg() {
            return driver.findElement(By.cssSelector("div[class=\"message-error validation-summary-errors\"]"));
        }

    }


