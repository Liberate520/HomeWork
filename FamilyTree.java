package homeWork;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FamilyTree {
    private List<Human> familyTree = new ArrayList<Human>();



    public void addHuman(Human human ){
        familyTree.add(human);
    }

    public String getFamilyTree(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список членов семьи:\n");
        for (Human human : familyTree){
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void removeHuman(Human human){
        familyTree.remove(human);
    }


    public String findChildren(FamilyTree tree) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a person: \n");
        String person = scanner.nextLine();
        scanner.close();
        StringBuilder stringBuilder = new StringBuilder();
        for (Human human : familyTree) {
            if (human.getName().equals(person)) {
                List<String> children = new ArrayList<>();
                if (!children.isEmpty()) {
                    stringBuilder.append("Children of ").append(person).append(":\n");
                    for (String child : children) {
                        stringBuilder.append(child).append("\n");
                    }
                } else {
                    stringBuilder.append(person).append(" has no children.\n");
                }
                break;
            }
        }
        return stringBuilder.toString();
    }


}