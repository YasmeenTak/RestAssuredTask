package RestAssuredTask;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.json.JSONObject;
public class EditCourse {
	// Test Case to Edit Course data using PUT API.
	@Test
	static void EditCourseTestCase() {
		JSONObject reqParams = new JSONObject();
		baseURI = "http://localhost:3000";

		reqParams.put("name", "QA");
		reqParams.put("describtion", "QA wow!");
		
		RequestSpecification req = given();
		req.header("content-type", "application/json");
		
		req.body(reqParams.toString());
	    Response  res= req.put("/courses/5");
	    
        int statusCode = res.getStatusCode();
        Assert.assertEquals(statusCode,200);

		String courseName =res.jsonPath().get("name");
		Assert.assertEquals(courseName, "QA");
		
		String describtion =res.jsonPath().get("describtion");
		Assert.assertEquals(describtion, "QA wow!");
	}

}
