
package cs544.blog.dao;

import cs544.blog.domain.Blog;
import cs544.blog.domain.Blogger;
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
    public boolean deleteBlogger(Blogger blogger) {
        sf.getCurrentSession().delete(blogger);
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
        return sf.getCurrentSession().createQuery("select b from Blogger br join br.blogs b").list();
    }

    @Override
    public Blog addBlong(Blog blog) {
        sf.getCurrentSession().save(blog);
        return blog;
    }
    
}
