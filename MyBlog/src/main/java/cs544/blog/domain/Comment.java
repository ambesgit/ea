
package cs544.blog.domain;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Comment {

    @Id
    @GeneratedValue
    private Long id;
    @Lob
    private String content;
    private Date commentedDate;
    public Comment(){
         
    }
     public Comment(String content){
         this.content=content;
     }
    public Long getId() {
        return id;
    }

    private void setId(Long id) {
        this.id = id;
    }
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCommentedDate() {
        return commentedDate;
    }

    public void setCommentedDate(Date commentedDate){
        this.commentedDate = commentedDate;
    }
    
}
