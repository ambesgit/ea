
package cs544.blog.service;

import cs544.blog.domain.Blog;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
public class BlogController {
    @RequestMapping(value="/")
    public String welcomePage(){
        
    return "index";
    }
     @RequestMapping(value="/post", method=RequestMethod.POST)
     public String postBlog(){
         return "redirect:/post_";
     }
      @RequestMapping(value="/post", method=RequestMethod.GET)
     public String gettBlog(@ModelAttribute Blog blog){
         return "post_";
     }
}
