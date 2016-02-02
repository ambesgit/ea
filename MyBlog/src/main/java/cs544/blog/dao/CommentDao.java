
package cs544.blog.dao;

import cs544.blog.domain.Comment;
import java.util.List;
import org.hibernate.SessionFactory;

public class CommentDao implements ICommentDao{
    private SessionFactory sf;
    public CommentDao(SessionFactory sf){
        this.sf=sf;
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
    
}
