package Family_tree.View;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import Family_tree.CommandsInterface;
import Family_tree.Presenter.*;

public class HumanManager implements CommandsInterface { //консольная версия

    //default
    private Map<String, String> elementDependentNames = new HashMap<String, String>() {
        {
            put("/im", "getSubjectInfo");
            put("/rd", "setDeathDate");
            put("/dm", "removeSubject");
        }
    };
    private Map<String, String> treeDependentNames = new HashMap<String, String>() {
        {
            put("/st", "saveTree");
            put("/dt", "removeTree");
            put("/am", "addSubject");
            put("/cr", "addChild");
            put("/sm", "searchSubject");
            put("/lm", "getSubjectsList");
        }
    };
    private Map<String, String> inDependentNames = new HashMap<String, String>() {
        {
            put("/lt", "getTreeList");
            put("/ct", "addTree");
            put("/rt", "loadTree");
            put("/se", "selectTree");
            put("/la", "getActionList");                
            put("/ex", "exit");
        }
    };
    private Map<String, String> elementDependentDesc = new HashMap<String, String>() {
        {
            put("/im", "Информация о субъекте");
            put("/rd", "Зарегистрировать дату смерти");
            put("/dm", "Удалить субъект");
        }
    };
    private Map<String, String> treeDependentDesc = new HashMap<String, String>() {
        {
            put("/st", "Сохранить древо");
            put("/dt", "Удалить древо");
            put("/am", "Добавить субъект");
            put("/cr", "Зарегистрировать ребёнка");
            put("/sm", "Найти субъект");
            put("/lm", "Список субъектов");
        }
    };
    private Map<String, String> inDependentDesc = new HashMap<String, String>() {
        {
            put("/lt", "Список древ");
            put("/ct", "Создать древо");
            put("/rt", "Загрузить древо");
            put("/se", "Выбрать древо");
            put("/la", "Список команд");
            put("/ex", "Выход");
        }
    };
// end default

    
    private HumanPresenter presenter;
    private Scanner scanner;
    private ActionLevel level;
    private HumanView view;

    public HumanManager(Scanner scanner, HumanView humanView) {
        // change default
        this.treeDependentDesc.put("/mm", "Зарегистрировать брак");
        this.treeDependentDesc.put("/dd", "Расторгнуть брак");
        this.treeDependentNames.put("/mm", "setMarriage");
        this.treeDependentNames.put("/dd", "delMarriage");
        // end changing
        this.level = ActionLevel.NoLevel;
        this.view = humanView;
        this.scanner = scanner;
        
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
        System.out.println(this.presenter.getTreeList());
        System.out.println("Укажите номер");
        String s;
        try {
            s = presenter.selectTree(Integer.parseInt(scanner.nextLine()) );
            //this.presenter.
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

    private String mapToString(Map<String, String> value) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : value.entrySet()) {
            sb.append(entry.getKey());
            sb.append("\t");
            sb.append(entry.getValue());
            sb.append("\n");
        }
        return sb.toString();
    }

    public String getelementDependentList() {
        return mapToString(elementDependentDesc);
    }

    @Override
    public String getActionList() {
        Map<String, String> full = new HashMap<>();
        full.putAll(inDependentDesc);
        full.putAll(treeDependentDesc);
        full.putAll(elementDependentDesc);
        return mapToString(full);
    }

    public String getTreeDependentList() { return mapToString(treeDependentDesc); }

    public String getInDependentList() { return mapToString(inDependentDesc); }

    public void exit() {
        System.out.println("Good bye");
        System.exit(0);
    } 

    public  Map<String, String> getIndependentMap(){ return this.inDependentDesc; }

    public  Map<String, String> getTreedependentMap() { return this.treeDependentDesc; }

    public  Map<String, String> getSubjectdependentMap(){ return this.elementDependentDesc; }

    public  Map<String, String> getIndependentActions(){return this.inDependentNames;  }

    public  Map<String, String> getTreedependentActions(){ return this.treeDependentNames; }

    public  Map<String, String> getSubjectdependentActions(){ return this.elementDependentNames; }


  
}
