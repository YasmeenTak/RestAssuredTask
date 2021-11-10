package RestAssuredTask;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DeleteCourse {
	// Test Case to Delete Course using DELETE API.
	@Test
	static void DeleteCourseTestCase() {
		baseURI = "http://localhost:3000";

		RequestSpecification req = given();
		req.header("content-type", "application/json");

		Response res = req.delete("/courses/7");

		int statusCode = res.getStatusCode();
		Assert.assertEquals(statusCode, 200);
	}

}
