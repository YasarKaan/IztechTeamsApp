package controller.helper;

import controller.datarecords.Data;
import model.clothes.*;
import model.user.Gender;

public class OutfitOperations {

    public static Outfit createOutfit(Collection collection, String name,String brandName,
                                      ClothingType clothingType, Gender gender, Size size,
                                      Color color){
        Outfit outfit = new Outfit();
        outfit.setBrandName(brandName);
        outfit.setOutfitId(Helper.randomNumberGenerator(Data.outfitIdList));
        outfit.setName(name);
        outfit.setClothingType(clothingType);
        outfit.setGender(gender);
        outfit.setColor(color);
        outfit.setSize(size);
        Data.outfitsList.add(outfit);
        collection.getOutfitsId().add(outfit.getOutfitId());
        Update.updateJson();
        return outfit;
    }

    public static void deleteOutfit(Outfit outfit, Collection collection){
        for (int i=0 ;i<collection.getOutfitsId().size();i++) {
            if (collection.getOutfitsId().get(i) == outfit.getOutfitId()) {
                collection.getOutfitsId().remove(i);
                break;
            }
        }
            Data.outfitsList.remove(outfit);
            outfit.setOutfitId(0);
            outfit.setSize(null);
            outfit.setColor(null);
            outfit.setBrandName(null);
            outfit.setClothingType(null);
            outfit.setComment(null);
            outfit.setBrandName(null);
            outfit.setDislike(null);
            outfit.setLike(null);
            outfit.setGender(null);
            Update.updateJson();
            Update.updateXml();
    }


}