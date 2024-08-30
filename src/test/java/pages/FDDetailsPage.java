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
    @FindBy(xpath = "//button[@id='combobox-button-137']")
    public WebElement customerTypesDropdown;
    @FindBy(xpath = "//*[starts-with(@data-item-id, 'combobox-button-137-')]")
    public List<WebElement> customerTypeList;
    @FindBy(xpath = "//button[@id='combobox-button-149']//span")
    public WebElement sourcingChannelSelectedValue;
    @FindBy(xpath = "//button[@id='combobox-button-161']")
    public WebElement branchDropdown;
    @FindBy(xpath = "(//lightning-base-combobox-item//span[2]//span)[position()>1]")
    public List<WebElement> branchList;





}
