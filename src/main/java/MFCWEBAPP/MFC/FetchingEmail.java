package MFCWEBAPP.MFC;

import java.io.IOException;
import java.io.InputStream;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.NoSuchProviderException;
import javax.mail.Part;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.search.FlagTerm;
import javax.mail.search.OrTerm;
import javax.mail.search.SearchTerm;

public class FetchingEmail 
{
	private static InputStream is;
	private static String returnmsg;
	private static String OTP;
	public static String fetch(String pop3Host, String storeType, String user,String password) 
	{
      try 
      {
         // create properties field
         Properties properties = new Properties();
         properties.put("mail.store.protocol", "pop3");
         properties.put("mail.pop3.host", pop3Host);
         properties.put("mail.pop3.port", "995");
         properties.put("mail.pop3.starttls.enable", "true");
         Session emailSession = Session.getDefaultInstance(properties);
         // emailSession.setDebug(true);

         // create the POP3 store object and connect with the pop server
         Store store = emailSession.getStore("pop3s");

         store.connect(pop3Host, user, password);

         // create the folder object and open it
         Folder emailFolder = store.getFolder("INBOX");
         emailFolder.open(Folder.READ_ONLY);
         Flags seen = new Flags(Flags.Flag.SEEN);
	     FlagTerm unseenFlagTerm = new FlagTerm(seen, false);
	     
	     Flags recent = new Flags(Flags.Flag.RECENT);
	     FlagTerm recentFlagTerm = new FlagTerm(recent, true);
	     SearchTerm searchTerm = new OrTerm(unseenFlagTerm,recentFlagTerm);
	     Message messages[] = emailFolder.search(searchTerm, emailFolder.getMessages());
                
         // retrieve the messages from the folder in an array and print it
        // Message[] messages = emailFolder.getMessages();

         for (int i = 0; i < messages.length; )
         {
            Message message = messages[i];
            returnmsg = writePart(message);
            break;
           /* String line = reader.readLine();
            if ("YES".equals(line)) 
            {
               message.writeTo(System.out);
            } 
            else if ("QUIT".equals(line)) 
            {
               break;
            }*/
         }
         OTP = returnmsg.replaceAll("[^0-9]", "");
         

      } 
      catch (NoSuchProviderException e) 
      {
         e.printStackTrace();
      } 
      catch (MessagingException e) 
      {
         e.printStackTrace();
      }
      catch (IOException e)
      {
         e.printStackTrace();
      } 
      catch (Exception e) 
      {
         e.printStackTrace();
      }
      return OTP;
   }
   
	public static String writePart(Part p) throws Exception 
	{
		if (p instanceof Message)
         //Call methos writeEnvelope
			writeEnvelope((Message) p);
		//check if the content is plain text
		if (p.isMimeType("text/plain")) 
		{
			System.out.println((String) p.getContent());
         	String message = (String) p.getContent();
         	return message;
		} 
		//check if the content has attachment
		else if (p.isMimeType("multipart/*")) 
     	{
			Multipart mp = (Multipart) p.getContent();
			int count = mp.getCount();
			String msg= "";
			for (int i = 0; i < count; i++)
			{
				msg = writePart(mp.getBodyPart(i));
			}
			return msg;
     	} 
		//check if the content is a nested message
		else if (p.isMimeType("message/rfc822")) 
		{
			String msg2 = writePart((Part) p.getContent());
			return msg2;
		} 
		
		else 
		{
			Object o = p.getContent();
			if (o instanceof String) 
			{
				System.out.println((String) o);
			} 
			else if (o instanceof InputStream) 
			{
				is = (InputStream) o;
				int c;
				while ((c = is.read()) != -1)
					System.out.write(c);
			} 
			else 
			{
				System.out.println(o.toString());
			}	
		}
	return "";

   }
   public static void writeEnvelope(Message m) throws Exception 
   {
      Address[] a;

      // FROM
      if ((a = m.getFrom()) != null)
      {
         for (int j = 0; j < a.length; j++)
         System.out.println("FROM: " + a[j].toString());
      }

      // TO
      if ((a = m.getRecipients(Message.RecipientType.TO)) != null) 
      {
         for (int j = 0; j < a.length; j++)
         System.out.println("TO: " + a[j].toString());
      }

      // SUBJECT
      if (m.getSubject() != null)
         System.out.println("SUBJECT: " + m.getSubject());

   }

}