import java.time.LocalDate;
public class Main {
    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree();
        Human person1 = new Human("Григорий","Рыжков");
        Human person2 = new Human("Семен","Григорьевич","Рыжков");
        Human person3 = new Human("Федор","Григорьевич","Рыжков");
        Human person4 = new Human("Ирина","Семеновна","Рыжкова",LocalDate.parse("1988-08-15"),Gender.Female);
        Human person5 = new Human("Федор","Григорьевич","Рыжков");

        person2.setFather(person1);
        person3.setFather(person1);
        person5.setFather(person1);
        person4.setFather(person2);

        System.out.println(person1.getChildren());
        System.out.println(person2.getChildren());

        familyTree.addHuman(person1);
        familyTree.addHuman(person2);
        familyTree.addHuman(person3);
        familyTree.addHuman(person4);

        System.out.println(familyTree.getTreeInfo());
        System.out.println(person5);

        FileHandler fh = new FileHandler();

        if (fh.write(familyTree,"FamilyTree.info")) System.out.println("Файл сохранен");
        else System.out.println("Ошибка сохранения файла");

        FamilyTree familyTree2 = (FamilyTree) fh.read("FamilyTree.info");

        System.out.println();
        System.out.println("Считанное из файла дерево:");
        if (familyTree2!=null) System.out.println(familyTree2.getTreeInfo());
    }

}


