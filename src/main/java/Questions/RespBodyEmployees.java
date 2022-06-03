package Questions;

import models.Employee;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class RespBodyEmployees implements Question {

    public static Question was(){
        return new RespBodyEmployees();
    }
    @Override
    public Employee answeredBy(Actor actor) {
        return SerenityRest.lastResponse().as(Employee.class);
    }
}

