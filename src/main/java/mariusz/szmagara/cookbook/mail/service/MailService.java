package mariusz.szmagara.cookbook.mail.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class MailService {
    private static final Logger logger = LoggerFactory.getLogger(MailService.class);
    private final JavaMailSender javaMailSender;
    @Value("${spring.mail.username}")
    private String domainOwnerEmailAddress;
    @Value("${reset.key.link.url}")
    private String link;

    public MailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendPasswordResetLink(String emailAddress, String randomPasswordResetKey) {
        logger.debug("Sending mail to {} ", emailAddress);
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
            helper.setTo(emailAddress);
            helper.setFrom(domainOwnerEmailAddress);
            helper.setSubject("Reset your password");
            String resetPasswordLink = "<a href=" + link + randomPasswordResetKey + ">Reset password</a>";
            String messageContent = "<p>No need to worry, you can reset your password by clicking the link. " + resetPasswordLink + "</p>";
            helper.setText(messageContent, true);
            javaMailSender.send(mimeMessage);
        } catch (MessagingException exception) {
            exception.printStackTrace();
            logger.warn("Error sending mail", exception);
        }
        logger.debug("Mail to {} has been sent successfully!", emailAddress);
    }
}
