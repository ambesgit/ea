
package cs544.blog.service;

import cs544.blog.domain.Blog;
import cs544.blog.domain.Blogger;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
    @Resource
    private Principal principal;

    public Credintial getCredintial() {
        return credintial;
    }

    public Principal getPrincipal() {
        return principal;
    }

    public void setCredintial(Credintial credintial) {
        this.credintial = credintial;
    }

    public void setPrincipal(Principal principal) {
        this.principal = principal;
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
    public String login(@ModelAttribute Credintial credintial){
        
        return "login";    
    }
     @RequestMapping(value="/login", method=RequestMethod.POST)
    public String loginVerify(@ModelAttribute Credintial credintial){
        List<Blogger> bloggers=blogService.getBloggers();
        for(Blogger b:bloggers){
            if(b.getUserName().equals(credintial.getUserName())&& b.getPassword().equals(credintial.getPassword()))
                principal.setBlogger(b);
               return "blogs";
        }
        return "redirect:/login";    
    }
    @RequestMapping(value="/blog",method=RequestMethod.GET)
    public String getBlogs(Model model){       
       model.addAttribute("blogs", blogService.getBlogs());
       
        return "blogs";
    }
     @RequestMapping(value="/post", method=RequestMethod.POST)
     public String postBlog(@ModelAttribute Blog blog){
         
         return "redirect:/post_";
     }
     @RequestMapping(value="/post", method=RequestMethod.GET)
     public String gettBlog(@ModelAttribute Blog blog){
         if(principal.getBlogger()!=null)
             return "post_";
         else
         return "index";
         
     }
     @RequestMapping(value="/blogger", method=RequestMethod.GET)
     public String gettBlogger(@ModelAttribute BloggerDto bloggerDto){
         
         return "blogger";
     }
      @RequestMapping(value="/blogger", method=RequestMethod.POST)
     public String addBlogger(BloggerDto bloggerDto){        
            blogService.addBlogger(bloggerDto.bloggerFactory());
         return "redirect:/blogger";
       
     }

   
    

     
}
