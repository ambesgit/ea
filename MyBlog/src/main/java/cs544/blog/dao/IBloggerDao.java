
package cs544.blog.dao;

import cs544.blog.domain.Blog;
import cs544.blog.domain.Blogger;
import java.util.List;

public interface IBloggerDao {
    public Blogger addBlogger(Blogger blogger);
    public boolean deleteBlogger(Blogger blogger);
    public Blogger updateBlogger(Blogger blogger);
    public Blogger getBlogger(int id);    
    public List<Blogger> getAllBloggers();
    public List<Blog> getAllBlogs();
    
    
}
