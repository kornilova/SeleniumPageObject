import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage {

    private WebDriver driver;

    public MainPage(WebDriver driver)
    {
            this.driver = driver;
    }

    @FindBy(xpath = "//a[contains(text(),'Sign in')]")
    private WebElement signInButton;

    @FindBy(xpath = "//a[contains(text(),'Sign up')]")
    private WebElement signUpButton;

    public LoginPage clickSignIn(){
        signInButton.click();
        return new LoginPage(driver);
    }

    public SignUpPage clickSignUp(){
        signUpButton.click();
        return new SignUpPage(driver);
    }


    public LoginPage login(String email, String password){
        this.clickSignIn();
        return (new LoginPage(driver)).loginWithInvalidCreds(email, password);
    }

    public SignUpPage register(String username, String email, String password, String optionNo){
        this.clickSignUp();
        return (new SignUpPage(driver)).registerWithInvalidCreds(username, email, password, optionNo);
    }
}
