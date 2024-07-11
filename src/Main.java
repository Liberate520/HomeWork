public class Main {
    public static void main(String[] args) {
        // Создаем генеалогическое древо
        FamilyTree familyTree1 = new FamilyTree();

        // Создаем родителей без указания их родителей
        Person harry = new Person("Harry", "Male", 88);
        Person emily = new Person("Emily", "Female", 81);

        Person charlie = new Person("Charlie", "Male", 83);
        Person ella = new Person("Ella", "Female", 77);

        // Создаем детей, указывая их родителей
        Person james = new Person("James", "Male", 39, harry, emily);
        Person jane = new Person("Jane", "Female", 34, charlie, ella);

        // Указываем отца и мать для James
        james.setFather(harry);
        james.setMother(emily);

        // Указываем отца и мать для Jane
        jane.setFather(charlie);
        jane.setMother(ella);

        // Создаем детей, указывая их родителей
        Person emma = new Person("Emma", "Female", 7, james, jane);
        Person michael  = new Person("Michael", "Male", 9, james, jane);
        Person thomas  = new Person("Thomas", "Male", 10, james, jane);

        // Добавляем ребенка к родителям(Harry, Emily)
        harry.addChild(james);
        emily.addChild(james);

        // Добавляем ребенка к родителям(Charlie, Ella)
        charlie.addChild(jane);
        ella.addChild(jane);

        // Добавляем детей к родителям(James, Jane)
        james.addChild(emma);
        james.addChild(michael);
        james.addChild(thomas);
        jane.addChild(emma);
        jane.addChild(michael);
        jane.addChild(thomas);

        // Добавляем людей в familyTree
        familyTree1.addPerson(harry); // Отец James'a
        familyTree1.addPerson(emily); // Мать James'a

        familyTree1.addPerson(charlie);  // Отец Jane
        familyTree1.addPerson(ella);     // Мать Jane

        familyTree1.addPerson(james); // Отец Emma, Michael
        familyTree1.addPerson(jane); // Мать Emma, Michael

        familyTree1.addPerson(emma); // Ребенок James, Jane
        familyTree1.addPerson(michael); // Ребенок James, Jane
        familyTree1.addPerson(thomas); // Ребенок James, Jane

        // Все дети James'a
        System.out.println("All children of James:");
        for (Person child : familyTree1.getAllChildren(james)) {
            System.out.println(child);
        }

        System.out.println();

        // Все дети Jane
        System.out.println("All children of Jane:");
        for (Person child : familyTree1.getAllChildren(jane)) {
            System.out.println(child);
        }

        // Поиск человека
        System.out.println(familyTree1.findPersonByName("William"));
        System.out.println();
        System.out.println(familyTree1.findPersonByName("James"));
        System.out.println();
        System.out.println(familyTree1.findPersonByName("Michael"));
        System.out.println();
        System.out.println(familyTree1.findPersonByName("Liam"));

        System.out.println();

        // Вывод матери James и отца Jane
        System.out.println(james.getMother());
        System.out.println(jane.getFather());

        System.out.println();

        // Вывод пола Michael и Jane
        System.out.println(michael.getGender());
        System.out.println(jane.getGender());

        System.out.println();

        // Вывод возраста James и Thomas
        System.out.println(james.getAge());
        System.out.println(thomas.getAge());

        System.out.println();

        // Вывод всех людей в familyTree
        System.out.println(familyTree1);

        System.out.println();

        // Вывод детей Harry
        System.out.println("Дети Harry - " + harry.getChildren());

        // Вывод детей Ella
        System.out.println("Дети Ella - " + ella.getChildren());

        // Вывод имени Michael
        System.out.println(michael.getName());
    }
}
