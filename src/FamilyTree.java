
import java.util.LinkedList;


public class FamilyTree {
LinkedList<Family> familys = new LinkedList<>();
   
public FamilyTree (){
    }

public void addNewFamily(Family e){
    familys.add(e);
} 
public void showTree(){
    for (Family e : familys) {
        System.out.println(String.format("Семья: %s", e.family));
        e.showFamily();
    }
}

}
