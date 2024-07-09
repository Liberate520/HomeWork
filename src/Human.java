import java.util.ArrayList;

public class Human {
    private String name;
    private String dateBirth;
    private String dateDiet;
    private Human whoSpouse;
    private String dateOfMarriage;
    Gender gender;
    FamilyStatus familyStatus;

    private ArrayList<Human> amountOfChildren = new ArrayList<>();
    private ArrayList<Human> parents = new ArrayList<>();

    public Human(String name) {
        this.name = name;
    }
    public Human(String name, String dateBirth, String dateDiet, Gender gender, FamilyStatus familyStatus) {
        this.name = name;
        this.dateBirth = dateBirth;
        this.dateDiet = dateDiet;
        this.gender = gender;
        this.familyStatus = familyStatus;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setDateBirth(String dateBirth) {
        this.dateBirth = dateBirth;
    }
    public String getDateBirth() {
        return dateBirth;
    }

    public void setDateDiet(String dateDiet) {
        this.dateDiet = dateDiet;
    }
    public String getDateDiet() {
        return dateDiet;
    }

    public void setWhoSpouse(Human whoSpouse) {
        this.whoSpouse = whoSpouse;
    }
    public Human getWhoSpouse() {
        return whoSpouse;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
    public Gender getGender() {
        return gender;
    }

    public void setDateOfMarriage(String dateOfMarriage) {
        this.dateOfMarriage = dateOfMarriage;
    }
    public String getDateOfMarriage() {
        return dateOfMarriage;
    }

    public void setFamilyStatus(FamilyStatus familyStatus) {
        this.familyStatus = familyStatus;
    }
    public FamilyStatus getFamilyStatus() {
        return familyStatus;
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", dateBirth='" + dateBirth + '\'' +
                ", dateDiet='" + dateDiet + '\'' +
                ", whoSpouse=" + (whoSpouse == null ? "There is no married couple.": whoSpouse.getName()) +
                ", dateOfMarriage='" + dateOfMarriage + '\'' +
                ", gender=" + gender +
                ", familyStatus=" + familyStatus +
                '}';
    }

    public void addChildren(Human human){
        amountOfChildren.add(human);
    }

    public void printChildren(){
        System.out.printf("%s's kids: \n", getName());
        for (Human h: amountOfChildren) {
            System.out.println(h.getName()+";");
        }
    }
    public void addParents(Human human){
        parents.add(human);
    }

    public void printParents(){
        System.out.printf("%s's parents: %s and %s.\n", getName(), parents.get(0).getName(), parents.get(1).getName());
    }

}
