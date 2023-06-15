package miu.edu.upvote;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/upvote")
public class UpvoteController {

    @Autowired
    UpvoteService upvoteService;

    @PostMapping("/add")
    public ResponseEntity<Object> addUpvote(@RequestBody Upvote upvote){
        return upvoteService.saveUpvote(upvote);
    }

    @GetMapping("/get/article/{articleId}")
    public ResponseEntity<Object> getUpvoteByArticleId(@PathVariable Long articleId){
        return upvoteService.getUpvoteForArticle(articleId);
    }

    @GetMapping("/get/user/{userId}")
    public ResponseEntity<Object> getUpvoteByUserId(@PathVariable Long userId){
        return upvoteService.getUpvoteForUser(userId);
    }
}
