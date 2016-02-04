
package cs544.blog.dao;

import cs544.blog.domain.Blog;
import cs544.blog.domain.Comment;
import java.util.List;

public interface ICommentDao {
    public Comment addComment(Comment comment);
    public boolean deleteComment(Comment comment);
    public Comment updateComment(Comment comment);
    public Comment getComment(int id);
    public List<Comment> getAll();
    public Comment addComment(long id,Comment comment);
    
}
