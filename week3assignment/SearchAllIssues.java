package week3assignment;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SearchAllIssues extends BaseClass {
@Test(dependsOnMethods = "week3assignment.DeleteJiraIssue.DeleteIssue")
	public void SearchAll() {
	RestAssured.baseURI="https://restapioct.atlassian.net/rest/api/2/search?jql=project=MAG";
	   RequestSpecification inputrequest = RestAssured.given().auth().preemptive().basic("rajalakshmiv105@gmail.com","zibN1VVbmQlizrZybP5Y20CE").accept(ContentType.JSON);
	   Response response = inputrequest.get();
	   
	   System.out.println(response.getStatusCode());
	   response.prettyPrint();
	   response.then().assertThat().statusCode(200);
	System.out.println("All the issues are searched and retrieved successfully");
	}
}
