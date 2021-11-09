package RestAssuredTask;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.equalTo;

public class TestCoursesCollection {
	@Test
	public void FirstTestCase() {
		Response response = get("http://localhost:3000/courses");
		System.out.println("Content type: " + response.getContentType());
		System.out.println("Status Code: " + response.getStatusCode());
		System.out.println("Body " + response.getBody().asPrettyString());
		System.out.println("Status Line: " + response.getStatusLine());
		System.out.println("Header Content type: " + response.getHeader("Content-type"));

	}

	@Test
	public void SecondTestCase() {
		baseURI = "http://localhost:3000";
		given().get("/courses").then().statusCode(200).body("name[2]", equalTo("IT")).log().all();
	}

}
