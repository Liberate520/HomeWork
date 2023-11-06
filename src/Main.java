package homeWork.src;

import homeWork.src.member.FamilyMember;
import homeWork.src.service.Service;
import homeWork.src.tree.FamilyTree;
import homeWork.src.tree.Gender;
import homeWork.src.writer.FileHandler;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        FamilyTree myTree = testTree();
        Service myService = new Service();
//        FamilyTree myTree = load();
//        System.out.println(myTree);


        System.out.println(myService.getFamilyTreeInfo(myTree));
        myService.sortBySurname(myTree);
        System.out.println(myService.getFamilyTreeInfo(myTree));
        myService.sortByBirthDate(myTree);
        System.out.println(myService.getFamilyTreeInfo(myTree));

//        FileHandler fileHandler = new FileHandler();
//        String filePath = "src/homeWork/src/writer/tree.txt";
//        fileHandler.save(myTree, filePath);
        save(myTree);

    }

    private static FamilyTree load(){
        FileHandler fileHandler = new FileHandler();
        String filePath = "src/homeWork/src/writer/tree.txt";
        return (FamilyTree) fileHandler.read(filePath);
    }

    private static void save(FamilyTree tree){
        FileHandler fileHandler = new FileHandler();
        String filePath = "src/homeWork/src/writer/tree.txt";
        fileHandler.save(tree, filePath);
    }

    static FamilyTree testTree() {
//        FamilyMemberBuilder builder = new FamilyMemberBuilder();
        Service service = new Service();
//        FamilyTree tree = new FamilyTree();


        FamilyMember member1 = service.createFamilyMember(
                "Nadezhda",
                "Khokhlova",
                "Pavlovna",
                Gender.Female,
                LocalDate.of(1954, 2, 28), null, null, null);

        FamilyMember member2 = service.createFamilyMember(
                "Alexandr",
                "Khokhlov",
                "Andreevich",
                Gender.Male,
                LocalDate.of(1956, 9, 1),
                LocalDate.of(2015, 2, 14), null, null);

        service.setWedding(member1, member2);

        FamilyMember member3 = service.createFamilyMember(
                "Andrey",
                "Khokhlov",
                "Alexandrovich",
                Gender.Male,
                LocalDate.of(1977, 3, 28),
                null,
                member2, member1);

        FamilyMember member4 = service.createFamilyMember(
                "Olga",
                "Shpakovskaya",
                "Alexandrovna",
                Gender.Female,
                LocalDate.of(1989, 10, 16), null,
                member2, member1);

        FamilyMember member5 = service.createFamilyMember(
                "Ekaterina",
                "Khokhlova",
                "Petrovna",
                Gender.Female,
                LocalDate.of(1945, 9, 1), null, null, null);

        service.addChild(member5, member3);

        return service.getFamilyTree();
    }
}
