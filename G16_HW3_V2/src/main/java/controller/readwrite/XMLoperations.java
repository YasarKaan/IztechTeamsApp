package controller.readwrite;

import controller.datarecords.Data;
import model.user.User;
import model.user.UserForXml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class XMLoperations {

    public static void writeXml(UserForXml userList){
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(UserForXml.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
            marshaller.marshal(userList, new FileOutputStream("user.xml"));
        } catch (JAXBException | FileNotFoundException e) {
            e.printStackTrace();
        }


    }
    public static void readXml(){
        try {
            File file = new File("user.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(UserForXml.class);
            Unmarshaller unMarshaller = jaxbContext.createUnmarshaller();
            Data.userList = (UserForXml) unMarshaller.unmarshal(file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }

}
