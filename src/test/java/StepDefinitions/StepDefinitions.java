package StepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class StepDefinitions extends CommonComponents.Main{

    @Given("^With valid API credentials$")
    public void with_valid_API_credentials() throws Throwable
    {
        apiCredentials();
    }

    @When("^user search with valid word through api call$")
    public void user_search_with_valid_word_through_api_call() throws Throwable
    {
        requestSpec();
    }

    @Then("^user should get status_ok status code and meanings of the word$")
    public void user_should_get_status_ok_status_code_and_meanings_of_the_word() throws Throwable
    {
        validateValidKeywordResponses();
    }

    @When("^user search with in valid word through api call$")
    public void user_search_with_in_valid_word_through_api_call() throws Throwable
    {
        requestSpec();
    }

    @Then("^user should get Not_Found status code and response content$")
    public void user_should_get_Not_Found_status_code_response_content() throws Throwable
    {
        validateInvalidKeywordResponses();
    }

    @When("^user search words randomly through api call$")
    public void user_search_words_randomly_through_api_call() throws Throwable
    {
        requestSpec();
    }

    @Then("^user should get approperiate status code and response content$")
    public void user_should_get_approperiate_status_code_and_response_content() throws Throwable
    {
        validateRandomWordSearchResponses();
    }

}
