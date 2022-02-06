package pageobjects.shopify.plugin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FindPage {
    final WebDriver driver;
    public FindPage(WebDriver driver){
        this.driver = driver;
    }

    @FindBy(xpath = "//h2[contains(text(),'Weather in your city')]")
    public WebElement headlineInFindPage;

    @FindBy(css = "[id$='search_str']")
    public WebElement searchBoxInForm;

    @FindBy(css = "form[id$='searchform'] > button[type$='submit']")
    public WebElement searchButtonInForm;

    @FindBy(xpath = "//*[@id='forecast_list_ul']//a")
    public WebElement forecastList;
}