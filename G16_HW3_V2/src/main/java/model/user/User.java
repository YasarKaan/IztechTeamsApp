package model.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
@XmlRootElement(name="user")
@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)

public class User {
    @XmlAttribute(name="ID")
    private int userId;
    private String userName;
    private String password;
    private Gender gender;
    private ArrayList<Integer> followingUsersId = new ArrayList<>();
    private ArrayList<Integer> followerUsersId = new ArrayList<>();
    private ArrayList<Integer> collectionsId = new ArrayList<>();
    public String toString() {
        return
                "\n User Name= " + userName +
                        "\n gender= " + gender +
                        "\n following= " + followingUsersId.size() +
                        "\n followers= " + followerUsersId.size() +
                        "\n collections= " + collectionsId.size() ;
    }
}
