package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

public class OverviewPage extends BasePage{

    //Svi Web elementi ove stranice
    @FindBy(id = "finish")
    WebElement finishButton;

    //konstruktori

    public OverviewPage(ChromeDriver driver) {
        super(driver);
        print(Strings.OVERVIEW_PAGE);
    }
    //metode

    public void clickfinishButton() {
        print("clickFinishButton");
        waitForElement(finishButton);
        finishButton.click();
    }
}
