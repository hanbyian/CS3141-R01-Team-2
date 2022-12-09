package com.example.CS3141R01Team2.Email;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import javax.mail.Session;
import javax.mail.internet.MimeMessage;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {EmailService.class})
@ExtendWith(SpringExtension.class)
class EmailServiceTest {
    @Autowired
    private EmailService emailService;

    @MockBean
    private JavaMailSender javaMailSender;

    /**
     * Method under test: {@link EmailService#send(String, String)}
     */
    @Test
    void testSend() throws MailException {
        doNothing().when(javaMailSender).send((MimeMessage) any());
        when(javaMailSender.createMimeMessage()).thenReturn(new MimeMessage((Session) null));
        emailService.send("alice.liddell@example.org", "jane.doe@example.org");
        verify(javaMailSender).createMimeMessage();
        verify(javaMailSender).send((MimeMessage) any());
    }

    /**
     * Method under test: {@link EmailService#send(String, String)}
     */
    @Test
    void testSend2() throws MailException {
        doThrow(new IllegalStateException()).when(javaMailSender).send((MimeMessage) any());
        when(javaMailSender.createMimeMessage()).thenReturn(new MimeMessage((Session) null));
        assertThrows(IllegalStateException.class,
                () -> emailService.send("alice.liddell@example.org", "jane.doe@example.org"));
        verify(javaMailSender).createMimeMessage();
        verify(javaMailSender).send((MimeMessage) any());
    }

    /**
     * Method under test: {@link EmailService#send(String, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testSend3() throws MailException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "javax.mail.internet.MimePart.setContent(Object, String)" because "mimePart" is null
        //       at com.example.CS3141R01Team2.Email.EmailService.send(EmailService.java:29)
        //   See https://diff.blue/R013 to resolve this issue.

        doNothing().when(javaMailSender).send((MimeMessage) any());
        when(javaMailSender.createMimeMessage()).thenReturn(null);
        emailService.send("alice.liddell@example.org", "jane.doe@example.org");
    }

    /**
     * Method under test: {@link EmailService#send(String, String)}
     */
    @Test
    void testSend4() throws MailException {
        doNothing().when(javaMailSender).send((MimeMessage) any());
        when(javaMailSender.createMimeMessage()).thenReturn(new MimeMessage((Session) null));
        assertThrows(IllegalStateException.class,
                () -> emailService.send("Confirm your email for StudyUp", "jane.doe@example.org"));
        verify(javaMailSender).createMimeMessage();
    }
}

