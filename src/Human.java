import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class Human implements Serializable {
    private static int humanNumber;
    private String name;
    private LocalDate dateBirth;
    private LocalDate dateDiet;
    private Human whoSpouse;
    private LocalDate dateOfMarriage;
    private Gender gender;
    private FamilyStatus familyStatus;
    private ArrayList<Human> amountOfChildren = new ArrayList<>();
    private ArrayList<Human> parents = new ArrayList<>();


    static {
        Human.humanNumber = 0;
    }
    
    public Human(String name, LocalDate dateBirth, LocalDate dateDiet, Gender gender, FamilyStatus familyStatus) {
        this.name = name;
        this.dateBirth = dateBirth;
        this.dateDiet = dateDiet;
        this.gender = gender;
        this.familyStatus = familyStatus;
    }

    public String getInfo() {
        return String.format("Name: %s, Date of Birt %s",this.name, this.dateBirth);
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setDateBirth(LocalDate dateBirth) {
        this.dateBirth = dateBirth;
    }
    public LocalDate getDateBirth() {
        return dateBirth;
    }

    public void setDateDiet(LocalDate dateDiet) {
        this.dateDiet = dateDiet;
    }
    public LocalDate getDateDiet() {
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

    public void setDateOfMarriage(LocalDate dateOfMarriage) {
        this.dateOfMarriage = dateOfMarriage;
    }
    public LocalDate getDateOfMarriage() {
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
                "id=" + ++humanNumber + '\'' +
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
    public void writeHuman(Human anyHuman){
        try{
            FileOutputStream fs = new FileOutputStream("Human.ser");
            ObjectOutputStream os = new ObjectOutputStream(fs);
            os.writeObject(anyHuman);
            os.close();
        } catch (IOException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }
    }

    public void readHuman(){
        try {
            FileInputStream fileInputStream = new FileInputStream("Human.ser");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Object objHuman = objectInputStream.readObject();
            Human human = (Human) objHuman;
            System.out.println(human.getInfo());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
