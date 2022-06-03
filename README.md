# ApiAutomation

In this project you will find an automated test solution to perform basic behavior validations on a generic example rest API.
The verbs that were taken into account are:

# Get:
 ```sh
http://dummy.restapiexample.com/api/v1/employees
```

# Post:
 ```sh
http://dummy.restapiexample.com/api/v1/create
```


# Get:
 ```sh
http://dummy.restapiexample.com/api/v1/create
```

# Delete:
 ```sh
http://dummy.restapiexample.com/public/api/v1/delete/2
```


## Technologies

* [Lenguaje: Java ](https://java.com/es/)
* [Framework: Serenity-Rest](https://serenity-bdd.github.io/theserenitybook/latest/serenity-screenplay-rest.html)
* [Dependency Orchestrator: Maven](https://maven.apache.org)
* [Runner: JUnit](https://junit.org/junit5/)
* [Pattern Design: ScreenPlay](https://johnfergusonsmart.com/better-automated-acceptance-tests-serenity-screenplay/)
* [Matchers: Hamcrest](http://hamcrest.org/)

## Running

1. Cloning of repository
 `$ git clone url`
2. Install packages
   ```sh
   mvn install
   ```
   
## Serenity evidence

3. Execute
   ```sh
   mvn serenity:aggregate
   ```


## How to contribute

You need to be approved to make a pull request to the project
