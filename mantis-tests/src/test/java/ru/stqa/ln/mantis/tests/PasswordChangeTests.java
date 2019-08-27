package ru.stqa.ln.mantis.tests;

import org.testng.annotations.Test;
import ru.lanwen.verbalregex.VerbalExpression;
import ru.stqa.ln.mantis.appmanager.HttpSession;
import ru.stqa.ln.mantis.model.MailMessage;
import ru.stqa.ln.mantis.model.UserData;
import ru.stqa.ln.mantis.model.Users;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class PasswordChangeTests extends TestBase{

    @Test
    public void testPasswordChange() throws MessagingException, IOException {
        String password = "password";
        String newPassword = "newpassword";
        app.login().start("administrator", "root");
        app.goTo().control();
        app.goTo().controlUsers();
        Users users = app.db().users();
        UserData user = users.iterator().next();
        app.change().selectUserById(user.getId());
        app.change().resetPassword();
        app.login().logout();
        List<MailMessage> mailMessages = app.james().waitForMail(user.getUsername(), password, 60000);
        String resetLink = findLink(mailMessages, user.getEmail());
        app.change().changePassword(resetLink, newPassword);
        app.change().changePassword(resetLink, newPassword);
        HttpSession session = app.newSession();
        assertTrue(session.login(user.getUsername(), newPassword));
        assertTrue(session.isLoggedInAs(user.getUsername()));

    }

    private String findLink(List<MailMessage> mailMessages, String email) {
        MailMessage mailMessage = mailMessages.stream().filter((m) -> m.to.equals(email)).findFirst().get();
        VerbalExpression regex = VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
        return regex.getText(mailMessage.text);
    }
}
