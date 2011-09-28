package nl.whitehorses.soa.ums.utilities;

import java.util.List;

import nl.whitehorses.soa.ums.entities.Receiver;

import oracle.sdp.messaging.Address;
import oracle.sdp.messaging.DeliveryType;
import oracle.sdp.messaging.MessagingFactory;

public class ReceiverConvertor {
    public ReceiverConvertor() {
        super();
    }

  public static Address[] convertReceiver (List<Receiver> receivers ) {
    Address[] soaRecipients = new Address[receivers.size()];
    int i = 0;
    for (Receiver receiver : receivers) {

      Address recipient = null;
      if ( receiver.getChannel().equalsIgnoreCase("EMAIL") ){
        recipient =  MessagingFactory.buildAddress(receiver.getReceiver(),
                                                   DeliveryType.EMAIL,
                                                   Address.EMAIL_MODE_TO);
      } else if (receiver.getChannel().equalsIgnoreCase("IM")) {
        recipient =  MessagingFactory.buildAddress(receiver.getReceiver(),
                                                   DeliveryType.IM,
                                                   null);
        
      }
      soaRecipients[i] = recipient;
      i += 1;
    }
    return soaRecipients;
  }

}
