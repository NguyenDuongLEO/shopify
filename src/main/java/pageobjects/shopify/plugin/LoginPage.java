package pageobjects.shopify.plugin;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

    @FindBy(xpath = "//*[@class='welcome-text']")
    public WebElement welcomeText;

    @FindBy(xpath = "//*[@for='basic_username']//span[contains(text(),'Email or Phone')]")
    public WebElement labelEmailOrPhone;
    @FindBy(xpath = "//*[@id='basic_username']")
    public WebElement textboxEmailOrPhone;
    @FindBy(xpath = "//*[@for='basic_password']//div[contains(text(),'Password')]")
    public WebElement labelPassword;
    @FindBy(xpath = "//*[@id='basic_password']")
    public WebElement textboxPassword;

    @FindBy(xpath = "//button[@type='submit']/span")
    public WebElement btnLogin;
}
