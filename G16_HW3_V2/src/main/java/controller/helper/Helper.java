
package controller.helper;
import controller.datarecords.Data;
import model.clothes.Collection;

import model.clothes.Outfit;
import model.user.User;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class Helper {

    public static String[] outfitList(String name) {
        Collection collection = findCollection(name);
        String[] strings = new String[collection.getOutfitsId().size()];
        int number = 0;
        for (int i : collection.getOutfitsId()) {
            strings[number] = Objects.requireNonNull(findOutfit(i)).getName();
            number++;
        }
        return strings;
    }
    public static User findUser(int userId){
        for(User i:  Data.userList.getUserList()){
            if(userId==i.getUserId()){
                return i;
            }
        }
        return null;
    }

    public static User findUser(Collection collection) {
        for (User i : Data.userList.getUserList()) {
            for (int j = 0; j < i.getCollectionsId().size(); j++) {
                if (i.getCollectionsId().get(j) == collection.getCollectionId()) {
                    return i;
                }
            }
        }
        return null;
    }

    public static Outfit findOutfit(int outfitId){
        for(Outfit i:  Data.outfitsList){
            if(outfitId==i.getOutfitId()){
                return i;
            }
        }
        return null;
    }

    public static Outfit findOutfit(String outfitName){
        for(Outfit i:  Data.outfitsList){
            if(outfitName.equals(i.getName())){
                return i;
            }
        }
        return null;
    }
    public static Collection findCollection(Outfit outfit){
        for(Collection i:  Data.collectionsList){
            for(int j=0 ;j<i.getOutfitsId().size();j++){
                if(outfit.getOutfitId()==i.getOutfitsId().get(j)){
                    return i;
                }
            }
        }
        return null;
    }



    public static Collection findCollection(int collectionId){
        for(Collection i:  Data.collectionsList){
            if(collectionId==i.getCollectionId()){
                return i;
            }
        }
        return null;
    }

    public static Collection findCollection(String collectionName){
        for(Collection i:  Data.collectionsList){
            if(collectionName.equals(i.getName())){
                return i;
            }
        }
        return null;
    }

    public static User findUserFromOutfitName(String name){
        Outfit outfit = Helper.findOutfit(name);
        Collection collection = Helper.findCollection(outfit);
        return Helper.findUser(collection);
    }
    public static User findUser(String name){
        for(User user: Data.userList.getUserList()){
            if(user.getUserName().equals(name)){
                return user;
            }
        }
        return null;
    }

    public static int findIndex(ArrayList<Integer> arrayList, int userId){
        for (int i=0; i<arrayList.size();i++) {
            if(arrayList.get(i)==userId){
                return i;
            }
        }
        return 0;
    }

    public static String[] outfitNameArray(){
        int i =0;
        String[] strings = new String[Data.outfitsList.size()];
        for(Outfit outfit: Data.outfitsList){
            strings[i] = outfit.getName();
            i++;
        }
        return strings;
    }
    public static String[] getCollectionArray(User user){
        String[] strings =new String[user.getCollectionsId().size()];
        int number=0;
        for(int i: user.getCollectionsId()){
            for(Collection collection: Data.collectionsList){
                if(collection.getCollectionId()==i){
                    strings[number]= collection.getName();
                    number++;
                }
            }
        }
        return strings;
    }

    public static int randomNumberGenerator(ArrayList<Integer> arrayList){
        Random random = new Random();
        while(true) {
            int number = random.nextInt(1000);
            if(!arrayList.contains(number)){
                return number;
            }
        }
    }

}
