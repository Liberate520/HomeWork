package re.zip.famely_tree.srv;
import re.zip.famely_tree.famely_tree.FamelyTree;


public class Service {
    // private int genId;
    private FamelyTree simpleTree;

    public Service() {
        simpleTree = new FamelyTree();        
    }

    // public void addToFamely(String firstName, String lastName, LocalDate dateOfBirsday, Gender gender){
    //     Human human = new Human(genId++, firstName, lastName, dateOfBirsday, gender);
    //     simpleTree.addToFamely(human);

    // }

    // public String getHumanInfo() {
    //     StringBuilder stringBuilder = new StringBuilder();
    //     // stringBuilder.append("\nID: " + getIdNo());
    //     stringBuilder.append("\nФИО: ");
    //     stringBuilder.append(bio());
    //     stringBuilder.append("\nВозраст: ");
    //     stringBuilder.append(getAge());
    //     stringBuilder.append("\nОтец: ");
    //     if (this.father != null)stringBuilder.append(father.bio());
    //     else stringBuilder.append("нет информации");
    //     stringBuilder.append("\nМать: ");
    //     if (this.mother != null) stringBuilder.append(mother.bio());
    //     else stringBuilder.append("нет информации");

    //     stringBuilder.append("\nСупруг/супругв: ");
    //     if (this.spouse != null) stringBuilder.append(getSpouseInfo());
    //     else stringBuilder.append("нет информации");

    //     stringBuilder.append("\nДети: ");
    //     stringBuilder.append(getChildrenInfo());
    //     //TODO добавить информацию о бывших супругах и, соответственно, детях от других браков
    //     return stringBuilder.toString();
    // }

    public void sortByFirstName() {
        simpleTree.sortByFirstName();
    }

    public void sortByFamelyName() {
        simpleTree.sortByFamelyName();
    }

}

