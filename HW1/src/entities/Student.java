package entities;

import java.util.ArrayList;
import java.util.Locale;

public class Student extends User {
    public Student(String userType, String userName, int id, String email, String password, ArrayList<String> teamId) {
        super(userType, userName, id, email, password, teamId);
    }

    public Student() {
        super();
    }


    @Override

        protected String generateEmail() {

            String[] name = getUserName().toLowerCase(Locale.ROOT).split(" ");
            return name[0] + name[name.length-1].trim().toLowerCase()+"@std.iyte.edu.tr";
        }
}


