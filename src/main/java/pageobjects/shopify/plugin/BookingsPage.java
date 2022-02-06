package pageobjects.shopify.plugin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BookingsPage  {
    final WebDriver driver;
    public BookingsPage(WebDriver driver){
        this.driver = driver;
    }

    @FindBy(xpath = "//*[@id='q']")
    public WebElement navSearchForm;
}
