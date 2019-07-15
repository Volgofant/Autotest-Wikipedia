import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreateNewArticlePage{

    WebDriver driver;

    public CreateNewArticlePage(WebDriver driver) {
        this.driver = driver;
    }

    By header = By.xpath ("//h1[@id=\"firstHeading\"]");
    By loginAnyway = By.xpath ("//span[@class=\"mw-ui-button\"]");



    public String getHeadingText() {
        return driver.findElement (header).getText ();
    }

    public CreateAccountPage clickLoginAnyway() {
        driver.findElement (loginAnyway).click ();
        return new CreateAccountPage (driver);
    }
}
