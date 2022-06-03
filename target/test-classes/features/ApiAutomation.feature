@RunAllAutomationTest
Feature: Employees API automation test
  The user must be able to consult, create and delete employees

  Background:
  Given The user accesses to the resource

@Get
  Scenario: The user can consult the data of an employee
    When The user searches for an employee in the database
    Then the requested data is returned successfully

@GetAll
  Scenario: The user can consult the data of multiple employees
    When The user searches for multiple employees in the database
    Then the requested for multiple data is returned successfully

@Create
  Scenario: The user can create an employee
    When The user need create an employee in the database
    Then employee creation was successful

@Delete
  Scenario: The user can delete an employee
    When The user need removal an employee from the database
    Then employee removal was successful
