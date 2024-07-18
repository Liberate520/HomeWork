import java.util.ArrayList;

public class FamilyTree {
    int ID;
    String FamilyName;
    int countPeople;
    ArrayList<Human> HumansFamily;

    public FamilyTree(int ID, String FamilyName, ArrayList<Human> HumansFamily){
        this.FamilyName = FamilyName;
        this.HumansFamily = HumansFamily;
        this.countPeople = HumansFamily.size();
        
    }

    @Override
    public String toString() {
        
        return String.format("\nID Семьи: %d\nФамилия семьи: %s\nКоличество людей: %d", ID, FamilyName, countPeople);
    }
   
   

    
}
