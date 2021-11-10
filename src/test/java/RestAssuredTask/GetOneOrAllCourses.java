package RestAssuredTask;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.baseURI;


public class GetOneOrAllCourses {
	// Test Case to Fetch all courses using GET API.
	@Test(priority = 1)
	static void getAllCoursesTestCase() {
		baseURI = "http://localhost:3000";

		RequestSpecification req = given();
		req.header("content-type", "application/json");

		Response res = req.get("/courses");
		int statusCode = res.getStatusCode();
		Assert.assertEquals(statusCode, 200);

		String body = res.asString();
		System.out.println(body);
	}
	
	// Test Case to Fetch One Course using GET API.
	@Test(priority = 2)
	static void getOneCourse() {
		baseURI = "http://localhost:3000";
		RequestSpecification request = given();
		request.header("content-type", "application/json");

		Response res = request.get("/courses/1");
		int statusCode = res.getStatusCode();
		Assert.assertEquals(statusCode, 200);

		String body = res.asString();
		System.out.println(body);
	}

}
