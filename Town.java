public class Town extends Places {
    protected String town;

    public Town(int homeNumber, String street, String region, String country, int postalCode, String town) {
        super(homeNumber, street, region, country, postalCode);
        this.town = town;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    @Override
    public String toString() {
        return getInfo();
    }

    @Override
    public String getInfo() {
        return "Город: " + town + ", " + super.getInfo();
    }

}
