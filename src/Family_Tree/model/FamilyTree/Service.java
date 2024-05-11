package Family_Tree.model.FamilyTree;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Service<E extends TreeVersatility<E>> implements Iterable<E>, Serializable {
    private List<E> HumanList;
    private Scanner scanner;
    private FamilyTree tree;
    private long countPeople;


//    public void addHuman(){
//        FamilyTree tree = new FamilyTree();
//        System.out.println("Введите имя: ");
//        String name = scanner.nextLine();
//        System.out.println("Введите дату рождения: ");
//        LocalDate birth= LocalDate.parse(scanner.nextLine());
//        System.out.println("Введите дату смерти: ");
//        LocalDate death= LocalDate.parse(scanner.nextLine());
//        System.out.println("Введите пол человека: ");
//        Gender gender= Gender.valueOf(scanner.nextLine());
//        Human human  = new Human(name, birth, death, gender);
//        tree.add(human);
//    }

    public boolean add(E human) {
        if (human == null) {
            return false;
        }
        if (!HumanList.contains(human)) {
            HumanList.add(human);
            human.setID(countPeople++);

        }
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }
}

