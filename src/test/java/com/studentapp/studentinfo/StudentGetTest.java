package com.studentapp.studentinfo;

import com.studentapp.testbase.TestBase;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

/*
 *  Created by Jay
 */
public class StudentGetTest extends TestBase {

    @Test
    public void getAllStudentsInfo() {
        Response response = given()
                .when()
                .get("/list");
        response.prettyPrint();
        response.then().statusCode(200);
    }

    @Test
    public void getSingleStudentInfo() {
        Response response = given()
                .pathParam("id", 1)
                .when()
                .get("/{id}");
        response.prettyPrint();
        response.then().statusCode(200);
    }

    @Test
    public void searchStudentWithParameter() {
        Map<String, Object> qParams = new HashMap<>();
        qParams.put("programme", "Computer Science");
        qParams.put("limit", 3);

        Response response = given()
                /*.param("programme", "Computer Science")
                .param("limit", 3)*/
                .params(qParams)
                .when()
                .get("/list");
        response.prettyPrint();
        response.then().statusCode(200);
    }
}