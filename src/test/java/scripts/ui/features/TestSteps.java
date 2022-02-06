package scripts.ui.features;

import data.ShopifyData;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.junit.Assert;
import pageobjects.shopify.plugin.LoginPage;
import pageobjects.shopify.plugin.OrdersPage;
import scripts.ui.BaseTest;
import java.util.concurrent.TimeUnit;
import static utils.HandleElements.WaitAndSendKey;

public class TestSteps extends BaseTest {
    @Before
    public void setUpClass(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver_mac");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ShopifyData.URL);
        driver.manage().window().maximize();
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        ordersPage = PageFactory.initElements(driver, OrdersPage.class);
    }

    @After
    public void tearDownClass() {
        driver.quit();
    }

    private String emailOrPhone;
    public String getEmailOrPhone() {
        return emailOrPhone;
    }

    public void setEmailOrPhone(String newEmailOrPhone) {
        this.emailOrPhone = newEmailOrPhone;
    }

    private String password;
    public String getPassword() {
        return emailOrPhone;
    }

    public void setPassword(String newPassword) {
        this.password = newPassword;
    }

    @Given("^user is on Login page")
    public void user_is_on_loginpage(){

        Assert.assertEquals("Login page Title is matching", ShopifyData.LOGIN_PAGE_TITLE, driver.getTitle());
        Assert.assertEquals("Welcome text is matching", ShopifyData.LOGIN_PAGE_WELCOME_TEXT, loginPage.welcomeText.getText().substring(0,10) + loginPage.welcomeText.getText().substring(11,32));
        Assert.assertEquals("Label Email or Phone is matching", "Email or Phone", loginPage.labelEmailOrPhone.getText());
        Assert.assertEquals("Label Password is matching", "Password", loginPage.labelPassword.getText());
        Assert.assertEquals("Label button Login is matching", "Login", loginPage.btnLogin.getText());
    }

    @When("^user enters valid \"Email or Phone\" such as \"(.*)\"$")
    public void user_enters_valid_emailorphone(String emailOrPhone){
        WaitAndSendKey(driver, loginPage.textboxEmailOrPhone, emailOrPhone);
        setEmailOrPhone(emailOrPhone);
    }

    @And("^user enters valid \"Password\" such as \"(.*)\"$")
    public void user_enters_valid_password(String password){
        WaitAndSendKey(driver, loginPage.textboxPassword, password);
        setEmailOrPhone(password);
    }

    @And("^user selects Login button$")
    public void user_selects_login_button(){
        Actions actions = new Actions(driver);
        actions.moveToElement(loginPage.btnLogin).click();
    }

    @Then("^user logs in successfully$")
    public void user_logs_in_successfully(){
        Assert.assertEquals("Page Title is matching", ShopifyData.ORDERS_PAGE_TITLE, driver.getTitle());
    }

    @And("^user navigates to Orders page$")
    public void user_navigates_to_orders_page() {
        Assert.assertEquals("Page Title is matching", ShopifyData.ORDERS_PAGE_TITLE, driver.getTitle());
    }
}
