import Writer.FileHandler;
import family_tree.FamilyTree;
import human.Gender;
import human.Human;
import human.HumanId;

import java.time.LocalDate;

public class Servise {
    private  FamilyTree familyTree;
    private FileHandler fileHandler;
    private  HumanId humanId;
    public Servise(){
        this.familyTree=new FamilyTree();
        this.humanId=new HumanId();
        this.fileHandler = new FileHandler();
    }
    public  void addHuman(String name, Gender sex, LocalDate brthDate){
        Human human = humanId.build(name,sex,brthDate);

        familyTree.add(human);

    }
    public  String getHumansList(){

        return familyTree.getInfo();

    }
    public void saveTree() {
        fileHandler.Save(familyTree);
    }
    public void saveTree(FamilyTree familyTree) {
        fileHandler.Save(familyTree);
    }

    public FamilyTree loadTree() {
        return (FamilyTree) fileHandler.Load();
    }
    public String GetInfoFamilyTree(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("На данный момент в дереве:\n");

        for (Object human : familyTree) {
            stringBuilder.append(human);
            stringBuilder.append("\n");

        }
        return stringBuilder.toString();
    }
    public void SortByName(){
        familyTree.SortByName();
    }
    public void SortBybrthDate(){
        familyTree.SortByBrthDate();
    }



}
