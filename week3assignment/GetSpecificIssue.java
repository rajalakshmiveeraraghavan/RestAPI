package week3assignment;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetSpecificIssue extends BaseClass{
@Test(dependsOnMethods="week3assignment.CreateJiraIssue.Createissue")
	public void GetJira() {
		RestAssured.baseURI = "https://restapioct.atlassian.net/rest/api/2/issue/";
		
		RequestSpecification inputreq = RestAssured.given().auth().preemptive().basic("rajalakshmiv105@gmail.com","zibN1VVbmQlizrZybP5Y20CE").accept(ContentType.JSON);
		
		Response response = inputreq.get(CreatedID);
		System.out.println(response.getStatusCode());
		response.prettyPrint();
		response.then().assertThat().statusCode(200);
		System.out.println("Specific issue details has been retrieved successfully");
			
	}
}
