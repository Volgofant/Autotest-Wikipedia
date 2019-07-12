import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class MainClass{
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\vnenashev\\IdeaProjects\\testselenium\\drivers\\chromedriver.exe");

        WebDriver driver = new ChromeDriver ();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://www.protesting.ru/testing/testdesign_technics.html");

    }
}
