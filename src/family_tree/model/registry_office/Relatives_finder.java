package family_tree.model.registry_office;

import family_tree.model.human.Human;
import family_tree.model.registry_office.Reg_office;
import family_tree.model.tree.FamilyTree;
import family_tree.model.infrastucture.try_catch.TryLong;

import java.util.Scanner;


public class Relatives_finder {

    private final TryLong tryLong;
    private final Scanner scanner;
    Reg_office reg_office;


    public Relatives_finder() {
        tryLong = new TryLong();
        scanner = new Scanner(System.in);
        reg_office = new Reg_office();
    }

    public void set_relatives(String str, FamilyTree<Human> familyTree){
        System.out.println("TST" + familyTree);
        switch (str) {
            case "1" -> reg_office.setFamily_tree(parents_finder(familyTree));
            case "2" -> reg_office.setFamily_tree(adoption(familyTree));
            case "3" -> reg_office.setFamily_tree(marriage(familyTree));
        }
    }


        public FamilyTree<Human> parents_finder(FamilyTree<Human> family_tree){
            System.out.println(family_tree);
            long id_person = get_person("Ребенок", family_tree);
            long id_mother = get_person("Мать", family_tree);
            long id_father = get_person("Отец", family_tree);
            if (id_person == -1 || id_father == -1 || id_mother == -1) {
                System.out.println("\nРодство не установлено.");
                return family_tree;
            } else {
                family_tree.getById(id_person).addParent(family_tree.getById(id_mother));
                family_tree.getById(id_person).addParent(family_tree.getById(id_father));
                family_tree.getById(id_mother).addChild(family_tree.getById(id_person));
                family_tree.getById(id_father).addChild(family_tree.getById(id_person));
                System.out.println("\nРодство задокументировано:");
                System.out.println(family_tree.getById(id_person));
                System.out.println(family_tree.getById(id_mother));
                System.out.println(family_tree.getById(id_father));
            }
            return family_tree;
        }

        public FamilyTree<Human> adoption(FamilyTree<Human> family_tree) {
            System.out.println(family_tree);
            long id_person = get_person("Родитель", family_tree);
            long id_child = get_person("Ребенок", family_tree);
            if (id_person == -1 || id_child == -1) {
                System.out.println("\nУсыновление не состоялось.");
                return family_tree;
            } else  {
                family_tree.getById(id_person).addChild(family_tree.getById(id_child));
                family_tree.getById(id_child).addParent(family_tree.getById(id_person));
                System.out.println("\nРебенок усыновлен:");
                System.out.println(family_tree.getById(id_person));
                System.out.println(family_tree.getById(id_child));
            }
            return family_tree;
        }

        public FamilyTree<Human> marriage(FamilyTree<Human> family_tree) {
            System.out.println(family_tree);
            long id_1 = get_person("Супруг", family_tree);
            long id_2 = get_person("Супруга", family_tree);
            if (id_1 == -1 || id_2 == -1) {
                System.out.println("\nБрак не зарегистрирован:");
            } else {
                family_tree.getById(id_1).setSpouse(family_tree.getById(id_2));
                family_tree.getById(id_2).setSpouse(family_tree.getById(id_1));
                System.out.println("\nБрак зарегистрирован:");
                System.out.println(family_tree.getById(id_1));
                System.out.println(family_tree.getById(id_2));
            }
            return family_tree;
        }

        private long get_person(String message, FamilyTree<Human> family_tree){
            String str;
            System.out.print(message + " - введите id: ");
            str = scanner.nextLine();
            long id_person = tryLong.try_long(str);
            try {
                family_tree.getById(id_person);
                System.out.println(message + ": " + family_tree.getById(id_person));
            } catch (Exception e){
                id_person = -1;
            }
            return id_person;
        }
    }