import java.util.List;

public class Main {
    public static void main(String[] args) {
        GenealogyTree tree = new GenealogyTree();

        Person nikolay = new Person("Nikolay", Gender.MALE);
        Person maryna = new Person("Maryna", Gender.FEMALE);
        Person albert = new Person("Albert", Gender.MALE);
        Person alina = new Person("Alina", Gender.FEMALE);

        nikolay.addChild(albert);
        nikolay.addChild(alina);
        maryna.addChild(albert);
        maryna.addChild(alina);

        albert.setFather();
        albert.setMother();
        alina.setFather();
        alina.setMother();

        tree.addPerson(nikolay);
        tree.addPerson(maryna);
        tree.addPerson(albert);
        tree.addPerson(alina);

        List<Person> NikolayAndMaryna = tree.getChildren(nikolay);
        System.out.println("Children of Nikolay And Maryna:");
        for (Person child : NikolayAndMaryna) {
            System.out.println(child.getName());
        }
    }
}