import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        FamilyTree tree = new FamilyTree(); //Тут создается семеное древо

        //Далее создаем людей
        HumanInfo viserys = new HumanInfo("Viserys", LocalDate.of(1770, 1, 1), Gender.MALE);
        HumanInfo aemma = new HumanInfo("Aemma", LocalDate.of(1775, 2, 15), LocalDate.of(1810, 5, 5), Gender.FEMALE);
        HumanInfo alisanta = new HumanInfo("Alisanta", LocalDate.of(1795, 3, 10), Gender.FEMALE);
        HumanInfo rhaenyra = new HumanInfo("Rhaenyra", LocalDate.of(1796, 4, 20), Gender.FEMALE);
        HumanInfo aegon = new HumanInfo("Aegon", LocalDate.of(1800, 5, 25), Gender.MALE);
        HumanInfo aemond = new HumanInfo("Aemond", LocalDate.of(1802, 6, 30), Gender.MALE);
        HumanInfo helaena = new HumanInfo("Helaena", LocalDate.of(1804, 7, 15), Gender.FEMALE);

        viserys.addChild(rhaenyra);
        viserys.addChild(aegon);
        viserys.addChild(aemond);
        viserys.addChild(helaena);
        aemma.addChild(rhaenyra);
        alisanta.addChild(aegon);
        alisanta.addChild(aemond);
        alisanta.addChild(helaena);

        rhaenyra.setFather(viserys);
        rhaenyra.setMother(aemma);
        aegon.setFather(viserys);
        aegon.setMother(alisanta);
        aemond.setFather(viserys);
        aemond.setMother(alisanta);
        helaena.setFather(viserys);
        helaena.setMother(alisanta);

        // Добавление людей в дерево
        tree.addPerson(viserys);
        tree.addPerson(aemma);
        tree.addPerson(alisanta);
        tree.addPerson(rhaenyra);
        tree.addPerson(aegon);
        tree.addPerson(aemond);
        tree.addPerson(helaena);

        List<HumanInfo> childrenOfViserys = tree.getChildrenOfPerson("Viserys");

        // Вывод результатов исследования
        System.out.println("Children of Viserys:");
        for (HumanInfo child : childrenOfViserys) {
            System.out.println(child.getName() + ", DOB: " + child.getDob() + ", DOD: " + (child.getDod() != null ? child.getDod() : "N/A") + ", Gender: " + child.getGender());
        }
    }
}
