import Writer.FileHandler;
import family_tree.FamilyTree;
import human.Gender;
import human.Human;

import java.io.Serializable;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {


        Servise servise = new Servise();

        servise.addHuman("Aнна", Gender.Female, LocalDate.of(1913, 12, 6));
        servise.addHuman("Афанасий", Gender.Male, LocalDate.of(1923, 5, 18));
        servise.addHuman("Чучуня", Gender.Female, LocalDate.of(1943, 4, 30));
        //servise.addHuman("Иван", Gender.Male, LocalDate.of(1948, 2, 12));


        //System.out.println(servise.getHumansList());




        servise.addHuman("Иван", Gender.Male, LocalDate.of(1948, 2, 12));
        servise.SortByName();
        System.out.println(servise.GetInfoFamilyTree());
        servise.SortBybrthDate();
        System.out.println(servise.GetInfoFamilyTree());







    }





//    private static FamilyTree LoadTree(){
//        FileHandler fileHandler = new FileHandler();
//        return  (FamilyTree) fileHandler.Load();
//    }
//    private static void SaveTree(FamilyTree tree) {
//        FileHandler fileHandler = new FileHandler();
//        fileHandler.Save(tree);
//    }
    }

