package familyTree;

import familyTree.humans.Gender;
import familyTree.humans.Person;
import familyTree.tree.FamilyTree;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class Test {
    public static void main(String[] args) {
        Person mama = new Person("Mama Preanick", LocalDate.of(1977, 6, 29), null, Gender.Female, null, null);
        Person papa = new Person("DleaProverki Smerti", LocalDate.of(1977, 6, 29), LocalDate.of(2000, 1, 1), Gender.Male, null, null);
        Person ianPreanik = new Person("Ianik Preanick", LocalDate.of(2001, 6, 22), null, Gender.Male, mama, papa);
        Person child1 = new Person("RebenOK 1", LocalDate.of(2020, 1, 1), null, Gender.Male, null, ianPreanik);
        Person child2 = new Person("RebenOK 2", LocalDate.of(2021, 1, 1), null, Gender.Male, null, ianPreanik);
        Person child3 = new Person("RebenOK 3", LocalDate.of(2022, 1, 1), null, Gender.Male, null, ianPreanik);
        List<Person> children = new ArrayList<>();
        children.add(child1);
        children.add(child2);
        children.add(child3);
        ianPreanik.setChildren(children);

        FamilyTree familyTree = new FamilyTree(papa);
        familyTree.addFamilyMember(mama);
        familyTree.addFamilyMember(ianPreanik);
        familyTree.addFamilyMember(child1);
        familyTree.addFamilyMember(child2);
        familyTree.addFamilyMember(child3);
        List<Person> persons = new ArrayList<>(familyTree.findPerson("Ianik Preanick")); // Можно поиграться с именем, НО вернет null, если не найдет людей.



        System.out.println(persons.get(0));

    }
}
