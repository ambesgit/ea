
package cs544.blog.domain;

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
    
     public Comment() {
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
    
}
