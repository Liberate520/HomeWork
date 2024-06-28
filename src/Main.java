public class Main {
    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree();

        Person ivan = new Person("Иван", "01.03.1980", Gender.MALE);
        Person anna = new Person("Анна", "15.07.1982", Gender.FEMALE);
        Person sergey = new Person("Сергей", "10.12.2005", Gender.MALE);
        Person olga = new Person("Ольга", "20.05.2007", Gender.FEMALE);
        Person nadya = new Person("Надя", "20.05.2017", Gender.FEMALE);

        ivan.addChild(sergey);
        ivan.addChild(olga);
        anna.addChild(sergey);
        anna.addChild(olga);
        ivan.addChild(nadya);
        anna.addChild(nadya);

        familyTree.addPerson(ivan);
        familyTree.addPerson(anna);
        familyTree.addPerson(sergey);
        familyTree.addPerson(olga);
        familyTree.addPerson(nadya);

        familyTree.printFamilyTree();
    }
}
