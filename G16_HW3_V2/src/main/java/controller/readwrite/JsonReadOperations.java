package controller.readwrite;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import controller.datarecords.Data;
import model.clothes.Collection;
import model.clothes.Outfit;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class JsonReadOperations {
    public static void readOutfits(){
        Gson gson = new Gson();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("outfits.json"));
            Data.outfitsList = gson.fromJson(br, new TypeToken<List<Outfit>>() {}.getType());
            for (Outfit outfit : Data.outfitsList){
                Data.outfitIdList.add(outfit.getOutfitId());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static void readCollections(){
        Gson gson = new Gson();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("collections.json"));
            Data.collectionsList = gson.fromJson(br, new TypeToken<List<Collection>>() {}.getType());
            for (Collection collection:Data.collectionsList) {
                Data.collectionIdList.add(collection.getCollectionId());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}