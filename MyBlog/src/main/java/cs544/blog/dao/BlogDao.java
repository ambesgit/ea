
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
    
    
//    private Session ss;
//    private  Transaction tx;
//    {
//        
//    try{
//        Address a1=new Address("street1","city1","state1",12341);
//        Address a2=new Address("street2","city2","state2",12342);
//        Address a3=new Address("street3","city3","state3",12343);
//        Address a4=new Address("street4","city4","state4",12344);
//        Address a5=new Address("street5","city5","state5",12345);       
//        //initialize blogger
//        Blogger bl1=new Blogger(a1,"name1", "email1","username1","password1",1234567891);
//        Blogger bl2=new Blogger(a2,"name2", "email2","username2","password2",1234567892);
//        Blogger bl3=new Blogger(a3,"name3", "email3","username3","password3",1234567893);
//        Blogger bl4=new Blogger(a4,"name4", "email4","username4","password4",1234567894);
//        Blogger bl5=new Blogger(a5,"name5", "email5","username5","password5",1234567895);
//        ss=sf.getCurrentSession();
//       tx=ss.beginTransaction();
//        ss.save(bl1);
//        ss.save(bl5);
//        ss.save(bl4);
//        ss.save(bl3);
//        ss.save(bl2);
//          //initialize comment
//        Comment c1=new Comment("comment1");
//        Comment c2=new Comment("comment2");
//        Comment c3=new Comment("comment3");
//        Comment c4=new Comment("comment4");
//        Comment c5=new Comment("comment5");
//        Comment c6=new Comment("comment6");
//        Comment c7=new Comment("comment7");
//        Comment c8=new Comment("comment8");
//        Comment c9=new Comment("comment9");
//        Comment c10=new Comment("comment10");
//        Comment c11=new Comment("comment11");
//        Comment c12=new Comment("comment12");
//        Comment c13=new Comment("comment13");
//        Comment c14=new Comment("comment14");
//        Comment c15=new Comment("comment15");
//        //initialize blog
//        Blog b1=new Blog("Spring","Spring framework is AOP,DI,Temp",bl1,new Date(),c1);
//        b1.addComment(c14);
//        ss.save(b1);
//        b1.addComment(c15);
//        Blog b2=new Blog("Spring","Spring framework is AOP,DI,Temp",bl1,new Date(),c2);
//        b2.addComment(c13);
//        b2.addComment(c12);
//        ss.save(b2);
//        Blog b3=new Blog("Spring","Spring framework is AOP,DI,Temp",bl1,new Date(),c3);
//        b3.addComment(c11);
//        ss.save(b3);
//        Blog b4=new Blog("Spring","Spring framework is AOP,DI,Temp",bl2,new Date(),c4);
//        b4.addComment(c10);
//        ss.save(b4);
//        Blog b5=new Blog("Spring","Spring framework is AOP,DI,Temp",bl3,new Date(),c5);
//        b5.addComment(c9);
//        ss.save(b5);
//        ss.save(new Blog("Spring","Spring framework is AOP,DI,Temp",bl4,new Date(),c6));
//        ss.save(new Blog("Spring","Spring framework is AOP,DI,Temp",bl5,new Date(),c7));
//        ss.save(new Blog("Spring","Spring framework is AOP,DI,Temp",bl2,new Date(),c8));
//    tx.commit();
//    }
//    catch(HibernateException e){
//    if(tx!=null)tx.rollback();
//    }
//     finally{if(ss!=null)ss.close();}
//    }

   
   
  
    
}
