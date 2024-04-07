package src;

import java.time.LocalDate;

public class main {
    public static void main(String[] args) {
        Person vania = new Person("Ваня",Gender.male,LocalDate.of(1986, 10, 16));
        Person any = new Person("Аня", Gender.female, LocalDate.of(1987, 9, 5));
        // vania.setDateD(LocalDate.of(2022, 5, 22));
        Person ura = new Person("Юра",Gender.male,LocalDate.of(2010, 12, 17));
        vania.setChild(ura);
        any.setChild(ura);

        FamilyTree ft = new FamilyTree();

        ft.addPerson(any);
        ft.addPerson(vania);
        ft.addPerson(ura);
        System.out.println(ft.printList());
    }    
}
