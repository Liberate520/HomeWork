// import java.time.LocalDate;

// import ru.gb.family_tree.model.item.FamilyTreeItem;
// import ru.gb.family_tree.model.item.Gender;
// import ru.gb.family_tree.model.item.Human;
// import ru.gb.family_tree.model.service.Service;
import ru.gb.family_tree.view.ConsoleUI;
import ru.gb.family_tree.view.View;

public class Main {
    public static void main(String[] args) throws Exception {

        // System.out.print ("\033 [H\033 [2J");  
        // System.out.flush();               

        // // FamilyTree<Human> tree = new FamilyTree<>();

        // // String storage = "family_tree.out";

        // // Writable writable = new FileHandler(tree);

        // // tree = writable.read_object(storage);
        // // System.out.println("После чтения из файла:\n\n" + tree);

        // // Human vasya = new Human(1, "Василий", Gender.Male, LocalDate.of(1963, 12, 11));
        // // Human masha = new Human(2, "Мария", Gender.Female, LocalDate.of(1965, 9, 29));
        // // Human cristina = new Human(3, "Кристина", Gender.Female, LocalDate.of(1988, 6, 5));
        // // Human semyon = new Human(4, "Семён", Gender.Male, LocalDate.of(1991, 1, 12));

        // // tree.add(vasya);
        // // tree.add(masha);
        // // tree.setWedding(vasya.getId(), masha.getId());
        // // tree.add(cristina);
        // // tree.add(semyon);

        // // Human grandMother = new Human(5, "Лариса", Gender.Female, LocalDate.of(1945, 9, 5));
        // // grandMother.addChild(vasya);
        // // tree.add(grandMother);

        // // Human grandGrandFather = new Human(6, "Фёдор", Gender.Male, LocalDate.of(1915, 3, 15));
        // // grandGrandFather.addChild(grandMother);
        // // tree.add(grandGrandFather);

        // // /*writable.write_object(tree, storage);

        // // tree = writable.read_object(storage);*/

        // // tree.sortByAge();
        // // System.out.println("ПРОВЕРКА СОРТИРОВКИ ПО ВОЗРАСТУ\n");
        // // System.out.println(tree);

        // // tree.sortByName();
        // // System.out.println("ПРОВЕРКА СОРТИРОВКИ ПО ИМЕНИ\n");
        // // System.out.println(tree);

        // // tree.sortBySpouse();
        // // System.out.println("ПРОВЕРКА СОРТИРОВКИ ПО СЕМЕЙНОМУ ПОЛОЖЕНИЮ\n");
        // // System.out.println(tree);

        /*Service<Human> tree = new Service<>();

        tree.addItem("Василий", Gender.Male, LocalDate.of(1963, 12, 11));
        tree.addItem("Мария", Gender.Female, LocalDate.of(1965, 9, 29));
        tree.addItem("Кристина", Gender.Female, LocalDate.of(1988, 6, 5));
        tree.addItem("Семён", Gender.Male, LocalDate.of(1991, 1, 12));        
        tree.addItem("Люда", Gender.Female, LocalDate.of(1969, 10, 05));
        tree.addItem("Фрося", Gender.Female, LocalDate.of(1869, 10, 05));
        tree.addItem("Саид", Gender.Male, LocalDate.of(1949, 10, 05));
        tree.addItem("Иван Сергеевич", Gender.Male, LocalDate.of(1913, 10, 05));  
        
        System.out.println("ПОСЛЕ СОЗДАНИЯ:\n" + tree);  
        
        tree.setWedding(0, 1);  
        
        tree.addItem("Лариса", Gender.Female, LocalDate.of(1945, 9, 5));
        tree.getById(8).addChild(tree.getById(0));

        tree.addItem("Фёдор", Gender.Male, LocalDate.of(1915, 3, 15));
        tree.getById(9).addChild(tree.getById(8));        
        
        System.out.println("ПОСЛЕ ДОБАВЛЕНИЯ НОВЫХ ЧЛЕНОВ СЕМЬИ И РОДСТВЕННЫХ СВЯЗЕЙ:\n" + tree);        

        tree.saveTree();

        tree.readTree();
        System.out.println("ПОСЛЕ ЧТЕНИЯ ИЗ ФАЙЛА:\n" + tree);          

        tree.sortByAge();
        System.out.println("ПОСЛЕ СОРТИРОВКИ ПО ВОЗРАСТУ:\n" + tree);

        tree.sortByName();
        System.out.println("ПОСЛЕ СОРТИРОВКИ ПО ИМЕНИ:\n" + tree);

        tree.sortBySpouse();
        System.out.println("ПОСЛЕ СОРТИРОВКИ ПО СЕМЕЙНОМУ ПОЛОЖЕНИЮ:\n" + tree); */

        @SuppressWarnings("rawtypes")
        View view = new ConsoleUI();
        view.start();        

    }
}
