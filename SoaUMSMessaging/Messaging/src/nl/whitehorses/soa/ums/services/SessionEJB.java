package nl.whitehorses.soa.ums.services;

import java.util.List;
import javax.ejb.Remote;
import nl.whitehorses.soa.ums.entities.Receiver;

@Remote
public interface SessionEJB {


    public List<nl.whitehorses.soa.ums.entities.Status> 
        getMessageStatus(String messageId);

    public String sendMixedMsg(String subject,
                               String Message, 
                               String Sender,
                               List<Receiver> receivers);

    public String sendMailAttachmentMsg(String sender,
                                        List<Receiver> receivers,
                                        String subject, 
                                        String message,
                                        byte[] data, 
                                        String mimetype,
                                        String fileName);
}
