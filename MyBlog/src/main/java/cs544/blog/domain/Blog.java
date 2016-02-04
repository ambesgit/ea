
package cs544.blog.domain;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Blog {
    @Id
    @GeneratedValue
    private Long id;
   
    private String title;
   
    @Lob
    private String content;
    @ManyToOne    
    private Blogger author;
    @OneToMany
    @JoinColumn
    private List<Comment> comments=new ArrayList();
    private int views=0;
    private Date postedDate;
    public Blog(){}
    public Blog(String t,String c,Blogger a,Date date){
        this.author=a;       
        this.content=c;
        this.postedDate=date;
        this.title=t;
        
    }
    public Long getId() {
        return id;
    }

    private void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public Blogger getAuthor() {
        return author;
    }

    public Comment getComments(int index) {
        return comments.get(index);
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setAuthor(Blogger author) {
        this.author = author;
    }

    public void addComment(Comment c) {
        this.comments.add(c);
        views+=1;
    }

    public int getViews() {
        return comments.size();
    }

    public Date getPostedDate() {
        return postedDate;
    }

    private void setViews(int views) {
        this.views = views;
    }

    public void setPostedDate(Date postedDate) {
        this.postedDate = postedDate;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }    
}
