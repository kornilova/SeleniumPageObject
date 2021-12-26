import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class MainClass {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Users/nataliagordeeva/Documents/chromedriver");
        WebDriver driver =  new ChromeDriver();
        driver.get("https://github.com/");

        MainPage mainPage = PageFactory.initElements(driver, MainPage.class);

       // mainPage.login("qweqew@cxcv.com", "qweqwe2SDD33");
        mainPage.register("userName13451","qweqew1@cxcv1.com", "qweqwe2SDD331", "N");

        driver.quit();
    }
}
