package tech.buildrun.springsecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import tech.buildrun.springsecurity.controller.dto.CreateTweetDTO;
import tech.buildrun.springsecurity.controller.dto.FeedDTO;
import tech.buildrun.springsecurity.controller.dto.FeedItemDTO;
import tech.buildrun.springsecurity.entity.Role;
import tech.buildrun.springsecurity.entity.Tweet;
import tech.buildrun.springsecurity.repository.TweetRepository;
import tech.buildrun.springsecurity.repository.UserRepository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class TweetService {

    private final TweetRepository tweetRepository;

    private final UserRepository userRepository;

    public TweetService(TweetRepository tweetRepository, UserRepository userRepository) {
        this.tweetRepository = tweetRepository;
        this.userRepository = userRepository;
    }

    // Create Tweet
    public void createTweet(CreateTweetDTO dto, JwtAuthenticationToken token){

        var user = userRepository.findById(UUID.fromString(token.getName()));

        var tweet = new Tweet();
        tweet.setUser(user.get());
        tweet.setContent(dto.content());

        tweetRepository.save(tweet);

    }

    // List Feed
    public FeedDTO getFeed(int page, int pageSize){
       Page<Tweet> tweetPage = tweetRepository.findAll(PageRequest.of(page,pageSize, Sort.Direction.DESC,"creationTimestamp"));

         List<FeedItemDTO> feedItems = tweetPage.getContent().stream()
                 .map(tweet -> new FeedItemDTO(
                         tweet.getTweetId(),
                         tweet.getContent(),
                         tweet.getUser().getUsername()
                 )).collect(Collectors.toList());

         return new FeedDTO(
                 feedItems,
                 page,
                 pageSize,
                 tweetPage.getTotalPages(),
                 tweetPage.getTotalElements()
         );

    }

    // Delete Tweet
    public void deleteTweet(Long tweetId, JwtAuthenticationToken token) {

        var user = userRepository.findById(UUID.fromString(token.getName()));

        var tweet = tweetRepository.findById(tweetId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        var isAdmin = user.get().getRoles()
                .stream().anyMatch(role -> role.getName().equalsIgnoreCase(Role.Value.ADMIN.name()));

        if (isAdmin ||tweet.getUser().getUserId().equals(UUID.fromString(token.getName()))) {
            tweetRepository.deleteById(tweetId);
        }else {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        }
    }
}
