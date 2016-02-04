
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
public class BlogService implements IBloggerService{   
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
    @Override
   public Blogger addBlogger(Blogger b){
       return bloggerDao.addBlogger(b);
   }  
    @Override
   public List<Blogger> getBloggers(){
        return bloggerDao.getAllBloggers();
   }   
     @Override
    public Blogger addBlogger(Blogger blogger,Blog blog){ //adde blog but also update blogger
        return bloggerDao.addBlogger(blogger,blog);
    }
    
    //To retrieve all blogs from all bloggers
     @Override
     public List<Blog> getBlogs(){
        return blogDao.getAllBlog();
    }
     @Override
     public Blog getBlog(long id){
        return blogDao.getBlog(id);
    }
    @Override
    public Comment addComment(long id,Comment comment){
        return commentDao.addComment(id, comment);
    }
    @Override
    public boolean deleteBlog(long id){
       return  blogDao.deleteBlog(id);
    }
     @Override
     public boolean updateBlog(Blog blog){
       return  blogDao.updateBlog(blog);
    }
}
