package nl.whitehorses.soa.ums.entities;

import java.io.Serializable;
import java.util.Date;

public class Status implements Serializable {
    public Status() {
    }
      
    private String messageId;
    private Date   sendTime;
    private String receiver;
    private String status;

    public Status(String messageId, Date sendTime, String receiver,
                  String status) {
        super();
        this.messageId = messageId;
        this.sendTime = sendTime;
        this.receiver = receiver;
        this.status = status;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
    
    public String toString() {
      return "message id: "+ messageId+" time: "+sendTime.toString()+ " status: " +status + " receiver: " + receiver;  
    }
}
