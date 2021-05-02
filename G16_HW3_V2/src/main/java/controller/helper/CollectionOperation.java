package controller.helper;

import controller.datarecords.Data;
import model.clothes.Collection;
import model.clothes.Outfit;
import model.user.User;

import java.util.ArrayList;

public class CollectionOperation {

    public static Collection createCollection(User user,String name){
        Collection collection = new Collection();
        collection.setName(name);
        collection.setUsersId(user.getUserId());
        collection.setOutfitsId(new ArrayList<Integer>());
        Data.collectionsList.add(collection);
        collection.setCollectionId(Helper.randomNumberGenerator(Data.collectionIdList));
        user.getCollectionsId().add(collection.getCollectionId());
        Update.updateJson();
        Update.updateXml();
        return collection;
    }
    public static void deleteCollection(User user,Collection collection){
        if(collection.getUsersId()==user.getUserId()) {
            int i=0;
            while(collection.getOutfitsId().size()!=0) {
                Outfit outfit = Helper.findOutfit(collection.getOutfitsId().get(i));
                OutfitOperations.deleteOutfit(outfit, collection);
            }
            Data.collectionsList.remove(collection);
            for (i=0; i<user.getCollectionsId().size(); i++){
                if(user.getCollectionsId().get(i)==collection.getCollectionId()){
                    user.getCollectionsId().remove(i);
                    break;
                }
            }
            collection.setCollectionId(0);
            collection.setName(null);
            collection.setUsersId(0);
            Update.updateXml();
            Update.updateJson();
        }
        else{
            System.out.println("You arent");
        }
    }
}
