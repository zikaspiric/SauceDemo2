package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CompletePage extends BasePage{

    //Svi Web elementi o0ve stranice
    @FindBy(id = "back-to-products")
    WebElement backHome;
    //konstruktori

    public CompletePage(ChromeDriver driver) {
        super(driver);
        print(Strings.COMPLETE_PAGE);
    }
    //metode

    public void clickBackHomeButton() {
        print("clickBackHomeButton");
        backHome.click();
    }

}
