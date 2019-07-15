import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage{
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    By header = By.xpath ("//h1[@id=\"firstHeading\"]");
    By login = By.xpath ("//input[@id=\"wpName1\"]");
    By password = By.xpath ("//input[@id=\"wpPassword1\"]");
    By checbox = By.xpath ("//input[@name=\"wpRemember\"]");
    By button = By.xpath ("//button[@id=\"wpLoginAttempt\"]");
    By errorMessage = By.xpath ("//div[@class=\"error\"]/p");


    public String getHeadingText() {
        return driver.findElement (header).getText ();
    }
    public LoginPage insertLogin(String oldLogin ) {
        driver.findElement (login).sendKeys (oldLogin);
        return this;
    }
    public LoginPage insertPassword (String oldPassword) {
        driver.findElement (password).sendKeys (oldPassword);
        return this;
    }
    public LoginPage checkedChecbox () {
        driver.findElement (checbox).click ();
        return this;
    }
    public LoginPage clickButton() {
        driver.findElement (button).click ();
        return this;
    }
    public String getErrorMessage() {
        return driver.findElement (errorMessage).getText ();

    }

}
