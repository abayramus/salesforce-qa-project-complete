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
    @Then("user clicks on profiles")
    public void user_clicks_on_profiles() {
        setUpPage.setUpProfiles.click();
//        SWTICH TO IFRAME
//        BrowserUtils.frameSwitchTo(1);
        waitFor(2);
        frameSwitchTo(0);
    }
    @Then("verify user profiles contains {string}")
    public void verify_user_profiles_contains(String profileName) {
        boolean isProfileFound=false;
        for (WebElement eachProfile :setUpPage.allProfiles ){
//            System.out.println("Profile Elements : "+eachProfile);
//            System.out.println("Profile Strings : "+eachProfile.getText());
            if (eachProfile.getText().contains(profileName)){
                isProfileFound=true;
            }
        }
        assertTrue(profileName + " BULUNAMADI!!!",isProfileFound);
//        message kismi sadece assertion fail ederse console da cikacak.
    }


    @Then("user clicks on Users")
    public void user_clicks_on_users() {
        setUpPage.userTab.click();
//        SWTICH TO IFRAME
//        BrowserUtils.frameSwitchTo(1);
        waitFor(2);
        frameSwitchTo(0);
    }

    @Then("verify users contains {string} profiles")
    public void verify_users_contains_profiles(String userProfiles) {
        boolean isUserProfileFound=false;
        for (WebElement eachUserProfiles :setUpPage.allUserProfiles ){
//            System.out.println("Profile Elements : "+eachProfile);
//            System.out.println("Profile Strings : "+eachProfile.getText());
            if (eachUserProfiles.getText().contains(userProfiles)){
                isUserProfileFound=true;
            }
        }
        assertTrue(userProfiles + " BULUNAMADI!!!",isUserProfileFound);
//        message kismi sadece assertion fail ederse console da cikacak.
    }


//    CUSTOM OBJECT STEP DEFS
    @Then("verify custom object contains {string}")
    public void verify_custom_object_contains(String expectedObject) {
        waitFor(1);
        clickWithTimeOut(setUpPage.objectManager,5);
        waitFor(1);
        waitFor(1);
        setUpPage.quickFind.clear();
        sendKeysWithTimeout(setUpPage.quickFind,expectedObject,5);
        waitFor(3);
        System.out.println("object name : "+setUpPage.objectName.getText());
        verifyExpectedAndActualTextMatch(expectedObject,setUpPage.objectName);
    }

    @Then("click on {string} object")
    public void click_on_object(String string) {
        clickWithTimeOut(setUpPage.objectName,5);
    }

    @Then("click on {string} option in the setting")
    public void click_on_option_in_the_setting(String string) {
        clickWithTimeOut(setUpPage.pageLayout,5);
    }

    @Then("verify {string} layout is in the list")
    public void verify_layout_is_in_the_list(String string) {
        boolean isFound=false;
        System.out.println("all layouts : "+setUpPage.pageLayoutList);
        for (WebElement layout : setUpPage.pageLayoutList){
            System.out.println(layout.getText());
            if (layout.getText().contains(string)){
                isFound=true;
            }
        }
        assertTrue( "Profile is not Found!",isFound);
    }

}
