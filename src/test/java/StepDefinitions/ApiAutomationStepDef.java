package StepDefinitions;

import Questions.RespBodyEmployees;
import Questions.ResponseCode;

import Task.CreateEmployee;
import Task.DeleteEmployee;
import Task.GetEmployee;
import Task.GetEmployees;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import models.Data;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import org.hamcrest.core.IsEqual;

import static UserInterfaces.API.restApiUrl;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class ApiAutomationStepDef {

    private Actor user;
    @Given("The user accesses to the resource")
    public void the_user_accesses_to_the_resource() {
        user = Actor.named("User");
        user.whoCan(CallAnApi.at(restApiUrl));
    }

    @When("The user searches for an employee in the database")
    public void the_user_searches_for_an_employee_in_the_database() {
        user.attemptsTo(
                GetEmployee.fromPage(2)
        );
    }

    @Then("the requested data is returned successfully")
    public void theRequestedDataIsReturnedSuccessfully() {
        user.should(
                seeThat("the response code", ResponseCode.was(), equalTo(200)),
                seeThat("Employee data", ResponseCode.was(), notNullValue()),
                seeThatResponse(" The user can see the employee consulted",
                        response -> response.body("data.employee_name",
                                IsEqual.equalTo("Garrett Winters")))
        );
    }
    @When("The user searches for multiple employees in the database")
    public void the_user_searches_for_multiple_employees_in_the_database() {
        user.attemptsTo(
                GetEmployees.fromAllPages()

        );
    }

    @Then("the requested for multiple data is returned successfully")
    public void the_requested_for_multiple_data_is_returned_successfully() {
        user.should(seeThat("the response code",ResponseCode.was(), equalTo(200)),
                    seeThat("Employee data", ResponseCode.was(), notNullValue())
                );

        Data employee = new RespBodyEmployees().answeredBy(user)
                .getData().stream().filter(x -> x.getId().equals(1)).findFirst().orElse(null);
    }

    @When("The user need create an employee in the database")
    public void the_user_need_create_an_employee_in_the_database() {
        user.attemptsTo(
                CreateEmployee.withGenericData()
        );
    }

    @Then("employee creation was successful")
    public void employee_creation_was_successful() {
        user.should(
                seeThat("the response code", new ResponseCode(), equalTo(200)),
                seeThat("Creation employee response", ResponseCode.was(), notNullValue()),
                seeThatResponse(" The user can see Successfully! Record has been added message",
                response -> response.body("data.message",
                        IsEqual.equalTo("Successfully! Record has been added.")))
        );
    }


    @When("The user need removal an employee from the database")
    public void the_user_need_removal_an_employee_from_the_database() {
        user.attemptsTo(
                DeleteEmployee.withData(2)
        );
    }

    @Then("employee removal was successful")
    public void employee_removal_was_successful() {
        user.should(
                seeThat("the response code", new ResponseCode(), equalTo(200)),
                seeThat("Removal employee response", ResponseCode.was(), notNullValue()),
                seeThatResponse(" The user can see Successfully! Record has been deleted",
                        response -> response.body("data.message",
                                IsEqual.equalTo("Successfully! Record has been deleted")))
        );
    }
}