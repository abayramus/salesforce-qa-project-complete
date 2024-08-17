package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utilities.Driver;

public class CommonStepDefs {
    @Then("close the application")
    public void close_the_application() {
        Driver.closeDriver();
    }
    @Given("user navigates to {string} page")
    public void user_navigates_to_page(String URL) {
        Driver.getDriver().get(URL);
    }
}
