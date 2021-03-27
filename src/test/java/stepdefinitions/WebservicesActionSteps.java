package stepdefinitions;

import com.pages.WebservicesAction;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class WebservicesActionSteps {

	private WebservicesAction service = new WebservicesAction();

	@Given("user hit the endpoint url {string} with {string} call")
	public void user_hit_the_endpoint_url(String url, String calltype) {
		service.actionResponse(url,calltype);
	}
	
	
	@Then("User verifies the responsecode with {int}")
	public void user_verifies_the_responsecode_with(int code) {
		service.verifyResponseCode(code);

	}
	
	@Then("User verifies the value of {string} field with {string} having {int}")
	public void user_verifies_the_responsecode_with(String field, String value,int index) {
		service.verifyJsonResponseArray(field,value,index);
	}
	
	@Then("User verifies the value of {string} field with {string}")
	public void user_verifies_the_responsecode_with(String field, String value) {
		service.verifyJsonResponse(field,value);

	}

}
