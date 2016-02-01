
package cs544.blog.dao;

import cs544.blog.domain.Blog;
import org.hibernate.SessionFactory;


public class BlogDao implements IBlogDao{
    private SessionFactory sf;
    public BlogDao(SessionFactory sf){
        this.sf=sf;
    }

    @Override
    public Blog addBlog(Blog blog) {
        sf.getCurrentSession().saveOrUpdate(blog);
        return blog;
    }

    @Override
    public boolean deleteBlog(Blog blog) {
        sf.getCurrentSession().delete(blog);
        return blog!=null;
    }

    @Override
    public Blog updateBlog(Blog blog) {
        sf.getCurrentSession().saveOrUpdate(blog);
        return blog;
        
    }

    @Override
    public Blog getBlog(int id) {        
        return (Blog)sf.getCurrentSession().get(Blog.class, id);
    }

  
    
}
