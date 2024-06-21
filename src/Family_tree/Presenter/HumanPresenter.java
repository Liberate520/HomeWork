package Family_tree.Presenter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import Family_tree.Model.HumanModel;
import Family_tree.Model.TreeManager;
import Family_tree.Model.Humans.Gender;
import Family_tree.Model.Humans.Human;
import Family_tree.Model.Tree.Family_tree;
import Family_tree.View.ActionLevel;
import Family_tree.View.HumanView;


public class HumanPresenter extends Presenter {
    
    private Family_tree<Human> activeTree;
    private HumanView view;
    private ActionLevel level;
    private Human activeSubject;
    private HumanModel model;
    private TreeManager<Human> manager;


    public HumanPresenter(){        
        this.activeTree = null;
        this.level = ActionLevel.NoLevel;
        this.activeSubject = null;
        this.model = new HumanModel();        
        this.manager = new TreeManager<Human>();
    }

    public void setView(HumanView value) {
        this.view = value;
    }

    

    @Override
    public String selectTree(int index) {
        boolean boo = this.manager.isEmpty();        
        if (!boo){
            model.setActiveTree(manager.getActiveTree());
            this.level = ActionLevel.TreeLevel;
            return "OK";
        }
        return "Древо не найдено";
      }    

    @Override
    public String setDeathDate(String text) {
        if (this.level == ActionLevel.SubjectLevel){
            if (this.model.setDeathDate(text)){
                return "OK";
            }
        }
        return "Ошибка записи";
    }

   

    public String getDeathDate(){
        if (this.level == ActionLevel.SubjectLevel) {   
            return model.getDeathDate();
        }               
        return "Древо не найдено";        
    }

    @Override
    public String saveTree(String text) {
        if (this.level == ActionLevel.TreeLevel){
            if (this.manager.saveTree(text)){
                return "OK";
            }
        }
        return "Ошибка записи";
    }

   

    @Override
    public String addToTree(String name, String gender, String birhday) {
        if (this.level == ActionLevel.TreeLevel){
            try{
            boolean boo = model.addToActiveTree(name, gender, birhday); 
            if (boo){
                this.activeSubject = model.getActiveHuman();
                this.level = ActionLevel.SubjectLevel;
                return "OK";
            }}           
            catch (Exception e) {
                System.out.println(e);
                return "Ошибка записи";
            }
        }
        return "Нет активного древа";
    }

    @Override
    public String newChild(String name, String gender, String birhday, int IDFather, int IDMother) {
        if (this.level == ActionLevel.TreeLevel){
            try{
                boolean boo = model.addToActiveTree(name, gender, birhday);
                if (boo){
                    Human human = model.getActiveHuman();          
                    Human fater = this.activeTree.getItem(IDFather);
                    Human mother = this.activeTree.getItem(IDMother);
                    human.setFather(fater);
                    human.setMother(mother);
                    fater.addChild(human);
                    mother.addChild(human);
                    this.activeTree.add(human);
                    this.activeSubject = human;
                    this.level = ActionLevel.SubjectLevel;
            return "OK";
                } 
            
            } catch (Exception e) {
                return "Ошибка записи";
            }
        }
        return "Нет активного древа";
    }

    @Override
    public String searchByPattern(String text) {
        if (this.level == ActionLevel.TreeLevel){
            return this.manager.searchByPattern(text);
        }
        return "Нет активного древа";
    }

    @Override
    public String createActiveTree(String text) {
        try {
            this.activeTree = new Family_tree<Human>(text);
            this.manager.addTree(this.activeTree);
            this.level = ActionLevel.TreeLevel;
            return String.format("Создано древа %s", this.activeTree.toString());
        } catch (Exception e) {
            return "Ошибка записи";
        }
    }

    @Override
    public String loadTree(String text) {
        if (this.manager.loadTree(text)){
            this.activeTree = this.manager.getActiveTree();
            this.model.setActiveTree(this.activeTree);
            this.level = ActionLevel.TreeLevel;
            return String.format("Древо %s загружено", this.activeTree.toString());
        }
        return "Ошибка чтения";
    }

    @Override
    public String showActiveSubjectInfo() {
        if (this.level == ActionLevel.SubjectLevel){
            return this.activeSubject.getInfo();
        }
        return "Субъект не обнаружен";
    }

    @Override
    public String removeMember() {
        if (this.level == ActionLevel.SubjectLevel){
           if (this.model.removeSubject()){
            this.activeSubject = null;
            this.level = ActionLevel.TreeLevel;
            return "OK";
           }
        }
        return "Ошибка удаления";
    }

    @Override
    public String removeTree() {
        try {
            this.manager.deleteTree(this.activeTree);
            this.activeSubject = null;
            this.activeTree = null;
            this.level = ActionLevel.NoLevel;
            return "OK";
        } catch (Exception e) {
            return "Ошибка удаления";
        }
        
    }

    @Override
    public String showSubjectList() {
        return this.activeSubject.getInfo();
    }

    @Override
    public String getTreeList() {
        if (this.manager.isEmpty()){
            return "Список древ пуст";
        }
        return this.manager.showList();
    }

    
    public HumanModel getModel() {
        return this.model;
    }

   
    public void setModel(HumanModel value) {
        this.model = value;
    }

    public String setMarriage(int id1, int id2) {
        Human male, female;        
            male = this.activeTree.getItem(id1);
            female = this.activeTree.getItem(id2);        
        if (male == null || female == null){
            return "Субъекты не обнаружены";
        }
        if (male.setSpouse(female) && female.setSpouse(female)){
            return "OK";
        }
        return "Ошибка регистрации";
    }

    public String delMarriage(int id1, int id2) {
        Human male = this.activeTree.getItem(id1);
        Human female = this.activeTree.getItem(id2);
        if (male.setSpouse(null) && female.setSpouse(null)){
            return "OK";
        }
        return "Ошибка регистрации";
    }

    public TreeManager<Human> getTreeModel(){
        return this.manager;
    }

    public ActionLevel getActionLevel(){
        return this.level;
    }

    

}
