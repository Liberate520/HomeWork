public class Main {
    public static void main(String[] args) {

        GenealogyTree genealogyTree = new GenealogyTree();

        Person person1 = new Person("Сергей", 1964, Gender.Male);
        Person person2 = new Person("Светлана", 1964, Gender.Female);
        Person person3 = new Person("Алексей", 1985, Gender.Male);
        Person person4 = new Person("Никита", 1993, Gender.Male);

        genealogyTree.addPerson(person1);
        genealogyTree.addPerson(person2);
        genealogyTree.addPerson(person3);
        genealogyTree.addPerson(person4);


        person3.setFather(person1);
        person3.setMother(person2);
        person4.setFather(person1);
        person4.setMother(person2);

        System.out.println("Генеалогическое древо:");
        genealogyTree.printTree();
    }
}