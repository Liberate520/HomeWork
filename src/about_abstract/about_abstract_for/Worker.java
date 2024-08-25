package about_abstract.Iterator;

import java.util.ArrayList;
import java.util.List;

public class Worker {
    public String firstname;
    public String lastname;
    public int age;
    public int salary;

    public Worker(String firstname, String lastname, int age, int salary) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.salary = salary;
    }

    public String fullname (){
        return String.format("%s %s",firstname,lastname);
    }
}
