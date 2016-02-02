
package cs544.blog.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Blogger {
    @Id
    @GeneratedValue
    private Long id;
    @OneToMany
    @JoinColumn
    private List<Blog> blogs=new ArrayList();
  
    private String name;
   
    private long phone; 

    private String email;
   
    private String userName;
   
    private String password;
    @Embedded
   
    private Address address; 
    
    
    public Blogger(){}
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Blog> getBlogs() {
        return blogs;
    }

    public String getName() {
        return name;
    }

    public long getPhone() {
        return phone;
    }

    public Address getAddress() {
        return address;
    }

    public void setBlogs(List<Blog> blogs) {
        this.blogs = blogs;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public Blogger(Address address,String name, String email,String username,String password,long phone){
    
        this.name=name;
        this.email=email;
        this.userName=username;
        this.phone=phone;
        this.password=password;
        this.address=address;
    }
}
