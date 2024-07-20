import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    public static void main(String[] args) {
        List<Human> family = new ArrayList<>();

        Human vasiliy = new Human(0, "Василий", Gender.MALE, 60);
        Human mariya = new Human(1, "Мария", Gender.FEMALE, 58);
        Human kristina = new Human(2, "Кристина", Gender.FEMALE, 36);
        Human semen = new Human(3, "Семен", Gender.MALE, 33);
        Human larisa = new Human(4, "Лариса", Gender.FEMALE, 78);

        vasiliy.spouse = mariya;
        mariya.spouse = vasiliy;
        vasiliy.mother = larisa;
        kristina.mother = mariya;
        kristina.father = vasiliy;
        semen.mother = mariya;
        semen.father = vasiliy;

        vasiliy.children.add(kristina);
        vasiliy.children.add(semen);
        mariya.children.add(kristina);
        mariya.children.add(semen);
        larisa.children.add(vasiliy);

        family.add(vasiliy);
        family.add(mariya);
        family.add(kristina);
        family.add(semen);
        family.add(larisa);

        System.out.println("В дереве " + family.size() + " объектов:");
        for (Human human : family) {
            System.out.println(human);
        }
    }
}