package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class LoginPage {

//    her login sayfasi icin consttuctor olustur ve initElement ile sayfayi initialize et

    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
//    username
    @FindBy(id="username")
    public WebElement username;
//    password
    @FindBy(id="password")
    public WebElement password;
//    login button
    @FindBy(id="Login")
    public WebElement loginButton;


}
