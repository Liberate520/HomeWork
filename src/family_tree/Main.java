package family_tree;

import family_tree.family_tree.FamilyTree;
import family_tree.human.Gender;
import family_tree.human.Human;

import java.time.LocalDate;

public class Main {
   public static void main(String[] args){
       FamilyTree tree = new FamilyTree();
       Human sheet1 = new Human("Андрей", Gender.Male, LocalDate.of(1974,4,17));
       Human sheet2 = new Human("Алена", Gender.Female, LocalDate.of(1974,4,1));
       tree.add(sheet1);
       tree.add(sheet2);
       Human sheet3 = new Human("Миша", Gender.Male, LocalDate.of(2008,8,14),sheet2,sheet1);
       tree.add(sheet3);

       System.out.println(tree);
   }
}
