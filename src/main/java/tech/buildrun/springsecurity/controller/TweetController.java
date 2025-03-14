package tech.buildrun.springsecurity.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.*;
import tech.buildrun.springsecurity.controller.dto.CreateTweetDTO;
import tech.buildrun.springsecurity.controller.dto.FeedDTO;
import tech.buildrun.springsecurity.service.TweetService;

@RestController
public class TweetController {

    private final TweetService tweetService;

    public TweetController(TweetService tweetService) {
        this.tweetService = tweetService;
    }

    @PostMapping("/tweets")
    public ResponseEntity<Void> newTweet(@RequestBody CreateTweetDTO dto, JwtAuthenticationToken token){
        tweetService.createTweet(dto, token);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/feed")
    public ResponseEntity<FeedDTO> feed(@RequestParam(value = "page", defaultValue = "0") int page,
                                        @RequestParam(value = "pageSize", defaultValue = "10") int pageSize){
        FeedDTO feed = tweetService.getFeed(page, pageSize);
        return ResponseEntity.ok(feed);

    }

    @DeleteMapping("/tweets/{id}")
    public ResponseEntity<Void> deleteTweet(@PathVariable("id") Long tweetId, JwtAuthenticationToken token){
        tweetService.deleteTweet(tweetId, token);

        return ResponseEntity.ok().build();
    }
}
