package family_tree;

import family_tree.help_classes.FamilyTreeItem;
import family_tree.help_classes.Gender;
import family_tree.program_classes.FamilyTree;
import family_tree.program_classes.Human;
import family_tree.saving_data.FileHandler;
import family_tree.services.RandomTreeService;
import family_tree.services.TreeService;

import java.time.LocalDate;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        //RandomTreeService rs = new RandomTreeService();
        //FamilyTree my_family = rs.CreateRandomTree();


        String filePath = "src/family_tree/saving_data/data.out";
        TreeService ts = new TreeService(filePath);
        //ts.saveDataFile(my_family);
        FamilyTree my_family_from_file = ts.loadDataFile();



        ts.PrintData(my_family_from_file);
        my_family_from_file.sortByName();
        ts.PrintData(my_family_from_file);
        my_family_from_file.sortBybirthDate();
        ts.PrintData(my_family_from_file);

        ArrayList<Human> find_by_name = my_family_from_file.findInfoByName("Имя 148");
        for (Human human : find_by_name) {
            System.out.println(human);
        }
        FamilyTreeItem find_by_doc = my_family_from_file.findInfoByDocument("doc19");
        FamilyTreeItem mother = my_family_from_file.findInfoByDocument("doc12");
        FamilyTreeItem father = my_family_from_file.findInfoByDocument("doc8");
        System.out.println(find_by_doc);
        ts.PrintData(my_family_from_file);





        ts.saveDataFile(my_family_from_file);

    }







}
