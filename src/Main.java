import java.time.LocalDate;

import Family_tree.Model.HumanService;
import Family_tree.Model.Service;
import Family_tree.Model.Humans.*;
import Family_tree.Model.Tree.Family_tree;

public class Main {
    

    public static void main(String[] args){
      
      
      Human Volkov = new Human("Александр", Gender.Male, LocalDate.of(1972,1,2));
      Human Volkova = new Human("Александра", Gender.Female, LocalDate.of(1974,1,12));
      Service<Human> service= new HumanService();
      service.addTree("Волковы");
      service.setCurrentTree(0);
      Family_tree<Human> tree = service.getCurrentTree();
      service.getCurrentTree().add(Volkova);
      service.getCurrentTree().add(Volkov);       
      System.out.println(service.getCurrentTree().getCount());
      service.newChild(new Human("Лиза", Gender.Female, LocalDate.of(1992,3,3)), Volkov, Volkova);
      Human Petr = new Human("Piter", Gender.Male, LocalDate.now());
      service.newChild(Petr, Volkova, Volkov);
      System.out.println(service.getCurrentTree().getCount());
      service.getCurrentTree().remove(3);
      System.out.println(tree.getInfo());
      service.setMarriage(Volkov, Volkova);


      System.out.println(Volkov.getInfo());

    }


}
