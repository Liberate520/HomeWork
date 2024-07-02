package Family_tree.Presenter;
import Family_tree.Model.HumanService;
import Family_tree.View.ActionLevel;
import Family_tree.View.HumanView;


public class HumanPresenter extends Presenter {    
    private HumanView view;      
    private HumanService service;
   


    public HumanPresenter(HumanView value){                 
        this.service = new HumanService();        
        this.view = value;
    }

    public ActionLevel getActionLevel(){
        return service.getActionLevel();
    }

    public void setActionLevel(ActionLevel level){
        service.setActionLevel(level);        
        //view.setActionLevel(level);
    }
   

    public String setActiveTree(int tree){
        try{
            service.setActiveTree(tree);
            this.setActionLevel(ActionLevel.TreeLevel);
            return String.format("Активно древо %s", this.service.getActiveTree().toString());
        } catch (Exception e) {
            System.out.println(e);
            this.setActionLevel(ActionLevel.NoLevel);
            return "Ошибка выбора";
        }
        
        
    }

    public boolean getActiveSubject(){
        return service.getActiveElement();
    }

    public void setActiveSubject(int human){
        service.setActiveElement(human);
    }

    public void setView(HumanView value) {
        this.view = value;
    }

    

    @Override
    public String selectTree(int index) { 
        if (this.service.getCollection().isEmpty()){
            return "Коллекция пуста";
        }       
        System.out.println(this.service.showList());
        System.out.println("Ваш выбор");
        return "";
      }    

    @Override
    public String setDeathDate(String text) {
        if (this.service.getActionLevel() == ActionLevel.SubjectLevel){
            if (this.service.setDeathDate(text)){
                return "OK";
            }
        }
        return "Ошибка записи";
    }

   

    public String getDeathDate(){
        if (this.service.getActionLevel() == ActionLevel.SubjectLevel) {   
            return service.getDeathDate();
        }               
        return "Древо не найдено";        
    }

    @Override
    public String saveTree(String text) {
        if (this.service.getActionLevel() == ActionLevel.TreeLevel || this.service.getActionLevel() == ActionLevel.SubjectLevel){
            //System.out.println(this.service.getActionLevel());
            if (this.service.saveTree(text)){
                return "OK";
            }
        }
        return "Ошибка записи";
    }

   

    @Override
    public String addToTree(String name, String gender, String birhday) {
        try{
            if(service.addToTree(name, gender, birhday)){
                return "OK";
            }            
        }catch(Exception e){
            System.out.println(e);
            return "Ошибка записи";
        }
        return "Ошибка записи";
    }
        

    @Override
    public String newChild(String name, String gender, String birhday, int IDFather, int IDMother) {
        if (this.getActionLevel() == ActionLevel.TreeLevel || this.service.getActionLevel() == ActionLevel.SubjectLevel){
            try{                
                return service.newChild(name, gender, birhday, IDFather, IDMother);                      
            } catch (Exception e) {
                return "Ошибка записи";
            }
        }
        return "Нет активного древа";
    }

    @Override
    public String searchByPattern(String text) {
        if (this.getActionLevel() == ActionLevel.TreeLevel || this.service.getActionLevel() == ActionLevel.SubjectLevel){
            return this.service.searchByPattern(text);
        }
        return "Нет активного древа";
    }

    @Override
    public String createActiveTree(String text) {        
        boolean boo = service.newTree(text);
        if (boo){            
            this.setActionLevel(ActionLevel.TreeLevel);
            return "OK";
        }
        return "Ошибка записи"; 
    }

    @Override
    public String loadTree(String text) {        
        if (service.loadTree(text)){
            return "OK";
        }
        return "Ошибка чтения";
    }

   

    @Override
    public String showActiveSubjectInfo() {
        return service.showActiveSubjectInfo();
    }

    @Override
    public String removeMember() {
       return service.removeMember();
    }

    @Override
    public String removeTree() {
        return service.removeTree();
    }

    @Override
    public String showSubjectList() {
        return service.showSubjectList();
    }

    @Override
    public String getTreeList() {
        if (this.service.isEmpty()){
            return "Список древ пуст";
        }
        return this.service.showList();
    }

    
    public HumanService getservice() {
        return this.service;
    }

   
    public void setservice(HumanService value) {
        this.service = value;
    }

    public String setMarriage(int id1, int id2) {        
        return service.setMarriage(id1, id2);
    }

    public String delMarriage(int id1, int id2) {
        return service.delMarriage(id1, id2);
    }

    public HumanService getService(){
        return this.service;
    }

    public String selectSubject(int index) {        
        return service.selectSubject(index);
    }

    

    

}
