import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class SignUpPage {

    private WebDriver driver;

    public SignUpPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @FindBy(xpath = "//div/h1[@class='sr-only']")
    private WebElement heading;

    @FindBy(xpath = "//input[@id='email']")
    private WebElement emailField;

    @FindBy(xpath = "//button[contains(text(),'Continue') and @type='button' and @data-continue-to='password-container']")
    private WebElement buttonToPassword;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//button[contains(text(),'Continue') and @type='button' and @data-continue-to='username-container']")
    private WebElement buttonToUserName;

    @FindBy(xpath = "//input[@id='login']")
    private WebElement loginField;

    @FindBy(xpath = "//button[contains(text(),'Continue') and @type='button' and @data-continue-to='opt-in-container']")
    private WebElement buttonToOption;

    @FindBy(xpath = "//input[@id='opt_in']")
    private WebElement optField;

    @FindBy(xpath = "//*[contains(text(), 'Unable to verify your captcha response')]")
    private WebElement captureError;


    public SignUpPage typeEmail(String email){
        emailField.sendKeys(email);
        return this;
    }

    public SignUpPage clickContinue1(){
        buttonToPassword.submit();
        return this;
    }

    public SignUpPage typePassword(String password){
        passwordField.sendKeys(password);
        return this;
    }

    public SignUpPage clickContinue2(){
        buttonToUserName.submit();
        return this;
    }

    public SignUpPage typeLogin(String login){
        loginField.sendKeys(login);
        return this;
    }

    public SignUpPage clickContinue3(){
        buttonToOption.submit();
        return this;
    }

    public SignUpPage typeOption(String option)
    {
        optField.sendKeys(option);
        return this;
    }


    public SignUpPage registerWithInvalidCreds(String username, String email, String password, String option){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        this.typeEmail(email);
        clickContinue1();
        this.typePassword(password);
        clickContinue2();
        this.typeLogin(username);
        clickContinue3();
        this.typeOption(option);
        return new SignUpPage(driver);
    }

    public String getHeadingText(){
        return heading.getText();
    }


    public boolean isVisibleCaptureError(){
        return captureError.isDisplayed();
    }
/*
    public String getUsernameErrorText(){
        return driver.findElement(userNameError).getText();
    }

    public String getPasswrodErrorText(){
        return driver.findElement(passwordError).getText();
    }

    public String getEmailErrorText(){
        return driver.findElement(emailError).getText();
    }*/
}
