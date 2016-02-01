
package cs544.blog.service;



import cs544.blog.dao.IAddressDao;
import cs544.blog.dao.IBlogDao;
import cs544.blog.dao.IBloggerDao;
import cs544.blog.dao.ICommentDao;
import cs544.blog.dao.IReaderDao;
import javax.transaction.Transactional;

@Transactional
public class BlogService {
    private final IBlogDao blogDao;
    private final IBloggerDao bloggerDao;
    private final ICommentDao commentDao;
    private final IReaderDao readerDao;
    private final IAddressDao addressDao;
    public BlogService(IAddressDao addressDao,IBlogDao blogDao,IBloggerDao bloggerDao,ICommentDao commentDao,IReaderDao readerDao){    
            this.blogDao=blogDao;
            this.bloggerDao=bloggerDao;
            this.commentDao=commentDao;
            this.readerDao=readerDao;
            this.addressDao=addressDao;
    }
   
    
}
