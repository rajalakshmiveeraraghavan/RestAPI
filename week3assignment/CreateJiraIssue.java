package week3assignment;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateJiraIssue extends BaseClass {
@Test
	public void Createissue() {
		RestAssured.baseURI = "https://restapioct.atlassian.net/rest/api/2/issue/";
		
		RequestSpecification input = RestAssured.given().auth().preemptive().basic("rajalakshmiv105@gmail.com","zibN1VVbmQlizrZybP5Y20CE").body("{\r\n"
				+ "    \"fields\": {\r\n"
				+ "        \"project\": {\r\n"
				+ "            \"key\": \"MAG\"\r\n"
				+ "        },\r\n"
				+ "        \"summary\": \"create issue in MAGIZH project\",\r\n"
				+ "        \"description\": \"Creating of an issue using project keys and issue type names using the REST API\",\r\n"
				+ "        \"issuetype\": {\r\n"
				+ "            \"name\": \"Task\"\r\n"
				+ "        }\r\n"
				+ "    }\r\n"
				+ "}").contentType(ContentType.JSON);
		
		Response response = input.post();
		System.out.println(response.getStatusCode());
		response.prettyPrint();
		
		CreatedID = response.jsonPath().get("id");
		Key = response.jsonPath().get("key");
		System.out.println("Successfully Created issue is " + CreatedID);
		response.then().assertThat().statusCode(201);
	}
}
