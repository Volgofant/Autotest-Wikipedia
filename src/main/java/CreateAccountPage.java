import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.awt.dnd.DragGestureEvent;

public class CreateAccountPage{
    WebDriver driver;

    public CreateAccountPage(WebDriver driver) {
        this.driver = driver;
    }

        By login = By.xpath ("//input[@id=\"wpName2\"]");
        By password = By.xpath ("//input[@id=\"wpPassword2\"]");
        By password2 = By.xpath ("//input[@id=\"wpRetype\"]");
        By mail = By.xpath ("//input[@id=\"wpEmail\"]");
        By kapcha = By.xpath ("//input[@id=\"mw-input-captchaWord\"]");
        By button = By.xpath ("//button[@id=\"wpCreateaccount\"]");
        By header = By.xpath ("//h1[@id=\"firstHeading\"]");
        By errorMessage = By.xpath ("//span[text()='Введённое имя участника уже используется.\n" +
                "Пожалуйста, выберите другое имя.']");
        By passwordErrorMessage = By.xpath ("//span[text()='Часто выбираемые пароли не могут быть использованы. Пожалуйста, выберите пароль, который сложнее угадать.']");
        By errorKaptchaMessage = By.xpath ("//div[@class=\"error\"]/p[1]");


    public CreateAccountPage insertLogin (String newLogin) {
        driver.findElement (login).sendKeys (newLogin);
        return this;
    }
    public CreateAccountPage insertPassword (String newPassword) {
        driver.findElement (password).sendKeys (newPassword);
        return this;
    }
    public CreateAccountPage insertPassword2 (String newPassword) {
        driver.findElement (password2).sendKeys (newPassword);
        return this;
    }
    public CreateAccountPage insertMail (String newMail) {
        driver.findElement (mail).sendKeys (newMail);
        return this;
    }
    public CreateAccountPage insertKapcha (String newKapcha) {
        driver.findElement (kapcha).sendKeys (newKapcha);
        return this;
    }
    public CreateAccountPage clickButton() {
        driver.findElement (button).click ();
        return new CreateAccountPage (driver);
    }
    public String getHeadingText() {
        return driver.findElement (header).getText ();

    }
    public String getErrorKaptchaText() {
        return driver.findElement (errorKaptchaMessage).getText ();
    }
    public String getLoginText() {
        return driver.findElement (login).getText ();
    }
    public String getPasswordText() {
        return driver.findElement (password).getText ();
    }
    public String getErrorMessageText() {
        return driver.findElement (errorMessage).getText ();
    }
    public String getPasswordErrorMessageText() {
        return driver.findElement (passwordErrorMessage).getText ();
    }

}
