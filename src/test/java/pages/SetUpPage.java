package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class SetUpPage {


    public SetUpPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//span[@title='Setup']")
    public WebElement setUpPageElement;

    @FindBy(xpath = "(//a[.='Users'])[1]")
    public WebElement setUpUsers;

    @FindBy(xpath = "(//a[.='Profiles'])[1]")
    public WebElement setUpProfiles;

    @FindBy(xpath = "//div[@class='listBody']//div[@class='x-grid3-cell-inner x-grid3-col-ProfileName']")
    public List<WebElement> allProfiles;



}
