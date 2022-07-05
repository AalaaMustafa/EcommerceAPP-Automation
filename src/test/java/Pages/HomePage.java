package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public WebElement NavigateToLoginPage() {
        return driver.findElement(By.cssSelector("a[class=\"ico-login\"]"));
    }

    public WebElement NavigateToRegisterPage() {
        return driver.findElement(By.cssSelector("a[class=\"ico-register\"]"));
    }

    public WebElement Currency() {
        return driver.findElement(By.id("customerCurrency"));
    }

    public WebElement CurrencyEuro() {
        return driver.findElement(By.xpath("//option[@value=\"https://demo.nopcommerce.com/changecurrency/6?returnUrl=%2F\"]"));
    }

    public WebElement ProductPrices() {
        return driver.findElement(By.cssSelector("span[class=\"price actual-price\"]"));
    }

    public WebElement CurrencyDollar() {
        return driver.findElement(By.xpath("//option[@value=\"https://demo.nopcommerce.com/changecurrency/1?returnUrl=%2F\"]"));
    }

    public WebElement SearchBar(){
        return driver.findElement(By.id("small-searchterms"));
    }

    public WebElement SearchBtn(){
        return driver.findElement(By.cssSelector("button[class=\"button-1 search-box-button\"]"));
    }

    public WebElement Slider(String sliderNum){
        return driver.findElement(By.xpath("(//a[@href=\"http://demo.nopcommerce.com/\"])["+sliderNum+"]"));
    }

    public WebElement FacebookIcon() {
        return driver.findElement(By.xpath("//a[@href=\"http://www.facebook.com/nopCommerce\"]"));
    }

    public WebElement TwitterIcon() {
        return driver.findElement(By.xpath("//a[@href=\"https://twitter.com/nopCommerce\"]"));
    }

    public WebElement rss() {
        return driver.findElement(By.xpath("//a[@href=\"/news/rss/1\"]"));
    }

    public WebElement YoutubeIcon() {
        return driver.findElement(By.xpath("//a[@href=\"http://www.youtube.com/user/nopCommerce\"]"));
    }

    public WebElement WishList() {
        return driver.findElement(By.cssSelector("div[class=\"header-links\"] [href=\"/wishlist\"]"));
    }

    public List<WebElement> AddWishList() {
        return driver.findElements(By.cssSelector("button[class=\"button-2 add-to-wishlist-button\"]"));
    }

    public WebElement WishSuccessMsg() {
        return driver.findElement(By.cssSelector("div[class=\"bar-notification success\"]"));
    }

    public WebElement CloseB() {
        return driver.findElement(By.cssSelector("span[class=\"close\"]"));
    }

    public WebElement Computers(){
        return driver.findElement(By.cssSelector("ul[class=\"top-menu notmobile\"] [href=\"/computers\"]"));
    }

    public WebElement Desktops(){
        return driver.findElement(By.cssSelector("ul[class=\"top-menu notmobile\"] [href=\"/desktops\"]"));
    }
}
