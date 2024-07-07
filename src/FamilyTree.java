public class FamilyTree {
    
    String nameFamily;
    int countPeople;

/**Создание семьи */
public FamilyTree(String nameFamily, int countPeople){
    this.nameFamily = nameFamily;
    this.countPeople = countPeople;

}






    @Override
    public String toString() {
        return String.format("\n\n\nСемья: %s, людей в семье: %s", nameFamily, countPeople);
    }
}





