package module.lesson2.human;

public class Status {
    public Gender getGender(int any){
        return switch (any) {
            case 1 -> Gender.MAN;
            case 2 -> Gender.WOMAN;
            default -> throw new IllegalStateException("Unexpected value: " + any);
        };
    }
    public FamilyStatus getStatus(int any){
        return switch (any) {
            case 1 -> FamilyStatus.HUSBAND;
            case 2 -> FamilyStatus.WIFE;
            default -> throw new IllegalStateException("Unexpected value: " + any);
        };
    }
}
