package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestPages {
    WebDriver driver;

    public By inputUser;
    public By inputPassword;
    public By buttonLogin;
    public By tittleProducts;
    public By listProducts;
    public By buttonAddCart;
    public By buttonShopping;
    public By tittleDescription;
    public By buttonCheckout;
    public By listInputInformation;
    public By buttonContinue;
    public By itemPrice;
    public By itemTotal;
    public By buttonFinish;
    public By textOrderComplete;

    public TestPages(WebDriver driver) {
        this.driver = driver;

        inputUser = By.id("user-name");
        inputPassword = By.name("password");
        buttonLogin = By.id("login-button");
        tittleProducts = By.xpath("//span[contains(.,'Products')]");
        listProducts = By.className("inventory_item_name");
        buttonAddCart = By.xpath("//button[contains(@id,'add-to-cart')]");
        buttonShopping = By.className("shopping_cart_badge");
        tittleDescription = By.className("inventory_item_name");
        buttonCheckout = By.id("checkout");
        listInputInformation = By.xpath("//input[contains(@class,'form_input')]");
        buttonContinue = By.id("continue");
        itemPrice = By.className("inventory_item_price");
        itemTotal = By.className("summary_total_label");
        buttonFinish = By.id("finish");
        textOrderComplete = By.className("complete-header");
    }
}
