package familytree.service;

import java.io.*;
import java.util.Map;

public class DataService {
    private MemberService memberService;

    public DataService(MemberService memberService) {
        this.memberService = memberService;
    }

    public void saveTree(String filename) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeObject(memberService.getFamilyTree());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadTree(String filename) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            Map<String, Member> familyTree = (Map<String, Member>) in.readObject();
            memberService.getFamilyTree().putAll(familyTree);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}