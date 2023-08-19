package com.virgingames.jackpotinfo;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.ValidatableResponse;
import net.thucydides.core.annotations.Steps;

import static org.hamcrest.CoreMatchers.equalTo;

public class MyStepdefs {

    static ValidatableResponse response;

    @Steps
    JackpotSteps jackpotSteps;

    @When("^I send a get request$")
    public void iSendAGetRequest() {
        response = jackpotSteps.getJackpotInfoByName();
    }

    @Then("^I get valid response code \"([^\"]*)\"$")
    public void iGetValidResponseCode(String arg0)  {
        response.statusCode(200);
    }

    @And("^I verify currency GBP$")
    public void iVerifyCurrencyGBP() {
        response.body("data.pots[1].currency",equalTo("GBP"));

    }

    @And("^I verify name is BubbleUpBingoVGN in bingo data$")
    public void iVerifyNameIsBubbleUpBingoVGNInBingoData() {
        response.body("data.pots[1].name", equalTo("BubbleUpBingoVGN"));
    }

    @Then("^I verify id (\\d+) is equal to BubbleUpBingoVGN in data$")
    public void iVerifyIdIsEqualToBubbleUpBingoVGNInData(int arg0) {
        response.extract().jsonPath().get("data.pots[1].id").equals("BubbleUpBingoVGN");
    }



}
