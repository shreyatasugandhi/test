package restassuredtestcases;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class ExtractValuesFromResponse {
	
	@Test
	public void test() {
		baseURI = "https://reqres.in/api";
		
		JSONObject reqData = new JSONObject();
		
		reqData.put("email", "eve.holt@reqres.in");
		reqData.put("password", "cityslicka");
		
		String token =	 given()
							.body(reqData.toJSONString())
							.contentType(ContentType.JSON)
							.accept(ContentType.JSON)
							.header("charset", "utf-8")
						.when()
							.post("/login")
						.then()
							.extract().path("token");
		
		System.out.println(token);

	}
	
	@Test
	public void test2 () {
		//Register a user >> extract id and token
		// Log in with the above created user >> extract token
		// run get single user to find the same user id >> validate name and job details
		// SINGLE <RESOURCE> use the same user if >> validate details
		// then update user details  >> add validations >> search user and validate again
		// patch same user >> validate response >> search user >> validate
		// delete same user >> validate code >> search user >> validate
		
	}
	
	
}
