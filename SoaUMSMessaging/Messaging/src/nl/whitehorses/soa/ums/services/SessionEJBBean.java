package nl.whitehorses.soa.ums.services;


import javax.ejb.Remote;
import javax.ejb.Stateless;

import java.util.HashMap;
import java.util.Map;

import java.util.ArrayList;
import java.util.List;

import javax.activation.DataHandler;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;

import nl.whitehorses.soa.ums.entities.Receiver;
import nl.whitehorses.soa.ums.utilities.ReceiverConvertor;

import oracle.sdp.messaging.Address;
import oracle.sdp.messaging.ApplicationInfo;
import oracle.sdp.messaging.DeliveryType;
import oracle.sdp.messaging.Message;
import oracle.sdp.messaging.MessagingFactory;
import oracle.sdp.messaging.MessagingClient;
import oracle.sdp.messaging.MessagingClientFactory;
import oracle.sdp.messaging.MessagingException;
import oracle.sdp.messaging.Status;
import oracle.sdp.messaging.util.ByteArrayDataSource;
import oracle.sdp.messaging.util.StringDataSource;

@Stateless(name="SessionEJB", mappedName = "SoaUMSMessaging-SessionEJB")
@Remote
@WebService(name        = "UMSMessagingService", 
            serviceName = "UMSMessagingService",
            portName    = "UMSMessagingServicePort")
public class SessionEJBBean implements SessionEJB {

    MessagingClient mClient = null;
    Map<String, Object> params = new HashMap<String, Object>();

    public SessionEJBBean() {
      params.put(ApplicationInfo.APPLICATION_NAME, "CompanyMsgr");
      params.put(ApplicationInfo.APPLICATION_INSTANCE_NAME, "CompanyInstance");
    }

    @WebMethod
    @WebResult(name = "messageId")
    public String sendMailAttachmentMsg(
                                        @WebParam(name = "sender")    String sender, 
                                        @WebParam(name = "receivers") List<Receiver> receivers,
                                        @WebParam(name = "subject")   String subject,
                                        @WebParam(name = "message")   String message,
                                        @WebParam(name = "data") byte[] data,
                                        @WebParam(name = "mimetype") String mimetype,
                                        @WebParam(name = "filename") String fileName) {

      MimeMultipart mp = null;

      try {
          // plain msg for the body
          MimeBodyPart mp_partPlain = new MimeBodyPart();
          mp_partPlain.setText(message);
        
          // binary attachement
          MimeBodyPart mp_partBinary = new MimeBodyPart();
          ByteArrayDataSource dataSource = new ByteArrayDataSource(data, mimetype);
          mp_partBinary.setDataHandler(new DataHandler(dataSource));
          mp_partBinary.setFileName(fileName);

          mp = new MimeMultipart("alternative");
          mp.addBodyPart(mp_partPlain);
          mp.addBodyPart(mp_partBinary);
      
      } catch (javax.mail.MessagingException e) {
          e.printStackTrace();
      }   

        try {
          Message soaMessage = MessagingFactory.createMessage();
          Address soaSender =
              MessagingFactory.buildAddress(sender, 
                                            DeliveryType.EMAIL,
                                            null);

          soaMessage.setSubject(subject);
          soaMessage.setContent(mp, "multipart/alternative");
          
          soaMessage.addSender(soaSender);
          soaMessage.addAllRecipients(ReceiverConvertor.convertReceiver(receivers));

          mClient = MessagingClientFactory.createMessagingClient(params);
          String messageId = mClient.send(soaMessage);
          return messageId;

        } catch (MessagingException e) {
             e.printStackTrace();
        }
 
        return null;
    }


    @WebMethod
    @WebResult(name = "statusses")    
    public List<nl.whitehorses.soa.ums.entities.Status> getMessageStatus(
            @WebParam(name = "messageId") String messageId) {

        try {
            mClient = MessagingClientFactory.createMessagingClient(params);
            Status[] msgStatuses = mClient.getStatus(messageId);
            List<nl.whitehorses.soa.ums.entities.Status> statusses =
                new ArrayList<nl.whitehorses.soa.ums.entities.Status>();

            for (Status msgStatus : msgStatuses) {
                nl.whitehorses.soa.ums.entities.Status status =
                    new nl.whitehorses.soa.ums.entities.Status();
                status.setMessageId(msgStatus.getMessageId());
                status.setReceiver(msgStatus.getAddress().toString());
                status.setStatus(msgStatus.getType().toString());
                status.setSendTime(msgStatus.getDate().getTime());
                statusses.add(status);
            }
            return statusses;
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return null;
    }

    @WebMethod
    @WebResult(name = "messageId")
    public String sendMixedMsg(@WebParam(name = "subject") String subject,
                               @WebParam(name = "message") String message, 
                               @WebParam(name = "sender") String sender, 
                               @WebParam(name = "receivers") List<Receiver> receivers) {


        Message soaMessage = MessagingFactory.createMessage();
        MimeMultipart part_mp = null;

        try {
          // IM Message  
          MimeBodyPart part_mp_partPlain = new MimeBodyPart();
          // set IM  
          part_mp_partPlain.addHeader(soaMessage.HEADER_SDPM_PAYLOAD_PART_DELIVERY_TYPE,
                                      "IM");
          part_mp_partPlain.setText(message);
 
          // Email Message             
          MimeBodyPart part_mp_partRich = new MimeBodyPart();
          // set Email  
          part_mp_partRich.addHeader(soaMessage.HEADER_SDPM_PAYLOAD_PART_DELIVERY_TYPE,
                                     "EMAIL");
          StringDataSource htmlDataSource = 
              new StringDataSource("<html><head></head><body><b><i>"+
                                   message+ 
                                   "</i></b></body></html>",
                                   "text/html; charset=UTF-8");
          part_mp_partRich.setDataHandler(new DataHandler(htmlDataSource));
    
          part_mp = new MimeMultipart("alternative");
          part_mp.addBodyPart(part_mp_partPlain);
          part_mp.addBodyPart(part_mp_partRich);

        } catch (javax.mail.MessagingException b) {
              b.printStackTrace();
        }


        try {
            mClient = MessagingClientFactory.createMessagingClient(params);

            soaMessage.setSubject(subject);
            soaMessage.setContent(part_mp, "multipart/alternative");
            // Enabled for IM and Email
            soaMessage.setMultiplePayload(true);

            Address soaSender = MessagingFactory.buildAddress(sender,
                                                              DeliveryType.EMAIL,
                                                              null);

            soaMessage.addSender(soaSender);
            soaMessage.addAllRecipients(ReceiverConvertor.convertReceiver(receivers));

            String messageId = mClient.send(soaMessage);
            return messageId;
        } catch (oracle.sdp.messaging.MessagingException b) {
            b.printStackTrace();
        }
        return null;
    }

}
