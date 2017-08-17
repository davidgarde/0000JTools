package es.dg.avan.jtools.control.email;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;

public class EmailUtil {
	//Logger de gestion de reservas de alojamientos
	static Logger log = Logger.getLogger(EmailUtil.class.getName());

	public static void sendEmailGmailServer(String from, String to, String subject, String textemail, boolean html, 
			final Properties props) {
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication((String)props.get("mail.smtp.user"), (String)props.get("mail.smtp.password"));
			}
		  });
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.setRecipients(Message.RecipientType.TO,	InternetAddress.parse(to));
			message.setRecipients(Message.RecipientType.BCC,InternetAddress.parse("davidgarde@avan31.com"));
			message.setSubject(subject);
			if (!html){
				message.setText(textemail);
			} else {
				message.setContent(textemail, "text/html" );
			}
			Transport.send(message);
			log.info("Email reserva enviado");
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	
	}

}
