package entities;

import java.util.ArrayList;

public abstract class User {
    private String userType;
    private String userName;
    private int id;
    private String password;
    private ArrayList<String> teamId;
    private String email;
    private ArrayList<String> teamOwner = new ArrayList<>();

    public User(String userType, String userName, int id,String email, String password, ArrayList<String> teamId) {
        this.userType = userType;
        this.userName = userName.trim();
        this.id = id;
        this.password = password;
        this.teamId = teamId;
        this.email = generateEmail();

    }
    public User(){}


    protected abstract String generateEmail();

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<String> getTeamId() {
        return teamId;
    }

    public void setTeamId(ArrayList<String> teamId) {
        this.teamId = teamId;
    }

    public void setTeamId(String teamID){
        teamId.add(teamID);
    }

    public String getEmail() {
        return email;
    }


    public ArrayList<String> getTeamOwner() {
        return teamOwner;
    }

    public void setTeamOwner(ArrayList<String> teamOwner) {
        this.teamOwner = teamOwner;
    }

    public void getOwnerTeams(){
        int display=1;
        for(String i:teamOwner) {
            if (!i.equals("")) {
                System.out.println(display + " " + i);
            }
            display++;
        }
    }
    public String getStringTeamId() {
        String str="";
        for (String s : teamId) {
            str = str + "," + s;
        }
        return str;
    }
}