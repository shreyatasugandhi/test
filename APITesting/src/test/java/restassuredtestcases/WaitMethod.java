package restassuredtestcases;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class WaitMethod {
	
	@Test
	public void testGetUserList() {
		baseURI = "https://reqres.in/api";
		
		given()
			.get("/users?delay=3")
		.then()
			.statusCode(200)
			.log().all();		
		
	}

}
