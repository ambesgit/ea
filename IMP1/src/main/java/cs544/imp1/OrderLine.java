
package cs544.imp1;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class OrderLine {
    private int id;
    private int quantity;
    
    //for Orderline and product association
    
    private Product product;

    @ManyToOne(cascade=CascadeType.ALL)
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
    

    public OrderLine() {
    }

    public OrderLine(int quantity) {        
        this.quantity = quantity;
    }
    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    
}
