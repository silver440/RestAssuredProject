import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import groovy.lang.Newify;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;
public class Test_Post {
	@Test()
	public void Test_get() {
		given().
		get("https://reqres.in/api/unknown").
		then().
		statusCode(200).
		body("data.color",hasItems("#C74375"));
		}
    @Test
	public void Test_post() {
		Map<String, Object>map =new HashMap<String, Object>();
//		map.put("name", "nur");
//		map.put("ocupation", "artist");
//		System.out.println(map);
//		
		JSONObject  request=new JSONObject(map);
		request.put("name", "nur");
		request.put("ocupation", "teacher");
	//	System.out.println(request);
		System.out.println(request.toJSONString());
		given().
		body(request.toJSONString()).
		when().
		post("https://reqres.in/api/users").
		then(). 
		statusCode(201);
		
		
		
	}
     @Test
     public void Test_put() {
    		Map<String, Object>map =new HashMap<String, Object>();

    		JSONObject  request=new JSONObject(map);
    		request.put("name", "nur");
    		request.put("ocupation", "teacher");
    		System.out.println(request);
    		System.out.println(request.toJSONString());
    		given().
    		body(request.toJSONString()).
    		when().
    		put("https://reqres.in/api/users/2").
    		then(). 
    		statusCode(200);
    		
     }
     @Test
     public void Test_path() {
    		Map<String, Object>map =new HashMap<String, Object>();
    		map.put("name", "nur");
    		map.put("ocupation", "artist");
    		System.out.println(map);
    		
    		JSONObject  request=new JSONObject(map);
    		request.put("name", "nur");
    		request.put("ocupation", "teacher");
    	//	System.out.println(request);
    		System.out.println(request.toJSONString());
    		given().
    		body(request.toJSONString()).
    		when().
    		patch("https://reqres.in/api/users/2").
    		then(). 
    		statusCode(200);
    		 }
     @Test
     public void Test_delete() {
    	
    		given().
    		delete("https://reqres.in/api/users/2").
    		then(). 
    		statusCode(204).log().all();
    		
     }
}
