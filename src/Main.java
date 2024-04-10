import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String filePath = "/Users/ramilbagirov/Desktop/Murad/GeekBrains/git_education/Git_Java/homeWork/src/tree.txt";

        //FamilyTree tree = testTree();
        Service service = testTree();
        System.out.println(service.getTreeInfo());

        save(service, filePath);

    }


        static void save(Service service, String filePath) {
            FileHandler fileHandler = new FileHandler();
            fileHandler.save(service, filePath);
        }

       static FamilyTree read(String filePath) {
            FileHandler fileHandler = new FileHandler();
            return (FamilyTree) fileHandler.read(filePath);
    }

    static Service testTree() {
        FamilyTree familyTree = new FamilyTree();
        Service service = new Service(familyTree);

        List<Human> children1 = new ArrayList<>();
        List<Human> children2 = new ArrayList<>();
        Human human1 = new Human("Vagif", "Male", null, null);
        Human human2 = new Human("Naila", "Female", null, null);
        Human human3 = new Human("Ramil", "Male", human1, human2);
        Human human4 = new Human("Nigar", "Female", null, null);
        Human human5 = new Human("Murad", "Male", human3, human4);
        Human human6 = new Human("Ayla", "Female", human3, human4);
        human1.SetDateOfBirth(1954, 4, 15);
        human2.SetDateOfBirth(1950, 1, 21);
        human3.SetDateOfBirth(1981, 9, 27);
        human4.SetDateOfBirth(1983, 3, 28);
        human5.SetDateOfBirth(2008, 2, 24);
        human6.SetDateOfBirth(2010, 12, 1);
        human1.setChildren(children1);
        human2.setChildren(children1);
        human3.setChildren(children2);
        human4.setChildren(children2);
        human1.addChild(children1, human3);
        human2.addChild(children1, human3);
        human3.addChild(children2, human5);
        human4.addChild(children2, human5);
        human3.addChild(children2, human6);
        human4.addChild(children2, human6);
        service.addFamilyMember(human1);
        service.addFamilyMember(human2);
        service.addFamilyMember(human3);
        service.addFamilyMember(human4);
        service.addFamilyMember(human5);
        service.addFamilyMember(human6);

        return service;
        }

    }