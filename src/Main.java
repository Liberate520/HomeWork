
import java.io.IOException;
import Family_tree.Model.Humans.*;
import Family_tree.View.*;

public class Main {
    

    public static void main(String[] args) throws IOException {
      
      System.out.println("_________________________________________________");
      HumanManager humanManager = new HumanManager(null);
      System.out.println(humanManager.getInDependentList());
      System.out.println("_________________________________________________");
      System.out.println(humanManager.getTreeDependentList());
      System.out.println("_________________________________________________");
      System.out.println(humanManager.getelementDependentList());
      System.out.println("_________________________________________________");
      System.out.println(humanManager.getFullDependentList());
    }
}