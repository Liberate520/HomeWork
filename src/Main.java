import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
//        TreeFamily treeFamily = new TreeFamily("Ивановы");
//        Human human1 = new Human("Иван", Gender.Male, LocalDate.of(1967, 01, 23),
//                LocalDate.of(2022, 05, 04));
//        Human human2 = new Human("Мария", Gender.Female, LocalDate.of(1977, 03,15), null);
//        Human human3 = new Human("Александр ", Gender.Male, LocalDate.of(2001,04,15), null);
//        Human human4 = new Human("Ольга ", Gender.Female, LocalDate.of(2003,10,30), null);
//
//        treeFamily.add(human1);
//        treeFamily.add(human2);
//        treeFamily.add(human3);
//        treeFamily.add(human4);
//
//        human3.setMother(human2);
//        human4.setFather(human1);
//        human4.setMother(human2);
//
//        human2.addChildren(human3);
//        human2.addChildren(human4);

//        System.out.println(treeFamily);
//        System.out.println("****************************************");
//        human2.setDod(LocalDate.of(2023, 02, 28));
//        System.out.println(treeFamily);
//        System.out.println("****************************************");
//        System.out.println(human1.getDod());
//        System.out.println("****************************************");
//        System.out.println(human2.getDob());
//        System.out.println("****************************************");
//        System.out.println(human3.getMother());
//        System.out.println("****************************************");
//        System.out.println(human3.getFather());
//        System.out.println("****************************************");
//        System.out.println(human2.getChildren());
//    }
        FileHandler fileHandler = new FileHandler();
        String file= "src/tree.txt";


        TreeFamily treeFamily1 = (TreeFamily) fileHandler.read(file);


        System.out.println(treeFamily1);

//        fileHandler.save(treeFamily, file);


    }
}
