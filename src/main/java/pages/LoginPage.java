package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{

    ChromeDriver driver;



    //webelementi

    @FindBy (id = "user-name")
    WebElement userNameField;

    @FindBy (id = "password")
    WebElement passwordField;

    @FindBy (id = "login-button")
    WebElement loginButton;

    @FindBy (xpath = "//h3[@data-test = 'error']")
     WebElement errorMessageText;


    public  LoginPage(ChromeDriver driver) {
        BasePage.print("Open LOGIN PAGE");
        driver.get("https://www.saucedemo.com/");
        //page factory instancira sve objekte web elemenate definisanih u toj page klasi
        PageFactory.initElements(driver, this);
    }
    public  void enterUsername(String userName) {
        BasePage.print("enterUsername");
        assert isElementPresent(userNameField) : "User name field is NOT present";
        userNameField.click();
        userNameField.sendKeys(userName);
    }

    public void enterPassword(String pass) {
        BasePage.print("enterPassword");
        passwordField.click();
        passwordField.sendKeys(pass);
    }

    public void clickEnter() {
        passwordField.sendKeys(Keys.ENTER);
    }

    public void clickLoginButton(){
        BasePage.print("clickLoginButton");
        loginButton.click();
    }

    public boolean isLoginButtonPresent() {
        try {
            return loginButton.isDisplayed();
        } catch (Exception e) {
//            System.out.println(e.getMessage());
            return false;
        }
    }


    public String getTextFromErrorMessage() {
        return errorMessageText.getText();
    }





}
