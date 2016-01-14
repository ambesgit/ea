
package cs544.imp1;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="ordertable")
public class Order {
    private int orderId;
    private Date date;
    //for Order and OrderLine association   
    private List<OrderLine> orderLines=new ArrayList();
    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="order_id")
    public List<OrderLine> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(List<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }
    public void addOrderline(OrderLine orderline){
        this.orderLines.add(orderline);
    }
    public OrderLine getOrderLine(int index){
        return orderLines.get(index);
    }
    
    //for Customer Order association
    private Customer owner;
    
    @ManyToOne   
    public Customer getOwner() {
        return owner;
    }

    public void setOwner(Customer customer) {
        this.owner = customer;
    }
    
    public Order() {
    }
    
    
    public Order(Date date) {        
        this.date = date;
    }
    @Id
    @GeneratedValue
    public int getOrderId() {
        return orderId;
    }

    public Date getDate() {
        return date;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
}
