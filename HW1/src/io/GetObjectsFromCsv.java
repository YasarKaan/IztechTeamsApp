package io;

import entities.*;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class GetObjectsFromCsv {

    public static void getUsers(ArrayList<User> studentList, ArrayList<User> academicianList ,ArrayList<Team> teamList){
        int id;
        String password;
        ArrayList<String[]> userList = FileIO.reader("userList.csv");
        ArrayList<Integer> numbersList = new ArrayList<>(1000);
        for(int i =0 ; i<=1000;i++){
            numbersList.add(i);
        }
        ArrayList userIdList = getDefaultId(userList);
        deleteDuplicateId(numbersList,userList);
        for(int i = 1 ; i<userList.size(); i++){

            String[] tmpArray = userList.get(i);
            if(tmpArray[2].equals("")) {
                id =idGenerator(numbersList);
                password = passwordGenerator();
            }
            else {
                id = Integer.parseInt(tmpArray[2]);
                password = tmpArray[4];
            }
            ArrayList<String> ids = getID(tmpArray,5);
            if((tmpArray[0].equals("Instructor")) || (tmpArray[0].equals("Teaching Assistant"))){
                Academician academician = new Academician(tmpArray[0],tmpArray[1],id,tmpArray[3],password,ids);
                academician.setTeamOwner(ids); // we assumed all academicians in a team is team Owner
                for(Team team: teamList){
                    for(String string: academician.getTeamOwner()){
                        if(string.equals(team.getTeamId())){
                            team.getTeamOwner().add(academician);
                        }
                    }
                }
                academicianList.add(academician);
            }else if(tmpArray[0].equals("Student")){
                Student student = new Student(tmpArray[0],tmpArray[1],id,tmpArray[3],password,ids);
                studentList.add(student);
            }
        }
    }

    public static void getTeams(ArrayList<Team> teamList) {
        ArrayList<String[]> list = FileIO.reader("teamList.csv");
        for(int i = 1 ; i<list.size(); i++){
            String[] tmpArray = list.get(i);
            ArrayList<PrivateChannel> channels =getPrivateChannels(tmpArray);
            Channel defaultChannel = new Channel(tmpArray[2],tmpArray[3]);
            Team team = new Team(tmpArray[0],tmpArray[1],defaultChannel,channels);
            teamList.add(team);
        }

    }
    private static ArrayList<PrivateChannel> getPrivateChannels(String[] data){
        ArrayList<PrivateChannel> channelList = new ArrayList<>();
        ArrayList<String> tmpArray = getID(data,4);
        int i=0;
        while (i<tmpArray.size()){
            ArrayList<Integer> partId = getParticipantID(tmpArray.get(i+2));
            PrivateChannel channel = new PrivateChannel(tmpArray.get(i),tmpArray.get(i+1),partId);
            channelList.add(channel);
            i = i+3;
        }
        return channelList;
    }


    private static ArrayList<Integer> getParticipantID(String data){
        if(!data.equals("")) {
            String[] tmpId = data.replace("\"", "").split(",");
            ArrayList<Integer> partId = new ArrayList<>();
            for(String s : tmpId) {
                partId.add(Integer.parseInt(s.trim()));
            }
            return partId;
        }
        return null;

    }



    private static ArrayList<String> getID(String[] data,int size){
        ArrayList<String> id = new ArrayList<>();
        id.addAll(Arrays.asList(data).subList(size, data.length));
        return id;
    }

    private static ArrayList<Integer> getDefaultId(ArrayList<String[]> userList){
        ArrayList<Integer> arrayList = new ArrayList<>();
        for(int i = 1 ; i<userList.size(); i++){
            String tmp = userList.get(i)[2];
            if(!tmp.equals("")){
                int id = Integer.parseInt(tmp);
                arrayList.add(id);
            }
        }
        return arrayList;
    }



    private static void deleteDuplicateId(ArrayList arrayList, ArrayList numbersList){

        for(int i = 0 ; i<arrayList.size();i++) {
            numbersList.remove(arrayList.get(i));
        }


    }
    private static int idGenerator(ArrayList<Integer> numbersList){
        Random rand = new Random();
        int randomNumber = rand.nextInt(numbersList.size());
        int number = numbersList.get(randomNumber);
        numbersList.remove(randomNumber);
        return number;
    }



    private static String passwordGenerator() {
        final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        SecureRandom rnd = new SecureRandom();

        StringBuilder sb = new StringBuilder(4);
        for (int i = 0; i < 4; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        return sb.toString();

    }

}