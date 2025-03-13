package tech.buildrun.springsecurity.service;

import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Service;
import tech.buildrun.springsecurity.controller.dto.CreateTweetDTO;
import tech.buildrun.springsecurity.entity.Tweet;
import tech.buildrun.springsecurity.repository.TweetRepository;
import tech.buildrun.springsecurity.repository.UserRepository;

import java.util.UUID;

@Service
public class TweetService {

    private final TweetRepository tweetRepository;

    private final UserRepository userRepository;

    public TweetService(TweetRepository tweetRepository, UserRepository userRepository) {
        this.tweetRepository = tweetRepository;
        this.userRepository = userRepository;
    }

    public void createTweet(CreateTweetDTO dto, JwtAuthenticationToken token){

        var user = userRepository.findById(UUID.fromString(token.getName()));

        var tweet = new Tweet();
        tweet.setUser(user.get());
        tweet.setContent(dto.content());

        tweetRepository.save(tweet);

    }
}
