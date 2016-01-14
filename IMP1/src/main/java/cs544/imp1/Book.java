
package cs544.imp1;

import java.util.logging.Logger;
import javax.persistence.Entity;
@Entity
public class Book extends Product{
    private String title;

    public Book() {
    }

    public Book(String title, String name, String description) {
        super(name, description);
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    
}
