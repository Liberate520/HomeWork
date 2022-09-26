import java.util.List;

public class Main {
    public static void main(String[] args) {

        FamilyTree tree = new FamilyTree(); //Тут создается семеное древо

        //Далее создаем людей
        HumanInfo Viseris = new HumanInfo("Viseris", 50);
        HumanInfo Aemma = new HumanInfo("Aema", 40);
        HumanInfo Alisanta = new HumanInfo("Alisanta", 20);
        HumanInfo Rhaenyra = new HumanInfo("Rhanyra", 20);
        HumanInfo Aegon = new HumanInfo("Aegon", 5);
        HumanInfo Aemond = new HumanInfo("Aemond", 3);
        HumanInfo Helaena = new HumanInfo("Helaena", 2);

        Viseris.addChild(Rhaenyra); //тут и далее установка родительских связей
        Viseris.addChild(Aegon);
        Viseris.addChild(Aemond);
        Viseris.addChild(Helaena);
        Aemma.addChild(Rhaenyra);
        Alisanta.addChild(Aegon);
        Alisanta.addChild(Aemond);
        Alisanta.addChild(Helaena);

        tree.addPerson(Viseris); //тут и далее добавление людей в древо
        tree.addPerson(Aemma);
        tree.addPerson(Alisanta);
        tree.addPerson(Rhaenyra);
        tree.addPerson(Aegon);
        tree.addPerson(Aemond);
        tree.addPerson(Helaena);

        List<HumanInfo> childrenOfViseris = tree.getChildrenOfPerson("Viseris");

        System.out.println("Children of Viseris: ");
        for (HumanInfo child : childrenOfViseris) {
            System.out.println(child.getName() + ", Age: " + child.getAge());
        }
    }
}
