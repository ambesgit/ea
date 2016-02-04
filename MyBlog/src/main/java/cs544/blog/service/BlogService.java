
package cs544.blog.service;



import cs544.blog.dao.IAddressDao;
import cs544.blog.dao.IBlogDao;
import cs544.blog.dao.IBloggerDao;
import cs544.blog.dao.ICommentDao;
import cs544.blog.domain.Blog;
import cs544.blog.domain.Blogger;
import cs544.blog.domain.Comment;

import java.util.List;
import javax.transaction.Transactional;

@Transactional
public class BlogService {   
    private final IBlogDao blogDao;
    private final IBloggerDao bloggerDao;
    private final ICommentDao commentDao;    
    private final IAddressDao addressDao;

    
   
    public BlogService(IAddressDao addressDao,IBlogDao blogDao,IBloggerDao bloggerDao,ICommentDao commentDao){    
            this.blogDao=blogDao;
            this.bloggerDao=bloggerDao;
            this.commentDao=commentDao;           
            this.addressDao=addressDao;
            
    }
     //Add and retrieve Bloggers
   public Blogger addBlogger(Blogger b){
       return bloggerDao.addBlogger(b);
   }  
   public List<Blogger> getBloggers(){
        return bloggerDao.getAllBloggers();
   }    
    public Blogger addBlogger(Blogger blogger,Blog blog){ //adde blog but also update blogger
        return bloggerDao.addBlogger(blogger,blog);
    }
    
    //To retrieve all blogs from all bloggers
     public List<Blog> getBlogs(){
        return blogDao.getAllBlog();
    }
     public Blog getBlog(long id){
        return blogDao.getBlog(id);
    }
    public Comment addComment(long id,Comment comment){
        return commentDao.addComment(id, comment);
    }
    public boolean deleteBlog(long id){
       return  blogDao.deleteBlog(id);
    }
    
     public boolean updateBlog(Blog blog){
       return  blogDao.updateBlog(blog);
    }
}
