package controller.helper;

import controller.datarecords.Data;
import controller.readwrite.JsonReadOperations;
import controller.readwrite.JsonWriteOperations;
import controller.readwrite.XMLoperations;

public class Update {

    public static void updateXml(){
        XMLoperations.writeXml(Data.userList);
        Data.userList.getUserList().clear();
        XMLoperations.readXml();
    }

    public static void updateJson(){
        JsonWriteOperations.writeOutfits();
        JsonWriteOperations.writeCollections();
        Data.outfitsList.clear();
        Data.collectionsList.clear();
        JsonReadOperations.readOutfits();
        JsonReadOperations.readCollections();
    }
}
