import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class MainPage{
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    By login = By.xpath ("//a[text()='Войти']");
    By createAccaunt = By.xpath ("//a[text()='Создать учётную запись']");
    By myContribution = By.xpath ("//li[@id=\"pt-anontalk\"]/a[text()='Вклад']");
    By createNewArticle = By.xpath ("//span[text()='Создать статью']");
    By logo = By.xpath ("//div[@id=\"p-logo\"]");
    By inputSearch = By.xpath ("//div[@id=\"simpleSearch\"]/input[@type=\"search\"]");

    public LoginPage clickLogin() {
        driver.findElement (login).click ();
        return new LoginPage (driver);
    }
    public CreateAccountPage clickCreateAccount() {
        driver.findElement (createAccaunt).click ();
        return new CreateAccountPage (driver);
    }
    public MyContributionPage clickMyContribution() {
        driver.findElement (myContribution).click ();
        return new MyContributionPage (driver);
    }
    public CreateNewArticlePage clickCreateNewArticle() {
        driver.findElement (createNewArticle).click ();
        return new CreateNewArticlePage (driver);
    }
    public SearchPage pasteSearch(String search) {
        driver.findElement (inputSearch).sendKeys (search);
        driver.findElement (inputSearch).sendKeys (Keys.ENTER);
        return new SearchPage (driver);
    }
}
