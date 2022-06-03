import Facts.InfoEmployees;
import Questions.RespBodyEmployees;
import Questions.ResponseCode;
import Task.CreateEmployee;
import Task.DeleteEmployee;
import Task.GetEmployees;
import models.Data;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;


import org.junit.Test;
import org.junit.runner.RunWith;

import Task.GetEmployee;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SerenityRunner.class)
public class IT {
    private final String restApiUrl="http://dummy.restapiexample.com/api";


    @Test
    public void getEmployee() {
        Actor Wilmar = Actor.named("Wilmar the TAE")
                .whoCan(CallAnApi.at(restApiUrl));

        Wilmar.attemptsTo(
                GetEmployee.fromPage(1)
        );

        Wilmar.should(
                seeThat("the response code", new ResponseCode(), equalTo(200))
        );
    }

    @Test
    public void getEmployees(){
        Actor Wilmar = Actor.named("Wilmar the TAE").whoCan(CallAnApi.at(restApiUrl));
        Wilmar.attemptsTo(
                GetEmployees.fromAllPages()
        );

        Wilmar.should(seeThat("the response code",ResponseCode.was(), equalTo(200)));

        Data employee = new RespBodyEmployees().answeredBy(Wilmar)
                .getData().stream().filter(x -> x.getId().equals(1)).findFirst().orElse(null);

    }



    @Test
    public void CreateEmployee(){
        Actor Wilmar = Actor.named("Wilmar the TAE")
                .whoCan(CallAnApi.at(restApiUrl));

        Wilmar.attemptsTo(
                CreateEmployee.withGenericData()
        );

        Wilmar.should(
                seeThat("the response code", new ResponseCode(), equalTo(200))
        );
    }

    @Test
    public void DeleteEmployee(){
        Actor Wilmar = Actor.named("Wilmar the TAE")
                .whoCan(CallAnApi.at(restApiUrl));

        Wilmar.attemptsTo(
                DeleteEmployee.withData(2)
        );
        Wilmar.should(
                seeThat("the response code", new ResponseCode(), equalTo(200))
        );
    }

    @Test
    public void factTest(){
        Actor Wilmar = Actor.named("Wilmar the TAE")
                .whoCan(CallAnApi.at(restApiUrl));

        Wilmar.has(InfoEmployees.toViewInfo());

        Wilmar.should(
              seeThat("the response code", new ResponseCode(), equalTo(200)));
    }
}
