import java.time.LocalDate;

import Family_tree.Model.Humans.*;
import Family_tree.Model.Tree.Family_tree;

public class Main {
    

    public static void main(String[] args){
      
      Family_tree<Human> tree = new Family_tree<Human>("Волковы");
      Human Volkov = new Human("Александр", Gender.Male, LocalDate.of(1972,1,2));
      Human Volkova = new Human("Александра", Gender.Female, LocalDate.of(1974,1,12));
      tree.add(Volkova);
      tree.add(Volkov);
      tree.add(Volkova);
      System.out.println(tree.getInfo());
      tree.remove(1);
      System.out.println(tree.getInfo());
    }


}
