package helper;

import entities.*;
import exceptions.UnauthorizedUserOperationException;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ChannelOperations {

    public static void addMeetingChannel(User user, ArrayList<Team> teamList){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Which team do you want to add Channel");
        int choice = scanner.nextInt();
        Team team = TeamOperations.selectTeam(user,teamList.get(choice-1));

        if(team!=null){
            scanner.nextLine();
            System.out.println("What is the name of channel? ");
            String name = scanner.nextLine();
            System.out.println("What is the meeting day and time? ");
            String meetingDay = scanner.nextLine();
            ArrayList<Integer> participantId = new ArrayList<>();
            participantId.add(user.getId());
            PrivateChannel privateChannel = new PrivateChannel(name,meetingDay,participantId);
            team.getPrivateChannels().add(privateChannel);

        }else{
            System.out.println("You did something wrong");
        }
    }
    public static void removeMeetingChannel(Academician academician, ArrayList<Team> teamList){
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Which team do you want to remove Channel");

            int choice = scanner.nextInt();
            Team team = TeamOperations.selectTeam(academician, teamList.get(choice - 1));
            if (team != null) {
                team.showChannels();
                System.out.println("Which channel do you want to remove");
                int channelId = scanner.nextInt();
                if (TeamOperations.isTeamOwner(academician,team)) {
                    if (team.getPrivateChannels().get(channelId - 1) != null) {
                        team.getPrivateChannels().remove(channelId - 1);
                    }
                }else{
                    throw new UnauthorizedUserOperationException();
                }
            }
        }catch (InputMismatchException e){
            System.out.println("Please write an integer");
        }catch (UnauthorizedUserOperationException e){
            System.out.println(e.getMessage());
        }
    }

    public static void addParticipant(Academician academician, ArrayList<Team> teamList, ArrayList<User> studentList,ArrayList<User> academicianList){
        Scanner scanner = new Scanner(System.in);
        try {
            int i = 1;
            TeamOperations.showTeams(teamList,academician);
            int choice = scanner.nextInt();
            Team team = TeamOperations.selectTeam(academician, teamList.get(choice - 1));
            for (String string : academician.getTeamOwner()) {
                assert team != null;
                if (string.equals(team.getTeamId())) {
                    team.showChannels();
                    System.out.println("Select a Channel");
                    int chooseChannel = scanner.nextInt();
                    if(chooseChannel==1){
                        System.out.println("This is a public channel you cannot ad participant");
                        break;
                    }
                    PrivateChannel channel = team.getPrivateChannels().get(chooseChannel);
                    showUsersInTeam(team, studentList, academicianList);
                    System.out.println("Select a UserId");
                    User chosenUser = findUser(studentList, academicianList, scanner.nextInt());
                    if (chosenUser != null && (chosenUser.getTeamId().contains(team.getTeamId())) ) {
                        if(!(channel.getParticipantId().contains(chosenUser.getId())) ) {
                            channel.getParticipantId().add(chosenUser.getId());
                        }else{
                            System.out.println("Student already in this channel");
                        }
                    }else{
                        System.out.println("You choose a null user or a user not in the team");
                    }
                }
            }
        }catch (InputMismatchException e ){
            System.out.println("Please enter an integer");
        }
    }
    public static void updateMeetingDayAndTime(User user, ArrayList<Team> teamList) {
        Scanner scanner = new Scanner(System.in);
        try {
            int i = 1;
            TeamOperations.showTeams(teamList,user);
            System.out.println("Select a team");
            int choice = scanner.nextInt();
            Team team = TeamOperations.selectTeam(user, teamList.get(choice - 1));
            if(team==null){
                System.out.println("you are not able to touch this team or you write wrong integer");
                return;
            }
            for (String string : user.getTeamOwner()) {
                if (string.equals(team.getTeamId())) {
                    team.showChannels();
                    System.out.println("Select a Channel");
                    int chooseChannel = scanner.nextInt();
                    Channel channel = team.getPrivateChannels().get(chooseChannel-1);
                    System.out.println("Please write new Meeting day and time: ");
                    scanner.nextLine();
                    String dayAndTime = scanner.nextLine();
                    channel.setMeetingDate(dayAndTime);

                }
            }
        }catch (InputMismatchException e){
            System.out.println("Please enter an integer");
        }
    }
    public static void removeParticipant(User user, ArrayList<Team> teamList, ArrayList<User> studentList,ArrayList<User> academicianList){
        Scanner scanner = new Scanner(System.in);
        try {
            int i = 1;
            TeamOperations.showTeams(teamList,user);
            int choice = scanner.nextInt();
            Team team = TeamOperations.selectTeam(user, teamList.get(choice - 1));
            for (String string : user.getTeamOwner()) {
                if (string.equals(team.getTeamId())) {
                    team.showChannels();
                    System.out.println("Select a Channel");
                    int chooseChannel = scanner.nextInt();
                    if(chooseChannel==1){
                        System.out.println("This is a public channel you cannot ad participant");
                        break;
                    }
                    PrivateChannel channel = team.getPrivateChannels().get(chooseChannel);
                    showUsersInChannel(channel);
                    System.out.println("Select a User");
                    int userId = scanner.nextInt();
                    if(userId< channel.getParticipantId().size() && userId>0) {
                        channel.getParticipantId().remove(userId);
                    }else{
                        System.out.println("Please write a valid integer");
                    }
                }
            }
        }catch (InputMismatchException e ){
            System.out.println("Please enter an integer");
        }
    }


    private static void showUsersInChannel (PrivateChannel channel){
        int i =1;
        for(int partId : channel.getParticipantId()){
            System.out.println(i+") "+partId);
            i++;
        }
}


    private static void showUsersInTeam(Team team, ArrayList<User> studentList,ArrayList<User> academicianList){
        for(User user:academicianList){
            if(user.getTeamId().contains(team.getTeamId())){
                System.out.println(user.getUserName()+" "+user.getId());
            }
        }
        for (User user:studentList){
            if(user.getTeamId().contains(team.getTeamId())){
                System.out.println(user.getUserName()+" "+user.getId());
            }
        }
    }

    public static User findUser(ArrayList<User> studentList, ArrayList<User> academicianList, int id) {
        ArrayList<User> userList = new ArrayList<>();
        userList.addAll(studentList);
        userList.addAll(academicianList);
        studentList.addAll(academicianList);
        for (int i = 0; i < userList.size(); i++)
            if (id == userList.get(i).getId()) {
                return userList.get(i);
            }
        return null;
    }
    public static void showTeamsAndMeetingChannels(ArrayList<Team> teamList,User user){
        System.out.println("-------------Teams are--------------");
        int displayNumber=0;
        for (Team i : teamList) {
            displayNumber++;
            for (String j : user.getTeamId()) {
                if (i.getTeamId().equals(j)) {
                    System.out.println(displayNumber+", "+i.getTeamName() + ", " + i.getTeamId());
                    Channel channel = i.getDefaultChannel();

                    System.out.println("Channels are \n"+channel.getMeetingChannel()+" "+channel.getMeetingDate() );
                    for (PrivateChannel privChannel: i.getPrivateChannels()){
                        if(privChannel.getMeetingChannel().equals("")){
                            continue;
                        }
                        if((privChannel.getParticipantId().contains(user.getId())) || user.getTeamOwner().contains(i.getTeamId()) ){
                            System.out.println(privChannel.getMeetingChannel()+" "+privChannel.getMeetingDate()+" "+privChannel.getParticipantId().toString());
                        }
                    }
                    break;
                    }
                }
            }
    }

}
