package Model.Creature;

import java.util.ArrayList;

public class Info {
   private final OwnInfo selfOwnInfo;
   private final OwnInfo matherOwnInfo;
   private final OwnInfo fatherOwnInfo;
   private final OwnInfo spouseOwnInfo;
   private final ArrayList<OwnInfo> childrenOwnInfo;

   public Info(OwnInfo selfOwnInfo, OwnInfo spouseOwnInfo, OwnInfo matherOwnInfo, OwnInfo fatherOwnInfo, ArrayList<OwnInfo> childrenOwnInfo) {
       this.childrenOwnInfo = childrenOwnInfo;
       this.fatherOwnInfo = fatherOwnInfo;
       this.matherOwnInfo = matherOwnInfo;
       this.spouseOwnInfo = spouseOwnInfo;
       this.selfOwnInfo = selfOwnInfo;
   }

    public ArrayList<OwnInfo> getChildrenInfo() {
        return childrenOwnInfo;
    }

    public OwnInfo getFatherInfo() {
        return fatherOwnInfo;
    }

    public OwnInfo getMatherInfo() {
        return matherOwnInfo;
    }

    public OwnInfo getSelfInfo() {
        return selfOwnInfo;
    }

    public OwnInfo getSpouseInfo() {
        return spouseOwnInfo;
    }
}
