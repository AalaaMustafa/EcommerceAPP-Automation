package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
public class SearchPage {
    WebDriver driver;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public int productsList(){
        return driver.findElements(By.cssSelector("h2[class=\"product-title\"]")).size();
    }

    public WebElement NoProducts(){
        return driver.findElement(By.cssSelector("div[class=\"no-result\"]"));
    }
}
