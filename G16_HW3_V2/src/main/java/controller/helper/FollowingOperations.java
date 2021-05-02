package controller.helper;

import model.user.User;

public class FollowingOperations {

    public static void followUser(User user,User user1){
        int followerId=user.getUserId();
        if(!user1.getFollowerUsersId().contains(followerId)){
            user1.getFollowerUsersId().add(followerId);
        }
        else{
            System.out.println("You already follow " + user1.getUserName());
        }
    }

    public static void unfollowUser(User user,User user1){
        int followerId=user.getUserId();
        if(!user1.getFollowingUsersId().contains(followerId)){
            user1.getFollowingUsersId().remove(followerId);
        }
        else{
            System.out.println("You are not following " + user1.getUserName());
        }
    }
}
