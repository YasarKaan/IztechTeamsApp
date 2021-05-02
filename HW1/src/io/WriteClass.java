package io;

import entities.Academician;
import entities.Team;
import entities.User;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class WriteClass {
    private static String line,fileLine;
    public static void writeToUserList(ArrayList<User> academicianList, ArrayList<User> studentList){
        academicianList.addAll(studentList);
        try {
            FileWriter fileWriter = new FileWriter ("userList.csv");
            line = "User Type,User Name,User ID,Email,Password,Team ID,\n";
            fileWriter.write(line);
            for(int i=0;i<academicianList.size();i++){
                User user = academicianList.get(i);
                fileLine=getUser(user);
                fileWriter.write(fileLine);
                if(i+1!=academicianList.size()){
                    fileWriter.write("\n");
                }
            }
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
    public static void writeToTeamList(ArrayList<Team> teamList){
        try {
            FileWriter fileWriter = new FileWriter ("teamList.csv");
            line = "Team Name,Team ID,Default Channel,Default Meeting Day and Time,Meeting Channel,Meeting Day and Time,Participant ID\n";
            fileWriter.write(line);
            for(int i=0;i<teamList.size();i++){
                Team team = teamList.get(i);
                fileLine=getTeams(team);
                fileWriter.write(fileLine);
                if(i+1!=teamList.size()){
                    fileWriter.write("\n");
                }
            }
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    private static String getUser(User user) {
        line= user.getUserType()+","+user.getUserName()+","+user.getId()+
                ","+user.getEmail()+","+user.getPassword()+user.getStringTeamId();
        return line;
    }

    private static String getTeams(Team team){
        line= team.getTeamName() + "," + team.getTeamId() + "," + team.getDefaultChannel().getMeetingChannel() +
                ","+team.getDefaultChannel().getMeetingDate() + "," + team.getPrivateChannelsToString();
        return line;
    }
}