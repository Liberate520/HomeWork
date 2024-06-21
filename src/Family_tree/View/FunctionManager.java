package Family_tree.View;


import java.util.HashMap;
import java.util.Map;
//import java.util.Scanner;

import Family_tree.CommandsInterface;
import Family_tree.Model.Humans.Endothermal;
import Family_tree.Presenter.Presenter;

public abstract class FunctionManager<T extends Endothermal> implements CommandsInterface {
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
    private Presenter presenter;
    private View<T> view;
    //private Scanner sc;

    

    public Map<String, String> getIndependentMap() {
        return this.inDependentDesc;
    }

    public Map<String, String> getTreedependentMap() {
        return this.treeDependentDesc;
    }

    public Map<String, String> getSubjectdependentMap() {
        return this.elementDependentDesc;
    }

    public Map<String, String> getIndependentActions() {
        return this.inDependentNames;
    }

    public Map<String, String> getTreedependentActions() {
        return this.treeDependentNames;
    }

    public Map<String, String> getSubjectdependentActions() {
        return this.elementDependentNames;
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

    public String getTreeDependentList() {
        return mapToString(treeDependentDesc);
    }

    public String getInDependentList() {
        return mapToString(inDependentDesc);
    }

    public String getActionList() {
        Map<String, String> full = new HashMap<>();
        full.putAll(inDependentDesc);
        full.putAll(treeDependentDesc);
        full.putAll(elementDependentDesc);
        return mapToString(full);
    }

    public abstract String getSubjectInfo(); 

    public abstract String setDeathDate() ;

    public abstract String removeSubject(); 

    public abstract String removeTree();

    public abstract String getSubjectsList(); 

    public abstract String getTreeList(); 
  
    public void exit() {
        System.out.println("Good bye");
        System.exit(0);
    }
    
    
        
    


}
