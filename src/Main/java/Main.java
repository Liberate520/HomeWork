package Main.java;
import java.util.List;
import com.example.genealogy.model.Person;
import com.example.genealogy.service.GenealogyTree;

public class Main {

    public static void main(String[] args) {
        Person person1 = new Person("Иван", null);
        Person person2 = new Person("Алексей", person1);
        Person person3 = new Person("Екатерина", person1);

        GenealogyTree tree = new GenealogyTree(person1);


        tree.sortByName();
        List<Person> sortedByName = (List<Person>) tree;


        tree.sortByDateOfBirth();
        List<Person> sortedByDateOfBirth = (List<Person>) tree;


        for (Person person : sortedByName) {
            System.out.println(person.getName());
        }

        for (Person person : sortedByDateOfBirth) {
            System.out.println(person.getName());

        }
    }
}

