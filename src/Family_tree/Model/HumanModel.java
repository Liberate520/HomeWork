package Family_tree.Model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import Family_tree.Model.Humans.Gender;
import Family_tree.Model.Humans.Human;
import Family_tree.Model.Tree.Family_tree;
import Family_tree.View.ActionLevel;

public class HumanModel extends ElementManager<Human> {

    private Human activeElement;
    private Family_tree<Human> activeTree;
    private String FormateDate = "d.MM.yyyy";
    private ActionLevel actionLevel ;
    //private boolean isActiveTreeEmpty;


    public HumanModel(){
        this.activeElement = null;
        this.activeTree = null;
       // this.isActiveTreeEmpty = true;
    }

    public void setActionLevel(ActionLevel level){
        this.actionLevel = level;
    }

    public ActionLevel getActionLevel(){
        return this.actionLevel;
    }

    private Gender strToGender(String value){
        if (value.equalsIgnoreCase("м")){
            return Gender.Male;
        } else if(value.equalsIgnoreCase("ж")){
            return Gender.Female;
        } else {
            return null;
        }
    }

    public boolean setDeathDate(String date){        
        try{
            this.activeElement.setDeathDate(strToDate(date));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private LocalDate strToDate(String value){
        try{
            DateTimeFormatter formatter =DateTimeFormatter.ofPattern(FormateDate);
            LocalDate d = LocalDate.parse(value, formatter);
            return d;
        } catch (Exception e){
            return null;
        }
    }

    
    public Human newSubject(String name, Gender gender, LocalDate bd) {
        Human human = new Human(name, gender, bd);
        this.activeElement = human;
        return  human;
    }



    

    public boolean addToActiveTree(String name, String gender, String bd){ 
        try{
            
            Human human = newSubject(name, strToGender(gender), strToDate(bd));
            this.activeTree.add(human);  
            return true;
        }  catch (Exception e) {
            System.out.println(e);
            return false;
        }     
              
    }

    @Override
    public boolean removeSubject() {
        try{
            Human human = this.activeElement;
            Family_tree<Human> tree = super.getActiveTree();
            tree.remove(human);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean setActiveSubject(int id) {
        try{
            this.activeElement = this.activeTree.getItem(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }    

    @Override
    public boolean setActiveSubject(long innerID) {
        try{
            this.activeElement = this.activeTree.getItemByInnerID(innerID); 
            if (this.activeElement != null) {
                return true;
            }                
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;       
    }

    @Override
    public boolean setActiveSubject(Human subject) {
       for (Human human : this.activeTree.getMemberList()) {
            if(human.equals(subject)){
                this.activeElement = human;
                return true;
            }
       }
       return false;
    }

    private String mapText(Map<Integer, Human> value){   
        if (value.isEmpty()){
            return "Ничего не найдено";
        }     
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Integer,Human> entray : value.entrySet()) {
            sb.append(entray.getKey());
            sb.append(" ");
            sb.append(entray.getValue());
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public String searchSubject(String pattern) {
        Map<Integer, Human> list = this.activeTree.searchByPattern(pattern);
        return mapText(list);
    }

    @Override
    public String searchSubject(String pattern, Family_tree<Human> tree) { // Зарезервировано для взаимодействий между древами
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'searchSubject'");
    }

    @Override
    public String searchSubject(String pattern, long treeInnerID) { // Зарезервировано для взаимодействий между древами
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'searchSubject'");
    }

    @Override
    public String searchSubject(String pattern, int treeIndex) { // Зарезервировано для взаимодействий между древами
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'searchSubject'");
    }

    @Override
    public boolean setChild(Human subject, Human father, Human mother) {
        try{
            subject.setFather(father);
            subject.setMother(mother);
            father.addChild(subject);
            mother.addChild(subject);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean newSubject(String name, String gender, String bd) {
        try{
            Human human = newSubject(name, strToGender(gender), strToDate(bd));
            this.activeElement = human;
            return true;
        }catch (Exception e) {
            return false;
        }       
    }

    @Override
    public Human newItem(String name, String gender, String bd) {
        Human human = newSubject(name, strToGender(gender), strToDate(bd));
        this.activeElement = human;
        return human;
    }

    public Family_tree<Human> getActiveTree(){
        return this.activeTree;
    }

    public Human getActiveElement(){
        return this.activeElement;
    }

    public void setActiveTree(Family_tree<Human> tree){
        this.activeTree = tree;
    }

    public void setActiveElement(Human human) {
        this.activeElement = human;
    }

    

    
}
