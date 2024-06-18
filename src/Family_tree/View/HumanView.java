package Family_tree.View;

import java.util.*;
import Family_tree.Model.Humans.Human;
import Family_tree.Presenter.HumanPresenter;
import Family_tree.Presenter.Presenter;

public class HumanView extends View<Human> {

    private ActionLevel level;
    private HumanPresenter presenter;
    private HumanManager manager;
    private Scanner scanner;

    public HumanView(){
        this.level = ActionLevel.NoLevel;
        this.scanner = new Scanner(System.in);
        this.presenter = new HumanPresenter(this);
        this.manager = new HumanManager(presenter, scanner);
    }   

    @Override
    public Presenter<Human> getPresenter() {
        return this.presenter;
    }    

    @Override
    public FunctionManager<Human> getManager() {
        return this.manager;
    }
    
    //________________________________________________________________________________________________
    
    public void intro() {
        System.out.println("На старте доступны команды:");
        manager.setLevel(ActionLevel.NoLevel);
        System.out.println(manager.getInDependentList());
        System.out.println("После создания древа добавятся:");
        System.out.println(manager.getTreeDependentList());
        System.out.println("После создания или выбора человека добавятся:");
        System.out.println(manager.getelementDependentList());
    }

    public void start(){
        intro();
    }
   
}
