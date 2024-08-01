package famili_tree;

import famili_tree.Human.Human;
import famili_tree.family_tree.FamilyTree;



public class Main
{
    public static void main(String[] args) {
        Human numan1=new Human("Vasiliy", "Morozov", "man", "1990.06.22");
        Human numan2=new Human("Aleksandr", "Morozov", "man");
        Human numan3=new Human("Vasisuil", "lokhankin", "man", "1961.08.20","2003.09.25" );
        Human numan4=new Human("Evgeniya", "Morozova", "woman", "1991.03.12");
        FamilyTree treeM=new FamilyTree(numan1);
        numan1.addChildren(numan2);
        numan1.addChildren(numan2);
        numan1.addSuprug(numan4);
        // System.out.println(numan1);
        System.out.println(numan1.suprug);
        System.out.println(numan4.suprug);
        System.out.println(treeM);
        // System.out.println(numan1.children);
        // System.out.println(numan1.getVozrast());
        // System.out.println(numan3);
        
    }
}
