package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;
import pages.HomePage;
import pages.LoginPage;
import pages.SetUpPage;
import utilities.BrowserUtils;
import utilities.Driver;

import static org.junit.Assert.assertTrue;
import static utilities.BrowserUtils.*;
import static utilities.JSUtils.JSclickWithTimeout;
import static utilities.WaitUtils.waitFor;

public class ProfilesStepDefs {
//    PAGE ELEMENTS
    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();
    SetUpPage setUpPage = new SetUpPage();

    @Given("user is on {string} page and login in as {string} profile")
    public void user_is_on_page_and_login_in_as_profile(String url, String profile) {
//        sayfaya git
        Driver.getDriver().get(url);
//        login page de login elementlerini olustur - PAGE OBJECT MODEL
        if (profile.equalsIgnoreCase("bank_user")){
//            loginPage.username.sendKeys("bank186187@tpe.com");
//            loginPage.password.sendKeys("salesforceqa12");
//            loginPage.loginButton.click();

//            ALTERNATIVELY
            sendKeysWithTimeout(loginPage.username,"bank186187@tpe.com",5);
            sendKeysWithTimeout(loginPage.password,"salesforceqa12",5);
            clickWithTimeOut(loginPage.loginButton,5);
//            JSclickWithTimeout(loginPage.loginButton);



        }else if (profile.equalsIgnoreCase("super_platform_user")){
            loginPage.username.sendKeys("super@tpe.com");
            loginPage.password.sendKeys("superforceqa12");
            loginPage.loginButton.click();
        }
    }
    @Given("user clicks on the setting icon")
    public void user_clicks_on_the_setting_icon() {
        homePage.setUpIcon.click();
    }
    @Given("clicks on setup option")
    public void clicks_on_setup_option() {
        homePage.setUpOption.click();
    }
    @Then("verify user is on the setup page")
    public void verify_user_is_on_the_setup_page() {
//        ikinci tab e switch yapalim
//        BrowserUtils.windowSwitchTo(1);
        windowSwitchTo(1);
        assertTrue(setUpPage.setUpPageElement.isDisplayed());
    }
    @Then("user clicks on User drop down arrow")
    public void user_clicks_on_user_drop_down_arrow() {
        setUpPage.setUpUsers.click();
    }
    @Then("verify user profiles contains {string}")
    public void verify_user_profiles_contains(String profileName) {
        setUpPage.setUpProfiles.click();
//        SWTICH TO IFRAME
//        BrowserUtils.frameSwitchTo(1);
        waitFor(3);
        frameSwitchTo(0);
        boolean isProfileFound=false;
        for (WebElement eachProfile :setUpPage.allProfiles ){
            System.out.println("Profile Elements : "+eachProfile);
            System.out.println("Profile Strings : "+eachProfile.getText());
            if (eachProfile.getText().contains(profileName)){
                isProfileFound=true;
            }

        }
        assertTrue(profileName + " BULUNAMADI!!!",isProfileFound);
//        message kismi sadece assertion fail ederse console da cikacak.
    }
}
