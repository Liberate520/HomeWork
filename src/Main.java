public class Main {
    public static void main (String[] args) {
        FamilyTree familyTree = new FamilyTree();
        Human vladimir = new Human("Vladimir");
        Human larisa = new Human("Larisa");
        Human alyona = new Human("Alyona");
        Human oksana = new Human("Oksana");
        Human timur = new Human("Timur");
        Human semen = new Human("Semen");

        alyona.setMother(larisa);
        alyona.setFather(vladimir);
        oksana.setFather(vladimir);
        timur.setMother(oksana);
        semen.setMother(alyona);

        vladimir.addChild(alyona);
        vladimir.addChild(oksana);
        oksana.addChild(timur);
        larisa.addChild(oksana);

        familyTree.addHuman(vladimir);
        familyTree.addHuman(larisa);
        familyTree.addHuman(alyona);
        familyTree.addHuman(oksana);
        familyTree.addHuman(timur);
        familyTree.addHuman(semen);

        Plant plant = new Plant(familyTree);

        System.out.println("Vladimir's children: " + plant.getChildren("Vladimir"));
        System.out.println("Alyona's parents: " + java.util.Arrays.toString(plant.getParents("Alyona")));
        System.out.println("Oksana's siblings: " + plant.getSiblings("Oksana"));
    }
}
