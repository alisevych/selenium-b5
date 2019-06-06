package site.entities;

public class User {

    public String taxID;
    public String company;
    public String firstName;
    public String lastName;
    public String address1;
    public String address2;
    public String postcode;
    public String city;
    public String country;
    public String state;
    public int stateNumber;
    public String email;
    public String phone;
    public boolean newsletterSubscribe;
    public String desiredPassword;
    public String confirmPassword;

    public User(){
    }

    public User(String firstName, String lastName, String address1, String postcode,
                String city, String country, int stateNumber, String email, String phone, String password){
        this.firstName = firstName;
        this.lastName = lastName;
        this.address1 = address1;
        this.postcode = postcode;
        this.city = city;
        this.country = country;
        this.stateNumber = stateNumber;
        this.email = email;
        this.phone = phone;
        this.desiredPassword = password;
        this.confirmPassword = password;
    }

    public void setTaxID(String taxID) {
        this.taxID = taxID;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setNewsletterSubscribe(boolean newsletterSubscribe) {
        this.newsletterSubscribe = newsletterSubscribe;
    }

    public void setDesiredPassword(String password) {
        this.desiredPassword = password;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
