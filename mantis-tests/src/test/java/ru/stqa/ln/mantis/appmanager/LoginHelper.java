package ru.stqa.ln.mantis.appmanager;

import org.openqa.selenium.By;

public class LoginHelper extends HelperBase {

    public LoginHelper(ApplicationManager app) {
        super(app);
    }
    public void start(String username, String password) {
         wd.get(app.getProperty("web.baseUrl") + "/login_page.php");
         type(By.name("username"), username);
         click(By.cssSelector("input[type='submit']"));
         type(By.name("password"), password);
         click(By.cssSelector("input[type='submit']"));
    }

    public void logout() {
        wd.get(app.getProperty("web.baseUrl") + "/logout_page.php");
    }
}
