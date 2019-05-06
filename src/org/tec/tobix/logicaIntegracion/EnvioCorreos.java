package org.tec.tobix.logicaIntegracion;



import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class EnvioCorreos {

	final String username = "tobixDS2019@gmail.com";
	final String password = "bztlcifrptbedqpp";	
public void EnviarCorreo(String idActividad, String email) {
	Properties props = new Properties();
	props.put("mail.smtp.auth", "true");
	props.put("mail.smtp.starttls.enable","true");
	props.put("mail.smtp.host","smtp.gmail.com");
	props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
	props.put("mail.smtp.port","587");
	
	String mensaje= "Su participacion a la actividad "+idActividad+" ha sido confirmada."+"\n" +"Gracias por elegirnos ";
	
	
	Session session = Session.getInstance(props,
            new javax.mail.Authenticator() {
		protected PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication(username, password);
		}
	  });

	try {

		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress("tobixDS2019@gmail.com"));
		message.setRecipients(Message.RecipientType.TO,
			InternetAddress.parse(email));
		message.setSubject("Tobix");
		message.setText(mensaje);

		Transport.send(message);
	} catch (MessagingException e) {
		throw new RuntimeException(e);
	}
}



}



