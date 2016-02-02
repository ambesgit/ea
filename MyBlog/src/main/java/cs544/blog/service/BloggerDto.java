
package cs544.blog.service;

import cs544.blog.domain.Address;
import cs544.blog.domain.Blogger;


public class BloggerDto {
  
    private String name;
   
    private String userName;
   
    private String password;
   
    private String email;
  
    private long phone;
  
    private String street;
   
    private String city;
 
    private String state;
  
    private int zip;    
    BloggerDto(){
    }                 

    public String getName() {
        return name;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public long getPhone() {
        return phone;
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

    public void setName(String name) {
        this.name = name;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(long phone) {
        this.phone = phone;
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
    
    public Blogger bloggerFactory(){
    return new Blogger(new Address(street, city,state,zip),name, email,userName,password,phone);
    } 
    
}
