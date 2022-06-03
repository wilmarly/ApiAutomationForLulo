package Task;


import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CreateEmployee implements Task {

    public CreateEmployee(){

    }
    public static Performable withGenericData(){
        return instrumented(CreateEmployee.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Post.to("/v1/create").with(
                        requestSpecification -> requestSpecification
                                .contentType(ContentType.JSON))


        );
    }
}







