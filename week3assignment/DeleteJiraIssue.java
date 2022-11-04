package week3assignment;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DeleteJiraIssue extends BaseClass {
@Test(dependsOnMethods="week3assignment.UpdateJiraIssue.UpdateIssue")
	public void DeleteIssue() {
		RestAssured.baseURI = "https://restapioct.atlassian.net/rest/api/2/issue/";
		RequestSpecification request = RestAssured.given().auth().preemptive().basic("rajalakshmiv105@gmail.com","zibN1VVbmQlizrZybP5Y20CE");
		Response response = request.delete(CreatedID);
		
		System.out.println(response.getStatusCode());
		response.prettyPrint();
		response.then().assertThat().statusCode(204);
		System.out.println("The issue has been deleted successfully");
	}
}
