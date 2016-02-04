
package cs544.blog.dao;

import cs544.blog.domain.Blog;
import cs544.blog.domain.Blogger;
import java.util.Date;
import java.util.List;
import org.hibernate.SessionFactory;

public class BloggerDao implements IBloggerDao{
    
    private SessionFactory sf;
    
    public BloggerDao(SessionFactory sf){
        this.sf=sf;    
    }

    @Override
    public Blogger addBlogger(Blogger blogger) {
        sf.getCurrentSession().saveOrUpdate(blogger);
        return blogger;
    }

    @Override
    public boolean deleteBlogger(long id) {
        Blogger blogger=(Blogger)sf.getCurrentSession().get(Blogger.class, id);
        sf.getCurrentSession().delete(blogger);
        sf.getCurrentSession().flush();
        return blogger!=null;
    }

    @Override
    public Blogger  updateBlogger(Blogger blogger) {
        sf.getCurrentSession().saveOrUpdate(blogger);
        return blogger;
    }

    @Override
    public Blogger getBlogger(int id) {
        return (Blogger)sf.getCurrentSession().get(Blogger.class, id);
    }
      @Override
    public List<Blogger> getAllBloggers() {
        return sf.getCurrentSession().createQuery("from Blogger").list();
    }

    @Override
    public List<Blog> getAllBlogs() {
        return sf.getCurrentSession().createQuery("select b from Blogger br left join fetch br.blogs b").list();
    }

    
       
    @Override
    public Blogger addBlogger(Blogger blogger,Blog blog) { 
        blog.setPostedDate(new Date());
        blog.setAuthor(blogger);
        sf.getCurrentSession().save(blog); 
       
        return blogger;
    }
    
}
