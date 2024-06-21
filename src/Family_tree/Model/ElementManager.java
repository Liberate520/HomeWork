package Family_tree.Model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import Family_tree.Model.Humans.Endothermal;
import Family_tree.Model.Humans.Gender;
import Family_tree.Model.Tree.Family_tree;

public abstract class ElementManager<T extends Endothermal> implements ElementManagment<T> { 

    private T activeElement;
    private Family_tree<T> activeTree;
    private String FormateDate = "d.MM.yyyy";
    private boolean isActiveTreeEmpty;
    //private TreeManager<T> treeManager;
    

    public ElementManager (/*TreeManager<T> treeManager*/){       
        this.activeElement = null;
        this.activeTree = null;
        this.isActiveTreeEmpty = true;
        //this.treeManager = treeManager;
    }
    public void setFormateDate(String value){
        this.FormateDate = value;
    }

    public String getFormateDate(){
        return this.FormateDate;
    }
    
    public boolean ActiveTreeIsEmpty(){
        if (activeTree == null || activeTree.getMemberList().isEmpty()){
            return true;
        }
        return false;
    }

    public Family_tree<T> getActiveTree(){return this.activeTree;}

    public void setActiveTree(Family_tree<T> value) {this.activeTree = value; }

    abstract T newSubject(String name, Gender gender, LocalDate bd);

    private Gender strToGender(String value){
        if (value.equalsIgnoreCase("м")){
            return Gender.Male;
        } else if(value.equalsIgnoreCase("ж")){
            return Gender.Female;
        } else {
            return null;
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

    @Override
    public boolean addToTree(T subject) {
        if (activeTree == null){
            return false;
        }
        activeTree.add(subject);
        activeElement = subject;
        this.isActiveTreeEmpty = false;
        return true;
    }

    @Override
    public boolean newSubject(String name, String gender, String bd) {
        Gender sex = strToGender(gender);
        LocalDate birthDate = strToDate(bd);
        try{
            T subject = newSubject(name, sex, birthDate);
            this.activeElement = subject;
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean addToTree(T subject, Family_tree<T> tree) {
        try { 
            tree.add(subject);
            return true;
        }
         catch (Exception e)  {
            return false;
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

    private String dateText(LocalDate date){
        return date.format(DateTimeFormatter.ofPattern("d.MM.yyyy"));
    }


    public String getDeathDate(){
        if (this.activeElement.getDeatdDate() != null){
            LocalDate date = this.activeElement.getDeatdDate();
            return dateText(date);
        }
        return "отсутствует";
    }

    @Override
    public int getActiveSubjectIndex() {
        for (int i = 0; i < this.activeTree.getCount(); i++){
            if (this.activeElement.equals(this.activeTree.getItem(i))){
                return i;
            }
        }
        return -1;
    }

    @Override
    public long getActiveSubjectInnerID() {
        return this.activeElement.getInnerID();
    }

    @Override
    public String getInfo() {
        return this.activeElement.getInfo();
    }    

}
