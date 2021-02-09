package mail.simple_mail;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;

public class Mail {
	public static void main(String[] args) throws EmailException {
		String attachmentFilePath = "C:\\Users\\Name\\Documents\\data.pdf";
		String pdfFileName = "data.pdf";

		String myMail = "username@gmail.com";
		String hostName = "smtp.gmail.com";
		int portNumber = 465;
		String username = "username";
		String password = "password";
		String subject = "Hi, there";
		String message = "this a simple message";

		String mailRecipient = "joe@outlook.com";

		EmailAttachment attachment = new EmailAttachment();
		attachment.setPath(attachmentFilePath);
		attachment.setDisposition(EmailAttachment.ATTACHMENT);
		attachment.setDescription("My PDF Attachment");
		attachment.setName(pdfFileName);

		MultiPartEmail email = new MultiPartEmail();
		email.setHostName(hostName);
		email.setSmtpPort(portNumber);
		email.setAuthenticator(new DefaultAuthenticator(username, password));
		email.setSSLOnConnect(true);
		email.setFrom(myMail);
		email.setSubject(subject);
		email.setMsg(message);

		email.addTo(mailRecipient);
		email.attach(attachment);
		email.send();
	}
}
