package com.virgingames.jackpotinfo;

import com.virgingames.constants.EndPoints;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class JackpotSteps {

    @Step ("Getting the jackpot Bingo information with name : {0}")
    public ValidatableResponse getJackpotInfoByName() {
        return SerenityRest.given().log().all()
                .when()
                .get(EndPoints.GET_ALL_JACKPOT)
                .then().statusCode(200);
    }

}
