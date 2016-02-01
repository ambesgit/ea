
package cs544.blog.dao;

import cs544.blog.domain.Reader;

public interface IReaderDao {    
    public Reader addReader(Reader reader);
    public boolean deleteReader(Reader reader);
    public Reader updateReader(Reader reader);
    public Reader getReader(int id);
    
}
