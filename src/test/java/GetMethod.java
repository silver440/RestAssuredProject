

import org.testng.Assert;
import org.testng.annotations.Test;

import  static io.restassured.RestAssured.*;
import  static io.restassured.matcher.RestAssuredMatchers.*;
import static  org.hamcrest.Matchers.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetMethod {

	
@Test
void getMethod01() {
	//specify the base URI to the restful web service
//	RestAssured.baseURI="https://reqres.in/api";
//	RequestSpecification httpRequestSpecification=RestAssured.given();
	
	Response response=get("https://reqres.in/api/users?page=2");
			
			
	System.out.println("response for the pretty code:	"+response.asPrettyString());
	System.out.println("get status code: "  +  response.getStatusCode());
	System.out.println("get body:  "+response.getBody().asPrettyString());
	System.out.println("get status line:   "+response.getStatusLine());
	System.out.println("Responce to get headers:   "+response.getHeaders().toString());
	int statuscode=response.getStatusCode();
	Assert.assertEquals(statuscode, 200);
}
  @Test
  void test_02() {
	  given().
	  get("https://reqres.in/api/users?page=2")
	  .then()
	  .statusCode(200)
	  .body("data.id[0]",equalTo(7) );
  }
}
