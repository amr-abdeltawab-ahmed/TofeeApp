public class Address {
    private String city;
    private String street;
    private String state;
    private int zip_code;

    public Address(String city, String street, String state, int zip_code) {
        this.city = city;
        this.street = street;
        this.state = state;
        this.zip_code = zip_code;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setZip_code(int zip_code) {
        this.zip_code = zip_code;
    }

    public String getStreet() {
        return street;
    }

    public String getState() {
        return state;
    }

    public int getZip_code() {
        return zip_code;
    }

    public String printAddress(){
        return "City: "+city+"\t"+"Street: "+street+"\t"+"State: "+state+"\t"+"Zip code: "+zip_code;
    }

}
