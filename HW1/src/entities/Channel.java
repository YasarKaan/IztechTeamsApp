package entities;

public class Channel {
    private String meetingChannel;
    private String meetingDayAndTime;


    public Channel(String meetingChannel, String meetingDate) {
        this.meetingChannel = meetingChannel;
        this.meetingDayAndTime = meetingDate;

    }

    public Channel() {
    }

    public String getMeetingChannel() {
        return meetingChannel;
    }

    public void setMeetingChannel(String meetingChannel) {
        this.meetingChannel = meetingChannel;
    }

    public String getMeetingDate() {
        return meetingDayAndTime;
    }

    public void setMeetingDate(String meetingDate) {
        this.meetingDayAndTime = meetingDate;
    }


}