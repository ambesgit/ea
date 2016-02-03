
package cs544.blog.service;

import cs544.blog.domain.Blog;
import cs544.blog.domain.Blogger;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.ModelAttribute;
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
    
    //Routing based on url and http methods
    @RequestMapping(value="/")
    public String welcomePage(){
            return "index";
        }
    @RequestMapping(value="/index")
    public String indexPage(){
        
            return "index";
        }
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
              return "index";
        }
        return "redirect:/login";    
    }
    @RequestMapping(value="/blog",method=RequestMethod.GET)
    public String getBlogs(Model model, Blog blog){       
       model.addAttribute("blogs", blogService.getBlogs());
       
        return "blogs";
    }
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
         return "login";
         
     }
     @RequestMapping(value="/blogger", method=RequestMethod.GET)
     public String gettBlogger(BloggerDto bloggerDto){
         
         return "blogger";
     }
     @RequestMapping(value="/blogger", method=RequestMethod.POST)
     public String addBlogger(BloggerDto bloggerDto){        
            blogService.addBlogger(bloggerDto.bloggerFactory());
         return "redirect:/blogger";
       
     }     
}
