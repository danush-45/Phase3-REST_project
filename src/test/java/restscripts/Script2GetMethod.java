package restscripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Script2GetMethod {
	
	
		

		@Test(enabled=false)
		public void httpGetMethod() {

			Response res = RestAssured.get("https://reqres.in/api/users?page=3");
			
			//https://reqres.in/api/users/3

			System.out.println(res.getStatusCode());

			System.out.println(res.getBody().asPrettyString());

			System.out.println(res.getTime());

			System.out.println(res.getHeader("Content-Type"));

			int expectedStatusCode = 200;
			int actualStatusCode = res.getStatusCode();

			Assert.assertEquals(expectedStatusCode, actualStatusCode);

		
	}
	    @Test
		public void GetMethodBDDStyle() {
			
			RestAssured
			.given()
			.baseUri("https://reqres.in/api/users")
			.queryParam("page", "2")
			.when().get()
			.then()
			.statusCode(200)
			.log().all();
			
	
	}
	

}
