
package cs544.blog.domain;

import javax.persistence.Embeddable;


@Embeddable
public class Address {    
  
    private String street;
   
    private String city;
  
    private String state;
  
    private int zip;
    public Address(){}
    public Address(String street, String city, String state, int zip){
        this.city=city;
        this.state=state;
        this.street=street;
        this.zip=zip;
    
    }
    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public int getZip() {
        return zip;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }
    
}
