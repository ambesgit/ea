
package cs544.blog.service;

import cs544.blog.domain.Blog;
import cs544.blog.domain.Blogger;
import cs544.blog.domain.Comment;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Transactional
@Controller
public class BlogController {
    @Resource
    private BlogService blogService;
     public BlogService getBlogService() {
        return blogService;
    }

    public void setBlogService(BlogService blogService) {
        this.blogService = blogService;
    }
    @Resource
    private Credintial credintial;  
    public Credintial getCredintial() {
        return credintial;
    }
    public void setCredintial(Credintial credintial) {
        this.credintial = credintial;
    } 
    
    //Welcome page
    @RequestMapping(value="/")
    public String welcomePage(){
            return "redirect:/blog";
        }
    @RequestMapping(value="/index")
    public String indexPage(){
        
            return "index";
        }
    
    
    //Login page 
    @RequestMapping(value="/login", method=RequestMethod.GET)
    public String login(HttpSession session,@ModelAttribute Credintial credintial){
        if(session.getAttribute("bgr")!=null){
            session.invalidate();
            credintial=null;
        }
        return "login";    
    }
    @RequestMapping(value="/login", method=RequestMethod.POST)
    public String loginVerify(HttpSession session,Credintial credintial){
        List<Blogger> bloggers=blogService.getBloggers();
        for(Blogger b:bloggers){
            if(b.getUserName().equals(credintial.getUserName())&& b.getPassword().equals(credintial.getPassword()))
               session.setAttribute("bgr",b); 
            session.setAttribute("cre",credintial);
              return "index";
        }
        return "redirect:/login";    
    }
    
    
    //Blog page 
    @RequestMapping(value="/blog",method=RequestMethod.GET)
    public String getBlogs(Model model, Blog blog){       
       model.addAttribute("blogs", blogService.getBlogs());
       
        return "blogs";
    }
    @RequestMapping(value="/blog/{blogId}",method=RequestMethod.GET)
    public String getBlog(Model model,@PathVariable long blogId,Blog blog,Comment comment){       
       model.addAttribute("blog", blogService.getBlog(blogId));       
        return "blog";
    }
    @RequestMapping(value="/blog/{blogId}",method=RequestMethod.POST)
    public String postComment(@PathVariable long blogId,Comment comment){ 
        blogService.addComment(blogId, comment);
        return "redirect:/blog/"+blogId;
    }
      //post page 
     @RequestMapping(value="/post_", method=RequestMethod.POST)
     public String postBlog(HttpSession session,Blog blog){
         
         Blogger b=(Blogger)session.getAttribute("bgr");                 
         blogService.addBlogger(b,blog);
         return "redirect:/post_";
         
         
     } 
     
   
   
     @RequestMapping(value="/post_", method=RequestMethod.GET)
     public String gettBlog(HttpSession session,@ModelAttribute Blog blog){
         if(session.getAttribute("bgr")!=null)
             return "post_";
         else
         return "index";
         
     }
     
     //Blogger page 
     @RequestMapping(value="/blogger", method=RequestMethod.GET)
     public String gettBlogger(BloggerDto bloggerDto){
         
         return "blogger";
     }
     @RequestMapping(value="/blogger", method=RequestMethod.POST)
     public String addBlogger(BloggerDto bloggerDto){        
            blogService.addBlogger(bloggerDto.bloggerFactory());
         return "redirect:/blogger";
       
     }  
     
   //Delete      
     @RequestMapping(value="/delete/{blogId}",method=RequestMethod.GET)
     public String deleteBlog(HttpSession session,@PathVariable long blogId){
         
         Blog b=(Blog)blogService.getBlog(blogId);
          if(session.getAttribute("bgr")!=null && 
                 b.getAuthor().getPassword().equals(((Credintial)session.getAttribute("cre")).getPassword())
                 &&b.getAuthor().getUserName().equals(((Credintial)session.getAttribute("cre")).getUserName())
             )
         {
             
          blogService.deleteBlog(blogId);
          return "redirect:/blog";
         }
         else return "redirect:/blog";
        }
}
