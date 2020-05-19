package service;

import javax.ejb.EJB;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.naming.Context;
import javax.naming.InitialContext;

import java.util.Date;
import java.util.Hashtable;
import java.util.Properties;


import metier.session.PlatformGDLocal;
import web.GlobalConfig;

public class emailManagement {
	@EJB
	private PlatformGDLocal metier;
	
	public emailManagement() {
		try {
		final Hashtable<String, String> jndiProperties = new Hashtable<String, String>();
		jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
		final Context context = new InitialContext(jndiProperties);
		metier = (PlatformGDLocal) context
				.lookup("java:global/PlatformeGDEAR/PlatformGDEJB/BK!metier.session.PlatformGDLocal");
	} catch (Exception e) {
		e.printStackTrace();
	}
	}
	

	
	public void sendEmail(String to, String subject, String body) 
	{
        Properties props = new Properties();
        props.put("mail.smtp.host", GlobalConfig.host);
        props.put("mail.smtp.port", GlobalConfig.port);
        switch (GlobalConfig.protocol) {
            case SMTPS:
                props.put("mail.smtp.ssl.enable", true);
                break;
            case TLS:
                props.put("mail.smtp.starttls.enable", true);
                break;
		default:
			break;
        }

        Authenticator authenticator = null;
        if (GlobalConfig.auth) {
            props.put("mail.smtp.auth", true);
            authenticator = new Authenticator() {
                private PasswordAuthentication pa = new PasswordAuthentication(GlobalConfig.username, GlobalConfig.password);
                @Override
                public PasswordAuthentication getPasswordAuthentication() {
                    return pa;
                }
            };
        }

        Session session = Session.getInstance(props, authenticator);

        MimeMessage message = new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress(GlobalConfig.from));
            InternetAddress[] address = {new InternetAddress(to)};
            message.setRecipients(Message.RecipientType.TO, address);
            message.setSubject(subject);
            message.setSentDate(new Date());
//            message.setText(body);
            message.setContent(body, "text/html");
            Transport.send(message);
        } catch (MessagingException ex) {
            ex.printStackTrace();
        }
	}
}
