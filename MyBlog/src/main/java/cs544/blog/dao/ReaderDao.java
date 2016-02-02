
package cs544.blog.dao;

import cs544.blog.domain.Reader;
import org.hibernate.SessionFactory;

public class ReaderDao implements IReaderDao{    
    private SessionFactory sf;
    public ReaderDao(SessionFactory sf){
        this.sf=sf;
    }

    @Override
    public Reader addReader(Reader reader) {
        sf.getCurrentSession().saveOrUpdate(reader);
        return reader;
    }

    @Override
    public boolean deleteReader(Reader reader) {
        sf.getCurrentSession().delete(reader);
        return reader!=null;
    }

    @Override
    public Reader updateReader(Reader reader) {
       sf.getCurrentSession().saveOrUpdate(reader);
       return reader;
    }

    @Override
    public Reader getReader(int id) {
        return (Reader)sf.getCurrentSession().get(Reader.class, id);
    }
    
}
