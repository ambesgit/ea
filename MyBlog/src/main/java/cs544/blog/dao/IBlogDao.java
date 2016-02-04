
package cs544.blog.dao;

import cs544.blog.domain.Blog;
import cs544.blog.domain.Comment;
import java.util.List;

public interface IBlogDao {
    
    public Blog addBlog(Blog blog);
    public boolean deleteBlog(Blog blog);
    public Blog updateBlog(Blog blog);
    public Blog getBlog(long id);
    public List<Blog> getAllBlog();
     public Comment addComment(Blog blog,Comment comment);
   
}
