package TeamsTechApp;

import entities.*;
import helper.ChannelOperations;
import helper.SignInHelper;
import helper.TeamOperations;
import io.GetObjectsFromCsv;
import io.WriteClass;
import menus.Menu;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Mediator {

 public static void mediator(){

     ArrayList<User> studentList = new ArrayList<>();
     ArrayList<User> academicianList = new ArrayList<>();
     ArrayList<Team> teamList = new ArrayList<>();
     GetObjectsFromCsv.getTeams(teamList);
     GetObjectsFromCsv.getUsers(studentList, academicianList,teamList);
     SignInHelper signInHelper = new SignInHelper();
     System.out.println("Welcome to Teams App");
     boolean check=true;
     int updateChoice;

     while (check) {
         System.out.println("Press 1 for Student SignIn page Press 2 for Academician SignIn page 0 for exit ");
         Scanner scanner = new Scanner(System.in);
         try {
             int signType = scanner.nextInt();
             if (signType == 1) {
                 Student student = (Student) signInHelper.signInForMain(studentList);
                 int choice =5;
                 while(choice !=0) {
                     try {
                         if (student != null) {
                             choice = Menu.studentMenu();
                             if (choice == -1) {
                                 choice = 0;
                                 check = false;
                             } else if (choice == 1) {
                                 ChannelOperations.showTeamsAndMeetingChannels(teamList, student);
                             } else if (choice == 2) {
                                 TeamOperations.distinctUsers(student, studentList, academicianList, teamList);
                             }
                         }else{
                             choice=0;
                         }
                     }catch (InputMismatchException e){
                         System.out.println("Please write a valid integer");
                     }
                 }
             } else if (signType == 2) {
                 Academician academician = (Academician) signInHelper.signInForMain(academicianList);
                 int choice=5;
                 while(choice!=0) {
                     try {
                         if (academician != null) {
                             choice = Menu.academicianMenu();

                             if (choice == -1) {
                                 check = false;
                                 choice = 0;
                             } else if (choice == 1) {
                                 Team team = TeamOperations.createTeam(academician);
                                 if (team.getTeamId() != null) {
                                     teamList.add(team);

                                 }
                             } else if (choice == 2) {
                                 TeamOperations.removeTeam(academician, teamList, studentList, academicianList);
                             } else if (choice == 3) {
                                 //TODO: update team burda olacak
                                 updateChoice = Menu.updateTeamMenuForAcademician();
                                 if (updateChoice == -1) {
                                     check = false;
                                     break;
                                 } else if (updateChoice == 0) {
                                     break;
                                 } else if (updateChoice == 1) {
                                     TeamOperations.showTeams(teamList, academician);
                                     ChannelOperations.addMeetingChannel(academician, teamList);
                                 } else if (updateChoice == 2) {
                                     TeamOperations.showTeams(teamList, academician);
                                     ChannelOperations.removeMeetingChannel(academician, teamList);
                                 } else if (updateChoice == 3) {
                                     int updateChannelChoice = Menu.updateChannelMenu();
                                     if (updateChannelChoice == 1) {
                                         ChannelOperations.addParticipant(academician, teamList, studentList, academicianList);
                                     } else if (updateChannelChoice == 2) {
                                         ChannelOperations.removeParticipant(academician, teamList, studentList, academicianList);
                                     } else if (updateChannelChoice == 3) {
                                         ChannelOperations.updateMeetingDayAndTime(academician, teamList);
                                     } else {
                                         System.out.println("Please write correct integer");
                                     }
                                 } else if (updateChoice == 4) {
                                     int studentId = TeamOperations.getStudent(studentList);
                                     TeamOperations.addStudentToTeam(academician, teamList, studentList, studentId);
                                 } else if (updateChoice == 5) {
                                     TeamOperations.removeStudentToTeam(academician, teamList, studentList);
                                 } else if (updateChoice == 6) {
                                     TeamOperations.giveTeamOwnerRole(academician, teamList, academicianList);
                                 } else if (updateChoice == 7) {
                                     ChannelOperations.showTeamsAndMeetingChannels(teamList, academician);
                                 } else if (updateChoice == 8) {
                                     TeamOperations.distinctUsers(academician, studentList, academicianList, teamList);
                                 }
                             }
                         } else {
                             choice = 0;

                         }
                     }catch (InputMismatchException e){
                         System.out.println("Please write a valid integer");
                     }
                 }

             } else if (signType == 0) {
                 break;
             } else {

                 System.out.println("Please write a valid number");
             }
         } catch (InputMismatchException e) {
             System.out.println("Please write a valid integer");

         }
     }

     WriteClass.writeToTeamList(teamList);
     WriteClass.writeToUserList(academicianList,studentList);
 }

}