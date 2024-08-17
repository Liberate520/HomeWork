package ru.gb.family.view;

import ru.gb.family.model.familyTree.ItemFamilyTrees.ItemFamilyTree;
import ru.gb.family.model.familyTree.ItemFamilyTrees.enums.DegreeOfKinship;
import ru.gb.family.model.familyTree.ItemFamilyTrees.enums.Gender;

import ru.gb.family.presenter.Presenter;
import ru.gb.family.view.menu.EditItemTreeMenu;
import ru.gb.family.view.menu.EditTreeMenu;
import ru.gb.family.view.menu.StartMenu;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class ConsoleUI implements View {
    private Scanner scanner;
    private Presenter presenter;
    private boolean workMenuStart = true, workMenuEditTree = true, workMenuEditItemTree = true;
    private StartMenu startMenu;
    private EditTreeMenu editTreeMenu;
    private EditItemTreeMenu editItemTreeMenu;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        startMenu = new StartMenu(this);
        editTreeMenu = new EditTreeMenu(this);
        editItemTreeMenu = new EditItemTreeMenu(this);
    }

    @Override
    public void start() {

        System.out.println();
        while (workMenuStart) {
            System.out.println(startMenu.menu());
            String choice = scanner.nextLine();
            startMenu.run(Integer.parseInt(choice));
            while (workMenuEditTree) {

                System.out.println(editTreeMenu.menu());
                String choiceEditTree = scanner.nextLine();
                editTreeMenu.run(Integer.parseInt(choiceEditTree));

            }
            workMenuEditTree = true;

        }

    }

    public void finishMenuStart() {
        workMenuEditTree = false;
        workMenuStart = false;
        workMenuEditItemTree = false;

    }

    public void finishMenuEditTree() {
        workMenuEditTree = false;
    }


    public void editItemTree() {
        while (workMenuEditItemTree) {
            System.out.println(editItemTreeMenu.menu());
            String choice = scanner.nextLine();
            editItemTreeMenu.run(Integer.parseInt(choice));
        }
        workMenuEditItemTree = true;
    }

    public void loadTree() {

        long num = 1;
        for (String nameTree:presenter.getListDataTree()) System.out.println(num++ + ":" + nameTree);
        System.out.println(num++ +":Вернуться в главное меню..");
        System.out.print("Выберите дерево:");
        int answer = Integer.parseInt(scanner.nextLine());
        System.out.println(num);
        if (answer>=1 && answer<=num-1){
          if (answer == num-1) {
              finishMenuEditTree();
            } else{
              System.out.println(presenter.getListDataTree());
              String nameTree = presenter.getListDataTree().get(answer-1);
              presenter.openTree(nameTree);
              System.out.println("Загружено:["+nameTree+"] ("+ presenter.getTree().counting() +"- записей)");
            }
        }

    }

    public void newTree() {
        System.out.print("Введите название нового древа:");
        presenter.newTree(scanner.nextLine());

    }
    public void delTree() {
        long num = 1;
        for (String nameTree:presenter.getListDataTree()) System.out.println(num++ + ":" + nameTree);
        System.out.print("Выберите древо для удаления!:");
        presenter.delTree(presenter.getListDataTree().get(Integer.parseInt(scanner.nextLine())-1));
        finishMenuStart();

      }

    @Override
    public void printAnswer(String answer) {
        System.out.println(answer);
    }

    public void mapMenu() {
        StringBuilder stringBuilder =new StringBuilder();
        stringBuilder.append("\n -==Меню работы с Деревьями==-\n");
        for (int i = 0; i < startMenu.printStartCommand().size(); i++) {
            stringBuilder.append(startMenu.printStartCommand().get(i));
            stringBuilder.append("\n");
        }
        stringBuilder.append("\n\t\t -==Меню работы с элементами древа==-\n");
        for (int i = 0; i < editTreeMenu.printEditTreeMenuCommand().size(); i++) {
            stringBuilder.append("\t\t\t"+editTreeMenu.printEditTreeMenuCommand().get(i));
            stringBuilder.append("\n");
        }
        stringBuilder.append("\n\t\t\t -==Меню работы редактирования элементов древа==-\n");
        for (int i = 0; i < editItemTreeMenu.printEditItemTreeMenuCommand().size(); i++) {
            stringBuilder.append("\t\t\t\t"+editItemTreeMenu.printEditItemTreeMenuCommand().get(i));
            stringBuilder.append("\n");
        }
        //stringBuilder.append(startMenu.menu());
        System.out.println(stringBuilder);
        finishMenuEditTree();
    }

    public void addItemTree() {
        LocalDate birthday,dateOfDead;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        formatter = formatter.withLocale( Locale.ROOT );  // Locale specifies human language for translating, and cultural norms for lowercase/uppercase and abbreviations and such. Example: Locale.US or Locale.CANADA_FRENCH
        System.out.print("Введите ФИО:");
        String name = scanner.nextLine();
        System.out.println("Введите дату рождения в формате год-месяц-день(1986-03-12):");
        birthday =  LocalDate.parse(scanner.nextLine(), formatter);
        System.out.println("Введите дату смерти в формате год-месяц-день(1986-03-12) или оставте пустой:");
        String dateOfDeadStr = scanner.nextLine();
        if (dateOfDeadStr == ""  ){
            dateOfDead = null;
        }else{
            dateOfDead = LocalDate.parse(dateOfDeadStr, formatter);
        }
        int i =1;
        for (Gender s:Gender.values()) {

            System.out.println(i++ +":" + s);
        }
        Gender[] gender = Gender.values();
        presenter.addItemTree(name,birthday,dateOfDead,gender[(Integer.parseInt(scanner.nextLine())-1)]);
        presenter.save();
    }

    public void printTree(){
        presenter.printTree();
    }
    public void save(String name) {
        presenter.save();
    }


    public void editItemParent(DegreeOfKinship degreeOfKinship) {
        ItemFamilyTree item1 = null;
        ItemFamilyTree item2 = null;

        switch (degreeOfKinship){
            case Father, Mother: {System.out.print("Поиск.Введите имя ребенка:");break;}
            case Spouse: {System.out.print("Поиск.Введите имя cупруга(и):");break;}
            
        }
        item1 = getItemFamilyTree();


        switch (degreeOfKinship){
            case Father, Mother: {System.out.print("Поиск.Введите имя родителя:");break;}
            case Spouse: {System.out.print("Поиск.Введите имя cупруга(и):");break;}
        }
        item2 = getItemFamilyTree();

        presenter.itemEdit(item1, item2,degreeOfKinship);
        System.out.println(item1);
        System.out.println(item2);
        presenter.save();
    }

    private ItemFamilyTree getItemFamilyTree() {
        Dictionary<Integer, ItemFamilyTree> dictSearch = new Hashtable<>();
        int num;
        num = 1;
        for (ItemFamilyTree itemFamilyTree : presenter.searchItemByName(scanner.nextLine())) {
            System.out.println(num + ":" + itemFamilyTree.getName() + "(" + itemFamilyTree.getAge() + ")" + "-" + itemFamilyTree.getBirthday());
            dictSearch.put(num, itemFamilyTree);
            num = num + 1;
        }
        System.out.print("Выберите из списка:");
        ItemFamilyTree item = null;
        if (dictSearch.size() > 0) {
            item =  dictSearch.get(Integer.parseInt(scanner.nextLine()));

        }
        return item;
    }
}
