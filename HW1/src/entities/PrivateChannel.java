package entities;

import java.util.ArrayList;

public class PrivateChannel extends Channel {
    private ArrayList<Integer> participantId;
    public PrivateChannel(String meetingChannel, String meetingDate, ArrayList<Integer> participantId) {
        super(meetingChannel, meetingDate);
        this.participantId = participantId;
    }

    public ArrayList<Integer> getParticipantId() {
        return participantId;
    }

    public void setParticipantId(ArrayList<Integer> participantId) {
        this.participantId = participantId;
    }

    public String participantIdToString(){
        String str="\"";
        if(participantId==null){
            return "";
        }
        for( int i=0 ; i<participantId.size();i++){
            if(i+1 >= getParticipantId().size()){
                str = str + participantId.get(i);
            }else{
                str = str + participantId.get(i)+", ";
            }

        }
        return str+"\"";
    }
}