package Task;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class GetEmployee implements Task {

    private final int page;

    public GetEmployee(int page) {
        this.page = page;
    }

    public static Performable fromPage(int page){
        return instrumented(GetEmployee.class,page);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Get.resource("/v1/employee/"+page).with(requestSpecification
                        -> requestSpecification.contentType(ContentType.JSON)
                        .header("Accept-Encoding","gzip, deflate, br"))
    );
    }
}
