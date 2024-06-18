package Family_tree.View;


import java.util.Map;
import java.util.Scanner;

import Family_tree.Model.Humans.Human;
import Family_tree.Presenter.*;

public class HumanManager extends FunctionManager<Human> { //консольная версия

    private Map<String, String> elementDependentNames = super.getSubjectdependentActions();
    private Map<String, String> treeDependentNames = super.getTreedependentActions() ;
    private Map<String, String> inDependentNames = super.getIndependentActions() ;
    private Map<String, String> elementDependentDesc = super.getSubjectdependentMap() ;    
    private Map<String, String> treeDependentDesc = super.getTreedependentMap() ;
    private Map<String, String> inDependentDesc = super.getIndependentMap() ;
    HumanPresenter presenter;
    Scanner scanner;

    public HumanManager(HumanPresenter presenter, Scanner scanner) {
        super(presenter, scanner);
        this.treeDependentDesc.put("/mm", "Зарегистрировать брак");
        this.treeDependentDesc.put("/dd", "Расторгнуть брак");
        this.treeDependentNames.put("/mm", "setMarriage");
        this.treeDependentNames.put("/dd", "delMarriage");
        this.inDependentDesc.put("/aa", "Список доступных команд");
        this.inDependentNames.put("/aa", "getListUsageAction");
    }

    public String setDeathDate() {
        System.out.println("Укажите дату смерти: (Д.ММ.ГГГГ)");        
        return presenter.setDeathDate(scanner.nextLine());
    }

    public String saveTree(){
        System.out.println("Укажите путь");
      return  presenter.saveTree(scanner.nextLine());
    }

    @Override
    public String addSubject() {
        String[] s = subjectString();        
        return presenter.addToTree(s[0], s[1], s[2]);
    }
    private String[] subjectString(){
        String[] s = new String[3];
        System.out.println("Введите имя");
        s[0] = scanner.nextLine();
        System.out.println("Укажите пол: (м/ж)");
        s[1] = scanner.nextLine();
        System.out.println("Укажите дату рождения: (Д.ММ.ГГГГ)");
        s[2] = scanner.nextLine();
        return s;
    }

    @Override
    public String addChild() {
        String[] s = subjectString();
        System.out.println("Укажите ID отца");
        int ID1 = Integer.parseInt(scanner.nextLine());
        System.out.println("Укажите ID матери");
        int ID2 = Integer.parseInt(scanner.nextLine());
        return presenter.newChild(s[0], s[1], s[2], ID1, ID2);
    }

    @Override
    public String searchSubject() {
        System.out.println("Введите шаблон поиска");
        return presenter.searchByPattern(scanner.nextLine());
    }

    @Override
    public String addTree() {
        System.out.println("Введите название");
        return presenter.createActiveTree(scanner.nextLine());
    }

    @Override
    public String loadTree() {
        System.out.println("Укажите путь");
        return presenter.loadTree(scanner.nextLine());
    }

    @Override
    public String selectTree() {
        System.out.println("Укажите номер");
        return presenter.selectTree(Integer.parseInt(scanner.nextLine()) );
    };

    public String setMarriage(){
        System.out.println("Укажите номер для жениха");
        int id1 = Integer.parseInt(scanner.nextLine());
        System.out.println("Укажите номер для невесты");
        int id2 = Integer.parseInt(scanner.nextLine());
        return presenter.setMarriage(id1, id2);
    }

    public String delMarriage(){
        System.out.println("Укажите номер мужа");
        int id1 = Integer.parseInt(scanner.nextLine());
        System.out.println("Укажите номер жены");
        int id2 = Integer.parseInt(scanner.nextLine());
        return presenter.delMarriage(id1, id2);
    }

}
