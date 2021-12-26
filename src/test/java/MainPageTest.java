import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class MainPageTest {
    private WebDriver driver;
    private MainPage mainPage;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "/Users/nataliagordeeva/Documents/chromedriver");
        driver =  new ChromeDriver();
        driver.get("https://github.com/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        mainPage = PageFactory.initElements(driver, MainPage.class);
    }

    @Test
    public void signInTest(){
        LoginPage loginPage = mainPage.clickSignIn();
        String heading = loginPage.getHeadingText();
        Assert.assertEquals("Sign in to GitHub", heading);
    }

    @Test
    public void registerCaptureOffTest(){
        SignUpPage signUpPage = mainPage.register("testuser", "testemail", "testpass", "N");
        Assert.assertTrue("Capture Error is exists", signUpPage.isVisibleCaptureError());
    }


    @After
    public void exit(){
        driver.quit();
    }
}
