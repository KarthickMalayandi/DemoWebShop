package webServicesTestCases;

import org.testng.Reporter;
import org.testng.annotations.Test;

import genericLib.BaseClass;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Module1_GithubRepo extends BaseClass{

	String bearerToken="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";
	String baseURI="https://api.github.com";
	String ownerName;
	String repoName;
	
	@Test
	public void tc001_CreateRepo()
	{
		
		int randomNum = util.generateRandomNum(5);
		String reqBody="{\"name\":\"RA_Github_Repo"+randomNum+"\",\"description\":\"Rest Assured Repo\"}";
		
		Response response = RestAssured.given().
				header("Authorization", "Bearer " + bearerToken).
				body(reqBody).
				post(baseURI+"/user/repos");
		
		repoName = response.body().jsonPath().get("name");
		ownerName=response.body().jsonPath().get("owner.login");
		String description = response.body().jsonPath().get("description");
		
		Reporter.log("Status Code : "+response.getStatusCode(),true);
		Reporter.log("Status Message : "+response.getStatusLine(),true);
		
		util.verifyExpString(repoName, "RA_Github_Repo"+randomNum);
		util.verifyExpString(description, "Rest Assured Repo");
		
	}
	
	@Test
	public void tc002_GetRepo()
	{
		
		Response response = RestAssured.given().
				header("Authorization", "Bearer " + bearerToken).
				get(baseURI+"/repos/"+ownerName+"/"+repoName);
		
		Reporter.log("Status Code : "+response.getStatusCode(),true);
		Reporter.log("Status Message : "+response.getStatusLine(),true);
		
	}
	
	@Test
	public void tc003_UpdateRepo()
	{
		String reqBody="{\"description\":\"New Rest Assured Repo description\"}";
		
		Response response = RestAssured.given().
				header("Authorization", "Bearer " + bearerToken).
				body(reqBody).
				patch(baseURI+"/repos/"+ownerName+"/"+repoName);
		
		String description = response.body().jsonPath().get("description");
		
		Reporter.log("Status Code : "+response.getStatusCode(),true);
		Reporter.log("Status Message : "+response.getStatusLine(),true);
		
		util.verifyExpString(description, "New Rest Assured Repo description");
		
	}
	
	@Test
	public void tc004_DeleteRepo()
	{
		
		Response response = RestAssured.given().
				header("Authorization", "Bearer " + bearerToken).
				delete(baseURI+"/repos/"+ownerName+"/"+repoName);
		
		Reporter.log("Status Code : "+response.getStatusCode(),true);
		Reporter.log("Status Message : "+response.getStatusLine(),true);
		
	}
}
