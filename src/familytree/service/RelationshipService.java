package familytree.service;

import java.util.List;

public class RelationshipService {
    private MemberService memberService;

    public RelationshipService(MemberService memberService) {
        this.memberService = memberService;
    }

    public void addRelationship(String parentName, String childName) {
        Member parent = memberService.findMember(parentName);
        Member child = memberService.findMember(childName);
        if (parent != null && child != null) {
            parent.addChild(child);
        }
    }

    public List<Member> getChildren(String parentName) {
        Member parent = memberService.findMember(parentName);
        if (parent != null) {
            return parent.getChildren();
        }
        return List.of();
    }
}