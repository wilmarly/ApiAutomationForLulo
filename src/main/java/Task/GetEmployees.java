package Task;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;


import static net.serenitybdd.screenplay.Tasks.instrumented;

public class GetEmployees implements Task {

    public GetEmployees() {
    }

    public static Performable fromAllPages(){

        return instrumented(GetEmployees.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Get.resource("/v1/employees").with(requestSpecification
                        -> requestSpecification.contentType(ContentType.JSON)
                        .header("Accept-Encoding","gzip, deflate, br"))
        );
    }
}
