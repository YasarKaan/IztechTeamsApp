package model.clothes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.user.Gender;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Outfit {
    private int outfitId;
    private String name;
    private String brandName;
    private ClothingType clothingType;
    private Gender gender;
    private Size size;
    private Color color;
    private ArrayList<String> comment = new ArrayList<>();
    private ArrayList<Integer> like = new ArrayList<>();
    private ArrayList<Integer> dislike = new ArrayList<>();

    public String toString() {
        return "Outfit name='" + name + '\'' +
                ",\n brandName='" + brandName + '\'' +
                ",\n clothingType=" + clothingType +
                ",\n gender=" + gender +
                ",\n size=" + size +
                ",\n color=" + color +
                ",\n like=" + like.size() +
                ",\n dislike=" + dislike.size() +
                ",\n comment Amount= "+ comment.size()+
                ",\n comments=" + comment.toString();
    }
}