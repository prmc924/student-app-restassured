package com.studentapp.studentinfo;

import com.studentapp.constant.EndPoints;
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
                .pathParam("studentId", 1)
                .when()
                .delete(EndPoints.DELETE_STUDENT_BY_ID)
                .then().log().all()
                .statusCode(204);
    }

}
