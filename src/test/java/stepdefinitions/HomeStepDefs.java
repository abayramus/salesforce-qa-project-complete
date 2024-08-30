package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.HomePage;
import pages.SetUpPage;

import static utilities.BrowserUtils.*;
import static utilities.WaitUtils.waitFor;

public class HomeStepDefs {

    HomePage homePage = new HomePage();
    SetUpPage setUpPage = new SetUpPage();
    @Given("search for {string} from the app launcher")
    public void search_for_from_the_app_launcher(String string) {
        clickWithTimeOut(homePage.appLauncher,5);
        sendKeysWithTimeout(homePage.appLauncherSearchBox,string,5);
    }
    @Then("verify the result {string} app")
    public void verify_the_result_app(String string) {
        waitFor(3);
        verifyExpectedAndActualTextMatch(string,homePage.appLauncherResult);
    }
}
