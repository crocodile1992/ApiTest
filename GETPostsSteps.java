package steps;


import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;

import org.testng.Assert;
import utilities.RestAssuredExtension;


import java.util.HashMap;

import static org.hamcrest.MatcherAssert.assertThat;

import static org.hamcrest.CoreMatchers.hasItem;

public class GETPostsSteps {

    public static ResponseOptions<Response> response;
    public static String token;

    @Given("^I perform GET operation for \"([^\"]*)\"$")
    public void iPerformGETOperationFor(String url) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        response = RestAssuredExtension.GetOpsWithToken(url, response.getBody().jsonPath().<String>get("access_token"));
    }


    @Then("^I should see the author name as \"([^\"]*)\"$")
    public void iShouldSeeTheAuthorNameAs(String authorName) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertEquals(response.getBody().jsonPath().get("author"), "Karthik KK");

    }


    @Then("^I should see the author names$")
    public void iShouldSeeTheAuthorNames() {
    }

    @Then("^I should see verify GET Parameter$")
    public void iShouldSeeVerifyGETParameter() {
    }

    @Given("^I perform authentication operation for \"([^\"]*)\" with body$")
    public void iPerformAuthenticationOperationForWithBody(String url, DataTable table) throws Throwable {
        // Write code here that turns the phrase above into concrete actions

        HashMap<String, String> body = new HashMap();
        body.put("email", table.raw().get(1).get(0));
        body.put("password", table.raw().get(1).get(1));

        response = RestAssuredExtension.PostOpsWithBody(url, body);
    }

    @Then("^I should see the name as \"([^\"]*)\"$")
    public void iShouldSeeTheNameAs(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions

        Assert.assertEquals(response.getBody().jsonPath().get("name"), "Product001");
    }
}
