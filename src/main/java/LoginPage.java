import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//input[@id='login_field']")
    private WebElement loginField;
    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordField;
    @FindBy(xpath = "//input[@type='submit' and @name='commit']")
    private WebElement signInButton;
    @FindBy(xpath = "//div[contains(@class, 'auth-form-header')]/h1")
    private WebElement heading;
    @FindBy(xpath = ".//*[@id='js-flash-container']//div[@class='container-lg px-2']")
    private WebElement error;
    @FindBy(xpath = "//a[text()='Create an account']")
    private WebElement createAccLink;

    public LoginPage typeUsername(String username){
        loginField.sendKeys(username);
        return this;
    }

    public LoginPage typePassword(String password){
        passwordField.sendKeys(password);
        return this;
    }

    public LoginPage loginWithInvalidCreds(String username, String password){
        this.typeUsername(username);
        this.typePassword(password);
        signInButton.click();
        return new LoginPage(driver);
    }

    public String getHeadingText(){
        return heading.getText();
    }

    public String getErrorText(){
        return error.getText();
    }

    public SignUpPage createAccount(){
        createAccLink.click();
        return new SignUpPage(driver);
    }
}
