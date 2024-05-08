package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YourCartPage extends BasePage{

//Svi Web elementi ove stranice

    @FindBy(id = "checkout")
    WebElement checkoutButton;


    //konstruktori

    public YourCartPage(ChromeDriver driver) {
        super(driver);
        print(Strings.YOUR_CART_PAGE);
        this.driver = driver;
        PageFactory.initElements(driver,this);

    }

    //metode
    public  void clickCheckoutButton(){
        print("clickCheckoutButton");
        checkoutButton.click();

    }
}
