package com.studentapp.studentinfo;

import com.studentapp.constant.EndPoints;
import com.studentapp.model.StudentPojo;
import com.studentapp.testbase.TestBase;
import com.studentapp.utils.TestUtils;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

/*
 *  Created by Jay
 */
public class StudentPutTest extends TestBase {

    @Test
    public void updateStudent() {
        String email = TestUtils.getRandomValue() + "prime@gmail.com";

        List<String> courseList = new ArrayList<>();
        courseList.add("Java");
        courseList.add("C#");

        StudentPojo studentPojo = new StudentPojo();
        studentPojo.setFirstName("prime");
        studentPojo.setLastName("testing");
        studentPojo.setEmail(email);
        studentPojo.setProgramme("Automation Testing");
        studentPojo.setCourses(courseList);

        Response response = given().log().all()
                .header("Content-Type", "application/json")
                .pathParam("studentId", 1)
                .when()
                .body(studentPojo)
                .put(EndPoints.UPDATE_STUDENT_BY_ID);
        response.prettyPrint();
        response.then().statusCode(200);

    }
}