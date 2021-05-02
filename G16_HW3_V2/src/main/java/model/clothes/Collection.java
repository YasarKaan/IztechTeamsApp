package model.clothes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Collection {
    private int collectionId;
    private String name;
    private int usersId;
    private ArrayList<Integer> outfitsId = new ArrayList<>();

}
