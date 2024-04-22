import Model.FamilyTree.FamilyTree;
import Model.Human.Human;
import Model.Human.Gender;
import Model.Service.Service;
import Model.Writer.FileHandler;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
public class Main {

    public static void main(String[] args) {
        String filePath = "src\\familyTree.txt";
        Human dima = new Human("Dmitry",
                "Yermoshin",
                Gender.male,
                LocalDate.of(2012, 12, 23));
        Human daniil = new Human("Daniil",
                "Yermoshin", Gender.male,
                LocalDate.of(1984, 8, 28));
        daniil.setChildren(dima);
        dima.addParent(daniil);
        System.out.println(dima.getInfo());
        System.out.println(daniil.getInfo());
        System.out.println(daniil.getChildren());
        Human alina = new Human("Alina",
                "Yermoshina",
                Gender.female,
                LocalDate.of(1986, 10, 8));
        Human yulia = new Human("Yulia", "Yermoshina",
                Gender.female, LocalDate.of(2018, 2, 7));
        daniil.setChildren(yulia);
        alina.setChildren(yulia);
        dima.addParent(alina);
        Service service = new Service();
//        FamilyTree familyTree = new FamilyTree();
        Human tatyana1 = new Human("Tatyana", "Yermoshina",
                Gender.female, LocalDate.of(1950, 7, 24));
        Human tatyana2 = new Human("Tatyana", "Kuznetsova",
                Gender.female, LocalDate.of(1961, 7, 14));
        Human fedor = new Human("Fedor", "Yermoshin",
                Gender.male, LocalDate.of(1946, 6, 3));
        Human alexander = new Human("Alexander", "Kuznetsov",
                Gender.male, LocalDate.of(1965, 10, 11));
        Human alexey = new Human("Alexey", "Yermoshin",
                Gender.male, LocalDate.of(1989, 1, 31));
        Human kirill = new Human("Kirill", "Yermoshin",
                Gender.male, LocalDate.of(1982, 3, 29));
        Human pavel = new Human("Pavel", "Yermoshin",
                Gender.male, LocalDate.of(1979, 11, 15));
        boolean x = tatyana1.setChildren(daniil);
        x = fedor.setChildren(daniil);
        x = tatyana1.setChildren(alexey);
        x = fedor.setChildren(alexey);
        x = tatyana1.setChildren(kirill);
        x = fedor.setChildren(kirill);
        x = tatyana1.setChildren(pavel);
        x = fedor.setChildren(pavel);
        x = tatyana2.setChildren(alina);
        x = alexander.setChildren(alina);
        boolean y = Service.addLeaf(dima);
        y = Service.addLeaf(yulia);
        y = Service.addLeaf(alina);
        y = Service.addLeaf(daniil);
        y = Service.addLeaf(kirill);
        y = Service.addLeaf(pavel);
        y = Service.addLeaf(alexey);
        y = Service.addLeaf(fedor);
        y = Service.addLeaf(tatyana1);
        y = Service.addLeaf(tatyana2);
        y = Service.addLeaf(alexander);
        boolean z = service.setWedding(daniil, alina);
        z = service.setWedding(tatyana1, fedor);
        z = service.setWedding(tatyana2, alexander);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        Service.saveTree(service.familyTree, filePath);
        for (Object human: service.familyTree){
            System.out.println(human);
        }
        service.familyTree.sortByAge();
        System.out.println();
        System.out.println(service.familyTree);
        service.familyTree.sortByAgeRevers();
        System.out.println();
        System.out.println(service.familyTree);
    }

}