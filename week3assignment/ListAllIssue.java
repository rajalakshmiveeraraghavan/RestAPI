package week3assignment;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ListAllIssue extends BaseClass{
 @Test(dependsOnMethods="week3assignment.SearchAllIssues.SearchAll")
public void ListIssue() {
	RestAssured.baseURI="https://restapioct.atlassian.net/rest/api/2/issuetype";
	RequestSpecification inputRequest = RestAssured.given().auth().preemptive().basic("rajalakshmiv105@gmail.com","zibN1VVbmQlizrZybP5Y20CE").accept(ContentType.JSON);
	Response response= inputRequest.get();
	System.out.println(response.getStatusCode());
	response.prettyPrint();
	response.then().assertThat().statusCode(200);
	System.out.println("All the issues are listed successfully");
	
}
}
