package nl.whitehorses.soa.ums;

import java.io.FileInputStream;

import java.io.FileNotFoundException;

import java.io.IOException;

import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import java.util.ArrayList;
import java.util.Hashtable;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import nl.whitehorses.soa.ums.entities.Receiver;
import nl.whitehorses.soa.ums.entities.Status;
import nl.whitehorses.soa.ums.services.SessionEJB;

public class SessionEJBClient {
    public static void main(String[] args) {
        try {
            final Context context = getInitialContext();
            SessionEJB sessionEJB =
                (SessionEJB)context.lookup("SoaUMSMessaging-SessionEJB#nl.whitehorses.soa.ums.services.SessionEJB");

            List<Receiver> receivers = new ArrayList<Receiver>();
            Receiver receiver  = new Receiver("biemond@gmail.com", "EMAIL");
            Receiver receiver2 = new Receiver("biemond@tiscali.nl", "EMAIL");
            receivers.add(receiver);
            receivers.add(receiver2);



            String messageId =
                sessionEJB.sendMailAttachmentMsg( "ebiemond@xs4all.nl",
                                                   receivers,
                                                   "hello subject",
                                                   "hello body"
                                                   ,doDownload("C:/temp/logo.png"),
                                                   "image/png",
                                                   "logo.png");

            System.out.println("MessageId is " + messageId +
                               " lets wait 2 seconds for the status");
            Thread.sleep(2000);

            if (messageId != null) {
              List<Status> statusses =
                  sessionEJB.getMessageStatus(messageId);
              for (Status status : statusses) {
                  System.out.println(status.toString());
              }
            }


            Receiver receiver3 = new Receiver("nl2en@bot.talk.google.com", "IM");
            receivers.add(receiver3);

            messageId = sessionEJB.sendMixedMsg("Hello",
                                                "Hello world",
                                                "ebiemond@xs4all.nl",
                                                receivers );


            System.out.println("MessageId is " + messageId +
                               " lets wait for the status");
            Thread.sleep(4000);

            if (messageId != null) {
                List<Status> statusses =
                    sessionEJB.getMessageStatus(messageId);
                for (Status status : statusses) {
                    System.out.println(status.toString());
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static Context getInitialContext() throws NamingException {
        Hashtable env = new Hashtable();
        env.put(Context.INITIAL_CONTEXT_FACTORY,
                "weblogic.jndi.WLInitialContextFactory");
        env.put(Context.PROVIDER_URL, "t3://localhost:8001");
        return new InitialContext(env);
    }

    public static byte[] doDownload(String fileName) {
        FileInputStream fis;
        byte[] data = null;
        FileChannel fc;

        try {
            fis = new FileInputStream(fileName);
            fc = fis.getChannel();
            data = new byte[(int)(fc.size())];
            ByteBuffer bb = ByteBuffer.wrap(data);
            fc.read(bb);
        } catch (FileNotFoundException e) {
            // TODO
        } catch (IOException e) {
            // TODO
        }
        return data;
    }
}
