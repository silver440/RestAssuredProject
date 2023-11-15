import org.testng.annotations.Test;

import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;
import  static io.restassured.matcher.RestAssuredMatchers.*;
import static  org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

public class Test_Get {
	
	@Test
	public void test_1() {
		given().
		 get("https://reqres.in/api/users?page=2").
		 then().
		 statusCode(200).
		 body("data.id[2]",equalTo( 9)).
		 body("data.first_name", hasItems("Michael", "Tobias"));
		 
		 
	}


}
