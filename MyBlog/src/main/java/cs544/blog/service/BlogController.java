
package cs544.blog.service;

import cs544.blog.domain.Blog;
import cs544.blog.domain.Blogger;
import cs544.blog.domain.Comment;
import java.util.ArrayList;
import java.util.Date;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BlogController {   
    private BlogService blogService;
     public BlogService getBlogService() {
        return blogService;
    }

    public void setBlogService(BlogService blogService) {
        this.blogService = blogService;
    }
    
    //Routing based on url and http methods
    @RequestMapping(value="/")
    public String welcomePage(){
                
                return "index";
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
         return "post_";
     }
     @RequestMapping(value="/blogger", method=RequestMethod.GET)
     public String gettBlogger(@ModelAttribute BloggerDto bloggerDto){
         
         return "blogger";
     }
      @RequestMapping(value="/blogger", method=RequestMethod.POST)
     public String addBlogger(BloggerDto bloggerDto){
        
            //blogService.addBlogger(bloggerDto.bloggerFactory());
         return "redirect:/blogger";
       
     }

   
    

     
}
