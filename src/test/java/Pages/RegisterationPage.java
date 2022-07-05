package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;



public class RegisterationPage {

    WebDriver driver;

    public RegisterationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement RegisterLink() {
        return driver.findElement(By.cssSelector("a[class=\"ico-register\"]"));
    }

    public WebElement FemaleRadioButton() {
        return driver.findElement(By.id("gender-female"));
    }

    public WebElement FristNameTxT() {
        return driver.findElement(By.id("FirstName"));
    }

    public WebElement LastNameTxT() {
        return driver.findElement(By.id("LastName"));
    }

    public WebElement DAY() {
        return driver.findElement(By.name("DateOfBirthDay"));
    }

    public WebElement MonTh() {
        return driver.findElement(By.name("DateOfBirthMonth"));
    }

    public WebElement Year() {
        return driver.findElement(By.name("DateOfBirthYear"));
    }

    public WebElement EmailTXt() {
        return driver.findElement(By.id("Email"));
    }

    public WebElement CompanyTxT() {
        return driver.findElement(By.id("Company"));
    }

    public WebElement PasswordTxT() {
        return driver.findElement(By.id("Password"));
    }

    public WebElement ConfirmPasswordxT() {
        return driver.findElement(By.id("ConfirmPassword"));
    }

    public WebElement RegisterBtn() {
        return driver.findElement(By.id("register-button"));
    }

    public WebElement SuccessfulMsg() {
        return driver.findElement(By.xpath("//div[@class=\"result\"]"));
    }

}



