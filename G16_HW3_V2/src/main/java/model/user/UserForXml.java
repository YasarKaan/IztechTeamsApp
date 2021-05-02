package model.user;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
@Data
@XmlRootElement(name = "Users")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserForXml {
    @XmlElement(name= "User")
    private ArrayList<User> userList = new ArrayList<>();

}

