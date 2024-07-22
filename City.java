public class City extends Places {
    private String city;

    public City(int homeNumber, String street, String region, String country, int postalCode, String city) {
        super(homeNumber, street, region, country, postalCode);
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "City = " + city + ", " + super.toString();
    }

}
