package tech.buildrun.springsecurity.controller.dto;

public record FeedItemDTO(long tweetId,
                          String content,
                          String username) {
}
