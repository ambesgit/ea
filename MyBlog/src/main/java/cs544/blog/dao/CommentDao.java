
package cs544.blog.dao;

import cs544.blog.domain.Blog;
import cs544.blog.domain.Comment;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import org.hibernate.SessionFactory;

public class CommentDao implements ICommentDao{
    private SessionFactory sf;
    private BlogDao blogDao;  
    
    public CommentDao(SessionFactory sf, BlogDao blogDao){
        this.sf=sf;
        this.blogDao=blogDao;
    }
    @Override
    public Comment addComment(Comment comment) {
        sf.getCurrentSession().saveOrUpdate(comment);
        return comment;
    }

    @Override
    public boolean deleteComment(Comment comment) {
        sf.getCurrentSession().delete(comment);
        return comment!=null;
    }

    @Override
    public Comment updateComment(Comment comment) {
        sf.getCurrentSession().saveOrUpdate(comment);
        return comment;
    }

    @Override
    public Comment getComment(int id) {
        return (Comment)sf.getCurrentSession().get(Comment.class,id);
    }

    @Override
    public List<Comment> getAll() {
        return sf.getCurrentSession().createQuery("select c from Blog b join b.comments c").list();
    }

    @Override
    public Comment addComment(long id, Comment comment) {
        comment.setCommentedDate(new Date());
        long cid=(Long)sf.getCurrentSession().save(comment);
        Comment c=(Comment)sf.getCurrentSession().get(Comment.class, cid);
        Blog blog=(Blog)sf.getCurrentSession().get(Blog.class, id);
        return blogDao.addComment(blog,c);
        
    }
    
}
