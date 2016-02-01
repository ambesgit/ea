
package cs544.blog.dao;

import cs544.blog.domain.Blog;
import java.util.List;

public interface IBlogDao {
    
    public Blog addBlog(Blog blog);
    public boolean deleteBlog(Blog blog);
    public Blog updateBlog(Blog blog);
    public Blog getBlog(int id);
   
}
