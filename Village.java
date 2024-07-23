public class Village extends Places {
    private String village;

    public Village(int homeNumber, String street, String region, String country, int postalCode, String village) {
        super(homeNumber, street, region, country, postalCode);
        this.village = village;
    }

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
    }

    @Override
    public String toString() {
        return getInfo();
    }

    @Override
    public String getInfo() {
        return "Деревня: " + village + ", " + super.getInfo();
    }

}
