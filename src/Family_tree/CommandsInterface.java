package Family_tree;

public interface CommandsInterface {
    
        
        String getSubjectInfo();
        String setDeathDate();
        String removeSubject();
   
        String saveTree();
        String removeTree();
        String addSubject();
        String addChild();
        String searchSubject();  
        String getSubjectsList();          
   
        String getTreeList();
        String addTree();
        String loadTree();
        String selectTree();
        String getActionList();
        void exit();  
}
