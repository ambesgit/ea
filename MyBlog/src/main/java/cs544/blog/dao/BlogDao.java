
package cs544.blog.dao;


import cs544.blog.domain.Blog;
import cs544.blog.domain.Comment;
import java.util.List;
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
    public boolean deleteBlog(long id) {
        Blog blog=(Blog)sf.getCurrentSession().get(Blog.class, id);
         sf.getCurrentSession().delete(blog);
         sf.getCurrentSession().flush();
        return blog!=null;
    }

    @Override
    public boolean updateBlog(Blog blog) {        
        sf.getCurrentSession().saveOrUpdate(blog);
        return true;
        
    }

    @Override
    public Blog getBlog(long id) {        
        return (Blog)sf.getCurrentSession().createQuery("select b from Blog b left join fetch b.comments where b.id=:id").setParameter("id", id).uniqueResult();
    }    

    @Override
    public List<Blog> getAllBlog() {
        return sf.getCurrentSession().createQuery("select distinct b from Blog b left join fetch b.comments ").list();
    }

    @Override
    public Comment addComment(Blog blog,Comment comment) {
        blog.addComment(comment);
        sf.getCurrentSession().saveOrUpdate(blog);
        return comment;
    }
}
