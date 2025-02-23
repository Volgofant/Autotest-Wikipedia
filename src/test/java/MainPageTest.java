import org.hamcrest.Condition;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import sun.rmi.runtime.Log;

import java.util.concurrent.TimeUnit;

public class MainPageTest{

    private WebDriver driver;
    private MainPage mainPage;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\vnenashev\\IdeaProjects\\testselenium\\drivers\\chromedriver.exe");
        driver = new ChromeDriver ();
        driver.manage ().timeouts ().implicitlyWait (5, TimeUnit.SECONDS);
        driver.manage ().window ().maximize ();
        driver.get("https://ru.wikipedia.org/wiki/%D0%97%D0%B0%D0%B3%D0%BB%D0%B0%D0%B2%D0%BD%D0%B0%D1%8F_%D1%81%D1%82%D1%80%D0%B0%D0%BD%D0%B8%D1%86%D0%B0");
        mainPage = new MainPage (driver);
    }

    @Test
    public void logIn() {
        String heading = null;
        for (int i = 0; i < 5; i++) {
            CreateAccountPage createAccountPage = mainPage.clickCreateAccount ();
            heading = createAccountPage.getHeadingText ();

        }
        Assert.assertEquals ("Создать учётную запись", heading);
    }

    @Test
    public void logInPaste() {
        CreateAccountPage createAccountPage = mainPage.clickCreateAccount ();
        String heading = createAccountPage.getHeadingText ();
        createAccountPage.insertLogin ("login");
        String errorMessage = createAccountPage.getErrorMessageText ();
        Assert.assertEquals ("Введённое имя участника уже используется. Пожалуйста, выберите другое имя.", errorMessage);

    }
    @Test
    public void passwordPaste() {
        CreateAccountPage createAccountPage = mainPage.clickCreateAccount ();
        createAccountPage.insertLogin ("loginlolol");
        String password = createAccountPage.getPasswordText ();
        createAccountPage.insertPassword ("password");
        String errorMessagePass = createAccountPage.getPasswordErrorMessageText ();
        Assert.assertEquals ("Часто выбираемые пароли не могут быть использованы. Пожалуйста, выберите пароль, который сложнее угадать.", errorMessagePass);
    }
    @Test
    public void capchaPaste() {
        CreateAccountPage createAccountPage = mainPage.clickCreateAccount ();
        createAccountPage.insertLogin ("loginlol");
        createAccountPage.insertPassword ("Password123");
        createAccountPage.insertPassword2 ("Password123");
        createAccountPage.insertMail ("bond@mail.ru");
        createAccountPage.insertKapcha ("ssssssssssssssssssssss");
        createAccountPage.clickButton ();
        String errorMessageKaptcha = createAccountPage.getErrorKaptchaText ();
        Assert.assertEquals ("Контрольная комбинация неверна или не введена.", errorMessageKaptcha);
    }
    @Test
    public void createAccountOnNewArticle() {
        mainPage.clickCreateNewArticle ();
        CreateNewArticlePage createNewArticlePage = new CreateNewArticlePage (driver);
        String header = createNewArticlePage.getHeadingText ();
        Assert.assertEquals ("Википедия:Мастер статей", header);
    }
    @Test
    public void inCreateArticleGoToCreateAcc() {
        mainPage.clickCreateNewArticle ();
        CreateNewArticlePage createNewArticlePage = new CreateNewArticlePage (driver);
        createNewArticlePage.clickLoginAnyway ();
        CreateAccountPage createAccountPage = mainPage.clickCreateAccount ();
        String header = createAccountPage.getHeadingText ();
        Assert.assertEquals ("Создать учётную запись", header);

    }
    @Test
    public void checkLoginPage() {
        mainPage.clickLogin ();
        LoginPage loginPage = new LoginPage (driver);
        String heading = loginPage.getHeadingText ();
        Assert.assertEquals ("Войти", heading);
    }
    @Test
    public void loginPageIn() {
        mainPage.clickLogin ();
        LoginPage loginPage = new LoginPage (driver);
        loginPage.insertLogin ("login");
        loginPage.insertPassword ("password");
        loginPage.checkedChecbox ();
        loginPage.clickButton ();
        String errors = loginPage.getErrorMessage ();
        Assert.assertEquals ("Введены неверные имя участника или пароль. Попробуйте ещё раз.", errors);

    }

    @After
    public void tierDown() {
        driver.quit ();
    }
}
