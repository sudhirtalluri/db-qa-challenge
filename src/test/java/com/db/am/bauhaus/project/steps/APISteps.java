package com.db.am.bauhaus.project.steps;

import com.db.am.bauhaus.project.SessionVar;
import com.db.am.bauhaus.project.steplib.CategoryNavAPI;
import com.db.config.SerenityFacade;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.builder.RequestSpecBuilder;

public class APISteps {
    RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
    CategoryNavAPI categoryNavAPI;


    @Given("^John has an api request$")
    public void johnIsHasAnApiRequest() throws Throwable {
        requestSpecBuilder.setBaseUri("https://www.etsy.com/");
        SerenityFacade.setData(SessionVar.REQUEST_SPEC,requestSpecBuilder);
    }

    @When("^he made api request$")
    public void heMadeApiRequest() throws Throwable {
         categoryNavAPI = new CategoryNavAPI();
        categoryNavAPI.getCategoryAPIResponse(requestSpecBuilder);
    }

    @Then("^response displayed with categories$")
    public void responseDisplayedWithCategories() throws Throwable {
        categoryNavAPI.checkCategoriesAreDisplayed();
    }
}
