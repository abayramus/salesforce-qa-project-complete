package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HomePage {

    public HomePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "(//div[@class='headerTrigger  tooltip-trigger uiTooltip'])[2]")
    public WebElement setUpIcon;


    @FindBy(id = "related_setup_app_home")
    public WebElement setUpOption;




}
