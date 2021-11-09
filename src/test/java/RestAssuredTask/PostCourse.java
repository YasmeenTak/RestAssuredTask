package RestAssuredTask;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.equalTo;

import org.json.JSONObject;

public class PostCourse {
	// Test Case
	@Test (priority = 1 )
	static void postTestCase() {
		JSONObject requestParams = new JSONObject();
		requestParams.put("name", "SDLC");
		requestParams.put("description", "Software Development Life");
		requestParams.put("auther", "Yasmeeeen");

		
		
		baseURI = "http://localhost:3000";
		
		RequestSpecification req = given();
		req.header("content-type", "application/json");
		req.body(requestParams.toString());
		
		Response res = req.post("/courses");
		int statusCode = res.getStatusCode();
		Assert.assertEquals(statusCode, 201);
		
		String courseName =res.jsonPath().get("name");
		Assert.assertEquals(courseName, "SDLC");

	}

}
