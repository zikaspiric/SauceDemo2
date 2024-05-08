package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends BasePage{

    //Svi Web elementi ove stranice

    @FindBy(id = "continue")
    WebElement continueButton;
    @FindBy(id = "first-name")
    WebElement firstNameInput;
    @FindBy(id = "last-name")
    WebElement lastNameInput;
    @FindBy(id = "postal-code")
    WebElement zipCodeInput;
    @FindBy(xpath = "//h3[@data-test = 'error']")
    WebElement errorMessageLastnameCheckout;

    //Konstruktori

    public CheckoutPage(ChromeDriver driver){
        super(driver);
        print(Strings.CHECKOUT_PAGE_URL);
    }

    //metode

    public void clickContinueButton() {
        print("clickContinueButton");
        continueButton.click();
    }
    public void inputFirstName(String firstName) {
        assert isElementPresent(firstNameInput): "Error first name is NOT present";
        print("inputFirstName");
        firstNameInput.click();
        firstNameInput.sendKeys(firstName);
    }
    public void inputLastName(String lastName) {
        assert isElementPresent(lastNameInput): "Error last name is NOT present";
        print("lastFirstName");
        lastNameInput.click();
        lastNameInput.sendKeys(lastName);
    }
    public void inputZipCode(String zipCode) {
        assert isElementPresent(zipCodeInput): "Error zipCode is NOT present";
        print("zipCode");
        zipCodeInput.click();
        zipCodeInput.sendKeys(zipCode);
    }
    public String getTextFromErrorMessage() {
        return errorMessageLastnameCheckout.getText();
    }
}
