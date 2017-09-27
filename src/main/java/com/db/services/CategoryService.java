package com.db.services;

import com.db.services.enums.HTTPMethods;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;

public class CategoryService extends BaseService {
    private static final String CATEGORY_SERVICE_URL ="/api/v3/ajax/public/category-nav/view/subnav";

    public static Response getCategoryServiceResponse(RequestSpecBuilder requestSpecBuilder){
        requestSpecBuilder.addParam("responsive_enabled",true);
        return sendGetRequest(CATEGORY_SERVICE_URL,HTTPMethods.GET,requestSpecBuilder);
    }

}
