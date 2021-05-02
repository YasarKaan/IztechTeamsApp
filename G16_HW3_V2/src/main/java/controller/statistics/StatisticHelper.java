package controller.statistics;

import controller.datarecords.Data;
import model.clothes.Collection;
import model.clothes.Outfit;
import model.user.User;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

public class StatisticHelper {

    public static Outfit mostLikedOutfit(){
        ArrayList<Integer> list = new ArrayList();
        for(Outfit outfit: Data.outfitsList){
            list.add(outfit.getLike().size());
        }
        Integer max = Collections.max(list);
        for(Outfit outfit: Data.outfitsList){
            if(outfit.getLike().size()==max){
                return outfit;
            }
        }
        return null;
    }

    public static Outfit mostDislikedOutfit(){
        ArrayList<Integer> list = new ArrayList();
        for(Outfit outfit: Data.outfitsList){
            list.add(outfit.getDislike().size());
        }
        Integer max= Collections.max(list);
        for(Outfit outfit: Data.outfitsList){
            if(outfit.getDislike().size()==max){
                return outfit;
            }
        }
        return null;
    }

    public static User mostFollowerUser(){
        ArrayList<Integer> list = new ArrayList();
        for(User user: Data.userList.getUserList()){
            list.add(user.getFollowerUsersId().size());
        }
        Integer max = Collections.max(list);
        for(User user: Data.userList.getUserList()){
            if(user.getFollowerUsersId().size()==max){
                return user;
            }
        }
        return null;
    }
}