package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
import java.util.List;

public class FDDetailsPage {
    public FDDetailsPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//a[@title='New']")
    public WebElement newButton;
    @FindBy(xpath = "(//input[@type='radio'])[1]")
    public WebElement branchVisitRTOption;
    @FindBy(xpath = "//span[.='Next']")
    public WebElement nextButton;
    @FindBy(xpath = "//button[@name='SaveEdit']")
    public WebElement saveButton;
    @FindBy(xpath = "//div[@class='fieldLevelErrors']//li")
    public List<WebElement> fdDetailsFieldErrorList;

}
