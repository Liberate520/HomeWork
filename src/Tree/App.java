package Tree;

public class App {
    public static void main(String[] args) {
        Tree tree = new Tree();
        Person pa = new Person("Vasiliy","Valetov", "Innokentievich","11/07/1940",
                Gender.Man);
        Person ma = new Person("Elena","Valetova", "Petrovna","24/03/1943",
                Gender.Female);
        Person so = new Person("Andrey","Valetov", "Vasilievich","30/10/1972",
                Gender.Man);
        Person dot = new Person("Tamara","Voynash", "Vasilevna","20/11/1966",
                Gender.Man);
        Person vot = new Person("Tamara","Voynash", "Vasilevna","20/11/1966",
                Gender.Man);


        tree.addLink(pa,ma,Relations.Husband,Relations.Wife);
        tree.addLink(pa,so,Relations.Father,Relations.Son);
        tree.addLink(pa,dot,Relations.Father,Relations.Daughter);
        tree.addLink(ma,so,Relations.Mother,Relations.Son);
        tree.addLink(ma,dot,Relations.Mother,Relations.Daughter);
        tree.addLink(so,dot,Relations.Brother,Relations.Sister);
        tree.addLink(vot,dot,Relations.Brother,Relations.Sister);

        System.out.println("-------------------\n");
        System.out.println(tree);
        System.out.println("-------------------\n");
//        Research.getRelation(pa,tree);
//        System.out.println("-------------------\n");
//        Research.getRelation(dot,tree);
//        System.out.println("-------------------\n");
//        Research.getRelation(dot,tree);
        System.out.println("-------------------\n");
        Research.getRelation(Relations.Sister, tree);
        System.out.println("-------------------\n");
        Research.getRelation(vot, Relations.Father, tree);

    }
}