import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Human human1 = new Human("Ivan Konstantinov", LocalDate.of(1999, Month.APRIL,12), null, Gender.Male );
        Human human2 = new Human("Irina Konstantinova", LocalDate.of(1998, Month.DECEMBER,12), null, Gender.Female );
        Human human3 = new Human("Maria Petrova", LocalDate.of(1964, Month.APRIL,12), null, Gender.Female );
        Human human4 = new Human("Semen Konstantinov", LocalDate.of(1968, Month.DECEMBER,12), null, Gender.Male );

        List<Human> children1 = new ArrayList<>();
        children1.add(human1);
        children1.add(human2);
        human4.setChildren(children1);
        human3.setChildren(children1);

        human1.setMother(human3.getName());
        human1.setFather(human4.getName());
        human2.setMother(human3.getName());
        human2.setFather(human4.getName());

        FamilyTree familyTree1 = new FamilyTree();
        familyTree1.addHuman(human1);
        familyTree1.addHuman(human2);
        familyTree1.addHuman(human3);
        familyTree1.addHuman(human4);

        System.out.println(familyTree1);
    }
}
