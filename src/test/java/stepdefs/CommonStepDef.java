package stepdefs;
import core.BaseTest;
import core.UtilHelper;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommonStepDef extends BaseTest {

    @Given("^I logged in to the app \'([^\"]*)\' as admin$")
    public void iLoggedInToTheAppSoneuserAsAdmin(String user) {
        navigateToURL("https://app.hubspot.com/reports-dashboard/6452251/sales");
        setElementValuedById("username","vkosanamjlite@gmail.com");
        setElementValuedById("password","TestMe123");
        clickByXpath("//*[text()='Log in']/..");
    }

    @When("^I click on \'([^\"]*)\' menu item from \'([^\"]*)\' menu$")
    public void iClickOnContactsMenuItemFromContactMenu(String subMenuText, String mainMenuText) {
        clickByXpath("//div[@role='menubar']//a[contains(text(),'"+mainMenuText+"')]");
        clickByXpath("//div[@role='menu']//div[contains(text(),'"+subMenuText+"')]/parent::a");
    }

    @When("^I click on \'([^\"]*)\' button$")
    public void iClickOnCreateContactButton(String buttonText) {
        clickByXpath("//span[text()='"+buttonText+"']/../..");
    }

    @When("^I create contacts with below deatils$")
    public void iCreateContactsWithBelowDeatils(DataTable table) {
        int curRow =0;
        List<Map<String, String>> content = table.asMaps(String.class,String.class);
        for (Map<String, String> row : content) {
            curRow++;
            for (Map.Entry<String, String> entry : row.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if(key.toLowerCase().contains("email"))
                    setElementValuedByXpath("//label[text()='Email']/../../..//input", new UtilHelper().getCURRENT_TIME_STAMP().replace(":","")+value);
                if(key.toLowerCase().contains("first"))
                    setElementValuedByXpath("//label[text()='First name']/../../..//input", new UtilHelper().getCURRENT_TIME_STAMP().replace(":","")+value);
                if(key.toLowerCase().contains("last"))
                    setElementValuedByXpath("//label[text()='Last name']/../../..//input", new UtilHelper().getCURRENT_TIME_STAMP().replace(":","")+value);

            }
            clickByXpath("//footer//*[text()='Create contact']/..");
            if(curRow<content.size())
                clickByXpath("//footer//*[text()='Create contact']/..");

        }

    }
}