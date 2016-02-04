
package cs544.blog.service;

import cs544.blog.domain.Blog;
import cs544.blog.domain.Blogger;
import cs544.blog.domain.Comment;
import java.util.List;

public interface IBloggerService {
    public Blogger addBlogger(Blogger blogger);
    public List<Blogger> getBloggers();
    public Blogger addBlogger(Blogger blogger,Blog blog);
    public List<Blog> getBlogs();
     public Blog getBlog(long id);
     public Comment addComment(long id,Comment comment);
     public boolean deleteBlog(long id);
     public boolean updateBlog(Blog blog);
}
