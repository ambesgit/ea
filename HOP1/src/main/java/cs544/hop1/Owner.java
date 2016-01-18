package cs544.hop1;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import org.hibernate.FetchMode;
import org.hibernate.annotations.Fetch;

@Entity
//@org.hibernate.annotations.BatchSize(size=50)
//@NamedQuery(name="owner_pets",query="select o from Owner o left join fetch o.pets")

public class Owner {
	@Id  
    @GeneratedValue
    private int id;
    private String name;
    @OneToMany (cascade={CascadeType.PERSIST})
    @org.hibernate.annotations.Fetch(org.hibernate.annotations.FetchMode.JOIN)
    //@org.hibernate.annotations.Fetch(org.hibernate.annotations.FetchMode.SUBSELECT)
    @JoinColumn (name="clientid")
    private List<Pet> pets;
    
	public Owner() {
	}
	public Owner(String name) {
		super();
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Pet> getPets() {
		return pets;
	}
	public void setPets(List<Pet> pets) {
		this.pets = pets;
	}
    
	
    
}
