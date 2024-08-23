package familytree.model;

public interface SearchCriteria {
    boolean matches(TreeMember member);
}