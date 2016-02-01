
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
    
    
}
