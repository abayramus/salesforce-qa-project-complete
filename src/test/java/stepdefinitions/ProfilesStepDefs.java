package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.HomePage;
import pages.LoginPage;
import pages.SetUpPage;
import utilities.Driver;

import static org.junit.Assert.assertTrue;

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
            loginPage.username.sendKeys("bank186187@tpe.com");
            loginPage.password.sendKeys("salesforceqa12");
            loginPage.loginButton.click();
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
        assertTrue(setUpPage.setUpPageElement.isDisplayed());
    }
    @Then("user clicks on User drop down arrow")
    public void user_clicks_on_user_drop_down_arrow() {

    }
    @Then("verify user profiles contains {string}")
    public void verify_user_profiles_contains(String string) {

    }
}
