package com.studentapp.studentinfo;

import com.studentapp.testbase.TestBase;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

/*
 *  Created by Jay
 */
public class StudentDeleteTest extends TestBase {

    @Test
    public void deleteTheStudent(){
        given().log().all()
                .pathParam("id", 1)
                .when()
                .delete("/{id}")
                .then().log().all()
                .statusCode(204);
    }

}
