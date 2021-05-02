package controller.readwrite;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import controller.datarecords.Data;
import model.clothes.Collection;

import model.clothes.Outfit;

import java.io.FileWriter;
import java.io.IOException;



public class JsonWriteOperations {
    public static void writeOutfits(){
        try {
            FileWriter writer = new FileWriter("outfits.json");
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(Data.outfitsList,writer);
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void writeCollections(){
        try {
            FileWriter writer = new FileWriter("collections.json");
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(Data.collectionsList,writer);
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}