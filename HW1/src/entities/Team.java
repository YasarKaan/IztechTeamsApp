package entities;

import java.util.ArrayList;

public class Team {
    private String teamName;
    private String teamId;
    private Channel defaultChannel;
    private ArrayList<PrivateChannel> privateChannels;
    private ArrayList<User> teamOwner = new ArrayList<>();

    public Team(String teamName,String teamId,Channel defaultChannel, ArrayList<PrivateChannel> privateChannels) {
        this.teamName = teamName;
        this.teamId = teamId;
        this.defaultChannel = defaultChannel;
        this.privateChannels = privateChannels;

    }

    public Team() {

    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public Channel getDefaultChannel() {
        return defaultChannel;
    }

    public void setDefaultChannel(Channel defaultChannel) {
        this.defaultChannel = defaultChannel;
    }

    public ArrayList<PrivateChannel> getPrivateChannels() {
        return privateChannels;
    }

    public void setPrivateChannels(ArrayList<PrivateChannel> privateChannels) {
        this.privateChannels = privateChannels;
    }

    public String getPrivateChannelsToString(){
        String str="";
        if(privateChannels==null){
            return str;
        }
        for(PrivateChannel privateChannel:privateChannels ){
            str=str+privateChannel.getMeetingChannel()+","
                    +privateChannel.getMeetingDate()+","
                    +privateChannel.participantIdToString();
        }
        return str;
    }

    public ArrayList<User> getTeamOwner() {
        return teamOwner;
    }

    public void setTeamOwner(ArrayList<User> teamOwner) {
        this.teamOwner = teamOwner;
    }
    public void showChannels(){
        int i =1;
        System.out.println(i+" "+defaultChannel.getMeetingChannel());
        for(PrivateChannel privateChannel: privateChannels) {
            if (!privateChannel.getMeetingChannel().equals("")) {
                System.out.println(i + " " + privateChannel.getMeetingChannel());
                i++;
            }
        }
    }

    public void getTeamOwner(Academician academician) {
        teamOwner.add(academician);
    }
}