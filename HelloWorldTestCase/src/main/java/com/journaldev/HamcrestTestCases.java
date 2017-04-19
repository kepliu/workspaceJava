package com.journaldev;
 
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matcher.*;
import org.hamcrest.core.StringContains;
import org.hamcrest.object.IsCompatibleType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
 
//import org.hamcrest.object..IsCompatibleType;
import org.junit.Test;
 
public class HamcrestTestCases {
 
    @Test
    public void testStartWith(){
 
        // Create Employee instance
        Employee employee = new Employee();
 
        // Using assertThat to evaluate specific matcher
        assertThat(employee.getName(), org.hamcrest.core.StringStartsWith.startsWith("Empty"));
    }
 
    @Test
    public void testEndsWith(){
 
        // Create Employee instance
        Employee employee = new Employee();
 
        // Using assertThat to evaluate specific matcher
        assertThat(employee.getName(), org.hamcrest.core.StringEndsWith.endsWith("Name"));
    }   
 
    @Test
    public void testContainsWith(){
 
        // Create Employee instance
        Employee employee = new Employee();
 
        // Using assertThat to evaluate specific matcher
        assertThat(employee.getName(), StringContains.containsString("y N"));
    }   
 
    @Test
    public void testEqualToIgnoringCase(){
        // Create Employee instance
        Employee employee = new Employee();
 
        // Using assertThat to evaluate specific matcher
        assertThat(employee.getName(), org.hamcrest.text.IsEqualIgnoringCase.equalToIgnoringCase("eMpTy NaMe"));
    }
 
    @Test
    public void testEqualToIgnoringWhiteSpace(){
        // Create Employee instance
        Employee employee = new Employee();
 
        // Using assertThat to evaluate specific matcher
        assertThat(employee.getName(),  org.hamcrest.text.IsEqualIgnoringWhiteSpace.equalToIgnoringWhiteSpace("    Empty       Name       "));
    }   
 
    @Test
    public void testhasItem(){
        // Create Employee instance
        Employee employee = new Employee();
 
        // Create employees list
        List<Employee> employees = new ArrayList<Employee>();
 
        // Add employee
        employees.add(employee);
 
        // Using assertThat to evaluate specific matcher
        assertThat(employees,org.hamcrest.Matchers.hasItem(employee));
    }   
 
    @Test
    public void testhasItems(){
        // Create Employee instance
        Employee employee1 = new Employee();
 
        // Create Employee instance
        Employee employee2 = new Employee();        
 
        // Create employees list
        List<Employee> employees = new ArrayList<Employee>();
 
        // Add employee
        employees.add(employee1);
 
        // Add employee
        employees.add(employee2);
 
        // Using assertThat to evaluate specific matcher
        assertThat(employees,org.hamcrest.Matchers.hasItems(employee1,employee2));
    }   
 
    @Test
    public void testhasEntry(){
        // Create Employee instance
        Employee employee1 = new Employee();
 
        employee1.setName("Mohammad");
 
        // Create a Map
        HashMap<String,Employee> employees = new HashMap<String,Employee>();
 
        // Add employee 1
        employees.put(employee1.getName(), employee1);
 
        // Assert
        assertThat(employees, org.hamcrest.Matchers.hasEntry(employee1.getName(), employee1));
    }   
 
    @Test
    public void testhasProperty(){
        // Create Employee instance
        Employee employee = new Employee();
 
        // Assert
        assertThat(employee, org.hamcrest.Matchers.hasProperty("name"));
    }   
 
    @Test
    public void testNotNull(){
        // Create Employee instance
        Employee employee = new Employee();
 
        // Assert
        assertThat(employee, org.hamcrest.Matchers.notNullValue());
    }   
 
    @Test
    public void testSameInstance(){
        // Create employee
        Employee employee = new Employee();
 
        // Declare another employee variable
        Employee employee2 = employee;
 
        // Assert
        assertThat(employee, org.hamcrest.Matchers.sameInstance(employee2));
    }
 
    @Test
    public void testInstanceOf(){
        // Create employee
        Employee employee = new Employee();
 
        // Assert
        assertThat(employee, org.hamcrest.Matchers.instanceOf(Person.class));
    }   
 
    @Test
    public void testNotInstanceOf(){
        // Create employee
        Person person = new Person();
 
        // Assert
        assertThat(person, org.hamcrest.Matchers.not(org.hamcrest.Matchers.instanceOf(Employee.class)));
    }
 
    @Test
    public void testIsCompatibleType(){
 
        // Create isCompatible Matcher
        IsCompatibleType<Person> isPersonCompatible = new IsCompatibleType<Person>(Person.class);
 
        // Create isCompatible Matcher
        IsCompatibleType<Employee> isEmployeeCompatible = new IsCompatibleType<Employee>(Employee.class);
 
        // Assert; Employee class definition is compatible (instance) with/of Person
        assertThat(Employee.class,isPersonCompatible);
 
        // Assert; Person class definition is compatible (instance) with/of Person
        assertThat(Person.class,isPersonCompatible);
 
        // Assert; Person class definition is not compatible (instance) with/of Employee
        assertThat(Person.class,org.hamcrest.Matchers.not(isEmployeeCompatible));
    }
 
    @Test
    public void testIsNotCompatibleType(){
 
        // Create isCompatible Matcher
        IsCompatibleType<String> isNotCompatible = new IsCompatibleType<String>(String.class);
 
        // Assert; employee class definition isn't compatible/instance with/of String
        assertThat(Employee.class,org.hamcrest.Matchers.not(isNotCompatible));
    }
 
    @Test
    public void testAnyOf(){
 
        // Create isCompatible Matcher
        IsCompatibleType<Person> isPersonCompatible = new IsCompatibleType<Person>(Person.class);
 
        // Create isCompatible Matcher
        IsCompatibleType<Employee> isEmployeeCompatible = new IsCompatibleType<Employee>(Employee.class);
 
        // Assert; employee class is instance of Person OR employee
        assertThat(Employee.class,org.hamcrest.Matchers.anyOf(isPersonCompatible,isEmployeeCompatible));
    }
 
    @Test
    public void testAllOf(){
 
        // Create isCompatible Matcher
        IsCompatibleType<Person> isPersonCompatible = new IsCompatibleType<Person>(Person.class);
 
        // Create isCompatible Matcher
        IsCompatibleType<Employee> isEmployeeCompatible = new IsCompatibleType<Employee>(Employee.class);
 
        // Assert; Person class is an instance of Person AND not of Employee
        assertThat(Person.class,org.hamcrest.Matchers.allOf(isPersonCompatible,org.hamcrest.Matchers.not(isEmployeeCompatible)));
    }                   
 
}
 
class Person {
 
    private String type;
 
    public String getType() {
        return type;
    }
 
    public void setType(String type) {
        this.type = type;
    }
 
}
 
class Employee extends Person{
 
    private int id = 0;
    private String name = "Empty Name";
 
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
 
}