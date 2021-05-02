package controller.datarecords;

import model.clothes.Collection;
import model.clothes.Outfit;
import model.user.UserForXml;

import java.util.ArrayList;

public class Data {
    public static UserForXml userList = new UserForXml();
    public static ArrayList<Outfit> outfitsList = new ArrayList<>();
    public static ArrayList<Collection> collectionsList = new ArrayList<>();
    public static ArrayList<Integer> outfitIdList = new ArrayList<>();
    public static ArrayList<Integer> collectionIdList = new ArrayList<>();

}
