package week3assignment;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UpdateJiraIssue extends BaseClass {
@Test(dependsOnMethods="week3assignment.GetSpecificIssue.GetJira")
	public void UpdateIssue() {
		RestAssured.baseURI="https://restapioct.atlassian.net/rest/api/2/issue/";
		RequestSpecification inputrequest = RestAssured
				                            .given()
				                            .auth()
				                            .preemptive()
				                            .basic("rajalakshmiv105@gmail.com","zibN1VVbmQlizrZybP5Y20CE")
				                            .contentType(ContentType.JSON)
		                                    .body("{\r\n"
		           		+ "    \"fields\": {\r\n"
		           		+ "        \"description\": \"Issue updated via RestAssured on Nov 2 2022 --second time\"\r\n"
		           		+ "    }\r\n"
		           		+ "}");
		Response response = inputrequest.put(CreatedID);
		response.prettyPrint();
		System.out.println(response.getStatusCode());
		response.then().assertThat().statusCode(204);
		System.out.println("The issue description has been updated successfully");
	}
}
