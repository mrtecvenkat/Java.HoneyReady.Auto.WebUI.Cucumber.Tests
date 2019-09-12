package stepdefs;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CommonStepDef {

    @Given("^I can open \"([^\"]*)\" in the \"([^\"]*)\" browser")
    public void iCanOpenSomeUrlInTheBrowseer(String url, String browserName){
        System.out.println(url);
        System.out.println(browserName);
    }
}