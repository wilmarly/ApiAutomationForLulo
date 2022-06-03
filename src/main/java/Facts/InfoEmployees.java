package Facts;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.facts.Fact;
import net.serenitybdd.screenplay.rest.interactions.Get;

import java.util.HashMap;
import java.util.List;

public class InfoEmployees implements Fact {

    private String dataInfo;

    public static InfoEmployees toViewInfo(){
        return new InfoEmployees();
    }

    @Override
    public void setup(Actor actor) {

        actor.attemptsTo(
                Get.resource("/v1/employees")
        );

        List<HashMap<String, String>> data = SerenityRest.lastResponse().path("data");

        actor.remember("data", data);

        dataInfo = data.toString();//list to string for print to report
    }

    public String toString(){
        return "The user's data are: " + dataInfo;
    }
}
