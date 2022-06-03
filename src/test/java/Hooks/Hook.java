package Hooks;


import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hook {
    @Before("@get")
    public void beforeHook(){
        System.out.println("*****************Execution before stage*******************");
    }

    @After("@get")
    public void afterHook(){
        System.out.println("*****************Execution after stage*******************");
    }
}
