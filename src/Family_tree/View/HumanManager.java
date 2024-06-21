package Family_tree.View;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
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
    private HumanPresenter presenter;
    private Scanner scanner;
    private ActionLevel level;
    private HumanView view;

    public HumanManager(Scanner scanner, HumanView humanView) {
        
        this.treeDependentDesc.put("/mm", "Зарегистрировать брак");
        this.treeDependentDesc.put("/dd", "Расторгнуть брак");
        this.treeDependentNames.put("/mm", "setMarriage");
        this.treeDependentNames.put("/dd", "delMarriage");
        //this.inDependentDesc.put("/aa", "Список доступных команд");
        //this.inDependentNames.put("/aa", "getListUsageAction");
        this.level = ActionLevel.NoLevel;
        this.view = humanView;
        this.scanner = scanner;
        //this.presenter = presenter;
    }

    public String removeSubject() {
        this.view.setActionLevel(ActionLevel.TreeLevel);
        return (presenter.removeMember());
    } 

    public  String getSubjectInfo() {
        return presenter.showActiveSubjectInfo();
    }

    public String removeTree(){
        this.view.setActionLevel(ActionLevel.NoLevel);
        return presenter.removeTree();
    } 

    public String getSubjectsList() {
        return presenter.showSubjectList();
    }

    public String getTreeList() {
        return presenter.getTreeList();
    } 

    public void setPresenter(HumanPresenter value){
        this.presenter = value;
    }
    
    public HumanView getView(){
        return this.view;
    }

    public HumanPresenter getPresenter(){
        return this.presenter;
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
        view.setActionLevel(ActionLevel.SubjectLevel)    ;   
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
        view.setActionLevel(ActionLevel.SubjectLevel)    ; 
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
        view.setActionLevel(ActionLevel.TreeLevel)    ; 
        return presenter.createActiveTree(scanner.nextLine());
    }

    @Override
    public String loadTree() {
        System.out.println("Укажите путь");
        view.setActionLevel(ActionLevel.TreeLevel)    ; 
        return presenter.loadTree(scanner.nextLine());
    }

    @Override
    public String selectTree() {
        System.out.println("Укажите номер");
        String s;
        try {
            s = presenter.selectTree(Integer.parseInt(scanner.nextLine()) );
            view.setActionLevel(presenter.getActionLevel());
            return s;
        } catch (Exception e) {
            return "Ничего не выбрано";
        }
        
        
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

    public void setLevel(ActionLevel level){
        this.level = level;
    }

    public void fireFunction(String action, Map<String, String> map) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException{       
        if (map.containsKey(action)){
            Method method = HumanManager.class.getMethod(map.get(action));
            method.setAccessible(true);
            Object[] o = null;
            System.out.println(method.invoke(this, o));            
        }
        System.out.println("_________________________________________________________________________________________________________");
        this.view.selectAction();
        }

    public ActionLevel getLevel(){
        return this.level;
    }

    
}
