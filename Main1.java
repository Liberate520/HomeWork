package PR.hW1Golubev;



public class Main1 {
    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree();

        Human ivan = new Human("Иван", "Иванов", "Мужчина");
        Human maria = new Human("Мария", "Иванова", "Женщина");
        Human alexei = new Human("Алепшксей", "Иванов", "Мужчина");
        Human anna = new Human("Анна", "Иванова", "Женщина");

        familyTree.addParentChildRelationship(ivan, alexei);
        familyTree.addParentChildRelationship(ivan, anna);
        familyTree.addParentChildRelationship(maria, alexei);
        familyTree.addParentChildRelationship(maria, anna);

        System.out.println("Дети Ивана Иванова:");
        for (Human child : familyTree.getChildren(ivan)) {
            System.out.println(child);
        }

        System.out.println("\nДети Марии Ивановой:");
        for (Human child : familyTree.getChildren(maria)) {
            System.out.println(child);
        }

        System.out.println("\nБратья и сестры Алексея Иванова:");
        for (Human sibling : familyTree.getSiblings(alexei)) {
            System.out.println(sibling);
        }

        System.out.println("\nБратья и сестры Анны Ивановой:");
        for (Human sibling : familyTree.getSiblings(anna)) {
            System.out.println(sibling);
        }
    }
}