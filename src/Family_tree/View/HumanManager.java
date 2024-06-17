package Family_tree.View;

import java.util.HashMap;
import java.util.Map;

import Family_tree.Model.Humans.Human;
import Family_tree.Presenter.Presenter;

public class HumanManager extends FunctionManager {

    private Map<String, String> elementDependentNames = super.getSubjectdependentActions();
    private Map<String, String> treeDependentNames = super.getTreedependentActions() ;
    private Map<String, String> inDependentNames = super.getIndependentActions() ;
    private Map<String, String> elementDependentDesc = super.getSubjectdependentMap() ;    
    private Map<String, String> treeDependentDesc = super.getTreedependentMap() ;
    private Map<String, String> inDependentDesc = super.getIndependentMap() ;

    public HumanManager(Presenter<Human> presenter) {
        super(presenter);
        this.treeDependentDesc.put("/mm", "Зарегистрировать брак");
        this.treeDependentDesc.put("/dd", "Расторгнуть брак");
        this.treeDependentNames.put("/mm", "setMarriage");
        this.treeDependentNames.put("/dd", "delMarriage");
    }

}
