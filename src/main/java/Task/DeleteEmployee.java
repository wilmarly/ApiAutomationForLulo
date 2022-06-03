package Task;


import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Delete;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class DeleteEmployee implements Task {

    private final int data;

    public DeleteEmployee(int data){
        this.data = data;
    }

    public static Performable withData(int data) {
        return instrumented(DeleteEmployee.class,data);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Delete.from("/v1/delete/"+data).with(requestSpecification -> requestSpecification
                        .contentType(ContentType.JSON))
        );

    }
}
