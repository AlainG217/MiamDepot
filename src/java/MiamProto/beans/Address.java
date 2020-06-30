/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MiamProto.beans;

/**
 *
 * @author stagjava
 */
public class Address {

    /**
     * Attributes
     */
    private int     id;
    private String  firstName;
    private String  laststName;
    private String  line1;
    private String  line2;
    private String  postalCode;
    private String  city;
    private String  phone;
    private String  email;
    
    /**
     * Getters and setters
     */

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLaststName() {
        return laststName;
    }

    public void setLaststName(String laststName) {
        this.laststName = laststName;
    }

    public String getLine1() {
        return line1;
    }

    public void setLine1(String line1) {
        this.line1 = line1;
    }

    public String getLine2() {
        return line2;
    }

    public void setLine2(String line2) {
        this.line2 = line2;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Address{" + "id=" + id + ", firstName=" + firstName + ", laststName=" + laststName + ", line1=" + line1 + ", line2=" + line2 + ", postalCode=" + postalCode + ", city=" + city + ", phone=" + phone + ", email=" + email + '}';
    }
    
   
}
