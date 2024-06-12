import java.time.LocalDate;

import Family_tree.Model.HumanService;
import Family_tree.Model.Service;
import Family_tree.Model.Humans.*;
import Family_tree.Model.Tree.Family_tree;
import Family_tree.View.*;

public class Main {
    

    public static void main(String[] args){
      
      
      Human Volkov = new Human("Александр", Gender.Male, LocalDate.of(1972,1,2));
      Human Volkova = new Human("Александра", Gender.Female, LocalDate.of(1974,1,12));
      View<Human> view = new HumanView();
      view.start();
      

    }


}
