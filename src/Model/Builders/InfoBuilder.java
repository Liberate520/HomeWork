package Model.Builders;

import Model.Creature.Info;
import Model.Creature.OwnInfo;

import java.util.ArrayList;

public class InfoBuilder {
    private OwnInfo selfOwnInfo;
    private OwnInfo matherOwnInfo;
    private OwnInfo fatherOwnInfo;
    private OwnInfo spouseOwnInfo;
    private ArrayList<OwnInfo> childrenOwnInfo;

    public InfoBuilder setSelfInfo(OwnInfo selfOwnInfo) {
        this.selfOwnInfo = selfOwnInfo;

        return this;
    }

    public InfoBuilder setSpouseInfo(OwnInfo spouseOwnInfo) {
        this.spouseOwnInfo = spouseOwnInfo;

        return this;
    }

    public InfoBuilder setMatherInfo(OwnInfo matherOwnInfo) {
        this.matherOwnInfo = matherOwnInfo;

        return this;
    }

    public InfoBuilder setFatherInfo(OwnInfo fatherOwnInfo) {
        this.fatherOwnInfo = fatherOwnInfo;

        return this;
    }

    public InfoBuilder setChildrenInfo(ArrayList<OwnInfo> childrenOwnInfo) {
        this.childrenOwnInfo = childrenOwnInfo;

        return this;
    }

    public Info build(){
        return new Info(this.selfOwnInfo, this.spouseOwnInfo, this.matherOwnInfo, this.fatherOwnInfo, this.childrenOwnInfo);
    }
}
