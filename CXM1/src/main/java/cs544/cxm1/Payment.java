
package cs544.cxm1;

import javax.persistence.Embeddable;

@Embeddable
public class Payment {//no id is required for embeddable because they live inside a table with its own id
    private String payDate;
    private double amount;

    public Payment(String payDate, double amount) {
        this.payDate = payDate;
        this.amount = amount;
    }

    public Payment() {
    }
    

    public String getPayDate() {
        return payDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setPayDate(String payDate) {
        this.payDate = payDate;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
    
    
}
