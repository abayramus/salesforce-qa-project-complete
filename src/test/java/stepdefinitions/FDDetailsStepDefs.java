package stepdefinitions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;
import pages.FDDetailsPage;
import pages.HomePage;
import utilities.Driver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertTrue;
import static utilities.BrowserUtils.clickWithTimeOut;
import static utilities.BrowserUtils.verifyExpectedAndActualTextMatch;
import static utilities.JSUtils.JSclickWithTimeout;
import static utilities.WaitUtils.waitFor;

public class FDDetailsStepDefs {
    HomePage homePage = new HomePage();
    FDDetailsPage fdDetailsPage = new FDDetailsPage();
    @Given("clicks on FD Details tab")
    public void clicks_on_fd_details_tab() {
//        homePage.FDDetailsTab.click();
        clickWithTimeOut(homePage.FDDetailsTab,5);
    }
    @Given("clicks on FD Details new button")
    public void clicks_on_fd_details_new_button() {
        clickWithTimeOut(fdDetailsPage.newButton,5);
    }
    @Given("clicks on FD Details Branch Visit RT record type and click next")
    public void clicks_on_fd_details_branch_visit_rt_record_type_and_click_next() {
        clickWithTimeOut(fdDetailsPage.branchVisitRTOption,5);
        clickWithTimeOut(fdDetailsPage.nextButton,5);

    }
    @Given("clicks on FD Details Branch Visit RT save button")
    public void clicks_on_fd_details_branch_visit_rt_save_button() {
        clickWithTimeOut(fdDetailsPage.saveButton,5);

    }
    @Then("verify the {string}, {string}, and {string} are the required fields")
    public void verify_the_and_are_the_required_fields(String string, String string2, String string3) {
//        List<WebElement> -> List<String>
//        List<String> errorListText = new ArrayList<>();
//        for (WebElement element : fdDetailsPage.fdDetailsFieldErrorList) {
//            errorListText.add(element.getText());
//        }
//        ALTERNATIVELY

        List<String> errorListText= fdDetailsPage.fdDetailsFieldErrorList
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());

        System.out.println(errorListText);

        assertTrue(errorListText.contains(string)&&errorListText.contains(string2)&&errorListText.contains(string3));
    }

    @Then("verify the customer types contains {string}, {string}, and {string}")
    public void verify_the_customer_types_contains_and(String string, String string2, String string3) {
//        clickWithTimeOut(fdDetailsPage.customerTypesDropdown,5);
        JSclickWithTimeout(fdDetailsPage.customerTypesDropdown);
        System.out.println(fdDetailsPage.customerTypeList);
        List<String> customers= fdDetailsPage.customerTypeList
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());

        System.out.println(customers);

        assertTrue(customers.contains(string)&&customers.contains(string2)&&customers.contains(string3));
    }
    @Then("verify the sourcing channel value contains {string}")
    public void verify_the_sourcing_channel_value_contains(String string) {
        System.out.println(fdDetailsPage.sourcingChannelSelectedValue.getText());
        verifyExpectedAndActualTextMatch(string,fdDetailsPage.sourcingChannelSelectedValue);
    }

    @Then("verify the branch list is in  alphabetical order")
    public void verify_the_branch_list_is_in_alphabetical_order() {
//        System.out.println(fdDetailsPage.branchList);
//        waitFor(3);
        JSclickWithTimeout(fdDetailsPage.branchDropdown);
//        System.out.println(fdDetailsPage.branchList);
        List<String> branches= fdDetailsPage.branchList
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
        System.out.println(branches);

        // Create a sorted copy of the list
        List<String> sortedBranches = new ArrayList<>(branches);
        Collections.sort(sortedBranches);

// Compare the original list with the sorted list
        if (branches.equals(sortedBranches)) {
            assertTrue( "The branch list is in alphabetical order.",true);
        } else {
            assertTrue("The branch list is NOT in alphabetical order.", false);

        }
    }
}
