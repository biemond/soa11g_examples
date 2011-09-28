package nl.whitehorses.soa.ums.entities;

import java.io.Serializable;

public class Receiver implements Serializable{
    public Receiver() {

    }

    private String receiver;
    private String channel;

    public Receiver(String receiver, String channel) {
        super();
        this.receiver = receiver;
        this.channel = channel;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getChannel() {
        return channel;
    }
}
