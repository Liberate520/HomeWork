import java.io.IOException;
import java.io.Serializable;
import java.io.*;
import java.util.Collections;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        FamilyTree<Human> familyTree = new FamilyTree<>();
        //      FamilyTree <Cats>  catsFamilyTree= new FamilyTree<>();

        //разкомментировать для создания файла backup ниже
      //  Human h1 = new Human("Ivan", "Male", 66);
      //  Human h2 = new Human("Ola", "FeMale", 62);
      //  Human h3 = new Human("Sana", "Male", 44, h1, h2);
      //  Human h4 = new Human("Kola", "Male", 45, h1, h2);
      //  Human h5 = new Human("Tana", "FeMale", 23, h1, h2);
      //  Human h6 = new Human("Dasha", "FeMale", 6, h3, h5);
      //  Cats c1 = new Cats("Vaska", "Male",2);
      //  Cats c2 = new Cats("Milka", "FeMale",1);
      //  Cats c3 = new Cats("Murka", "FeMale",5);
      //  Cats c4 = new Cats("Kotic", "Male",7);
      //  Cats c5 = new Cats("Barni", "Male",6);
      //  familyTree.addHuman(h1);
      //  familyTree.addHuman(h2);
      //  familyTree.addHuman(h3);
      //  familyTree.addHuman(h4);
      //  familyTree.addHuman(h5);
      //  familyTree.addHuman(h6);
      //  familyTree.addCat(c1);
      //  familyTree.addCat(c2);
      //  familyTree.addCat(c3);
      //  familyTree.addCat(c4);
      //  familyTree.addCat(c5);

        familyTree.write(); // запись файла
        familyTree.read(); // чтение файла
        familyTree.printAllTree();  // печать всех членов дерева
//
//        System.out.println("Поиск по имени человека ");
//        System.out.println(familyTree.findByName("Ola").toString());
//        System.out.println(familyTree.findChild(familyTree.findByName("Ola")));
//        System.out.println(familyTree.findParents(familyTree.findByName("Ola")));
//        System.out.println(" ");
//        System.out.println("Поиск по имени человека ");
//        System.out.println(familyTree.findByName("Tana").toString());
//        System.out.println(familyTree.findChild(familyTree.findByName("Tana")));
//        System.out.println(familyTree.findParents(familyTree.findByName("Tana")));

//        System.out.println("Исходный список");
//        for (Object human :  familyTree){
//            System.out.println(human); }

        System.out.println("Сортировка по возрасту");
        familyTree.sortingByAge();
        for (Object human :  familyTree){
          System.out.println(human); }

         System.out.println("Сортировка по имени");
         familyTree.sortingByName();

         for (Human human :  familyTree){
           System.out.println(human); }


    }

}



