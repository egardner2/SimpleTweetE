package com.codepath.apps.restclienttemplate.models;

import androidx.room.Embedded;

import java.util.ArrayList;
import java.util.List;

public class TweetWithUser {

    //Embedded noation flattens the properties of the User object into the object, preserving encapuslation.
    @Embedded
    User user;

    @Embedded(prefix = "tweet")
    Tweet  tweet;

    public static List<Tweet> getTweetListI(List<TweetWithUser> tweetWithUsers) {
        List<Tweet> tweets = new ArrayList<>();

        for(int i = 0; i <tweetWithUsers.size(); i++) {
            Tweet tweet = tweetWithUsers.get(i).tweet;
            tweet.user = tweetWithUsers.get(i).user;
            tweets.add(tweet) ;
        }

        return tweets;
    }
}
