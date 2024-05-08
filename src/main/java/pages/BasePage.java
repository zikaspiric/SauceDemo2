package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    ChromeDriver driver;



    @FindBy (id = "react-burger-menu-btn")
    WebElement hamburgerMenu;

    @FindBy (xpath = "//a[@class = 'shopping_cart_link']")
    WebElement shoppingCartIcon;

    @FindBy (id = "logout_sidebar_link")
    WebElement logoutButton;

    @FindBy(xpath = "//li[@class = 'social_twitter']/a")
    WebElement twitterButton;

    public BasePage() {}

    public BasePage(ChromeDriver driver) {
        //ovde setujete da drajver iz testa bude i u klasi
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void clickHamburgerMenu() {
        hamburgerMenu.click();
//        waitForElement(logoutButton);
    }

    public void clickShoppingCartIcon() {
        waitForElement(shoppingCartIcon);
        shoppingCartIcon.click();
    }

    public static void print(String s) {
        System.out.println(s);
    }
    public void clickLogout() {
        waitForElement(logoutButton);
        logoutButton.click();
    }

    public void clickTwitterButton() {
        scrollIntoView(twitterButton);
        twitterButton.click();
    }

    //Ovo cemo koristiti za elemente stranice gde treba da se skroluje do njih
    public void scrollIntoView(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)" ,element);
    }

    //explictni wait, koji ceka odredjen weblement sa odredjenim uslovom
    public void waitForElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public boolean isElementPresent(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (Exception e) {
//            System.out.println(e.getMessage());
            return false;
        }
    }

}
