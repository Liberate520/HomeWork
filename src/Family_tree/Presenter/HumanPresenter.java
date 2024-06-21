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
    private HumanView view;      
    private HumanModel model;
    private TreeManager<Human> manager;


    public HumanPresenter(){                 
        this.model = new HumanModel();        
        this.manager = new TreeManager<Human>();
    }

    public ActionLevel getActionLevel(){
        return view.getActionLevel();
    }

    public void setActionLevel(ActionLevel level){
        model.setActionLevel(level);
        manager.setActionLevel(level);
        view.setActionLevel(level);
    }

    public Family_tree<Human> getActiveTree(){
        return model.getActiveTree();
    }

    public void setActiveTree(Family_tree<Human> tree){
        model.setActiveTree(tree);
        manager.setActiveTree(tree);
    }

    public Human getActiveSubject(){
        return model.getActiveElement();
    }

    public void setActiveSubject(Human human){
        model.setActiveElement(human);
    }

    public void setView(HumanView value) {
        this.view = value;
    }

    

    @Override
    public String selectTree(int index) {
        boolean boo = this.manager.isEmpty();        
        if (!boo){
            this.setActiveTree(manager.selectTree(index)) ;
            this.setActionLevel(ActionLevel.TreeLevel);
            return "OK";
        }
        return "Древо не найдено";
      }    

    @Override
    public String setDeathDate(String text) {
        if (this.model.getActionLevel() == ActionLevel.SubjectLevel){
            if (this.model.setDeathDate(text)){
                return "OK";
            }
        }
        return "Ошибка записи";
    }

   

    public String getDeathDate(){
        if (this.model.getActionLevel() == ActionLevel.SubjectLevel) {   
            return model.getDeathDate();
        }               
        return "Древо не найдено";        
    }

    @Override
    public String saveTree(String text) {
        if (this.manager.getActionLevel() == ActionLevel.TreeLevel || this.model.getActionLevel() == ActionLevel.SubjectLevel){
            //System.out.println(this.manager.getActionLevel());
            if (this.manager.saveTree(text)){
                return "OK";
            }
        }
        return "Ошибка записи";
    }

   

    @Override
    public String addToTree(String name, String gender, String birhday) {
        try{
            Human human = model.newItem( name,  gender,  birhday);
            Family_tree<Human> tree = manager.getActiveTree();
            tree.add(human);
            this.setActiveSubject(human);
            this.setActionLevel(ActionLevel.SubjectLevel);
            return "OK";
        }catch(Exception e){
            System.out.println(e);
            return "Ошибка записи";
        }
        
    }
        

    @Override
    public String newChild(String name, String gender, String birhday, int IDFather, int IDMother) {
        if (this.getActionLevel() == ActionLevel.TreeLevel || this.model.getActionLevel() == ActionLevel.SubjectLevel){
            try{
                boolean boo = model.addToActiveTree(name, gender, birhday);
                if (boo){
                    Human human = model.getActiveElement();          
                    Human fater = manager.getActiveTree().getItem(IDFather);
                    Human mother = manager.getActiveTree().getItem(IDMother);
                    human.setFather(fater);
                    human.setMother(mother);
                    fater.addChild(human);
                    mother.addChild(human);
                    this.getActiveTree().add(human);
                    this.setActiveSubject(human);
                    this.setActionLevel( ActionLevel.SubjectLevel);
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
        if (this.getActionLevel() == ActionLevel.TreeLevel || this.model.getActionLevel() == ActionLevel.SubjectLevel){
            return this.manager.searchByPattern(text);
        }
        return "Нет активного древа";
    }

    @Override
    public String createActiveTree(String text) {        
        boolean boo = manager.newTree(text);
        if (boo){            
            this.setActiveTree(manager.getActiveTree());
            this.setActionLevel(ActionLevel.TreeLevel);
            return "OK";
        }
        return "Ошибка записи"; 
    }

    @Override
    public String loadTree(String text) {
        if (this.manager.loadTree(text)){
            this.setActiveTree(this.manager.getActiveTree());            
            this.setActionLevel(ActionLevel.TreeLevel);
            return String.format("Древо %s загружено", this.getActiveTree().toString());
        }
        return "Ошибка чтения";
    }

    @Override
    public String showActiveSubjectInfo() {
        if (this.getActionLevel() == ActionLevel.SubjectLevel){
            return this.getActiveSubject().getInfo();
        }
        return "Субъект не обнаружен";
    }

    @Override
    public String removeMember() {
        if (this.getActionLevel() == ActionLevel.SubjectLevel){
           if (this.model.removeSubject()){
            this.setActiveSubject(null);
            this.setActionLevel(ActionLevel.TreeLevel);
            return "OK";
           }
        }
        return "Ошибка удаления";
    }

    @Override
    public String removeTree() {
        try {
            this.manager.deleteTree(this.getActiveTree());
            this.setActiveSubject(null);
            this.setActiveTree(null);
            this.setActionLevel(ActionLevel.NoLevel);
            return "OK";
        } catch (Exception e) {
            return "Ошибка удаления";
        }
        
    }

    @Override
    public String showSubjectList() {
        return this.getActiveTree().getInfo();
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
            male = this.getActiveTree().getItem(id1);
            female = this.getActiveTree().getItem(id2);        
        if (male == null || female == null){
            return "Субъекты не обнаружены";
        }
        if (male.setSpouse(female) && female.setSpouse(female)){
            return "OK";
        }
        return "Ошибка регистрации";
    }

    public String delMarriage(int id1, int id2) {
        Human male = this.getActiveTree().getItem(id1);
        Human female = this.getActiveTree().getItem(id2);
        if (male.setSpouse(null) && female.setSpouse(null)){
            return "OK";
        }
        return "Ошибка регистрации";
    }

    public TreeManager<Human> getTreeModel(){
        return this.manager;
    }

    

    

}
