package com.db.am.bauhaus.project.steplib;

import com.db.am.bauhaus.project.SessionVar;
import com.db.config.SerenityFacade;
import com.db.services.CategoryService;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import static org.hamcrest.Matchers.hasItems;

public class CategoryNavAPI extends ScenarioSteps {
    private final String[] expectedMainCategories =
            {"Clothing & Accessories","Jewelry","Craft Supplies & Tools", "Weddings","Entertainment","Home & Living","Kids & Baby","Vintage"};

    @Step
    public void getCategoryAPIResponse(RequestSpecBuilder requestSpecBuilder) {
        SerenityFacade.setData(SessionVar.SERVICE_RESPONSE, CategoryService.getCategoryServiceResponse(requestSpecBuilder));
    }

    @Step
    public void checkCategoriesAreDisplayed() {
        Response response= SerenityFacade.getData(SessionVar.SERVICE_RESPONSE);
        ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder();
        responseSpecBuilder
                .expectStatusCode(200)
                .expectBody("data.roots.node.name", hasItems(expectedMainCategories));
        responseSpecBuilder.build().validate(response);
    }
}
