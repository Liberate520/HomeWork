import familytree.FamilyTree;
import familytree.dog.Dog;
import filehandler.FileHandler;
import human.Human;
import service.Service;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String filePath = "/Users/ramilbagirov/Desktop/Murad/GeekBrains/git_education/Git_Java/homeWork/src/tree.txt";

        Service service1 = testTreeHuman();
        Service service2 = testTreeDog();
        //Service service = read(filePath);
        System.out.println(service1.getTreeInfoHuman());
        System.out.println(service2.getTreeInfoDog());

        save(service1, filePath);

    }


        static void save(Service service, String filePath) {
            FileHandler fileHandler = new FileHandler();
            fileHandler.save(service, filePath);
        }

       static Service read(String filePath) {
            FileHandler fileHandler = new FileHandler();
            return (Service) fileHandler.read(filePath);
    }

    static Service testTreeHuman() {
        FamilyTree<Human> familyTree = new FamilyTree<>();
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
        service.addFamilyMemberHuman(human1);
        service.addFamilyMemberHuman(human2);
        service.addFamilyMemberHuman(human3);
        service.addFamilyMemberHuman(human4);
        service.addFamilyMemberHuman(human5);
        service.addFamilyMemberHuman(human6);

        return service;
        }

        static Service testTreeDog() {
        FamilyTree<Dog> dogFamilyTree = new FamilyTree<>();
        Service dogService = new Service(dogFamilyTree);
        dogService.setService(dogFamilyTree);

        List<Dog> dogs1 = new ArrayList<>();

        Dog dog1 = new Dog("Layka", "Male", null, null, dogs1);
        Dog dog2 = new Dog("Lyelya", "Female", null, null, dogs1);
        Dog dog3 = new Dog("Ben", "Male", dog1, dog2, null);
        dog1.SetDateOfBirth(2008, 12, 5);
        dog2.SetDateOfBirth(2009, 2, 15);
        dog3.SetDateOfBirth(2017, 5, 31);
        dog1.addChild(dogs1, dog3);
        dog2.addChild(dogs1, dog3);
        dogService.addFamilyMemberDog(dog1);
        dogService.addFamilyMemberDog(dog2);
        dogService.addFamilyMemberDog(dog3);

        return dogService;
        }

    }