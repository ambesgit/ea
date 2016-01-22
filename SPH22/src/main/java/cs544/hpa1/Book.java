
package cs544.hpa1;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book {
    private int id;
    private String title;
    private String ISBN;
    private String author;
    private double price;
    private java.util.Date publish_date;

    public Book() {
    }    

    public Book(String title, String ISBN, String author, double price, Date publish_date) {        
        this.title = title;
        this.ISBN = ISBN;
        this.author = author;
        this.price = price;
        this.publish_date = publish_date;
    }
    
    //add annotation so hibernate will do something based on the type of the annotation
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    public Date getPublish_date() {
        return publish_date;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setPublish_date(Date publish_date) {
        this.publish_date = publish_date;
    }

    @Override
    public String toString() {
        return "Book{" + "id=" + id + ", title=" + title + ", ISBN=" + ISBN + ", author=" + author + ", price=" + price + ", publish_date=" + publish_date + '}';
    }
    
    
}
