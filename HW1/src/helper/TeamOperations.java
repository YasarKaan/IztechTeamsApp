package helper;

import entities.*;
import exceptions.UnauthorizedUserOperationException;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TeamOperations {

    public static Team createTeam(Academician user){
        Team team = new Team();
        Channel channel = new Channel();
        Scanner scanner = new Scanner(System.in);
        try {
            if(user.getUserType().equals("Instructor")){
                System.out.println("Enter Team Name: ");
                team.setTeamName(scanner.nextLine());
                System.out.println("Enter Team ID: ");
                String teamID=scanner.nextLine();
                team.setTeamId(teamID);
                System.out.println("Enter Default Meeting Day and Time: ");
                channel.setMeetingDate(scanner.nextLine());
                channel.setMeetingChannel("General");
                team.setDefaultChannel(channel);
                user.getTeamId().add(teamID);
                team.getTeamOwner(user);
            }
            else{
                throw new UnauthorizedUserOperationException();
            }
        } catch (UnauthorizedUserOperationException e) {
            System.out.println(e.getMessage());
        }
        return team;
    }

    public static void giveTeamOwnerRole(User user,ArrayList<Team> teamList,ArrayList<User> academicianList) {
        Scanner scanner = new Scanner(System.in);
        try {
            Team team = show(user, teamList, scanner);
            showAcademicianList(academicianList);
            int choice=scanner.nextInt();
            if(!academicianList.get(choice-1).getTeamOwner().contains(team.getTeamId())){//check is team owner
                if(!academicianList.get(choice-1).getTeamId().contains(team.getTeamId())) {//check is team id include
                    giveTeamOwnerRole((Academician) academicianList.get(choice-1),team);
                    academicianList.get(choice - 1).getTeamId().add(team.getTeamId());
                    System.out.println("Successful!!");
                }
            }else{
                System.out.println("Already Team Owner");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static void giveTeamOwnerRole(Academician academician,Team team) {
        team.getTeamOwner(academician);
    }
    private static void showAcademicianList(ArrayList<User> academicianList){
        int j=1;
        for(int i=0;i<academicianList.size();i++){
            System.out.println(j + "-" + academicianList.get(i).getUserType() +" " + academicianList.get(i).getUserName() + " "
                    + academicianList.get(i).getId());
            j++;
        }
    }

    public static void showTeams(ArrayList<Team> teamList,User user) {
        System.out.println("-------------Teams are--------------");
        int displayNumber=0;
        for (Team i : teamList) {
            displayNumber++;
            for (String j : user.getTeamId()) {
                if (i.getTeamId().equals(j)) {
                    System.out.println(displayNumber+", "+i.getTeamName() + ", " + i.getTeamId());
                    break;
                }
            }
        }



    }
    public static boolean isTeamOwner(Academician academician,Team team){
        for (int i=0;i<academician.getTeamOwner().size();i++) {
            if(team.getTeamOwner().get(i).equals(academician)){
                return true;
            }

        }
        return false;
    }

    public static void addStudentToTeam(Academician academician, ArrayList<Team> teamList, ArrayList<User> studentList, int id){
        Scanner scanner = new Scanner(System.in);
        showTeams(teamList,academician);;
        System.out.println("Select a team");
        int choice = scanner.nextInt();
        if(!isTeamOwner(academician,teamList.get(choice-1))){
            System.out.println("you are not team owner in this team");
            return;
        }
        Team team = teamList.get(choice-1);
        for (User user : studentList) {

            if (id == user.getId()) {
                if(user.getTeamId().contains(team.getTeamId())){
                    System.out.println("Student is already in team");
                    return;
                }
                addUserTeam(team, user);
                return;
            }
        }
    }
    private static void addUserTeam(Team team,User user){
        String teamId=team.getTeamId();
        user.setTeamId(teamId);
    }

    public static boolean removeStudentToTeam(User user,ArrayList<Team> teamList,ArrayList<User> studentList){
        showTeams(teamList,user);
        Scanner scanner = new Scanner(System.in);
        int choice= scanner.nextInt();

        Team team = selectTeam(user, teamList.get(choice - 1));
        if(!user.getTeamOwner().contains(team.getTeamId())){
            System.out.println("You are not Team owner in this team!");
            return false;
        }
        int id= getStudentInTeam(team,studentList);
        for (User student : studentList) {
            if (id == student.getId()) {
                if (removeUserTeam(team, student)) {
                    for(PrivateChannel channel : team.getPrivateChannels()){
                        if(channel.getParticipantId()==null){
                            continue;
                        }
                        if(channel.getParticipantId().contains(student.getId())){
                            channel.getParticipantId().remove(student.getId());
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean removeUserTeam(Team team,User user){
        String tmpTeamId=team.getTeamId();
        for(int i = 0; i<user.getTeamId().size();i++) {
            if(tmpTeamId.equals(user.getTeamId().get(i))){
                user.getTeamId().remove(i);
                return true;
            }
        }
        return false;
    }

    protected static Team selectTeam(User user, Team team){
        for (String j: user.getTeamId()) {
            if(j.equals(team.getTeamId())){
                return team;
            }
        }return null;
    }

    public static void removeTeam(User user, ArrayList<Team> teamList, ArrayList<User> studentList, ArrayList<User> academicianList){
        Scanner scanner = new Scanner(System.in);
        try {
            if(user.getUserType().equals("Instructor")) { // We only want to instructor can remove teams
                user.getOwnerTeams();
                System.out.println("Please choose team do you want to remove");
                try {
                    int chooseTeam = scanner.nextInt();
                    System.out.println(user.getTeamOwner().size());
                    if ((user.getTeamOwner().size() < chooseTeam) || (chooseTeam<=0)) {
                        System.out.println("You write wrong integer");
                    } else {
                        String teamId = user.getTeamOwner().get(chooseTeam-1);
                        for(User student: studentList){
                            removeUserFromTeam(student,teamId);
                        }
                        for (User academician: academicianList){
                            removeUserFromTeam(academician,teamId);
                        }
                        if(teamList.removeIf(team -> team.getTeamId().equals(teamId))){
                            System.out.println("Successfully removed ");
                            user.getTeamOwner().remove(teamId);
                        }else {
                            System.out.println("ERROR");
                        }

                    }
                } catch (InputMismatchException e) {
                    System.out.println("You didnt write an integer");
                }
            }
            else{
                throw new UnauthorizedUserOperationException();
            }

        } catch (UnauthorizedUserOperationException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void removeUserFromTeam(User user, String team ){
        user.getTeamId().remove(team);
    }

    public static void distinctUsers(User user,ArrayList<User> studentList,ArrayList<User> academicianList,ArrayList<Team> teamList){
        Scanner scanner = new Scanner(System.in);
        int studentAmount;
        int academicianAmount;
        int assistantAmount;
        try {
            Team team=show(user, teamList, scanner);
            assert team != null;
            academicianAmount = numberOfInstructor(user, academicianList, team);
            studentAmount = numberOfStudents(user,studentList,team);
            assistantAmount=numberOfTeachingAssistant(user,academicianList,team);
            System.out.println("Academician amount: "+academicianAmount);
            System.out.println("Teaching Assistant amount: "+assistantAmount);
            System.out.println("Student amount: "+studentAmount);
        } catch (InputMismatchException e) {
            System.out.println("Please enter an integer");
        }

    }

    private static int numberOfStudents(User user,ArrayList<User> studentList,Team team) {
        int studentCounter = 0;
        for (int j = 0; j < studentList.size(); j++) {
            if (studentList.get(j).getTeamId().contains(team.getTeamId())) {
                studentCounter++;
            }
        }
        return studentCounter;
    }


    private static int numberOfInstructor(User user,ArrayList<User> academicianList,Team team){
        int academicianAmount = 0;
        for (int j = 0; j < academicianList.size(); j++) {
            if (academicianList.get(j).getUserType().equals("Instructor") && academicianList.get(j).getTeamId().contains(team.getTeamId())) {
                academicianAmount++;
            }
        }
        return academicianAmount;
    }

    private static int numberOfTeachingAssistant(User user,ArrayList<User> academicianList,Team team){
        int assistantAmount=0;
        for (int i=0 ; i<academicianList.size(); i++){
            if(academicianList.get(i).getUserType().equals("Teaching Assistant")&& academicianList.get(i).getTeamId().contains(team.getTeamId())){
                assistantAmount++;
            }
        }
        return assistantAmount;
    }

    private static Team show(User user, ArrayList<Team> teamList, Scanner scanner) {
        TeamOperations.showTeams(teamList, user);
        System.out.println("Select a team");
        int choice = scanner.nextInt();
        Team team = TeamOperations.selectTeam(user, teamList.get(choice - 1));
        if (team == null) {
            System.out.println("you are not able to touch this team or you write wrong integer");
            return null;
        }
        return team;
    }
    public static int getStudent(ArrayList<User> studentList){
        Scanner scanner = new Scanner(System.in);
        for(User user: studentList){
            System.out.println(user.getUserName()+" "+user.getId());
        }
        return scanner.nextInt();
    }
    private static int getStudentInTeam(Team team,ArrayList<User> studentList){
        Scanner scanner = new Scanner(System.in);
        for(User user:studentList){
            if(user.getTeamId().contains(team.getTeamId())){
                System.out.println(user.getUserName()+" "+user.getId());
            }
        }
        return scanner.nextInt();
    }

}