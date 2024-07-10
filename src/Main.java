import Writer.FileHandler;
import family_tree.FamilyTree;
import human.Gender;
import human.Human;

import java.io.Serializable;
import java.time.LocalDate;

public class Main {
        public static void main(String[] args) {
            FamilyTree myTree = new FamilyTree();


            //Реализовать, с учетом ооп подхода, приложение.
            //Для проведения исследований с генеалогическим древом.
            //Идея: описать некоторое количество компонент, например:
            //модель человека и дерева
            //Под “проведением исследования” можно понимать например получение всех детей выбранного человека.
//            FamilyTree myTree = new FamilyTree();
            Human human1 = new Human("Aнна", Gender.Female, LocalDate.of(1913, 12, 6));
            Human human2 = new Human("Афанасий",Gender.Male, LocalDate.of(1923, 5, 18));
            Human human3 = new Human("Чучуня",Gender.Male, LocalDate.of(1943, 4, 30));


            myTree.addHuman(human1);
            myTree.addHuman(human2);
            myTree.addHuman(human3);
            myTree.setWedding(human1,human2);
            myTree.setFamily(human1,human3);
            human2.addChild(human3);
            Human human4 = new Human("Ольга",Gender.Female, LocalDate.of(1950, 9, 3));
            myTree.setFamily(human2,human4);
            //System.out.println(myTree);

            SaveTree(myTree);
            FamilyTree tree = LoadTree();
            System.out.println(tree);



        }




    private static FamilyTree LoadTree(){
        FileHandler fileHandler = new FileHandler();
        return  (FamilyTree) fileHandler.Load();
    }
    private static void SaveTree(FamilyTree tree) {
        FileHandler fileHandler = new FileHandler();
        fileHandler.Save(tree);
    }
    }

