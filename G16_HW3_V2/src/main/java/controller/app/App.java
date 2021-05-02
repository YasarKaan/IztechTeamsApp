package controller.app;

import controller.datarecords.Data;
import controller.readwrite.JsonReadOperations;
import controller.readwrite.JsonWriteOperations;
import controller.readwrite.XMLoperations;
import lombok.extern.java.Log;
import model.clothes.*;
import model.user.Gender;
import model.user.User;
import view.login.LoginFrame;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;

public class App {
    public static void main(String[] args) {

        {
/*          If any errors in xml and json files you can reset with this code
            After any operation you need to do change tab , mouse click or something else Because of updates and it runs slowly

            ArrayList<Integer> liike0 = new ArrayList<>();
            ArrayList<Integer> diislike0 = new ArrayList<>();
            ArrayList<Integer> liike1 = new ArrayList<>();
            ArrayList<Integer> diislike1 = new ArrayList<>();
            ArrayList<Integer> liike2 = new ArrayList<>();
            ArrayList<Integer> diislike2 = new ArrayList<>();
            ArrayList<Integer> liike3 = new ArrayList<>();
            ArrayList<Integer> diislike3 = new ArrayList<>();
            ArrayList<Integer> liike4 = new ArrayList<>();
            ArrayList<Integer> diislike4 = new ArrayList<>();
            ArrayList<Integer> liike5 = new ArrayList<>();
            ArrayList<Integer> diislike5 = new ArrayList<>();
            ArrayList<Integer> liike6 = new ArrayList<>();
            ArrayList<Integer> diislike6 = new ArrayList<>();
            ArrayList<Integer> liike7 = new ArrayList<>();
            ArrayList<Integer> diislike7 = new ArrayList<>();
            ArrayList<Integer> liike8 = new ArrayList<>();
            ArrayList<Integer> diislike8 = new ArrayList<>();

            Outfit outfit0 = new Outfit(0, "nike ayakkabı", "nike", ClothingType.sporty, Gender.male, Size.large, Color.Aquamarine, null, liike0, diislike0);
            Outfit outfit1 = new Outfit(1, "kazak", "Kardeşler giyim", ClothingType.other, Gender.female, Size.xlarge, Color.Olden, null, liike1, diislike1);
            Outfit outfit2 = new Outfit(2, "paçalı don", "Kardeşler giyim", ClothingType.other, Gender.female, Size.xlarge, Color.Olive, null, liike2, diislike2);
            Outfit outfit3 = new Outfit(3, "çorap", "Kardeşler giyim", ClothingType.other, Gender.female, Size.xsmall, Color.Black, null, liike3, diislike3);
            Outfit outfit4 = new Outfit(4, "pantolon", "Kardeşler giyim", ClothingType.other, Gender.female, Size.xlarge, Color.Aquamarine, null, liike4, diislike4);
            Outfit outfit5 = new Outfit(5, "tşört", "Kardeşler giyim", ClothingType.other, Gender.female, Size.medium, Color.Wheat, null, liike5, diislike5);
            Outfit outfit6 = new Outfit(6, "bluuz", "Kardeşler giyim", ClothingType.other, Gender.male, Size.large, Color.Green, null, liike6, diislike6);
            Outfit outfit7 = new Outfit(7, "saat", "Kardeşler giyim", ClothingType.other, Gender.female, Size.xlarge, Color.Magenta, null, liike7, diislike7);

            Data.outfitsList.add(outfit0);
            Data.outfitsList.add(outfit1);
            Data.outfitsList.add(outfit2);
            Data.outfitsList.add(outfit3);
            Data.outfitsList.add(outfit4);
            Data.outfitsList.add(outfit5);
            Data.outfitsList.add(outfit6);
            Data.outfitsList.add(outfit7);


            ArrayList<Integer> outfitIDS0 = new ArrayList<>();
            ArrayList<Integer> outfitIDS1 = new ArrayList<>();
            ArrayList<Integer> outfitIDS2 = new ArrayList<>();
            ArrayList<Integer> outfitIDS3 = new ArrayList<>();
            ArrayList<Integer> outfitIDS4 = new ArrayList<>();
            ArrayList<Integer> outfitIDS5 = new ArrayList<>();

            outfitIDS0.add(0);
            outfitIDS0.add(5);
            outfitIDS1.add(1);
            outfitIDS1.add(2);
            outfitIDS2.add(6);
            outfitIDS3.add(3);
            outfitIDS4.add(4);
            outfitIDS5.add(7);


            Collection collection0 = new Collection(1, "düğün", 1, outfitIDS0);
            Collection collection1 = new Collection(2, "nişan", 2, outfitIDS1);
            Collection collection2 = new Collection(3, "mezuniyet", 3, outfitIDS2);
            Collection collection3 = new Collection(4, "boşanma", 4, outfitIDS3);
            Collection collection4 = new Collection(5, "soygun", 5, outfitIDS4);
            Collection collection5 = new Collection(6, "konser", 1, outfitIDS5);

            Data.collectionsList.add(collection0);
            Data.collectionsList.add(collection1);
            Data.collectionsList.add(collection2);
            Data.collectionsList.add(collection3);
            Data.collectionsList.add(collection4);
            Data.collectionsList.add(collection5);

            ArrayList<Integer> following0 = new ArrayList<>();
            ArrayList<Integer> following1 = new ArrayList<>();
            ArrayList<Integer> following2 = new ArrayList<>();
            ArrayList<Integer> following3 = new ArrayList<>();
            ArrayList<Integer> following4 = new ArrayList<>();
            ArrayList<Integer> followers0 = new ArrayList<>();
            ArrayList<Integer> followers1 = new ArrayList<>();
            ArrayList<Integer> followers2 = new ArrayList<>();
            ArrayList<Integer> followers3 = new ArrayList<>();
            ArrayList<Integer> followers4 = new ArrayList<>();

            ArrayList<Integer> collectionID0 = new ArrayList<>();
            collectionID0.add(collection0.getCollectionId());
            collectionID0.add(collection5.getCollectionId());
            ArrayList<Integer> collectionID1 = new ArrayList<>();
            collectionID1.add(collection1.getCollectionId());
            ArrayList<Integer> collectionID2 = new ArrayList<>();
            collectionID2.add(collection2.getCollectionId());
            ArrayList<Integer> collectionID3 = new ArrayList<>();
            collectionID3.add(collection3.getCollectionId());
            ArrayList<Integer> collectionID4 = new ArrayList<>();
            collectionID4.add(collection4.getCollectionId());
            User user0 = new User(1, "tamer", "123", Gender.male, following0, followers0, collectionID0);
            User user1 = new User(2, "kaan", "123", Gender.male, following1, followers1, collectionID1);
            User user2 = new User(3, "halsey", "123", Gender.female, following2, followers2, collectionID2);
            User user3 = new User(4, "elon", "123", Gender.male, following3, followers3, collectionID3);
            User user4 = new User(5, "dua lipa", "123", Gender.female, following4, followers4, collectionID4);
            Data.userList.getUserList().add(user0);
            Data.userList.getUserList().add(user1);
            Data.userList.getUserList().add(user2);
            Data.userList.getUserList().add(user3);
            Data.userList.getUserList().add(user4);
            JsonWriteOperations.writeCollections();
            JsonWriteOperations.writeOutfits();
            XMLoperations.writeXml(Data.userList);
*/
            JsonReadOperations.readCollections();
            JsonReadOperations.readOutfits();
            XMLoperations.readXml();
            Data.collectionsList.get(1);
            Data.outfitsList.get(1);
            LoginFrame frame = new LoginFrame();
            frame.setVisible(true);

        }

    }
}
